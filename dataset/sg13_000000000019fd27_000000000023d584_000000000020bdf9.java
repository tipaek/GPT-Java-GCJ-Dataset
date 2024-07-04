import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        for (int t = 0; t < T; t++) {
            int N = scan.nextInt();
            int[] times1 = new int[24*60 + 1];
            int[] times2 = new int[24*60 + 1];
            for (int i = 1; i <= N; i++) {
                times1[scan.nextInt()] = i;
                times2[scan.nextInt()] = i;
            }

            ArrayList<Character> out = new ArrayList<>();
            boolean flag = true;
            Queue<Character> qu = new ArrayDeque<>();
            boolean[] assignments = new boolean[N + 1];
            qu.add('C'); //true
            qu.add('J'); //false

            for (int j = 0; j <= 24*60; j++) {
                if (times1[j] == 0 && times2[j] == 0) continue;
                if (times2[j] != 0) {
                    if (assignments[times2[j]]) qu.add('C');
                    else qu.add('J');
                }
                if (times1[j] != 0) {
                    if (qu.isEmpty()) {
                        flag = false;
                        break;
                    } else {
                        char person = qu.remove();
                        out.add(person);
                        assignments[times1[j]] = (person == 'C') ? true : false;
                    }
                }
            }

            if (flag) {
                String out1 = out.toString().substring(1, 3*out.size()-1).replaceAll(", ", "");
                System.out.println("Case #" + (t + 1) + ": " + out1);
            }
            else System.out.println("Case #" + (t + 1) + ": IMPOSSIBLE");
        }
    }
}
