package Y2023.Everyday;

public class Y231231_1 {
    public int dayOfYear(String date) {
        String[] dateStrArrays = date.split("-");
        int[] monthDays = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int result = 0;
        int year = Integer.parseInt(dateStrArrays[0]);
        int month = Integer.parseInt(dateStrArrays[1]);
        int days = Integer.parseInt(dateStrArrays[2]);

        for (int i = 0; i < month - 1; i++) {
            result += monthDays[i];
        }

        if (((year %100 != 0 && year % 4 == 0) || year % 400 == 0) && month > 2) {
            result++;
        }

        return result + days;
    }


    public static void main(String[] args) {
        Y231231_1 y2312311 = new Y231231_1();
        String date = "2019-02-10";
        System.out.println(y2312311.dayOfYear(date));
    }
}
