package umc5th.spring.web.dto;

import lombok.Getter;

import javax.validation.constraints.NotNull;

public class ReviewRequestDTO {

    @Getter
    public static class CreateDto{
        @NotNull
        String content;
        @NotNull
        Float rating;
    }

}
