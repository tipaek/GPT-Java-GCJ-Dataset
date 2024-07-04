import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int i = 0; i < T; i++) {
            solve(i + 1, scanner);
        }
    }

    private static void solve(int caseId, Scanner scanner) {
        int C = scanner.nextInt();
        int D = scanner.nextInt();

        int[] arrivalTime = new int[C];
        List<UserInfo> userInfoList = new ArrayList<>(C);
        userInfoList.add(new UserInfo(1, 0));
        for (int i = 2; i <= C; i++) {
            userInfoList.add(new UserInfo(i, -scanner.nextInt()));
        }

        Collections.sort(userInfoList);

        int time = 0;
        for (int i = 0; i < C; i++) {
            int start = i;
            while (i < C - 1 && userInfoList.get(i + 1).rank == userInfoList.get(start).rank) {
                i++;
            }
            int end = i;
            for (int j = start; j <= end; j++) {
                arrivalTime[userInfoList.get(j).id - 1] = time;
            }
            time++;
        }

        System.out.print("Case #" + caseId + ":");
        for (int i = 0; i < D; i++) {
            int u = scanner.nextInt() - 1;
            int v = scanner.nextInt() - 1;
            int distance = Math.abs(arrivalTime[u] - arrivalTime[v]);
            if (distance == 0) {
                distance = 1;
            }
            System.out.print(" " + distance);
        }
        System.out.println();
    }

    private static class UserInfo implements Comparable<UserInfo> {
        int id;
        int rank;

        UserInfo(int id, int rank) {
            this.id = id;
            this.rank = rank;
        }

        @Override
        public int compareTo(UserInfo other) {
            return Integer.compare(this.rank, other.rank);
        }

        @Override
        public String toString() {
            return "[" + id + "," + rank + "]";
        }
    }
}