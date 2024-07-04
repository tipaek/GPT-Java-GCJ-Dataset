import java.util.Comparator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Solution {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for(int tt=1;tt<=t;tt++) {
            int n = sc.nextInt();
            Set<Task> taskSet = new TreeSet<>(Comparator.comparing(o -> o.e));

            for(int i=0; i< n; i++) {
                int s = sc.nextInt();
                int e = sc.nextInt();
                taskSet.add(new Task(s,e));
            }

            int cTaskFinish = -1;
            int jTaskFinish = -1;
            boolean isPossible = true;

            StringBuilder sb = new StringBuilder();
            for(Task task : taskSet) {
                if(cTaskFinish == -1) {
                    cTaskFinish = task.e;
                    sb.append("C");
                } else if(cTaskFinish <= task.s) {
                    sb.append("C");
                    cTaskFinish = task.e;
                } else if(jTaskFinish == -1) {
                    jTaskFinish = task.e;
                    sb.append("J");
                } else if(jTaskFinish <= task.s) {
                    sb.append("J");
                    jTaskFinish = task.e;
                } else {
                    isPossible = false;
                    break;
                }
            }

            if(isPossible) {
                System.out.println("Case #" + tt + ": " + sb.toString());
            } else {
                System.out.println("Case #" + tt + ": " + "IMPOSSIBLE");
            }
        }
    }

    static class Task {
        Integer s;
        Integer e;

        public Task(int s, int e) {
            this.s = s ;
            this.e = e;
        }
    }
}
