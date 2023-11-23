package umc5th.spring.service.MemberService;

import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc5th.spring.domain.Member;
import umc5th.spring.domain.mapping.MemberMission;
import umc5th.spring.repository.MemberMissionRepository;
import umc5th.spring.repository.MemberRepository;
import umc5th.spring.repository.MissionRepository;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberQueryServiceImpl implements MemberQueryService {

    private final MemberRepository memberRepository;
    private final MissionRepository missionRepository;
    private final MemberMissionRepository memberMissionRepository;

    @Override
    public Optional<Member> findMember(Long id) {
        return null;
    }

    @Override
    public Page<MemberMission> getMemberMissionList(Long memberId, Integer page) {
        Member member = memberRepository.getReferenceById(memberId);
        Page<MemberMission> missionPage = memberMissionRepository.findAllByMember(member, PageRequest.of(page, 10));
        //Page<MemberMission> missionPage = missionRepository.findAllByMemberId(memberId, PageRequest.of(page, 10));

        return missionPage;
    }


}
