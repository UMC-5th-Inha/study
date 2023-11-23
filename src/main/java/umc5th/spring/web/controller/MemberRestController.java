package umc5th.spring.web.controller;

import javax.validation.Valid;

import io.swagger.v3.oas.annotations.Parameter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import umc5th.spring.apiPayload.ApiResponse;
import umc5th.spring.converter.MemberConverter;
import umc5th.spring.converter.ReviewConverter;
import umc5th.spring.domain.Member;
import umc5th.spring.domain.Review;
import umc5th.spring.service.MemberService.MemberCommandService;
import umc5th.spring.web.dto.MemberRequestDTO;
import umc5th.spring.web.dto.MemberResponseDTO.JoinResultDTO;
import umc5th.spring.web.dto.ReviewResponseDTO;


@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberRestController {

    private final MemberCommandService memberCommandService;

    @PostMapping("/")
    public ApiResponse<JoinResultDTO> join(@RequestBody @Valid MemberRequestDTO.JoinDto request) {
        Member member = memberCommandService.joinMember(request);
        return ApiResponse.onSuccess(MemberConverter.toJoinResultDTO(member));
    }

    @GetMapping("/{memberId}/reviews")
    @Parameter(name = "page", description = "페이지 번호, 0번이 1 페이지입니다.")
    public ApiResponse<ReviewResponseDTO.ReviewResultListDTO> getReviews(@PathVariable long memberId, @RequestParam(name = "page") Integer page){

        if(page > 0){
            Page<Review> memberReviews = memberCommandService.getReviewList(memberId, page);
            return ApiResponse.onSuccess(ReviewConverter.toReviewResultListDTO(memberReviews));
        }

        return null;
    }
}
