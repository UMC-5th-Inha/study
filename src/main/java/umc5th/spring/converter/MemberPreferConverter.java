package umc5th.spring.converter;

import umc5th.spring.domain.FoodType;
import umc5th.spring.domain.mapping.MemberFoodType;

import java.util.List;
import java.util.stream.Collectors;

public class MemberPreferConverter {
    public static List<MemberFoodType> toMemberFoodTypeList(List<FoodType> foodTypeList){

        return foodTypeList.stream()
                .map(foodType ->
                        MemberFoodType.builder()
                                .foodType(foodType)
                                .build()
                ).collect(Collectors.toList());
    }
}
