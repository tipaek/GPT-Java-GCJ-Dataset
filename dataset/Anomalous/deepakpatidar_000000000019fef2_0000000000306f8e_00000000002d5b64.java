import java.util.ArrayList;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int testCase = 0; testCase < t; testCase++) {
            int r = sc.nextInt();
            int s = sc.nextInt();

            int a = r * (s - 1);
            int b = r - 1;
            int count = 0;
            ArrayList<Integer> list = new ArrayList<>();

            while (b > 0) {
                for (int i = 0; i < (s - 1); i++) {
                    list.add(a);
                    list.add(b);
                    count++;
                    a--;
                }
                b--;
            }

            System.out.print("Case #" + (testCase + 1) + ": " + count);
            for (int i = 0; i < count * 2; i += 2) {
                System.out.println();
                System.out.print(list.get(i) + " " + list.get(i + 1));
            }
        }
    }
}