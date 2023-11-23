package umc5th.spring.converter;

import java.time.LocalDateTime;

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
}
