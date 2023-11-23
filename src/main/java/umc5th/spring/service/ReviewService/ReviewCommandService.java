package umc5th.spring.service.ReviewService;

import umc5th.spring.domain.Review;
import umc5th.spring.domain.Store;
import umc5th.spring.web.dto.ReviewRequestDTO;

public interface ReviewCommandService {
    public Review joinReview(ReviewRequestDTO.JoinDto request, Long storeId);
}
