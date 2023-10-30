package com.lbg.ob.aisp.intent.resolver.api.utility;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import org.jboss.logging.Logger;

import com.lbg.ob.aisp.intent.resolver.api.constants.IntentConstants;

public class DateUtils {
    
    private static final Logger logger = Logger.getLogger(DateUtils.class);


    public static Date getCurrentDateTime() {
        DateFormat sdf = new SimpleDateFormat(IntentConstants.DATE_FORMAT);
        Date createdAtDate = null;
        try {
            TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
            createdAtDate = sdf.parse(sdf.format(new Date()));
        } catch (ParseException e) {
            logger.error("Parse exeption for the CreatedAt Date " + e.getMessage());
        }
        return createdAtDate;
    }
}
