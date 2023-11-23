package umc5th.spring.web.dto;

import lombok.Getter;

import java.util.List;

public class ReviewRequestDTO {

    @Getter
    public static class JoinDto {
        String content;
        Float rating;
        Long memberId;
        List<String> reviewImageList;
    }
}
