package umc5th.spring.service.MemberService;

import umc5th.spring.domain.Member;
import umc5th.spring.web.dto.MemberRequestDTO;

public interface MemberCommandService {

    Member joinMember(MemberRequestDTO.JoinDto request);
}
