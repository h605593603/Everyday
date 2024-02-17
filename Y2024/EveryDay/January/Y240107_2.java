package Y2024.EveryDay.January;

/**
 * 赎金信
 * map数量确定, 可以使用数组代替HashMap()
 */
public class Y240107_2 {
    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) {
            return false;
        }
        int[] cnt = new int[26];
        for (char c : magazine.toCharArray()) {
            cnt[c - 'a']++;
        }
        for (char c : ransomNote.toCharArray()) {
            cnt[c - 'a']--;
            if(cnt[c - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Y240107_2 y2401072 = new Y240107_2();
        String ransomNote = "aa";
        String magazine = "ab";
        System.out.println(y2401072.canConstruct(ransomNote, magazine));
    }
}
