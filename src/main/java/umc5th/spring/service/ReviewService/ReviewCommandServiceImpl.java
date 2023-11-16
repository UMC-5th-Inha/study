package umc5th.spring.service.ReviewService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc5th.spring.converter.ReviewConverter;
import umc5th.spring.domain.Review;
import umc5th.spring.repository.ReviewRepositoy;
import umc5th.spring.web.dto.ReviewRequestDTO;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ReviewCommandServiceImpl implements ReviewCommandService {

    final private ReviewRepositoy reviewRepositoy;

    @Override
    @Transactional
    public Review createReview(ReviewRequestDTO.CreateDto request) {
        Review newReview = ReviewConverter.toReview(request);

        return reviewRepositoy.save(newReview);
    }


}
