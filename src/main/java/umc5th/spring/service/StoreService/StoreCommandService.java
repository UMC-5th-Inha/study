package umc5th.spring.service.StoreService;

import org.springframework.data.domain.Page;
import umc5th.spring.domain.Mission;
import umc5th.spring.domain.Store;
import umc5th.spring.web.dto.StoreRequestDTO;

import java.util.Optional;

public interface StoreCommandService {
    public Store joinStore(StoreRequestDTO.JoinDto request);
    Optional<Store> findStore(Long id);

    Page<Mission> getMissionList(Long StoreId, Integer page);
}
