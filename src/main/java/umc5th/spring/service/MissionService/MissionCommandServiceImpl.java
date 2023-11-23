package umc5th.spring.service.MissionService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc5th.spring.converter.MissionConverter;
import umc5th.spring.domain.Mission;
import umc5th.spring.domain.Store;
import umc5th.spring.repository.MissionRepository;
import umc5th.spring.repository.StoreRepository;
import umc5th.spring.web.dto.MissionRequestDTO;

@Service
@RequiredArgsConstructor
public class MissionCommandServiceImpl implements MissionCommandService {

    private final MissionRepository missionRepository;
    private final StoreRepository storeRepository;

    @Override
    @Transactional
    public Mission createMission(MissionRequestDTO.createDto request, Long storeId) {

        if (!storeRepository.existsById(storeId)) {
            throw new IllegalArgumentException("Store ID does not exist: " + storeId);
        }
        Store store = storeRepository.getReferenceById(storeId);

        Mission newMission = MissionConverter.toMission(request, store);
        return missionRepository.save(newMission);
    }

}
