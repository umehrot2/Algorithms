import java.util.Comparator;

/**
 * Created by uditmehrotra on 22/12/14.
 */
public class Date implements Comparable<Date>{

    private int year;
    private int month;
    private int day;
    public static final Comparator<Date> BY_YEAR = new ByYear();
    public static final Comparator<Date> BY_MONTH = new ByMonth();
    public static final Comparator<Date> BY_DAY = new ByDay();

    private static class ByYear implements Comparator<Date>
    {

        @Override
        public int compare(Date o1, Date o2) {
            Integer y1 = o1.year;
            Integer y2 = o2.year;
            return y1.compareTo(y2);
        }

    }

    private static class ByMonth implements Comparator<Date>
    {

        @Override
        public int compare(Date o1, Date o2) {
            Integer m1 = o1.month;
            Integer m2 = o2.month;
            return m1.compareTo(m2);
        }

    }

    private static class ByDay implements Comparator<Date>
    {

        @Override
        public int compare(Date o1, Date o2) {
            Integer d1 = o1.day;
            Integer d2 = o2.day;
            return d1.compareTo(d2);
        }

    }

    public Date(int y, int m, int d)
    {
        year = y;
        month = m;
        day = d;
    }

    public void print()
    {
        System.out.println(this.year + "/" + this.month + "/" + this.day);
    }

    @Override
    public int compareTo(Date o) {

        if(this.year < o.year) return -1;
        if(o.year < this.year) return +1;
        if(this.month < o.month) return -1;
        if(o.month < this.month) return +1;
        if(this.day < o.day) return -1;
        if(o.day < this.day) return +1;

        return 0;
    }
}
