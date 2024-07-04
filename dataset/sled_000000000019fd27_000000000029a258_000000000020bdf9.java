


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
        ArrayList<Integer> data1 = new ArrayList<>();

        for (int i = 0; i < N; ++i) {
            int first = in.nextInt();
            int sec = in.nextInt();
            data.add(first);
            data.add(sec);

            data1.add(first);
            data1.add(sec);
            pairs.add(data1);
            data1 =  new ArrayList<>();
        }

        Collections.sort(pairs, new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                if (o1.get(0).compareTo(o2.get(0)) == 0) {
                    return o1.get(1).compareTo(o2.get(1));
                }
                else {
                    return o1.get(0).compareTo(o2.get(0));
                }
            }
        });
        int C_finish = 0;
        int J_finish = 0;

        C_finish = pairs.get(0).get(1);
        ans[0] = 'C';

        for (int i = 1; i < N; ++i) {
            if (pairs.get(i).get(0) >= C_finish) {
                ans[i] = 'C';
                C_finish = pairs.get(i).get(1);
            }
            else if (pairs.get(i).get(0) < C_finish) {
                if (pairs.get(i).get(0) >= J_finish) {
                    ans[i] = 'J';
                    J_finish = pairs.get(i).get(1);
                }
                else return "IMPOSSIBLE";
            }
        }
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < data.size(); j+=2) {
                if (pairs.get(i).get(0).compareTo(data.get(j)) == 0) {
                    if (pairs.get(i).get(1).compareTo(data.get(j + 1)) == 0) {
                        result[j / 2] = ans[i];
                    }
                }
            }
        }
        return new String(result);
    }
}
