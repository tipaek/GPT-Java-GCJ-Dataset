import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int T = sc.nextInt();

        for (int t = 0; t < T; t++) {
            sb.append("Case #").append(t + 1).append(": ");

            int min = 2;
            int N = sc.nextInt();
            int D = sc.nextInt();
            int maxSlices = Integer.MIN_VALUE;

            Map<Long, Integer> count = new HashMap<>();

            for (int i = 0; i < N; i++) {
                Long degree = sc.nextLong();
                count.put(degree, count.getOrDefault(degree, 0) + 1);
                maxSlices = Math.max(maxSlices, count.get(degree));
            }

            if (maxSlices >= D) {
                sb.append("0");
            } else {
                if (D == 2) {
                    sb.append("1");
                } else {
                    if (maxSlices == 2) {
                        sb.append("1");
                    } else {
                        boolean flag = false;
                        for (Long key : count.keySet()) {
                            if (Math.floor(key / (double) 2) == Math.ceil(key / (double) 2)) {
                                if (count.containsKey(key / 2)) {
                                    flag = true;
                                    break;
                                }
                            }
                        }
                        if (flag)
                            sb.append("1");
                        else
                            sb.append("2");
                    }
                }
            }

            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}
