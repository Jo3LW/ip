package task;

import java.time.format.DateTimeFormatter;
import java.time.LocalDate;

public class Deadline extends Task {
    protected String by;

    protected String output;

    protected String string_Date;

    protected LocalDate date;

    protected String string_Time;


    /**
     * Creates a new Deadline.
     * @param description The name of activity.
     * @param by The time to do the deadline by.
     */
    public Deadline(String description, String by) {
        super(description);
        this.by = by;
        String[] dateAndTime = by.split(" ");;
        this.string_Date = dateAndTime[0];
        this.string_Time = dateAndTime[1];
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
        date = LocalDate.parse(string_Date, formatter);
        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("MMM dd yyyy");
        output = date.format(formatter1);
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " +
                output + " " + string_Time + ")";
    }

    public boolean isDueSoon() {
        LocalDate currentDate = LocalDate.now();
        LocalDate deadLine = currentDate.plusDays(6);
        return !date.isAfter(deadLine);
    }
}
