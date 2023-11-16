package umc5th.spring.web.dto;

import java.util.List;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Getter;
import umc5th.spring.validation.annotation.ExistCategories;

public class MemberRequestDTO {

    @Getter
    public static class JoinDto {
        @NotBlank
        String name;
        @NotNull
        Integer gender;
        @Size(min = 5, max = 12)
        String address;
        @ExistCategories
        List<Long> preferCategory;
        String nickname;
        String phoneNumber;

    }
}
