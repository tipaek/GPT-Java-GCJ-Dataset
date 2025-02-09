import java.util.*;
import java.io.*;
class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int tests = Integer.parseInt(in.nextLine()), test = 1;
        while (test <= tests) {
            int n = in.nextInt();
            int k = in.nextInt();
            solve(test, n, k);
            test++;
        }
        in.close();
    }
    public static void solve(int test, int n, int k) {
        String res;
        int sum = (n + 1) * n / 2;
        if (n == 2 && k == 3 || k < n || k > n * n) {
            res = "IMPOSSIBLE";
        } else if (k % n == 0 || k == sum) {
            res = "POSSIBLE";
        } else {
            res = "IMPOSSIBLE"; 
        }
        System.out.printf("Case #%d: %s\n", test, res);
        if (res.equals("IMPOSSIBLE")) return; 
        //print square
        List<List<Integer>> ls = new ArrayList();
        List<Integer> l = new ArrayList();
        int offset = 0;
        if (k % n == 0) offset = k / n - 1;
        for (int i = 1; i <= n; i++)
            l.add(i);
        for (int i = 0; i < n; i++) {
            List<Integer> lrotate = new ArrayList();
            offset = (offset + n) % n;
            lrotate.addAll(l.subList(offset, l.size()));//offset to end (exclusive)
            lrotate.addAll(l.subList(0, offset));//start to offset (exclusive)
            ls.add(lrotate);
            offset--;
        }
        for (int j = ls.size() - 1; j >= 0; j--) {
            l = ls.get(j);
            if (k==sum) Collections.reverse(l);
            for (int i = 0; i < l.size(); i++) 
                System.out.printf("%d ", l.get(i));
            System.out.printf("\n"); 
        }
    }
}