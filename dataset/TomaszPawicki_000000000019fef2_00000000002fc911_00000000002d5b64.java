import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            int r = sc.nextInt();
            int s = sc.nextInt();
            List<String> ret = new ArrayList<>();
            check(r, s, ret);
            System.out.println("Case #" + t + ": " + ret.size());
            for (String str : ret) {
                System.out.println(str);
            }
        }
    }

    private static void check(int r, int s, List<String> ret) {
        if(r < 2 || s < 2) {
            return;
        }
        for(int i=0;i<s-1;i++) {
            int total = r * s - i - 1;
            int b = r-1;
            int a = total - b;
            ret.add(a + " " + b);
        }
        check(r-1, s, ret);
    }
}
