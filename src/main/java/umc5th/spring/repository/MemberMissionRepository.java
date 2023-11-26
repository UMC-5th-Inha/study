package umc5th.spring.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import umc5th.spring.domain.Member;
import umc5th.spring.domain.enums.MemberMissionState;
import umc5th.spring.domain.mapping.MemberMission;

public interface MemberMissionRepository extends JpaRepository<MemberMission, Long> {
    Page<MemberMission> findAllByMemberAndState(Member member, MemberMissionState state, Pageable pageable);

}
