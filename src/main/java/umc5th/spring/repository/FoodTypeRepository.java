package umc5th.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc5th.spring.domain.FoodType;

public interface FoodTypeRepository extends JpaRepository<FoodType, Long> {

}
