import com.google.gson.Gson;
import spark.ResponseTransformer;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss Z");
        Date date = null;
        try {
            date = formatter.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return formatter.format(date);
    }
}
