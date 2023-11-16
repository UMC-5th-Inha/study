package umc5th.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc5th.spring.domain.Review;

public interface ReviewRepositoy extends JpaRepository<Review, Long> {
}
