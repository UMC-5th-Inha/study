package umc5th.spring.service.MissionService;

import umc5th.spring.domain.Mission;
import umc5th.spring.web.dto.MissionRequestDTO;

public interface MissionCommandService {

    Mission createMission(MissionRequestDTO.createDto request, Long storeId);
}
