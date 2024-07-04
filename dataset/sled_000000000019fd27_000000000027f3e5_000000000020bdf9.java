

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
        System.out.println(res);
     }

    public static String isPossible(int N, Scanner in) {

        char[] ans = new char[N];
        char[] result = new char[N];
        TreeMap<Integer, Integer> pair = new TreeMap<>(); // here is our pairs
        ArrayList<Integer> data = new ArrayList<>();

        for (int i = 0; i < N; ++i) {
            int first = in.nextInt();
            int sec = in.nextInt();
            in.nextLine();
            data.add(first);
            data.add(sec);
        }

        for (int i = 0; i < data.size(); i+=2) {
            pair.put(data.get(i), data.get(i+1));
        }

        int cnt = 0;
        int C_finish = 0;
        int J_finish = 0;

        for (Map.Entry<Integer, Integer> item : pair.entrySet()) {
            if (cnt == 0) {
                ans[cnt] = 'C';
                C_finish = item.getValue();
                cnt++;
            }
            else if (item.getKey() >= C_finish) {
                    ans[cnt] = 'C';
                    C_finish = item.getValue();
                    cnt++;
                }
            else if (item.getKey() < C_finish) {
                if (item.getKey() >= J_finish) {
                    ans[cnt] = 'J';
                    J_finish = item.getValue();
                    cnt++;
                }
                else {
                    return "IMPOSSIBLE";
                }
            }
        }


        cnt = 0;
        for (Map.Entry<Integer, Integer> item : pair.entrySet()) {
            for (int i = 0; i < data.size(); i+=2) {
                if (item.getKey() == data.get(i)) {
                    if (item.getValue() == data.get(i+1)) {
                        result[i / 2] = ans[cnt];
                    }
            }
            }
            ++cnt;
        }
        return new String(result);

    }
}
