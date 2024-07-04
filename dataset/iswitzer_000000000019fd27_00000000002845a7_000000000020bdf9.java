import java.util.*;
import java.io.*;

//PARENTING PARTNERING RETURNS
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int num_cases = Integer.parseInt(in.nextLine());
        ArrayList<String> outputs = new ArrayList<>();
        for(int n=0; n<num_cases; n++) {
            int tasks = Integer.parseInt(in.nextLine());
            ArrayList<Task> C = new ArrayList<>();
            ArrayList<Task> J = new ArrayList<>();
            String out = "Case #" + (n+1) + ": ";
            ArrayList<Task> task_list = new ArrayList<>();
            for(int i=0; i<tasks; i++) {
                task_list.add(new Task(in.nextLine()));
            }
            String order = "";
            for(Task t : task_list) {
                if(checkTask(t,C)) {
                    C.add(t);
                    order += "C";
                } else if(checkTask(t,J)) {
                    J.add(t);
                    order += "J";
                } else {
                    order = "IMPOSSIBLE";
                    break;
                }
            }
            out += order;
            outputs.add(out);
        }
        for(String s : outputs) {
            System.out.println(s);
        }
    }

    public static boolean checkTask(Task t, ArrayList<Task> prev) {
        for(Task n : prev) {
            if(n.min() >= t.min() && n.min() < t.max()) return false;
            if(n.max() < t.max() && n.max() > t.min()) return false;
            if(n.min() < t.min() && n.max() > t.max()) return false;
        }
        return true;
    }

    private static class Task {
        private int start;
        private int end;

        public Task(String t) {
            this.start = Integer.parseInt(t.split(" ")[0]);
            this.end = Integer.parseInt(t.split(" ")[1]);
        }

        public int min() {
            return this.start;
        }

        public int max() {
            return this.end;
        }
    }
}
