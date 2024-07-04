import java.util.*;
import java.io.*;
public class Solution {

    static class Task{
        int start;
        int end;
        Task(int start, int end){
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args){
        int t;
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        t = in.nextInt();


        for(int i=0; i<t; i++){
            int taskCount = in.nextInt();
            int cEnd = Integer.MIN_VALUE;
            int jEnd = Integer.MIN_VALUE;
            PriorityQueue<Task> minHeap = new PriorityQueue<>((t1,t2)-> t1.start == t2.start
                    ? t1.end - t2.end : t1.start - t2.start);
            for(int j=0; j<taskCount; j++){
                int start = in.nextInt();
                int end = in.nextInt();
                minHeap.add(new Task(start, end));
            }
            StringBuilder sb = new StringBuilder();

            while (!minHeap.isEmpty()){
                Task task = minHeap.poll();
                if(cEnd>task.start && jEnd>task.start){
                    break;
                }
                if(cEnd<=task.start){
                    cEnd = task.end;
                    sb.append("C");
                } else if(jEnd<=task.start){
                    jEnd = task.end;
                    sb.append("J");
                }
            }
            String result = sb.length() == taskCount ? sb.toString() : "IMPOSSIBLE";
            int caseNo = i+1;
            System.out.println("Case #" + caseNo + ": " + result);
        }

    }
}
