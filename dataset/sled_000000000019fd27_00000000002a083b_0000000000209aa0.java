

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        String res = "";
        for (int i = 1; i <= t; ++i) {
            int N = in.nextInt();
            int K = in.nextInt();
            if (i != t)
                res += "Case #" + i + ": " + latin(N, K, in) + "\n";
            else
                res += "Case #" + i + ": " + latin(N, K, in);
        }
        System.out.print(res);
    }

    public static String latin(int N, int K, Scanner in) {
        int track = 0;
        String s = "POSSIBLE " + '\n';
        for (int i = 1; i <= N; ++i) {
            if (K == N * i) {
                track = i;
                break;
            }
        }

        if (track == 0)
            return "IMPOSSIBLE";

        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        ArrayList<Integer> data = new ArrayList<>();
        ArrayList<Integer> tmp = new ArrayList<>();

        data.add(track);
        for (int i = 1; i < track; ++i) {
            data.add(i);
        }
        for (int i = track + 1; i <= N; ++i) {
            data.add(i);
        }
        list.add(data);

        for (int i = 1; i < N; ++i) {
            tmp.add(data.get(N-1));
            for(int j = 0; j < N - 1; ++j) {
                tmp.add(data.get(j));
            }
            list.add(tmp);
            data = tmp;
            tmp = new ArrayList<>();
        }
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < N; ++j) {
                s += list.get(i).get(j);
                s += " ";
            }
            if (i != N - 1) {
                s += "\n";
            }
        }
        return s;
    }
}
