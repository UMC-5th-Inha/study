package umc5th.spring.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import umc5th.spring.domain.Mission;

import java.time.LocalDate;
import java.util.List;


public class StoreRequestDTO {
  
    @Getter
    public static class JoinDto {
        String name;
        String type;
        String address;
        String regionName;
    }



}
