package umc5th.spring.converter;

import umc5th.spring.domain.Region;
import umc5th.spring.domain.Store;
import umc5th.spring.web.dto.StoreRequestDTO;
import umc5th.spring.web.dto.StoreResponseDTO;

import java.time.LocalDateTime;

public class StoreConverter {

    public static StoreResponseDTO.JoinResultDTO toJoinResultDTO(Store store) {
        return StoreResponseDTO.JoinResultDTO.builder()
                .storeId(store.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Store toStore(StoreRequestDTO.JoinDto request, Region region) {

        return Store.builder()
                .address(request.getAddress())
                .name(request.getName())
                .region(region)
                .type(request.getType())
                .build();
    }
}
