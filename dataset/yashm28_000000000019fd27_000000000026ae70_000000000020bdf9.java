import java.util.*;

class Solution {
 
    public static void main (String args[]) {
        
        Scanner scanner = new Scanner (System.in);
        int t = scanner.nextInt ();
        
        for (int c = 0; c < t; c++) {
            
            int n = scanner.nextInt ();
            char[] ans = new char [n];
            boolean isPossible = true;
            ArrayList <Task> tasks = new ArrayList <> ();
            
            for (int i = 0; i < n; i++) {
                tasks.add (new Task (
                    scanner.nextInt (),
                    scanner.nextInt (),
                    i
                ));
            }
            
            Collections.sort (tasks);
            
            HashMap <Character, Integer> busyTill = new HashMap <> ();
            busyTill.put ('C', 0);
            busyTill.put ('J', 0);
            
            for (Task task : tasks) {
                if (task.start >= busyTill.get ('C')) {
                    task.assignee = 'C';
                    busyTill.put ('C', task.end);
                    ans[task.index] = 'C';
                } else if (task.start >= busyTill.get ('J')) {
                    task.assignee = 'J';
                    busyTill.put ('J', task.end);
                    ans[task.index] = 'J';
                } else {
                    isPossible = false;
                    System.out.println (
                        "Case #" + (c + 1) + ": IMPOSSIBLE"
                    );
                    break;
                }
            }
            
            if (isPossible) {
                System.out.println (
                    "Case #" + (c + 1) + ": " + new String (ans)
                );
            }
        }
        
        scanner.close ();
        
    }
    
    static class Task  implements Comparable<Task> {
        int start, end, index;
        char assignee;
        
        public Task (int start, int end, int index) {
            this.start = start;
            this.end = end;
            this.index = index;
        }
        
        @Override     
        public int compareTo(Task task) {          
            return (this.start < task.start ? -1 : 
                    (this.start == task.start ? 0 : 1));     
        }  
        
    }
    
}