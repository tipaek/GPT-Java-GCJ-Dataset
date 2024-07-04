import java.util.*;
import java.io.*;

public class Solution {
    
    public static class Task implements Comparable<Task> {
        int time;
        int type;
        int index;
        
        public Task(int time, int type, int index) {
            this.time = time;
            this.type = type;
            this.index = index;
        }
        
        @Override
        public int compareTo(Task other) {
            if (this.time == other.time) {
                return this.type - other.type;
            }
            return Integer.compare(this.time, other.time);
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter output = new PrintWriter(System.out);
        int testCases = Integer.parseInt(input.readLine());
        
        for (int tc = 1; tc <= testCases; tc++) {
            int n = Integer.parseInt(input.readLine());
            PriorityQueue<Task> taskQueue = new PriorityQueue<>();
            
            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(input.readLine());
                taskQueue.add(new Task(Integer.parseInt(st.nextToken()), 0, i));
                taskQueue.add(new Task(Integer.parseInt(st.nextToken()), 1, i));
            }
            
            boolean isPossible = true;
            int activeTasks = 0;
            char[] schedule = new char[n];
            boolean isCameronBusy = false;
            boolean isJamieBusy = false;
            
            while (!taskQueue.isEmpty()) {
                Task currentTask = taskQueue.poll();
                
                if (currentTask.type == 0) {
                    activeTasks++;
                    if (activeTasks == 3) {
                        isPossible = false;
                        break;
                    } else {
                        if (!isCameronBusy) {
                            isCameronBusy = true;
                            schedule[currentTask.index] = 'C';
                        } else {
                            isJamieBusy = true;
                            schedule[currentTask.index] = 'J';
                        }
                    }
                } else {
                    activeTasks--;
                    if (schedule[currentTask.index] == 'C') {
                        isCameronBusy = false;
                    } else {
                        isJamieBusy = false;
                    }
                }
            }
            
            output.print("Case #" + tc + ": ");
            if (!isPossible) {
                output.println("IMPOSSIBLE");
            } else {
                output.println(new String(schedule));
            }
        }
        
        output.flush();
        output.close();
    }
}