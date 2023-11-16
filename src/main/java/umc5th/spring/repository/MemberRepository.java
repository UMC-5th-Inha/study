package umc5th.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc5th.spring.domain.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {


}
