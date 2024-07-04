import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int q = 0; q < t; q++) {
            int N = Integer.parseInt(br.readLine());
            ArrayList<ArrayList<Integer>> l = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                String[] s = br.readLine().split(" ");
                ArrayList<Integer> li = new ArrayList<>();
                for (int j = 0; j < s.length; j++) {
                    li.add(Integer.parseInt(s[j]));
                }
                l.add(li);
            }

            long k = 0;
            for (int i = 0; i < N; i++) {
                k += l.get(i).get(i);
            }

            int r = 0;
            for (int i = 0; i < N; i++) {
                ArrayList<Integer> li = l.get(i);
                Set<Integer> set = new HashSet<>(li);
                if (set.size() != N) {
                    r++;
                }
            }

            int c = 0;
            for (int j = 0; j < N; j++) {
                ArrayList<Integer> lj = new ArrayList<>();
                for (int i = 0; i < N; i++) {
                    lj.add(l.get(i).get(j));
                }
                Set<Integer> set = new HashSet<>(lj);
                if (set.size() != N) {
                    c++;
                }
            }

            System.out.println("Case #" + (q + 1) + ": " + k + " " + r + " " + c);
        }
    }
}
