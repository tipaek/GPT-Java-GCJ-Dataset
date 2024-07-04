import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int caseNum = 0; caseNum < t; caseNum++) {
            int r = sc.nextInt();
            int s = sc.nextInt();
            List<Integer> result = new ArrayList<>();
            int a = r * (s - 1);
            int b = r - 1;
            int count = 0;

            while (b > 0) {
                for (int i = 0; i < (s - 1); i++) {
                    result.add(a);
                    result.add(b);
                    count++;
                    a--;
                }
                b--;
            }

            System.out.println("Case #" + (caseNum + 1) + ": " + count);
            for (int i = 0; i < count * 2; i += 2) {
                System.out.println(result.get(i) + " " + result.get(i + 1));
            }
        }
        sc.close();
    }
}