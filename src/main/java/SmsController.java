import model.SmsService;

import static spark.Spark.after;
import static spark.Spark.before;
import static spark.Spark.get;

/**
 * Created by gaurav on 18/07/17.
 */
public class SmsController {

    public SmsController(final SmsService smsService) {

        get("/users", (request, response) -> {
            // process request
            return smsService.getSmsMessages();
        }, JsonUtil.json());

        // more routes


    }
}
