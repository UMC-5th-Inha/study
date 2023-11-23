package umc5th.spring.web.controller;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import umc5th.spring.apiPayload.ApiResponse;
import umc5th.spring.converter.MemberMissionConverter;
import umc5th.spring.domain.Mission;
import umc5th.spring.domain.mapping.MemberMission;
import umc5th.spring.service.MemberMissionService.MemberMissionCommandSevice;
import umc5th.spring.web.dto.MemberMissionResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class MemberMissionRestController {
    private final MemberMissionCommandSevice memberMissionCommandSevice;

    @GetMapping("/{memberId}/missions/")
    public List<Mission> getAvailableMissions(@PathVariable Long memberId) {
        return memberMissionCommandSevice.getAvailableMissions(memberId);
    }

    @PostMapping("/{memberId}/missions/{missionId}")
    public ApiResponse<MemberMissionResponseDTO.addMemberMissionResultDTO> addMemberMission(
            @PathVariable Long memberId, @PathVariable Long missionId) {
        MemberMission savedMemberMission = memberMissionCommandSevice.addMemberMission(memberId, missionId);

        return ApiResponse.onSuccess(MemberMissionConverter.toAddMemberMissionResultDTO(savedMemberMission));
    }
    @PatchMapping ("/{memberId}/missions/{memberMissionId}")
    public MemberMission updateMemberMissionComplete(@PathVariable Long memberId, @PathVariable Long memberMissionId){
        return memberMissionCommandSevice.updateMemberMissionComplete(memberId, memberMissionId);
    }

}
