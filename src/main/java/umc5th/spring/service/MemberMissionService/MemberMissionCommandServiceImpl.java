package umc5th.spring.service.MemberMissionService;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc5th.spring.converter.MemberMissionConverter;
import umc5th.spring.domain.Member;
import umc5th.spring.domain.Mission;
import umc5th.spring.domain.mapping.MemberMission;
import umc5th.spring.repository.MemberMissionRepository;
import umc5th.spring.repository.MemberRepository;
import umc5th.spring.repository.MissionRepository;
import umc5th.spring.service.MemberService.MemberCommandService;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberMissionCommandServiceImpl implements MemberMissionCommandSevice {
    private final MemberCommandService memberCommandService;
    private final MissionRepository missionRepository;
    private final MemberMissionRepository memberMissionRepository;
    private final MemberRepository memberRepository;

    @Override
    @Transactional
    public List<Mission> getAvailableMissions(Long memberId) {
//        Member member = memberRepository.getReferenceById(memberId);
//        List<Mission> alreadyMemberMissions = memberMissionRepository.findByMember(member);
//        List<Mission> availableMissions = missionRepository.findUnfinishedMissions();
//
//        availableMissions = availableMissions.stream()
//                .filter(mission -> !alreadyMemberMissions.contains(mission))
//                .collect(Collectors.toList());
//        return availableMissions;

        return null;
    }

    @Override
    @Transactional
    public MemberMission addMemberMission(Long memberId, Long missionId) {

        if (!memberRepository.existsById(memberId)) {
            throw new IllegalArgumentException("Member ID does not exist: " + memberId);
        }
        if (!missionRepository.existsById(missionId)) {
            throw new IllegalArgumentException("Mission ID does not exist: " + missionId);
        }

        Member member = memberRepository.getReferenceById(memberId);
        Mission mission = missionRepository.getReferenceById(missionId);

        // if (memberMissionRepository.existsByMissionId(missionId)){
        //     throw new IllegalArgumentException("Mission already exists: " + missionId);
        //}
        MemberMission memberMission = MemberMissionConverter.toMemberMission(member, mission);
        if (memberMissionRepository.existsById(memberMission.getId())) {
            throw new IllegalArgumentException("Member-mission ID already exists: " + memberMission);
        }
        return memberMissionRepository.save(memberMission);
    }
}
