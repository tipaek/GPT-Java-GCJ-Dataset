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

            for(int i=1; i<= n; i++) {
                int s = sc.nextInt();
                int e = sc.nextInt();
                taskSet.add(new Task(s,e, i));
            }

            int cTaskFinish = -1;
            int jTaskFinish = -1;
            boolean isPossible = true;

            for(Task task : taskSet) {
                if(cTaskFinish == -1 || cTaskFinish <= task.s) {
                    cTaskFinish = task.e;
                    task.setOwner("C");
                } else if(jTaskFinish == -1 || jTaskFinish <= task.s) {
                    jTaskFinish = task.e;
                    task.setOwner("J");
                } else {
                    isPossible = false;
                    break;
                }
            }

            if(isPossible) {
                Set<Task> newSet = new TreeSet<>(Comparator.comparing(o -> o.index));
                newSet.addAll(taskSet);
                System.out.print("Case #" + tt + ": ");
                for(Task task : newSet) {
                    System.out.print(task.owner);
                }
                System.out.println();
            } else {
                System.out.println("Case #" + tt + ": " + "IMPOSSIBLE");
            }
        }
    }

    static class Task {
        Integer s;
        Integer e;
        Integer index;
        String owner;

        public Task(int s, int e, int index) {
            this.s = s ;
            this.e = e;
            this.index = index;
        }

        public void setOwner(String owner) {
            this.owner = owner;
        }
    }
}
