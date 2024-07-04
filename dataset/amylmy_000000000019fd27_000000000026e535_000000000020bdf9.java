import java.util.*;

public class Solution {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int caseNum = input.nextInt();
        for (int ks = 1; ks <= caseNum; ks++) {
            System.out.println(String.format("Case #%d: %s", ks, new Solution().solve(input)));
        }
    }

    public String solve(Scanner scanner) {
        int N = scanner.nextInt();
        int[][] times = new int[N][2];
        for (int i = 0; i < N; i++) {
            times[i][0] = scanner.nextInt();
            times[i][1] = scanner.nextInt();
        }

        List<Integer> cList = new ArrayList<>();
        List<Integer> jList = new ArrayList<>();

        String ans = "C";
        cList.add(0);

        for (int i = 1; i < N; i++) {
            boolean cFlag = isOverlap(times[i], cList, times);
            boolean jFlag = isOverlap(times[i], jList, times);
            if (cFlag && jFlag) return "IMPOSSIBLE";
            if (cFlag) {
                ans += "J";
                jList.add(i);
            } else {
                ans += "C";
                cList.add(i);
            }
        }

        return ans;
    }

    public boolean isOverlap(int[] t1, int[] t2) {
        if (t2[0] < t1[0]) return isOverlap(t2, t1);
        return t1[1] > t2[0];
    }

    public boolean isOverlap(int[] t1, List<Integer> list, int[][] times) {
        for (int i = 0; i < list.size(); i++) {
            if (isOverlap(t1, times[list.get(i)])) return true;
        }
        return false;
    }
}