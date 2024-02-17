package Y2024.EveryDay.January;

public class Y240113_1 {
    public String repeatLimitedString(String s, int repeatLimit) {
        int[] charNum = new int[26];
        for (int i = 0; i < s.length(); i++) {
            charNum[s.charAt(i) - 'a']++;
        }
        StringBuffer result = new StringBuffer();
        for (int i = 25; i>=0; i--) {
            /* 当前轮次最多放repeatLimit个字符 */
            for (int j = 0; j < repeatLimit && charNum[i] > 0; j++) {
                result = result.append((char)('a' + i));
                charNum[i]--;
            }
            /* 当前字符未用完 */
            if (charNum[i] > 0) {
                /* 取下一个字符 */
                for (int j = i - 1; j >= 0; j--) {
                    if (charNum[j] != 0) {
                        result.append((char)('a' + j));
                        charNum[j]--;
                        i++;
                        break;
                    }
                }
                /* 无下一个字符, 则从上一个字符取 */
                if (result.charAt(result.length() - 1) == result.charAt(result.length() - 2)) {
                    break;
                }
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Y240113_1 y2401131 = new Y240113_1();
        String s = "cczazcc";
        int repeatLimit = 3;
        System.out.println(y2401131.repeatLimitedString(s, repeatLimit));
    }
}