package umc5th.spring.service.StoreService;

import umc5th.spring.domain.Store;
import umc5th.spring.web.dto.StoreRequestDTO;

public interface StoreCommandService {
    public Store joinStore(StoreRequestDTO.JoinDto request);
}
