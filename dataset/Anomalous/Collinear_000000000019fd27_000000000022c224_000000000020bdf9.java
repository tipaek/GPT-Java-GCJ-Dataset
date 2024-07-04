import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        int cases = input.nextInt();
        
        for (int x = 0; x < cases; x++) {
            int times = input.nextInt();
            Task[] tasks = new Task[times];
            
            for (int i = 0; i < times; i++) {
                int start = input.nextInt();
                int end = input.nextInt();
                tasks[i] = new Task(start, end, i);
            }
            
            Arrays.sort(tasks);
            
            int jEnd = -1; // End time for J
            int cEnd = -1; // End time for C
            boolean isImpossible = false;
            StringBuilder result = new StringBuilder();
            
            for (Task task : tasks) {
                if (task.start >= jEnd) {
                    task.assignedTo = 'J';
                    jEnd = task.end;
                } else if (task.start >= cEnd) {
                    task.assignedTo = 'C';
                    cEnd = task.end;
                } else {
                    result.append("IMPOSSIBLE");
                    isImpossible = true;
                    break;
                }
            }
            
            if (!isImpossible) {
                char[] output = new char[times];
                for (Task task : tasks) {
                    output[task.index] = task.assignedTo;
                }
                result.append(output);
            }
            
            System.out.println("Case #" + (x + 1) + ": " + result);
        }
        
        input.close();
    }
}

class Task implements Comparable<Task> {
    int start;
    int end;
    int index;
    char assignedTo;
    
    public Task(int start, int end, int index) {
        this.start = start;
        this.end = end;
        this.index = index;
    }
    
    @Override
    public int compareTo(Task other) {
        return Integer.compare(this.start, other.start);
    }
}