package pgdp.space;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int tests = scanner.nextInt();
        for (int i = 0; i < tests; i++) {
            System.out.println("Case #" + (i + 1) + ": " + solve(scanner));
        }
    }

    public static class Task{
        public int number;
        public int start;
        public int end;
        public List<Task> nextTasks;
        public boolean visited = false;

        public Task(int number, int start, int end){
            this.number = number;
            this.start = start;
            this.end = end;
            this.nextTasks = new ArrayList();
        }

        public boolean check(Task task){
            if ((this.start<task.start && this.end > task.start) || ( this.start < task.end && this.end > task.end)){
                this.nextTasks.add(task);
                task.nextTasks.add(this);
                return true;
            }
            return false;
        }

        public boolean hasConflict(){
            return !nextTasks.isEmpty();
        }
    }

    public static String solve(Scanner scanner) {
        int n = scanner.nextInt();
        Task tasks[] = new Task[n];
        char assigns[] = new char[n];
        for(int i = 0;i<n;i++){
            tasks[i] = new Task(i, scanner.nextInt(),scanner.nextInt());
        }
        //build graph
        for(int i = 0;i<n;i++) {
            for (int j = i; j < n; j++) {
                tasks[i].check(tasks[j]);
            }
        }
        //check all without conflict
        for(int i = 0;i<n;i++){
            if(!tasks[i].hasConflict()){
                assigns[i] = 'C';
                tasks[i].visited = true;
            }
        }
        //solve graph - start random
        for(int i = 0;i<n;i++){
            if(tasks[i].hasConflict()){
                char opposite = 'C';
                if(tasks[i].visited) {
                    //has already been fixed get name
                    opposite = assigns[i] == 'C' ? 'J' : 'C';
                } else {
                    assigns[i] = 'J';
                    tasks[i].visited = true;
                }
                //give all neighbours inverse
                for(Task t : tasks[i].nextTasks){
                    if(assigns[t.number] == assigns[i]){
                        return "IMPOSSIBLE";
                    } else {
                        assigns[t.number] = opposite;
                        t.visited = true;
                    }
                }
            }
        }
        //has passed create string from char array
        return new String(assigns);
    }
}
