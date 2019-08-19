import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.text.ParseException;
import java.time.YearMonth;

class DateRange extends Date
{
    //instance fields
    private Date start;
    private Date end;
    private long length;
    private DateFormat sdf;

    //constructor
    public DateRange(Date x, Date y) {
        this.start = x;
        this.end = y;
        this.length = (this.end.getTime() - this.start.getTime())/(1000*60*60*24);
        this.sdf = new SimpleDateFormat("yyyy-MM-dd");
    }


    //methods
    public int getRange() {
        return this.length;
    }

    public boolean greaterThan(DateRange other) {
        return this.difference > other.difference;
    }

    public boolean equalTo(DateRange other) {
        return this.difference == other.difference;
    }

    public String printRange() {
        return this.sdf.format(this.start) + " ===> " + this.sdf.format(this.end);
        //return this.start.toString() + " ===> " + this.end.toString();
    }

    public int overlap(DateRange other) {
        Date latestStart = this.start.after(other.start) ? other : this.start;
        Date earliestEnd = this.end.before(other.end) ? this.end : other;
        int delta = (earliestEnd.getTime() - latestStart.getTime())/(1000*60*60*24);
        return Math.max(0, delta);
    }

    public boolean isOverlap(DateRange other) {
        return this.overlap(other) != 0;
    }

}

class Tests
{
    //instance fields
    private DateFormat sdf;
    //constructor
    public Tests()
    {
        this.sdf = new SimpleDateFormat("yyyy-MM-dd");
    }

    public int getRandomInteger(int min, int max) {
        return Math.floor(Math.random() * (max-min)) + min;
    }

    public getRandomDate(Date start) {
        const MAX_DAYS = 30;
        const MIN_DAYS = 3;

        Date temp = start.clone();
        int numberOfDays = this.getRandomInteger(MIN_DAYS, MAX_DAYS);
        YearMonth yearMonthObject = YearMonth.of(temp.getYear(), temp.getMonth());
        int daysInMonth = yearMonthObject.lengthOfMonth();
        numberOfDays = numberOfDays%daysInMonth == numberOfDays ?
                       numberOfDays : daysInMonth - numberOfDays;
        Date newDate = sdf.parse(temp.getTime() + numberOfDays*(1000*60*60*24));
        return newDate;
    }

}

public class movieSchedule {

    public long difference(Date x, Date y) {
        return (y.getTime() - x.getTime())/(1000*60*60*24);
    }

    public static void main(String[] args) throws ParseException {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date today = new Date();
        System.out.println(df.format(today));
        String customDate = "2019-11-23";
        Date newDate = df.parse(customDate);
        System.out.println(newDate.compareTo(today));

        System.out.println(newDate.after(today));
        movieSchedule ms = new movieSchedule();
        long dd = ms.difference(today, newDate);
        System.out.println(dd);

        DateRange X = new DateRange(today, newDate);
        System.out.println(X.getDifference());
        System.out.println(X.printRange());

    }
}
