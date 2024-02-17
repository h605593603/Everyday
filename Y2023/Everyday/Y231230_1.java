package Y2023.Everyday;

public class Y231230_1 {

    public String dayOfTheWeek(int day, int month, int year) {
        String[] days = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        int[] monthDays = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        int yearDiff = year - 1971;

        int sum1 = yearDiff*365 + (int)(yearDiff + 2)/4 + day;
        int sum2 = 0;
        for (int i = 0; i < month - 1; i++) {
            sum2 += monthDays[i];
        }
        if (((year %100 != 0 && year % 4 == 0) || year % 400 == 0) && month > 2) {
            sum2++;
        }
        int result = (sum1 + sum2) % 7;

        return days[(result + 4) % 7];

    }

    public static void main(String[] args) {
        Y231230_1 y2312301 = new Y231230_1();
        int day = 31;
        int month = 8;
        int year = 2100;
        System.out.println(y2312301.dayOfTheWeek(day, month, year));
    }
}
