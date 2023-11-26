package umc5th.spring.converter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.data.domain.Page;
import umc5th.spring.domain.Member;
import umc5th.spring.domain.Mission;
import umc5th.spring.domain.enums.MemberMissionState;
import umc5th.spring.domain.mapping.MemberMission;
import umc5th.spring.web.dto.MemberMissionResponseDTO;

public class MemberMissionConverter {
    public static MemberMissionResponseDTO.addMemberMissionResultDTO toAddMemberMissionResultDTO(
            MemberMission memberMission) {
        return MemberMissionResponseDTO.addMemberMissionResultDTO.builder()
                .memberMissionId(memberMission.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static MemberMission toMemberMission(Member member, Mission mission) {
        return MemberMission.builder()
                .state(MemberMissionState.IN_PROGRESS)
                .member(member)
                .mission(mission)
                .build();
    }

    public static MemberMissionResponseDTO.MyMissionPreviewDTO myMissionPreviewDTO(MemberMission memberMission) {
        return MemberMissionResponseDTO.MyMissionPreviewDTO.builder()
                .content(memberMission.getMission().getContent())
                .price(memberMission.getMission().getPrice())
                .storeName(memberMission.getMission().getStore().getName())
                .build();
    }

    public static MemberMissionResponseDTO.MyMissionPreviewInProgressListDTO myMissionPreviewInProgressListDTO(
            Page<MemberMission> missionList) {
        List<MemberMissionResponseDTO.MyMissionPreviewDTO> myMissionPreviewDTOList = missionList.stream()
                .map(MemberMissionConverter::myMissionPreviewDTO).collect(Collectors.toList());

        return MemberMissionResponseDTO.MyMissionPreviewInProgressListDTO.builder()
                .isLast(missionList.isLast())
                .isFirst(missionList.isFirst())
                .totalPage(missionList.getTotalPages())
                .totalElements(missionList.getTotalElements())
                .listSize(myMissionPreviewDTOList.size())
                .myMissionListInProgress(myMissionPreviewDTOList)
                .build();
    }

}
