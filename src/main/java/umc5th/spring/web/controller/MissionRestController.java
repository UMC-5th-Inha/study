package umc5th.spring.web.controller;

import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import umc5th.spring.apiPayload.ApiResponse;
import umc5th.spring.converter.MissionConverter;
import umc5th.spring.domain.Mission;
import umc5th.spring.service.MissionService.MissionCommandService;
import umc5th.spring.service.MissionService.MissionCommandServiceImpl;
import umc5th.spring.web.dto.MissionRequestDTO;
import umc5th.spring.web.dto.MissionResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/stores")
public class MissionRestController {

    private final MissionCommandService missionCommandService;


    @PostMapping("/missions/{storeId}")
    public ApiResponse<MissionResponseDTO.createMissionResultDTO> createMission(
            @RequestBody @Valid MissionRequestDTO.createDto request, @PathVariable(value = "storeId") Long storeId) {
        Mission mission = missionCommandService.createMission(request, storeId);
        return ApiResponse.onSuccess(MissionConverter.toCreateMissionResultDTO(mission));
    }


}
