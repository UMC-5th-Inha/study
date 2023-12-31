package umc5th.spring.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import umc5th.spring.apiPayload.ApiResponse;
import umc5th.spring.converter.MemberConverter;
import umc5th.spring.converter.ReviewConverter;
import umc5th.spring.domain.Member;
import umc5th.spring.domain.Review;
import umc5th.spring.service.ReviewService.ReviewCommandService;
import umc5th.spring.web.dto.MemberRequestDTO;
import umc5th.spring.web.dto.MemberResponseDTO;
import umc5th.spring.web.dto.ReviewRequestDTO;
import umc5th.spring.web.dto.ReviewResponseDTO;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reviews")
public class ReviewController {
    private final ReviewCommandService reviewCommandService;

    @PostMapping("/{storeId}")
    public ApiResponse<ReviewResponseDTO.ReviewResultDTO> join(@RequestBody @Valid ReviewRequestDTO.CreateDto request, @PathVariable Long storeId){
        Review review = reviewCommandService.createReview(request, storeId);
        return ApiResponse.onSuccess(ReviewConverter.toReviewResultDTO(review));
    }
}
