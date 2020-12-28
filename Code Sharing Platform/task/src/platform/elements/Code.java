package platform.elements;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
public class Code {

    @JsonIgnore
    @Id
    @Column
    private String id;

    @Column(length = 500000)
    private String code;

    @Column
    @JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss")
    private LocalDateTime date;

    @Column
    private long time;

    @Column
    private int views;

    @Column
    @JsonIgnore
    private int timeViewed;

    @Column
    @JsonIgnore
    private boolean timeRestrict;

    @Column
    @JsonIgnore
    private boolean viewRestrict;

    public Code() {
        id = UUID.randomUUID().toString();
        date = LocalDateTime.now();
        timeViewed = 0;
    }

    public Code(String code, int time, int views) {
        this();
        this.code = code;
        this.time = time;
        this.views = views;
    }

    public Code(String code, LocalDateTime date) {
        this.code = code;
        setDate(date);
    }

    public String getCode() {
        return code;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public long getTime() {
        if (!isTimeRestrict()) {
            return 0;
        }
        return time - Duration.between(date, LocalDateTime.now()).toSeconds();
    }

    public int getViews() {
        if (!isViewRestrict()) {
            return 0;
        }
        return views - timeViewed;
    }

    @SuppressWarnings("unused")
    @JsonIgnore
    public String getFormattedDate() {
        return date.getYear() +
                "/" +
                addZero(date.getMonthValue()) +
                "/" +
                addZero(date.getDayOfMonth()) +
                " " +
                addZero(date.getHour()) +
                ":" +
                addZero(date.getMinute()) +
                ":" +
                addZero(date.getSecond());
    }

    private String addZero(int number) {
        return String.valueOf(number).length() == 1 ?
                "0" + number : String.valueOf(number);
    }

    public void increaseTimeViewed() {
        if (isViewRestrict()) {
            timeViewed++;
        }
    }

    public boolean isTimeRestrict() {
        return timeRestrict;
    }

    public boolean isViewRestrict() {
        return viewRestrict;
    }

    public void setRestricts() {
        timeRestrict = time != 0;
        viewRestrict = views != 0;
    }

}
