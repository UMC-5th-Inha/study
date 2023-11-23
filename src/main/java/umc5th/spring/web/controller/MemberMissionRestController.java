package umc5th.spring.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import umc5th.spring.apiPayload.ApiResponse;
import umc5th.spring.converter.MemberMissionConverter;
import umc5th.spring.domain.mapping.MemberMission;
import umc5th.spring.service.MemberService.MemberQueryService;
import umc5th.spring.web.dto.MemberMissionResponseDTO;

@RestController
@RequestMapping("/missions")
@RequiredArgsConstructor
public class MemberMissionRestController {

    private final MemberQueryService memberQueryService;

    @GetMapping("/{memberId}")
    @Operation(summary = "내가 진행중인 미션 목록 조회 API", description = "내가 진행중인 미션의 목록을 조회하는 API이며, 페이징을 포함합니다. Query String 으로 page 번호를 주세요")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200", description = "OK,성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!", content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "acess 토큰 만료", content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "acess 토큰 모양이 이상함", content = @Content(schema = @Schema(implementation = ApiResponse.class))),
    })
    @Parameters({@Parameter(name = "memberId", description = "멤버의 아이디, path variable 입니다")})
    public ApiResponse<MemberMissionResponseDTO.MyMissionPreviewInProgressListDTO> getMyMissionInProgressList(
            @PathVariable(name = "memberId") Long memberId, @RequestParam(name = "page") Integer page) {
        Page<MemberMission> memberMissionList = memberQueryService.getMemberMissionList(memberId, page);

        return ApiResponse.onSuccess(MemberMissionConverter.myMissionPreviewInProgressListDTO(memberMissionList));
    }

}
