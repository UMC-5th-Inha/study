package umc5th.spring.apiPayload.exception.handler;

import umc5th.spring.apiPayload.code.BaseErrorCode;
import umc5th.spring.apiPayload.exception.GeneralException;

public class TempHandler extends GeneralException {

    public TempHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}
