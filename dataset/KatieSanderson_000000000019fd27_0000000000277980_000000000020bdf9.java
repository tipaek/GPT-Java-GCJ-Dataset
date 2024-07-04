import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    private void solve(Scanner scan) {
        int N = scan.nextInt();
        List<List<Integer>> times = new ArrayList<>();
        List<List<Integer>> cameronTimes = new ArrayList<>();
        List<List<Integer>> jamieTimes = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            List<Integer> time = new ArrayList<>();
            time.add(scan.nextInt());
            time.add(scan.nextInt());
            times.add(time);
        }

        String order = "" + 'C';
        cameronTimes.add(times.get(0));
        String orderWithC = findValidOrder('C', 1, times, cameronTimes, jamieTimes, order);
        String orderWithJ = findValidOrder('J', 1, times, cameronTimes, jamieTimes, order);
        String resultOrder = orderWithC.length() > orderWithJ.length() ? orderWithC : orderWithJ;
        System.out.println(resultOrder.length() == N ? resultOrder : "IMPOSSIBLE");
    }

    private String findValidOrder(char attemptedWorker, int attemptedPosition, List<List<Integer>> times, List<List<Integer>> cameronTimes, List<List<Integer>> jamieTimes, String order) {
        if (attemptedPosition >= times.size()) {
            return order;
        }

        List<List<Integer>> workerTimes = new ArrayList<>();
        List<Integer> attemptedTime = times.get(attemptedPosition);
        if (attemptedWorker == 'C') {
            workerTimes = copyTimes(cameronTimes);
        } else if (attemptedWorker == 'J') {
            workerTimes = copyTimes(jamieTimes);
        }
        if (!canWorkThisTime(attemptedWorker, attemptedTime, workerTimes)) {
            return order;
        }
        order += attemptedWorker;
        if (attemptedWorker == 'C') {
            workerTimes.add(attemptedTime);
            cameronTimes = workerTimes;
        } else if (attemptedWorker == 'J') {
            workerTimes.add(attemptedTime);
            jamieTimes = workerTimes;
        }

        String orderWithC = findValidOrder('C', attemptedPosition + 1, times, cameronTimes, jamieTimes, order);
        String orderWithJ = findValidOrder('J', attemptedPosition + 1, times, cameronTimes, jamieTimes, order);
        return orderWithC.length() > orderWithJ.length() ? orderWithC : orderWithJ;
    }

    private List<List<Integer>> copyTimes(List<List<Integer>> workerTimes) {
        List<List<Integer>> copyWorkerTimes = new ArrayList<>();
        for (List<Integer> list : workerTimes) {
            copyWorkerTimes.add(new ArrayList<>(list));
        }
        return copyWorkerTimes;
    }

    private boolean canWorkThisTime(char attemptedWorker, List<Integer> attemptedTime, List<List<Integer>> workerTime) {
        for (List<Integer> time : workerTime) {
            int attemptedStartTime = attemptedTime.get(0);
            int attemptedEndTime = attemptedTime.get(1);
            int currentStartTime = time.get(0);
            int currentEndTime = time.get(1);
            if (!(attemptedEndTime <= currentStartTime || attemptedStartTime >= currentEndTime)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        int problems = scan.nextInt();
        for (int count = 0; count < problems; count++) {
            System.out.print("Case #" + (count+1) + ": ");
            new Solution().solve(scan);
        }
        scan.close();
    }
}
