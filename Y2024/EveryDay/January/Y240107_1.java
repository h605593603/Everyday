package Y2024.EveryDay.January;

import java.util.HashMap;
import java.util.Map;

/**
 * 赎金信
 */
public class Y240107_1 {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> charMap = new HashMap<>();
        boolean result = true;

        for (int i = 0; i < magazine.length(); i++) {
            char curChar = magazine.charAt(i);
            charMap.put(curChar, charMap.getOrDefault(curChar, 0) + 1);
        }

        for (int i = 0; i < ransomNote.length(); i++) {
            char curChar = ransomNote.charAt(i);
            int num = charMap.getOrDefault(curChar, 0);
            if (num == 0) {
                result = false;
                break;
            } else {
                charMap.put(curChar, num - 1);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Y240107_1 y2401071 = new Y240107_1();
        String ransomNote = "aa";
        String magazine = "ab";
        System.out.println(y2401071.canConstruct(ransomNote, magazine));
    }
}
