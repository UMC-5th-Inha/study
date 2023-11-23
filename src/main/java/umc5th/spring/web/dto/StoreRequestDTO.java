package umc5th.spring.web.dto;

import lombok.Getter;


public class StoreRequestDTO {
  
    @Getter
    public static class JoinDto {
        String name;
        String type;
        String address;
        String regionName;
    }
}
