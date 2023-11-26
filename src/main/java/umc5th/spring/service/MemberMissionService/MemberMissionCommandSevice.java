package umc5th.spring.service.MemberMissionService;

import java.util.List;
import umc5th.spring.domain.Mission;
import umc5th.spring.domain.mapping.MemberMission;

public interface MemberMissionCommandSevice {
    List<Mission> getAvailableMissions(Long memberId);

    MemberMission addMemberMission(Long memberId, Long missionId);

    MemberMission updateMemberMissionComplete(Long memberId, Long memberMissionId);
}
