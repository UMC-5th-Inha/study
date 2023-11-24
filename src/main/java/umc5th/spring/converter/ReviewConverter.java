package umc5th.spring.converter;

import org.springframework.data.domain.Page;
import umc5th.spring.domain.Member;
import umc5th.spring.domain.Review;
import umc5th.spring.domain.Store;
import umc5th.spring.web.dto.ReviewRequestDTO;
import umc5th.spring.web.dto.ReviewResponseDTO;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class ReviewConverter {

    public static ReviewResponseDTO.ReviewResultDTO toReviewResultDTO(Review review){
        return ReviewResponseDTO.ReviewResultDTO.builder()
                .reviewId(review.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Review toReview(ReviewRequestDTO.CreateDto request, Member member, Store store) {
        return Review.builder()
                .content(request.getContent())
                .rating(request.getRating())
                .member(member)
                .store(store)
                .build();

    }

    public static ReviewResponseDTO.ReviewSearchResultDTO toReviewSearchResultDTO(Review review){
        return ReviewResponseDTO.ReviewSearchResultDTO.builder()
                .reviewId(review.getId())
                .content(review.getContent())
                .rating(review.getRating())
                .status(review.getStatus())
                .memberName(review.getMember().getName())
                .storeName(review.getStore().getName())
                .reviewImageList(review.getReviewImageList())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static ReviewResponseDTO.ReviewResultListDTO toReviewResultListDTO(Page<Review> reviewList) {
        List<ReviewResponseDTO.ReviewSearchResultDTO> reviewResultDTOList = reviewList.stream()
                .map(ReviewConverter::toReviewSearchResultDTO).collect(Collectors.toList());

        return ReviewResponseDTO.ReviewResultListDTO.builder()
                .isLast(reviewList.isLast())
                .isFirst(reviewList.isFirst())
                .totalPage(reviewList.getTotalPages())
                .totalElements(reviewList.getTotalElements())
                .listSize(reviewResultDTOList.size())
                .reviewList(reviewResultDTOList)
                .build();
    }

}
