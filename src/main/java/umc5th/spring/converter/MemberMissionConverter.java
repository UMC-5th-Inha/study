package umc5th.spring.converter;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.data.domain.Page;
import umc5th.spring.domain.mapping.MemberMission;
import umc5th.spring.web.dto.MemberMissionResponseDTO;

public class MemberMissionConverter {

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
