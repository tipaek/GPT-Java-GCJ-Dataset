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
            BitSet C = new BitSet(1440);
            BitSet J = new BitSet(1440);
            String out = "Case #" + (n+1) + ": ";
            ArrayList<Task> task_list = new ArrayList<>();
            for(int i=0; i<tasks; i++) {
                task_list.add(new Task(in.nextLine()));
            }
            for(int i=0; i<task_list.size(); i++) {
                int min = task_list.get(i).min();
                int max = task_list.get(i).max();
                if(C.get(min,max).cardinality() == 0) {
                    out += "C";
                    C.set(min,max);
                } else if(J.get(min,max).cardinality() == 0) {
                    out += "J";
                    J.set(min,max);
                } else {
                    out = "Case #" + (n+1) + ": " + "IMPOSSIBLE";
                    break;
                }
                //System.out.println("C " + C + " J " + J + " " + out);
            }
            outputs.add(out);
        }
        for(String s : outputs) {
            System.out.println(s);
        }
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
