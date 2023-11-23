package umc5th.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc5th.spring.domain.Mission;

public interface MissionRepository extends JpaRepository<Mission, Long> {


}
