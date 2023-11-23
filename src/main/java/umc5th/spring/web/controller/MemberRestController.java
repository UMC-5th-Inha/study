package umc5th.spring.web.controller;

import javax.validation.Valid;

import io.swagger.v3.oas.annotations.Parameters;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import umc5th.spring.apiPayload.ApiResponse;
import umc5th.spring.converter.MemberConverter;
import umc5th.spring.domain.Member;
import umc5th.spring.service.MemberService.MemberCommandService;
import umc5th.spring.web.dto.MemberRequestDTO;
import umc5th.spring.web.dto.MemberResponseDTO.JoinResultDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberRestController {

    private final MemberCommandService memberCommandService;

    @PostMapping("/")
    public ApiResponse<JoinResultDTO> join(@RequestBody @Valid MemberRequestDTO.JoinDto request) {
        Member member = memberCommandService.joinMember(request);
        return ApiResponse.onSuccess(MemberConverter.toJoinResultDTO(member));
    }
}
