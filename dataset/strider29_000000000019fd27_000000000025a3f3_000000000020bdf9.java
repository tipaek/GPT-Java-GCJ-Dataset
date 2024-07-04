
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        int t1 = t;
        while (t-- > 0) {
            int n = scanner.nextInt();
            List<Activity> activities = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                activities.add(new Activity(scanner.nextInt(), scanner.nextInt(), i));
            }
            activities.sort((a,b) -> a.startTime - b.startTime);
            final PriorityQueue<QueueItem> queue = new PriorityQueue<>((o1, o2) -> o1.endTime - o2.endTime);
            List<QueueItem> ans = new ArrayList<>();
            for (Activity activity : activities) {
                if (queue.isEmpty()) {
                    queue.add(new QueueItem(activity.endTime, QueueItem.C));
                    ans.add(new QueueItem(activity.idx, QueueItem.C));
                    continue;
                }
                if (activity.startTime < queue.peek().endTime) {
                    if (queue.size() == 2) {
                        break;
                    }
                    final int owner = queue.peek().owner == QueueItem.C ? QueueItem.J : QueueItem.C;
                    queue.add(new QueueItem(activity.endTime, owner));
                    ans.add(new QueueItem(activity.idx, owner == QueueItem.C ? QueueItem.C : QueueItem.J));
                } else {
                    while (!queue.isEmpty() && activity.startTime >= queue.peek().endTime) {
                        queue.poll();
                    }
                    final int owner = queue.isEmpty() ? QueueItem.C :
                            queue.peek().owner == QueueItem.C ? QueueItem.J : QueueItem.C;
                    queue.add(new QueueItem(activity.endTime, owner));
                    ans.add(new QueueItem(activity.idx, owner == QueueItem.C ? QueueItem.C : QueueItem.J));
                }
            }
            Collections.sort(ans, (a,b) -> {return a.endTime - b.endTime;});
            System.out.print("Case #" + (t1-t) +": ");
            if (ans.size() != n) {
                System.out.print("IMPOSSIBLE");
            } else {
                for (int i = 0; i < n; i++) {
                    System.out.print(ans.get(i).owner == QueueItem.C ? "C" : "J");
                }
            }
            if( t > 0)
            System.out.println("");
        }
    }

    private static class QueueItem {

        private static final int C = 0;
        private static final int J = 1;

        int endTime;
        int owner;

        QueueItem(int e, int o) {
            endTime = e;
            owner = o;
        }

    }
    private static class Activity {
        int startTime;
        int endTime;
        int idx;

        Activity(int s, int e, int i) {
            startTime = s;
            endTime = e;
            idx = i;
        }
    }
}
