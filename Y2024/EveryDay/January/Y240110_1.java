package Y2024.EveryDay.January;

public class Y240110_1 {
    public int minLength(String s) {

        int n = s.length();
        if (n > 1) {
            for (int i = 0; i < s.length(); i++) {
                while (s.startsWith("AB", i) || s.startsWith("CD", i )) {
                    s = s.substring(0, i) + s.substring(i + 2);
                    if (i > 0) {
                        i--;
                    }
                }
            }
        }
        return s.length();
    }

    public static void main(String[] args) {
        Y240110_1 y2401101 = new Y240110_1();
        String s = "ACBBD";
        System.out.println(y2401101.minLength(s));
    }
}
