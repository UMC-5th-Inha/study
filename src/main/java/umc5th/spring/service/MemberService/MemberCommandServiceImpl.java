package umc5th.spring.service.MemberService;

import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc5th.spring.apiPayload.code.status.ErrorStatus;
import umc5th.spring.apiPayload.exception.handler.FoodTypeHandler;
import umc5th.spring.converter.MemberConverter;
import umc5th.spring.converter.MemberFoodTypeConverter;
import umc5th.spring.domain.FoodType;
import umc5th.spring.domain.Member;
import umc5th.spring.domain.mapping.MemberFoodType;
import umc5th.spring.repository.FoodTypeRepository;
import umc5th.spring.repository.MemberRepository;
import umc5th.spring.web.dto.MemberRequestDTO;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberCommandServiceImpl implements MemberCommandService {

    private final MemberRepository memberRepository;
    private final FoodTypeRepository foodTypeRepository;

    @Override
    @Transactional
    public Member joinMember(MemberRequestDTO.JoinDto request) {
        Member newMember = MemberConverter.toMember(request);
        List<FoodType> foodTypes = request.getPreferCategory().stream()
                .map(category -> {
                    return foodTypeRepository.findById(category)
                            .orElseThrow(() -> new FoodTypeHandler(ErrorStatus.FOOD_CATEGORY_NOT_FOUND));
                }).collect(Collectors.toList());

        List<MemberFoodType> memberFoodTypeList = MemberFoodTypeConverter.toMemberPreferList(foodTypes);

        memberFoodTypeList.forEach(memberFoodType -> {
            memberFoodType.setMember(newMember);
        });

        return memberRepository.save(newMember);
    }
}
