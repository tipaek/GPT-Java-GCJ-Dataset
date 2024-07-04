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
            for(int i=0; i<tasks; i++) order += "L";
            while(order.contains("L")) {
                int index = 0;
                for(int i=0; i<task_list.size(); i++) {
                    //Task m = task_list.get(i);
                    if(order.charAt(i) == 'L') {
                        index = i;
                        break;
                    }
                }
                for(int i=0; i<task_list.size(); i++) {
                    if(order.charAt(i) == 'L') {
                        Task m = task_list.get(index);
                        if(m.min() > task_list.get(i).min()) {
                            index = i;
                        }
                    }
                }
                Task t = task_list.get(index);
                if(checkTask(t,C)) {
                    C.add(t);
                    order = order.substring(0,index) + "C" + order.substring(index+1);
                    //order.replace((char) index,'C');
                    //order += "C";
                } else if(checkTask(t,J)) {
                    J.add(t);
                    order = order.substring(0,index) + "J" + order.substring(index+1);
                    //order.replace((char) index,'J');
                    //order += "J";
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
            if(n.min() <= t.min() && n.max() >= t.max()) return false;
            if(n.min() < t.min() && n.max() > t.min()) return false;
            if(n.max() >= t.max() && n.min() < t.max()) return false;
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
