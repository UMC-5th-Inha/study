package umc5th.spring.service.MemberService;

import org.springframework.data.domain.Page;
import umc5th.spring.domain.Member;
import umc5th.spring.domain.Review;
import umc5th.spring.web.dto.MemberRequestDTO;

import java.util.Optional;

public interface MemberCommandService {

    Member joinMember(MemberRequestDTO.JoinDto request);

    Optional<Member> findMember(Long memberId);

    Page<Review> getReviewList(Long memberId, int page);
}
