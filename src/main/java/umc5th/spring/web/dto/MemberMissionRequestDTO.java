package umc5th.spring.web.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import umc5th.spring.domain.enums.MemberMissionState;

public class MemberMissionRequestDTO {

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MyMissionPreviewRequestDTO {
        private MemberMissionState memberMissionState;
    }
}
