package umc5th.spring.service.ReviewService;

import lombok.RequiredArgsConstructor;
import org.hibernate.jpa.spi.StoredProcedureQueryParameterRegistration;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc5th.spring.converter.ReviewConverter;
import umc5th.spring.domain.Member;
import umc5th.spring.domain.Review;
import umc5th.spring.domain.Store;
import umc5th.spring.repository.MemberRepository;
import umc5th.spring.repository.ReviewRepositoy;
import umc5th.spring.repository.StoreRepository;
import umc5th.spring.web.dto.ReviewRequestDTO;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ReviewCommandServiceImpl implements ReviewCommandService {

    final private ReviewRepositoy reviewRepositoy;
    final private MemberRepository memberRepository;
    final private StoreRepository storeRepository;
    @Override
    @Transactional
    public Review createReview(ReviewRequestDTO.CreateDto request, Long storeId) {
        Member member =  memberRepository.getReferenceById(1L);
        Store store = storeRepository.getReferenceById(storeId);
        Review newReview = ReviewConverter.toReview(request,member, store);

        return reviewRepositoy.save(newReview);
    }


}
