package sejongfestival.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sejongfestival.Model.RecordCsv;

public interface RecordRepository extends JpaRepository<RecordCsv, Long> {
}