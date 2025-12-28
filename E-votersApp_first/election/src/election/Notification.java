package election;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Notification {
    private LocalDateTime timeCreated;
    private Poll poll;
    private boolean addNewPoll;
    private StringBuilder result;

    public Notification(Poll poll, boolean addNewPoll){
        this.poll = poll;
        this.addNewPoll = addNewPoll;
        timeCreated = LocalDateTime.now();
    }

    public void setResult(StringBuilder result) {
        this.result = result;
    }

    @Override
    public String toString() {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("E, MM-yyyy HH:mm");
        String dateFormatted = timeCreated.format(format);
        if(addNewPoll) return  "NEW POLL ALERT\n" +
                dateFormatted + "\n" +
                 poll;
        else return "POLL RESULT ALERT\n" +
                dateFormatted + "\n" +
                poll + result;

    }
}
