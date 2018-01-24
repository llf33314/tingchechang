package com.gt.parking.lot.core.exception;


import com.gt.parking.lot.common.enums.ResponseEnums;
import com.gt.parking.lot.common.exception.SystemException;

/**
 * @author psr
 *         Created by psr on 2017/10/10 0010.
 */
public class ParkingLotException extends SystemException {

    public ParkingLotException(String message) {
        super(message);
    }

    public ParkingLotException(int code, String message) {
        super(code, message);
    }

    public ParkingLotException(ResponseEnums responseEnums) {
        super(responseEnums);
    }
}
