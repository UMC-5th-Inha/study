package umc5th.spring.converter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import umc5th.spring.domain.Member;
import umc5th.spring.domain.enums.Gender;
import umc5th.spring.web.dto.MemberRequestDTO;
import umc5th.spring.web.dto.MemberResponseDTO;

public class MemberConverter {

    public static MemberResponseDTO.JoinResultDTO toJoinResultDTO(Member member) {
        return MemberResponseDTO.JoinResultDTO.builder()
                .memberId(member.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Member toMember(MemberRequestDTO.JoinDto request) {

        Gender gender = null;

        switch (request.getGender()) {
            case 1:
                gender = Gender.MALE;
                break;
            case 2:
                gender = Gender.FEMALE;
                break;
        }

        return Member.builder()
                .nickname(request.getNickname())
                .address(request.getAddress())
                .gender(gender)
                .name(request.getName())
                .memberFoodTypeList(new ArrayList<>())
                .build();
    }
}
