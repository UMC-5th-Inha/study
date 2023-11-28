package umc5th.spring.service.StoreService;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import umc5th.spring.converter.StoreConverter;
import umc5th.spring.domain.Mission;
import umc5th.spring.domain.Region;
import umc5th.spring.domain.Store;
import umc5th.spring.repository.MissionRepository;
import umc5th.spring.repository.RegionRepository;
import umc5th.spring.repository.StoreRepository;
import umc5th.spring.web.dto.StoreRequestDTO;

import java.util.ArrayList;
import java.util.Optional;

@Service
@RequiredArgsConstructor
//@Transactional(readOnly = true)
public class StoreCommandServiceImpl implements StoreCommandService{

    private final StoreRepository storeRepository;

    private final RegionRepository regionRepository;

    private final MissionRepository missionRepository;
    @Override
    public Store joinStore(StoreRequestDTO.JoinDto request) {

        Region region = regionRepository.findRegionByName(request.getRegionName());

        if(region == null){
            region = Region.builder()
                    .name(request.getRegionName())
                    .storeList(new ArrayList<>())
                    .build();
        }

        Store newStore = StoreConverter.toStore(request, region);

        // region.getStoreList().add(newStore);

        regionRepository.save(region);

        return storeRepository.save(newStore);
    }

    @Override
    public Optional<Store> findStore(Long id) {
        return storeRepository.findById(id);
    }

    @Override
    public Page<Mission> getMissionList(Long StoreId, Integer page) {
        Store store = storeRepository.findById(StoreId).get();

        Page<Mission> StorePage = missionRepository.findAllByStore(store, PageRequest.of(page, 10));
        return StorePage;
    }

}
