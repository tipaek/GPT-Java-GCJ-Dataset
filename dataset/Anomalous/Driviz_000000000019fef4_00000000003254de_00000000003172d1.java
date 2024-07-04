import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int test = 1; test <= T; test++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int D = Integer.parseInt(st.nextToken());
            boolean flag = false;
            TreeMap<Long, Integer> frequencyMap = new TreeMap<>();
            st = new StringTokenizer(br.readLine());

            while (st.hasMoreTokens()) {
                long key = Long.parseLong(st.nextToken());
                frequencyMap.put(key, frequencyMap.getOrDefault(key, 0) + 1);
                if (frequencyMap.get(key) == D) {
                    flag = true;
                    break;
                }
            }

            System.out.print("Case #" + test + ": ");
            if (flag) {
                System.out.println(0);
                continue;
            }

            if (D == 2) {
                System.out.println(1);
                continue;
            }

            if (N == 1) {
                System.out.println(D - 1);
                continue;
            }

            for (Long key : frequencyMap.keySet()) {
                if (frequencyMap.containsKey((D - 1) * key)) {
                    flag = true;
                    break;
                }
            }

            if (flag) {
                System.out.println(D - 2);
            } else {
                System.out.println(3);
            }
        }
    }
}