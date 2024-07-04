import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    StringBuilder status = new StringBuilder();

    public static void main(String[] args) {

        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int noOfCases = in.nextInt();

        for (int caseNo = 1; caseNo <= noOfCases; ++caseNo) {
            int x = in.nextInt();
            int y = in.nextInt();
            in.nextLine();

            Solution solution = new Solution();

            String path = solution.findPath(x, y);

            System.out.println("Case #" + caseNo + ": " + path);

        }
    }

    public String findPath(int targetX, int targetY) {
        int totalSteps = (int) Math.ceil(Math.log(Math.abs(targetX) + Math.abs(targetY)) / Math.log(2)) + 1;
        Queue<Status> queue = new LinkedList<>();

        int steps = 1;
        int jump = 1;

        queue.add(new Status(0, 0, new StringBuilder()));

        while (!queue.isEmpty()) {

            List<Status> tempList = new ArrayList<>();

            while (!queue.isEmpty()) {

                Status status = queue.poll();

                if (status.x == targetX && status.y == targetY) {
                    return status.path.toString();
                }

                tempList.add(new Status(status.x + jump, status.y, new StringBuilder(status.path).append("E")));
                tempList.add(new Status(status.x - jump, status.y, new StringBuilder(status.path).append("W")));
                tempList.add(new Status(status.x, status.y + jump, new StringBuilder(status.path).append("N")));
                tempList.add(new Status(status.x, status.y - jump, new StringBuilder(status.path).append("S")));
            }

            queue.addAll(tempList);

            steps++;
            jump *= 2;

            if (steps > totalSteps) {
                return "IMPOSSIBLE";
            }
        }
        return "IMPOSSIBLE";
    }

    public class Status {
        int x;
        int y;
        StringBuilder path;

        public Status(int x, int y, StringBuilder path) {
            this.x = x;
            this.y = y;
            this.path = path;
        }
    }

}