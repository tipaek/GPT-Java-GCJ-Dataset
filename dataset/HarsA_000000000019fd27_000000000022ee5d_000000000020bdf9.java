import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

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

            taskList.sort((o1, o2) -> {
                if(o1.e.equals(o2.e)) {
                    return o1.s.compareTo(o2.s);
                } else {
                    return o1.e.compareTo(o2.e);
                }
            });

            int cTaskFinish = -1;
            int jTaskFinish = -1;
            boolean cTurn = true;
            boolean isPossible = true;
            char[] carr = new char[n];

            for(Task task : taskList) {
                if(cTurn) {
                    if(cTaskFinish == -1 || cTaskFinish <= task.s) {
                        cTaskFinish = task.e;
                        carr[task.index-1] = 'C';
                        cTurn = true;
                    } else if(jTaskFinish == -1 || jTaskFinish <= task.s) {
                        jTaskFinish = task.e;
                        carr[task.index-1] = 'J';
                        cTurn = false;
                    } else {
                        isPossible = false;
                        break;
                    }
                } else {
                    if(jTaskFinish == -1 || jTaskFinish <= task.s) {
                        jTaskFinish = task.e;
                        carr[task.index-1] = 'J';
                        cTurn = false;
                    } else if(cTaskFinish <= task.s) {
                        cTaskFinish = task.e;
                        carr[task.index-1] = 'C';
                        cTurn = true;
                    } else{
                        isPossible = false;
                        break;
                    }
                }
            }

            if(isPossible) {
                System.out.println("Case #" + tt + ": " + new String(carr));
            } else {
                System.out.println("Case #" + tt + ": " + "IMPOSSIBLE");
            }
        }
    }

    static class Task {
        Integer s;
        Integer e;
        Integer index;

        public Task(int s, int e, int index) {
            this.s = s ;
            this.e = e;
            this.index = index;
        }
    }
}