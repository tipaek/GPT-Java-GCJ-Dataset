import java.util.*;

public class Solution {

    public static void main(String[] args) {

        System.out.flush();

        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 1; i <= t; i++) {

            int b = in.nextInt();

            process(b, in);

            System.out.flush();

        }
    }

    private static void process(int b, Scanner in) {

        int[] array = new int[b];
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
            array[i] = in.nextInt();
        }

        System.out.println(Arrays.toString(array));
        in.next();
    }

}
