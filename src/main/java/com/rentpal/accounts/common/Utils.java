package com.rentpal.accounts.common;

/*
 * @author frank
 * @created 12 Dec,2020 - 3:24 AM
 */

import com.rentpal.accounts.model.APIRequestResponse;
import org.springframework.http.HttpStatus;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Utils {

    public static APIRequestResponse getApiRequestResponse(final String message) {
        return getApiRequestResponse(message, null);
    }
    /**
     * Gets the api request response.
     *
     * @param message the message
     * @param data the data
     * @return the api request response
     */
    public static APIRequestResponse getApiRequestResponse(final String message, final Object data) {
        APIRequestResponse response=new APIRequestResponse();
        if(data!=null) {
            response.setData(data);
        }
        response.setMessage(message);
        response.setHttpStatus(HttpStatus.OK);
        response.setStatus(Constants.SUCCESS);
        return response;
    }

    /**
     * Gets the date.
     *
     * @param milliseconds the milliseconds
     * @return the date
     */
    public static String getDate(Long milliseconds) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMM d, yyyy", Locale.ENGLISH);
        return simpleDateFormat.format(new Date(milliseconds));
    }

    /**
     * Gets the user id.
     *
     * @return the user id
     */
    public static Long getUserId() {
        Object id=RentpalThreadLocal.get("id");
        if(id!=null){
            return Long.parseLong(id.toString());
        }
        return null;
    }

    /**
     * Gets the user email.
     *
     * @return the user email
     */
    public static String getUserEmail() {
        Object email=RentpalThreadLocal.get("email");
        if(email!=null){
            return RentpalThreadLocal.get("email").toString();
        }
        return null;
    }
}
