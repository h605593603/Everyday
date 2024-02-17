package Y2023.Everyday;

public class Y231224_1 {
    public long minimumPerimeter(long neededApples) {
        if (neededApples > 0) {
            int sum = 3;
            int last = 3;
            int n = 1;
            while (4L * sum < neededApples) {
                n++;
                last = 6 * n - 3 + last;
                sum += last;
            }
            return 8L*n;
        }
        return 0;
    }

    public static void main(String[] args) {
        Y231224_1 y2312241 = new Y231224_1();
        long needApples = 13;
        System.out.println(y2312241.minimumPerimeter(needApples));
    }
}
