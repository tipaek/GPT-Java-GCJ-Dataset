import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

class Solution {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for(int tt=1;tt<=t;tt++) {
            int n = sc.nextInt();
            List<Task> taskList = new ArrayList<>();

            for(int i=1; i<= n; i++) {
                int s = sc.nextInt();
                int e = sc.nextInt();
                taskList.add(new Task(s,e,i));
            }

            taskList.sort(Comparator.comparing(o -> o.e));
            int cTaskFinish = -1;
            int jTaskFinish = -1;
            boolean isPossible = true;

            for(Task task : taskList) {
                if(cTaskFinish == -1 || cTaskFinish <= task.s) {
                    cTaskFinish = task.e;
                    task.setOwner('C');
                } else if(jTaskFinish == -1 || jTaskFinish <= task.s) {
                    jTaskFinish = task.e;
                    task.setOwner('J');
                } else {
                    isPossible = false;
                    break;
                }
            }

            if(isPossible) {
                char[] carr = new char[n];
                for(Task task : taskList){
                    carr[task.index-1] = task.owner;
                }
                System.out.println("Case #" + tt + ": " + new String(carr));
            } else {
                System.out.println("Case #" + tt + ": " + "IMPOSSIBLE");
            }
        }
    }

    static class Task {
        int s;
        int e;
        int index;
        char owner;

        public Task(int s, int e, int index) {
            this.s = s ;
            this.e = e;
            this.index = index;
        }

        public void setOwner(char owner) {
            this.owner = owner;
        }
    }
}
