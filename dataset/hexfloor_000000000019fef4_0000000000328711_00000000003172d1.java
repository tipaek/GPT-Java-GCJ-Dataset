

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {

        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = in.nextInt();
        in.nextLine();
        for (int i = 0; i < t; ++i) {
            int n = in.nextInt();
            int d = in.nextInt();
            List<Long> cut = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                cut.add(in.nextLong());
            }
            int result = solve(cut, d);
            String answer = "Case #" + (i + 1) + ": " + result;
            System.out.println(answer);
        }
        in.close();
        out.close();
    }

    static int solve(List<Long> cut, int d) {
        if (d == 1) {
            return 0;
        }
        Collections.sort(cut);
        Map<Integer, Integer> map = new HashMap<>();
        cut.forEach(v -> map.put(map.getOrDefault(v, 1), 1));
        int sc = map.entrySet().stream().map(Map.Entry::getValue).max(Integer::compareTo).orElse(0);


        return d -(int)sc;
    }

    static int solve2(List<Long> cut) {
        if (cut.size() == 1) {
            return 1;
        }
        for (int i = 1; i < cut.size(); i++) {
            if (cut.get(i).equals(cut.get(i - 1))) {
                return 0;
            }
        }
        return 1;
    }

    static int solve3(List<Long> cut) {
        if (cut.size() == 1) {
            return 1;
        }
        for (int i = 1; i < cut.size(); i++) {
            if (cut.get(i).equals(cut.get(i - 1))) {
                return 0;
            }
        }
        return 1;
    }


}