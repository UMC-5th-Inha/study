package umc5th.spring.service.ReviewService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc5th.spring.apiPayload.code.status.ErrorStatus;
import umc5th.spring.apiPayload.exception.handler.StoreHandler;
import umc5th.spring.converter.ReviewConverter;
import umc5th.spring.domain.Member;
import umc5th.spring.domain.Review;
import umc5th.spring.domain.Store;
import umc5th.spring.repository.MemberRepository;
import umc5th.spring.repository.ReviewRepository;
import umc5th.spring.repository.StoreRepository;
import umc5th.spring.web.dto.ReviewRequestDTO;


@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ReviewCommandServiceImpl implements ReviewCommandService {

    private final ReviewRepository reviewRepository;
    private final MemberRepository memberRepository;
    private final StoreRepository storeRepository;
    @Override
    @Transactional
    public Review createReview(ReviewRequestDTO.CreateDto request, Long storeId) {
        Member member =  memberRepository.getReferenceById(1L);

        Store store = storeRepository.findByIdAndStateTrue(storeId)
                .orElseThrow(() -> new StoreHandler(ErrorStatus.STORE_NOT_EXTIST));

        Review newReview = ReviewConverter.toReview(request,member, store);
        return reviewRepository.save(newReview);


    }



}
