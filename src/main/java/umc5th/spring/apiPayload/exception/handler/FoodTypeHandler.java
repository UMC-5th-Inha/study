package umc5th.spring.apiPayload.exception.handler;

import umc5th.spring.apiPayload.code.BaseErrorCode;
import umc5th.spring.apiPayload.exception.GeneralException;

public class FoodTypeHandler extends GeneralException {

    public FoodTypeHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }

}
