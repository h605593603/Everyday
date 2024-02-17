package Y2023.Everyday;

import java.util.Arrays;
import java.util.List;

public class Y231220_1 {
    public boolean isAcronym(List<String> words, String s) {
        for (int i = 0; i < words.size(); i++) {
            if (words.size() != s.length() || words.get(i).charAt(0) != s.charAt(i)) {
                return Boolean.FALSE;
            }
        }
        return Boolean.TRUE;
    }

    public static void main(String[] args) {
        Y231220_1 y2312201 = new Y231220_1();
        String[] words = {"never","gonna","give","up","on","you"};
        String s = "ngguoy";
        System.out.println(y2312201.isAcronym(Arrays.asList(words), s));
    }
}
