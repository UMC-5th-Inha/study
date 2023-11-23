package umc5th.spring.service.MemberService;

import org.springframework.data.domain.Page;
import umc5th.spring.domain.Member;
import umc5th.spring.domain.Review;
import umc5th.spring.web.dto.MemberRequestDTO;
import umc5th.spring.web.dto.ReviewResponseDTO;

import java.util.List;
import java.util.Optional;

public interface MemberCommandService {

    Member joinMember(MemberRequestDTO.JoinDto request);

    public Optional<Member> findMember(Long memberId);

    public Page<Review> getReviewList(Long memberId, int page);
}
