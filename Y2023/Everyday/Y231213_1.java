package Y2023.Everyday;

public class Y231213_1 {
    public String makeSmallestPalindrome(String s) {
        int len = s.length() - 1;
        StringBuffer sb = new StringBuffer(s);
        for (int i = 0; i < len - i; i++) {
            if (s.charAt(i) < s.charAt(len - i)) {
                sb.setCharAt(len - i, s.charAt(i));
            } else if (s.charAt(i) > s.charAt(len - i)){
                sb.setCharAt(i, s.charAt(len - i));
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Y231213_1 y2312131 = new Y231213_1();
        String s = "seven";
        System.out.println(y2312131.makeSmallestPalindrome(s));
    }
}
