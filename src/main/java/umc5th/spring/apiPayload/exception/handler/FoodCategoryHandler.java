package umc5th.spring.apiPayload.exception.handler;

import umc5th.spring.apiPayload.code.BaseErrorCode;
import umc5th.spring.apiPayload.exception.GeneralException;

public class FoodCategoryHandler extends GeneralException {

    public FoodCategoryHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}
