package umc5th.spring.service.ReviewService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc5th.spring.converter.ReviewConverter;
import umc5th.spring.converter.ReviewImageConverter;
import umc5th.spring.domain.Member;
import umc5th.spring.domain.Review;
import umc5th.spring.domain.ReviewImage;
import umc5th.spring.domain.Store;
import umc5th.spring.repository.MemberRepository;
import umc5th.spring.repository.ReviewImageRepository;
import umc5th.spring.repository.ReviewRepository;
import umc5th.spring.repository.StoreRepository;
import umc5th.spring.web.dto.ReviewRequestDTO;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReviewCommandServiceImpl implements ReviewCommandService{

    private final StoreRepository storeRepository;
    private final MemberRepository memberRepository;
    private final ReviewRepository reviewRepository;
    private final ReviewImageRepository reviewImageRepository;

    @Override
    @Transactional
    public Review joinReview(ReviewRequestDTO.JoinDto request, Long storeId) {

        Store store = storeRepository.findStoreById(storeId);
        Member member = memberRepository.findMemberById(request.getMemberId());

        request.getReviewImageList().stream()
                .forEach(reviewImageUrl -> {
                    ReviewImage reviewImage = ReviewImageConverter.toReviewImage(reviewImageUrl);
                    reviewImageRepository.save(reviewImage);
                });

        Review review = ReviewConverter.toReview(request, store, member);

        return reviewRepository.save(review);
    }
}
