import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int mm = 1; mm <= T; mm++) {
            String[] input = br.readLine().split(" ");
            int N = Integer.parseInt(input[0]);
            int D = Integer.parseInt(input[1]);
            HashMap<Long, Integer> map = new HashMap<>();
            long[] arr = new long[N];
            long largest = 0;

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < N; i++) {
                long a = Long.parseLong(st.nextToken());
                arr[i] = a;
                largest = Math.max(largest, a);
                map.put(a, map.getOrDefault(a, 0) + 1);
            }

            if (D == 2) {
                int cut = 1;
                for (long a : arr) {
                    if (map.get(a) >= 2) {
                        cut = 0;
                        break;
                    }
                }
                sb.append("Case #").append(mm).append(": ").append(cut).append("\n");
            }

            if (D == 3) {
                int cut = 2;
                for (long a : arr) {
                    if (map.get(a) >= 3) {
                        cut = Math.min(cut, 0);
                    }
                    if (map.containsKey(2 * a)) {
                        cut = Math.min(cut, 1);
                    }
                    if (map.get(a) == 2 && a != largest) {
                        cut = Math.min(cut, 1);
                    }
                }
                sb.append("Case #").append(mm).append(": ").append(cut).append("\n");
            }
        }

        System.out.print(sb);
    }
}