package umc5th.spring.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import umc5th.spring.apiPayload.ApiResponse;
import umc5th.spring.converter.ReviewConverter;
import umc5th.spring.converter.StoreConverter;
import umc5th.spring.domain.Review;
import umc5th.spring.domain.Store;
import umc5th.spring.service.ReviewService.ReviewCommandService;
import umc5th.spring.service.StoreService.StoreCommandService;
import umc5th.spring.web.dto.ReviewRequestDTO;
import umc5th.spring.web.dto.ReviewResponseDTO;
import umc5th.spring.web.dto.StoreRequestDTO;
import umc5th.spring.web.dto.StoreResponseDTO;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/stores")
public class StoreRestController {

    private final StoreCommandService storeCommandService;

    private final ReviewCommandService reviewCommandService;

    @PostMapping("/new")
    public ApiResponse<StoreResponseDTO.JoinResultDTO> join(@RequestBody @Valid StoreRequestDTO.JoinDto request) {
        Store store = storeCommandService.joinStore(request);

        return ApiResponse.onSuccess(StoreConverter.toJoinResultDTO(store));
    }

    @PostMapping("/{storeId}/reviews")
    public ApiResponse<ReviewResponseDTO.JoinResultDTO> join(@PathVariable long storeId, @RequestBody @Valid ReviewRequestDTO.JoinDto request) {

        Review review = reviewCommandService.joinReview(request, storeId);

        return ApiResponse.onSuccess(ReviewConverter.toJoinResultDTO(review));
    }

    @PostMapping("/{storeId}/missions/challenge")
    public Boolean join(@PathVariable long storeId) {

        return storeCommandService.insertMissions(storeId);
    }
}

