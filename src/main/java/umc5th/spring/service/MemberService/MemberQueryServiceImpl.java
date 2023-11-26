package umc5th.spring.service.MemberService;

import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc5th.spring.domain.Member;
import umc5th.spring.domain.enums.MemberMissionState;
import umc5th.spring.domain.mapping.MemberMission;
import umc5th.spring.repository.MemberMissionRepository;
import umc5th.spring.repository.MemberRepository;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberQueryServiceImpl implements MemberQueryService {

    private final MemberRepository memberRepository;
    private final MemberMissionRepository memberMissionRepository;

    @Override
    public Optional<Member> findMember(Long id) {
        return null;
    }

    @Override
    public Page<MemberMission> getMemberMissionList(Long memberId, Integer page,
                                                    MemberMissionState memberMissionState) {
        Member member = memberRepository.getReferenceById(memberId);
        Page<MemberMission> missionPage = memberMissionRepository.findAllByMemberAndState(member, memberMissionState,
                PageRequest.of(page, 10));

        return missionPage;
    }


}
