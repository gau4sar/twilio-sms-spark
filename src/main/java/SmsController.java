import com.twilio.sdk.TwilioRestClient;
import com.twilio.sdk.resource.ResourceSet;

import com.twilio.sdk.resource.api.v2010.account.Message;
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
        List<SmsMessage> messageList = new ArrayList<>();

        get("/users", (request, response) -> {
            // process request
            ResourceSet<Message> smss = Message.read(client.getAccountSid()).execute();
            // Loop over smss and print out a property for each one.
            for (Message sms : smss) {
                messageList.add(new SmsMessage(
                        sms.getTo(), sms.getDateSent().toString(),
                        sms.getBody().substring(sms.getBody().length() - 6)));
            }

            SmsService smsService = new SmsService(messageList);
            return smsService.getSmsMessages();
        }, JsonUtil.json());

        // more routes


    }
}
