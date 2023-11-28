package umc5th.spring.apiPayload.exception.handler;

import umc5th.spring.apiPayload.code.BaseErrorCode;
import umc5th.spring.apiPayload.exception.GeneralException;

public class StoreHandler extends GeneralException {
    public StoreHandler(BaseErrorCode errorCode) {super(errorCode);}

}
