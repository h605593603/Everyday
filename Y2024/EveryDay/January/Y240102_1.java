package Y2024.EveryDay.January;

public class Y240102_1 {
    public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
        int numS1 = 0;
        int numS2 = 0;
        StringBuilder sb1 = new StringBuilder(s1);
        StringBuilder sb2 = new StringBuilder(s2);
        int i = 0, j = 0;

        while (true) {
            if (i == sb1.length() && j== sb2.length()) {
                numS1 = i/s1.length();
                numS2 = j/s2.length();
                break;
            }

            while (i < sb1.length() && j < sb2.length()) {
                if (sb1.charAt(i) == sb2.charAt(j)) {
                    i++;
                    j++;
                } else {
                    i++;
                }
            }
            if (i >= sb1.length() && j != sb2.length()) {
                sb1.append(s1);
            } else if (i < sb1.length()) {
                /* 去除s1中无效字符 */
                while (i < sb1.length()) {
                    if (sb1.charAt(i) != s2.charAt(0)) {
                        i++;
                    } else {
                        sb2.append(s2);
                        break;
                    }
                }
            }
        }

        int result = n1*numS2/(numS1*n2);

        return result;
    }

    public static void main(String[] args) {
        Y240102_1 y2401021 = new Y240102_1();
        String s1 = "bacaba", s2 = "abacab";
        int n1 = 3, n2 = 1;
        System.out.println(y2401021.getMaxRepetitions(s1, n1, s2, n2));
    }
}
