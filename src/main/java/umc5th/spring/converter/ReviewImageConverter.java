package umc5th.spring.converter;

import umc5th.spring.domain.Member;
import umc5th.spring.domain.Review;
import umc5th.spring.domain.ReviewImage;
import umc5th.spring.domain.Store;
import umc5th.spring.web.dto.ReviewRequestDTO;

import java.util.List;

public class ReviewImageConverter {

    public static ReviewImage toReviewImage(String reviewImageUrl) {

        return ReviewImage.builder()
                .imgUrls(reviewImageUrl)
                .build();
    }
}
