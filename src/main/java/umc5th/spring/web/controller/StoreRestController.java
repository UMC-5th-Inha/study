package umc5th.spring.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import umc5th.spring.apiPayload.ApiResponse;
import umc5th.spring.apiPayload.code.status.ErrorStatus;
import umc5th.spring.apiPayload.exception.handler.StoreHandler;
import umc5th.spring.converter.StoreConverter;
import umc5th.spring.domain.Mission;
import umc5th.spring.domain.Store;
import umc5th.spring.service.StoreService.StoreCommandService;
import umc5th.spring.web.dto.StoreRequestDTO;
import umc5th.spring.web.dto.StoreResponseDTO;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/stores")
public class StoreRestController {

    private final StoreCommandService storeCommandService;

    @PostMapping("/new")
    public ApiResponse<StoreResponseDTO.JoinResultDTO> join(@RequestBody @Valid StoreRequestDTO.JoinDto request) {
        Store store = storeCommandService.joinStore(request);

        return ApiResponse.onSuccess(StoreConverter.toJoinResultDTO(store));
    }

    @GetMapping("/{store-id}/missions")
    public ApiResponse<StoreResponseDTO.MissionPreViewListDTO> getMissionList(@PathVariable(name = "store-id") Long storeId, @RequestParam(name = "page") Integer page){
        if(page > 0){
            Page<Mission> storeMissions = storeCommandService.getMissionList(storeId, page-1);

            return ApiResponse.onSuccess(StoreConverter.missionPreViewListDTO(storeMissions));
        }
        throw new StoreHandler(ErrorStatus.INVALID_PAGE);
    }
}
