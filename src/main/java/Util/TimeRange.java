package Util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class TimeRange {

    private Date begin;
    private Date end;

    /** Chỉ dùng factory methods bên dưới. */
    private TimeRange(LocalDate begin, LocalDate end) {
        this.begin = java.sql.Date.valueOf(begin);
        this.end   = java.sql.Date.valueOf(end);
    }

    /** Hôm nay: [00:00 hôm nay, trước 00:00 ngày mai] */
    public static TimeRange today() {
        LocalDate start = LocalDate.now();
        LocalDate end = start.plusDays(1); // ngày mai
        return new TimeRange(start, end);
    }


    /** Tuần này (thứ 2 → Chủ nhật): [start thứ 2, end Chủ nhật] */
    public static TimeRange thisWeek() {
        LocalDate now   = LocalDate.now();
        LocalDate start = now.minusDays(now.getDayOfWeek().getValue() - 1);
        LocalDate last  = start.plusDays(6);
        return new TimeRange(start, last);
    }

    /** Tháng này: ngày 1 → ngày cuối tháng */
    public static TimeRange thisMonth() {
        LocalDate start = LocalDate.now().withDayOfMonth(1);
        LocalDate last  = start.withDayOfMonth(start.lengthOfMonth());
        return new TimeRange(start, last);
    }

    /** Quý này: tháng đầu quý → tháng cuối quý */
    public static TimeRange thisQuarter() {
        LocalDate now   = LocalDate.now();
        int firstMonth  = now.getMonth().firstMonthOfQuarter().getValue();
        LocalDate start = now.withMonth(firstMonth).withDayOfMonth(1);
        LocalDate last  = start.plusMonths(3).minusDays(1);
        return new TimeRange(start, last);
    }

    /** Năm này: 01/01 → 31/12 */
    public static TimeRange thisYear() {
        LocalDate start = LocalDate.of(LocalDate.now().getYear(), 1, 1);
        LocalDate last  = start.plusYears(1).minusDays(1);
        return new TimeRange(start, last);
    }

    // getters và setters
    public Date getBegin() { return begin; }
    public void setBegin(Date begin) { this.begin = begin; }
    public Date getEnd()   { return end;   }
    public void setEnd(Date end)     { this.end = end;     }
}
