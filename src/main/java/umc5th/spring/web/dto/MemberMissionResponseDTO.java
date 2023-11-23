package umc5th.spring.web.dto;

import java.time.LocalDateTime;
import lombok.*;


public class MemberMissionResponseDTO {
    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class addMemberMissionResultDTO{
        Long memberMissionId;
        LocalDateTime createdAt;
    }

}
