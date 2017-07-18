package model;

public class SmsMessage {

    private String to;
    private String dateSent;
    private String otp;

    /**
     * No args constructor for use in serialization
     */
    public SmsMessage() {
    }

    /**
     * @param to
     * @param dateSent
     * @param otp
     */
    public SmsMessage(String to, String dateSent, String otp) {
        super();
        this.to = to;
        this.dateSent = dateSent;
        this.otp = otp;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getDateSent() {
        return dateSent;
    }

    public void setDateSent(String dateSent) {
        this.dateSent = dateSent;
    }

    public String getOtp() {
        return otp;
    }

    public void setOtp(String otp) {
        this.otp = otp;
    }

}