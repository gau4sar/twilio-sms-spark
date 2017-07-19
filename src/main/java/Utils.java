import com.google.gson.Gson;
import spark.ResponseTransformer;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * Created by gaurav on 18/07/17.
 */
public class Utils {
    public static String toJson(Object object) {
        return new Gson().toJson(object);
    }

    public static ResponseTransformer json() {
        return Utils::toJson;
    }

    public static String convertTimeZone(String dateString) {
        DateFormat originalFormat = new SimpleDateFormat("EEE MMM d HH:mm:ss z yyyy");
        DateFormat targetFormat = new SimpleDateFormat("HH:mm a, d MMM yyyy");
        targetFormat.setTimeZone(TimeZone.getTimeZone("IST"));
        Date date = null;
        try {
            date = originalFormat.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String formattedDate = targetFormat.format(date);
        System.out.println(formattedDate);

        return formattedDate;
    }
}
