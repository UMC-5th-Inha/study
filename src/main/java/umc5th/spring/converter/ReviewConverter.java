package umc5th.spring.converter;

import umc5th.spring.domain.Member;
import umc5th.spring.domain.Review;
import umc5th.spring.domain.enums.Gender;
import umc5th.spring.web.dto.MemberRequestDTO;
import umc5th.spring.web.dto.MemberResponseDTO;
import umc5th.spring.web.dto.ReviewRequestDTO;
import umc5th.spring.web.dto.ReviewResponseDTO;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class ReviewConverter {

    public static ReviewResponseDTO.ReviewResultDTO toReviewResultDTO(Review review){
        return ReviewResponseDTO.ReviewResultDTO.builder()
                .reviewId(review.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Review toReview(ReviewRequestDTO.CreateDto request) {
        return Review.builder()
                .content(request.getContent())
                .rating(request.getRating())
                .build();

    }

}
