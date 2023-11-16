package umc5th.spring.web.dto;

import java.time.LocalDate;
import lombok.Getter;

public class MissionRequestDTO {

    @Getter
    public static class createDto {

        private String content;
        private Integer price;
        private Integer point;
        private String authCode;
        private LocalDate endDate;
    }
}
