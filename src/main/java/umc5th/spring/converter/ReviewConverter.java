package umc5th.spring.converter;

import org.springframework.data.domain.Page;
import umc5th.spring.domain.Member;
import umc5th.spring.domain.Region;
import umc5th.spring.domain.Review;
import umc5th.spring.domain.Store;
import umc5th.spring.web.dto.ReviewRequestDTO;
import umc5th.spring.web.dto.ReviewResponseDTO;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ReviewConverter {

    public static ReviewResponseDTO.JoinResultDTO toJoinResultDTO(Review review) {
        return ReviewResponseDTO.JoinResultDTO.builder()
                .reviewId(review.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static ReviewResponseDTO.ReviewResultDTO toReviewResultDTO(Review review) {
        return ReviewResponseDTO.ReviewResultDTO.builder()
                .reviewId(review.getId())
                .rating(review.getRating())
                .content(review.getContent())
                .status(review.getStatus())
                .storeName(review.getStore().getName())
                .createdAt(review.getCreatedAt())
                .build();
    }

    public static Review toReview(ReviewRequestDTO.JoinDto request, Store store, Member member) {

        return Review.builder()
                .content(request.getContent())
                .rating(request.getRating())
                .store(store)
                .member(member)
                .build();
    }

    public static ReviewResponseDTO.ReviewResultListDTO toReviewResultListDTO(Page<Review> reviewList) {
        List<ReviewResponseDTO.ReviewResultDTO> reviewResultDTOList = reviewList.stream()
                .map(ReviewConverter::toReviewResultDTO).collect(Collectors.toList());

        return ReviewResponseDTO.ReviewResultListDTO.builder()
                .isFirst(reviewList.isLast())
                .isFirst(reviewList.isFirst())
                .totalPage(reviewList.getTotalPages())
                .totalElements(reviewList.getTotalElements())
                .listSize(reviewResultDTOList.size())
                .reviewList(reviewResultDTOList)
                .build();
    }

}
