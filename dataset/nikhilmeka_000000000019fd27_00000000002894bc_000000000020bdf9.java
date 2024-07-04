import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner s = new Scanner(System.in);
        int n = Integer.parseInt(s.nextLine());
        for(int i = 0; i < n; i++){
            int t = Integer.parseInt(s.nextLine());
            ArrayList<Task> tasks = new ArrayList<Task>();
            for(int j = 0; j<t; j++){
                tasks.add(new Task(s.nextLine(), j));
            }
            Collections.sort(tasks, new Comparator<Task>() {
                @Override
                public int compare(Task o1, Task o2) {
                    return o1.start - o2.start;
                }
            });
            int c = 0;
            int j = 0;
            boolean impossible = false;
            for(Task task : tasks){
                if(c <= task.start){
                    task.person = 'C';
                    c = task.end;
                }
                else if(j <= task.start){
                    task.person = 'J';
                    j = task.end;
                }
                else{
                    impossible = true;
                    break;
                }
            }
            if(impossible){
                System.out.println("Case #" + (i+1) + ": IMPOSSIBLE");
            }
            else {
                Collections.sort(tasks, new Comparator<Task>() {
                    @Override
                    public int compare(Task o1, Task o2) {
                        return o1.index - o2.index;
                    }
                });
                String ret = "";
                for (Task task : tasks) {
                    ret += task.person;
                }
                System.out.println("Case #" + (i + 1) + ": " + ret);
            }
        }
        s.close();

    }
    static class Task{
        int index;
        int start;
        int end;
        char person;
        public Task(String line, int index){
            this.index = index;
            String[] s = line.split(" ");
            start = Integer.parseInt(s[0]);
            end = Integer.parseInt(s[1]);
            person = '0';
        }
    }
}
