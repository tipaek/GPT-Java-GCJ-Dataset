import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int T = sc.nextInt();

        for (int i = 0; i < T; i++) {
            sb.append("Case #").append(i + 1).append(": ");

            int N = sc.nextInt();
            Integer[][] time = new Integer[N][3];
            char[] ans = new char[N];
            boolean flag = false;

            for (int j = 0; j < N; j++) {
                time[j][0] = sc.nextInt();
                time[j][1] = sc.nextInt();
                time[j][2] = j;
            }

            Arrays.sort(time, (a, b) -> a[0].equals(b[0]) ? a[1] - b[1] : a[0] - b[0]);

            Map<Character, Integer> map = new HashMap<>();
            map.put('C', 0);
            map.put('J', 0);

            for (int j = 0; j < N; j++) {
                if (map.containsKey('C') && map.get('C') <= time[j][0]) {
                    ans[time[j][2]] = 'C';
                } else if (map.containsKey('J') && map.get('J') <= time[j][0]) {
                    ans[time[j][2]] = 'J';
                } else {
                    flag = true;
                    break;
                }
                map.put(ans[time[j][2]], time[j][1]);
            }

            if (flag) {
                sb.append("IMPOSSIBLE" + "\n");
            } else {
                sb.append(String.valueOf(ans)).append("\n");
            }

        }
        System.out.println(sb.toString());
    }
}
