package umc5th.spring.service.ReviewService;

import umc5th.spring.domain.Review;
import umc5th.spring.web.dto.ReviewRequestDTO;

public interface ReviewCommandService {
    Review createReview(ReviewRequestDTO.CreateDto request, Long storeId);
}
