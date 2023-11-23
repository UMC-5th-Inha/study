package umc5th.spring.service.StoreService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc5th.spring.converter.StoreConverter;
import umc5th.spring.domain.Region;
import umc5th.spring.domain.Store;
import umc5th.spring.repository.RegionRepository;
import umc5th.spring.repository.StoreRepository;
import umc5th.spring.web.dto.StoreRequestDTO;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
//@Transactional(readOnly = true)
public class StoreCommandServiceImpl implements StoreCommandService{

    private final StoreRepository storeRepository;

    private final RegionRepository regionRepository;

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
}
