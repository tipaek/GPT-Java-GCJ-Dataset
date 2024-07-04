import java.io.BufferedInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedInputStream(System.in));
        int t = sc.nextInt();
        for (int x = 1; x <= t; x++) {
            int n = sc.nextInt();
            List<List<Integer>> res = solve(n);
            System.out.println("Case #" + x + ": ");
            for (List<Integer> l : res) {
                System.out.println(l.get(0) + " " +  l.get(1));
            }
        }
    }

    private static List<List<Integer>> solve(int n) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            res.add(Arrays.asList(i+1, 1));
        }
        if (n == 501) {
            res.add(3, Arrays.asList(3,2));
        }
        return res;
    }
}
