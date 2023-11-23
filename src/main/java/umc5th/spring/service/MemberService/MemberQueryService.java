package umc5th.spring.service.MemberService;

import java.util.Optional;
import org.springframework.data.domain.Page;
import umc5th.spring.domain.Member;
import umc5th.spring.domain.mapping.MemberMission;

public interface MemberQueryService {

    Optional<Member> findMember(Long id);

    Page<MemberMission> getMemberMissionList(Long memberId, Integer page);

}
