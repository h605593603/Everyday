package Y2024.EveryDay.January;

public class Y240111_1 {
    public int addMinimum(String word) {
        int result = 0;
        String str = "abc";

        StringBuilder wordBuilder = new StringBuilder(word);
        for (int i = 0; i < wordBuilder.length(); i = i + 3) {
            if (!wordBuilder.toString().startsWith(str, i)) {
                if ('a' != wordBuilder.charAt(i)) {
                    result++;
                    wordBuilder = new StringBuilder(wordBuilder.substring(0, i) + "a" + wordBuilder.substring(i));
                }
                if (i + 1 == wordBuilder.length()) {
                    result++;
                    wordBuilder.append("b");
                }
                if ('b' != wordBuilder.charAt(i + 1)) {
                    result++;
                    wordBuilder = new StringBuilder(wordBuilder.substring(0, i + 1) + "b" + wordBuilder.substring(i + 1));
                }
                if (i + 2 == wordBuilder.length()) {
                    result++;
                    wordBuilder.append("c");
                }
                if ('c' != wordBuilder.charAt(i + 2)) {
                    result++;
                    wordBuilder = new StringBuilder(wordBuilder.substring(0, i + 2) + "b" + wordBuilder.substring(i + 2));
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Y240111_1 y2401111 = new Y240111_1();
        String word = "abc";
        System.out.println(y2401111.addMinimum(word));
    }
}
