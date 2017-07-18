package model;

import java.util.List;

public class SmsService {

    private List<SmsMessage> smsMessages = null;

    /**
     * No args constructor for use in serialization
     */
    public SmsService() {
    }

    /**
     * @param smsMessages
     */
    public SmsService(List<SmsMessage> smsMessages) {
        super();
        this.smsMessages = smsMessages;
    }

    public List<SmsMessage> getSmsMessages() {
        return smsMessages;
    }

    public void setSmsMessages(List<SmsMessage> smsMessages) {
        this.smsMessages = smsMessages;
    }

}