package umc5th.spring.converter;

import java.time.LocalDateTime;
import umc5th.spring.domain.Mission;
import umc5th.spring.domain.Store;
import umc5th.spring.repository.StoreRepository;
import umc5th.spring.web.dto.MissionRequestDTO;
import umc5th.spring.web.dto.MissionResponseDTO;

public class MissionConverter {


    public static MissionResponseDTO.createMissionResultDTO toCreateMissionResultDTO(Mission mission) {
        return MissionResponseDTO.createMissionResultDTO.builder()
                .missionId(mission.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Mission toMission(MissionRequestDTO.createDto request, Store store) {

        return Mission.builder()
                .content(request.getContent())
                .price(request.getPrice())
                .point(request.getPoint())
                .authCode(request.getAuthCode())
                .endDate(request.getEndDate())
                .store(store)
                .build();

    }

}
