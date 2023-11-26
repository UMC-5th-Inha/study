package umc5th.spring.service.MemberService;

import java.util.Optional;
import org.springframework.data.domain.Page;
import umc5th.spring.domain.Member;
import umc5th.spring.domain.enums.MemberMissionState;
import umc5th.spring.domain.mapping.MemberMission;
import umc5th.spring.web.dto.MemberMissionRequestDTO;

public interface MemberQueryService {

    Optional<Member> findMember(Long id);

    Page<MemberMission> getMemberMissionList(Long memberId, Integer page, MemberMissionState memberMissionState);

}
