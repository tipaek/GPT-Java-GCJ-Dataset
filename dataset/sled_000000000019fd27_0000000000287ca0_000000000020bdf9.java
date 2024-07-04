
import java.lang.reflect.Array;
import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        String res = "";
        for (int i = 1; i <= t; ++i) {
            int N = in.nextInt();
            if (i != t)
                res += "Case #" + i + ": " + isPossible(N, in) + "\n";
            else
                res += "Case #" + i + ": " + isPossible(N, in);
        }
        System.out.print(res);
     }

    public static String isPossible(int N, Scanner in) {
        char[] ans = new char[N];
        char[] result = new char[N];
        ArrayList<ArrayList<Integer>> pairs = new ArrayList<>();
        ArrayList<Integer> data = new ArrayList<>();

        for (int i = 0; i < N; ++i) {
            data.add(in.nextInt());
            data.add(in.nextInt());
            pairs.add(data);
            data = new ArrayList<>();
        }

        ArrayList<ArrayList<Integer>> C_busy = new ArrayList<>();
        ArrayList<ArrayList<Integer>> J_busy = new ArrayList<>();
        boolean is_c = true;
        boolean is_j = true;

        for (int i = 0; i < N; ++i) {
            if (i == 0) {
                ans[i] = 'C';
                C_busy.add(pairs.get(i));
            }
            else {
                for (int j = 0; j < C_busy.size(); ++j) {
                    if (!(pairs.get(i).get(0) >= C_busy.get(j).get(1) || pairs.get(i).get(1) <= C_busy.get(j).get(0))) {
                        is_c = false;
                    }
                }
                for (int j = 0; j < J_busy.size(); ++j) {
                    if (!(pairs.get(i).get(0) >= J_busy.get(j).get(1) || pairs.get(i).get(1) <= J_busy.get(j).get(0))) {
                        is_j = false;
                    }
                }

                if (is_c) {
                    ans[i] = 'C';
                    C_busy.add(pairs.get(i));
                }
                else if (is_j) {
                        ans[i] = 'J';
                J_busy.add(pairs.get(i));
                }
                else return "IMPOSSIBLE";
                is_c = true;
                is_j = true;
            }
        }

        return new String(ans);

    }
}
