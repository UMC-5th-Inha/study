package umc5th.spring.web.dto;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import lombok.*;


public class MemberMissionResponseDTO {
    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MyMissionPreviewInProgressListDTO {
        List<MyMissionPreviewDTO> myMissionListInProgress;
        Integer listSize;
        Integer totalPage;
        Long totalElements;
        Boolean isFirst;
        Boolean isLast;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MyMissionPreviewDTO {
        String storeName;
        Integer price;
        String content;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class addMemberMissionResultDTO{
        Long memberMissionId;
        LocalDateTime createdAt;
    }
}
