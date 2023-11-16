package umc5th.spring.converter;

import java.util.List;
import java.util.stream.Collectors;
import umc5th.spring.domain.FoodType;
import umc5th.spring.domain.mapping.MemberFoodType;

public class MemberFoodTypeConverter {

    public static List<MemberFoodType> toMemberPreferList(List<FoodType> foodTypes) {
        return foodTypes.stream()
                .map(foodType ->
                        MemberFoodType.builder()
                                .foodType(foodType)
                                .build()
                ).collect(Collectors.toList());
    }
}
