import com.twilio.sdk.TwilioRestClient;
import com.twilio.sdk.resource.instance.Sms;
import com.twilio.sdk.resource.list.SmsList;
import model.SmsMessage;
import model.SmsService;
import spark.Spark;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.*;

public class SMSBackend {
    public static void main(String[] args) {

        //Heroku assigns different port each time, hence reading it from process.
        ProcessBuilder process = new ProcessBuilder();
        Integer port;
        if (process.environment().get("PORT") != null) {
            port = Integer.parseInt(process.environment().get("PORT"));
        } else {
            port = 4567;
        }
        Spark.port(port);

        TwilioRestClient client = new TwilioRestClient(
                "AC21e8234124dff16803124e62af2661d1",
                "9e855d7a8c39f0c5fa36676a265640fe");

        get("/", (req, res) -> "Hello, World");

        before((req, res) -> {
            res.type("application/json");
        });

        post("/sms", (req, res) -> {
            String body = req.queryParams("Body");
            String to = req.queryParams("To");
            String from = "+14437207354";

            Map<String, String> callParams = new HashMap<>();
            callParams.put("To", to);
            callParams.put("From", from);
            callParams.put("Body", body);
            Sms message = client.getAccount().getSmsFactory().create(callParams);

            return message.getSid();
        });

        /*List<SmsMessage> messageList = new ArrayList<>();
        SmsList smss = client.getAccount().getSmsMessages();

        // Loop over smss and print out a property for each one.
        for (Sms sms : smss) {
            messageList.add(new SmsMessage(
                    sms.getTo(), sms.getDateSent().toString(),
                    sms.getBody().substring(sms.getBody().length() - 6)));
        }*/

        new SmsController(client);
    }
}
