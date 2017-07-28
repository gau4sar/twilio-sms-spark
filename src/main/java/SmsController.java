import com.twilio.sdk.TwilioRestClient;
import com.twilio.sdk.resource.instance.Sms;
import com.twilio.sdk.resource.list.SmsList;
import model.SmsMessage;
import model.SmsService;

import java.util.ArrayList;
import java.util.List;

import static spark.Spark.get;

/**
 * Created by gaurav on 18/07/17.
 */
public class SmsController {

    public SmsController(TwilioRestClient client) {

        get("/users", (request, response) -> {

            System.out.println(response.body());
            
            List<SmsMessage> messageList = new ArrayList<>();
            SmsList smss = client.getAccount().getSmsMessages();

            // Loop over smss and print out a property for each one.
            for (Sms sms : smss) {
                messageList.add(new SmsMessage(
                        sms.getTo(), Utils.convertTimeZone(sms.getDateSent().toString()),
                        sms.getBody().substring(sms.getBody().length() - 6)));
            }

            SmsService smsService = new SmsService(messageList);
            return smsService.getSmsMessages();
        }, Utils.json());

        // more routes


    }
}
