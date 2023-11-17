package umc5th.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc5th.spring.domain.Region;

public interface RegionRepository extends JpaRepository<Region, Long> {

    Region findRegionByName(String regionName);
}
