package sejongfestival.Controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class IdeaController {

    @Value("${flask.server.url}")
    private String flaskServerUrl;

    @CrossOrigin(origins = "*")
    @PostMapping("/find-similar-ideas")
    public ResponseEntity<?> findSimilarIdeas(@RequestBody Map<String, String> request) {
        String serviceName = request.get("serviceName");
        String serviceDetail = request.get("serviceDetail");

        RestTemplate restTemplate = new RestTemplate();
        String url = flaskServerUrl + "/similar-ideas";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        Map<String, String> flaskRequest = new HashMap<>();
        flaskRequest.put("serviceName", serviceName);
        flaskRequest.put("serviceDetail", serviceDetail);

        HttpEntity<Map<String, String>> entity = new HttpEntity<>(flaskRequest, headers);

        ResponseEntity<String> response = restTemplate.postForEntity(url, entity, String.class);
        return ResponseEntity.ok(response.getBody());
    }
}
