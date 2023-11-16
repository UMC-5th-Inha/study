package umc5th.spring.service.MemberService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc5th.spring.apiPayload.code.status.ErrorStatus;
import umc5th.spring.apiPayload.exception.handler.FoodCategoryHandler;
import umc5th.spring.converter.MemberConverter;
import umc5th.spring.converter.MemberPreferConverter;
import umc5th.spring.domain.FoodType;
import umc5th.spring.domain.Member;
import umc5th.spring.domain.mapping.MemberFoodType;
import umc5th.spring.repository.FoodTypeRepository;
import umc5th.spring.repository.MemberRepository;
import umc5th.spring.web.dto.MemberRequestDTO;

import java.util.List;
import java.util.stream.Collectors;

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

        List<FoodType> foodTypeList = request.getPreferCategory().stream()
                .map(category -> {
                    return foodTypeRepository.findById(category).orElseThrow(() -> new FoodCategoryHandler(ErrorStatus.FOOD_CATEGORY_NOT_FOUND));
                }).collect(Collectors.toList());

        List<MemberFoodType> memberPreferList = MemberPreferConverter.toMemberFoodTypeList(foodTypeList);

        memberPreferList.forEach(memberPrefer -> {memberPrefer.setMember(newMember);});

        return memberRepository.save(newMember);
    }

}
