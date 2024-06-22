package sejongfestival.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;

@Entity
@Getter
public class RecordCsv {

    @Id
    @GeneratedValue
    private Long id;

    @Column(length = 255)
    private String title;

    @Column(length = 200)
    private String briefSummary;

    @Column(length = 1000)
    private String DetailSummary;

    public RecordCsv() {
    }

    public RecordCsv(String title, String briefSummary, String detailSummary) {
        this.title = title;
        this.briefSummary = briefSummary;
        this.DetailSummary = detailSummary;
    }
}
