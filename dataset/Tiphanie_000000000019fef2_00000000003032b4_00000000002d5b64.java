import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {


    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            int R = in.nextInt();
            int S = in.nextInt();
            List<Integer> res = find(R, S);
            System.out.println("Case #" + i + ": " + res.size() / 2);
            for (int k = 0; k < res.size(); k+=2) {
                System.out.println(res.get(k) + " "+res.get(k + 1));
            }
        }

    }
    private static List<Integer> find(int r, int s) {
        List<Integer> path = new ArrayList<>();
        int total = r * s;
        int a = total - r;
        int b = r - 1;
        path.add(a);
        path.add(b);
        while (a > s) {
            a--;
            b = Math.max(b - 1, 1);
            path.add(a);
            path.add(b);
        }
        return path;
    }

}
