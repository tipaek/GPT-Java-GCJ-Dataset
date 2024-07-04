import java.io.*;
import java.util.*;
class Task{
    int s, e, index;
    Task(int a, int b, int c){
        s = a;
        e = b;
        index = c;
    }
}
class TaskComparison implements Comparator<Task>{
    public int compare(Task a, Task b){
        if(a.s != b.s)
            return a.s - b.s;
        else
            return a.index - b.index;
    }
}
public class Solution{
    public static void main(String[] args) throws IOException {
        int t = getInt();
        for(int i = 1; i <= t; i++){
           int n = getInt();
           int[] assignment = new int[n];
           boolean isPossible = true;
           int cBusyUntil = 0;
           int jBusyUntil = 0;
           PriorityQueue<Task> tasks = new PriorityQueue<>(new TaskComparison());
           for(int j = 0; j < n; j++){
               tasks.add(new Task(getInt(), getInt(), j));
           }
           while(tasks.size() > 0){
               Task a = tasks.poll();
               if(a.s >= cBusyUntil){
                   assignment[a.index] = 1;
                   cBusyUntil = a.e;
               }
               else if (a.s >= jBusyUntil){
                   assignment[a.index] = 2;
                   jBusyUntil = a.e;
               }
               else{
                   isPossible = false;
                   break;
               }
           }
           System.out.print("Case #" + i + ": ");
           if(isPossible){
               
               for(int a : assignment){
                System.out.print((a == 1)? 'C':'J');
               }
               System.out.println("");
           }
           else
           System.out.println("IMPOSSIBLE");
        }
    }
    public static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    public static int getInt() throws IOException{
        int c = skipSpace();
        boolean isNeg = (char) c == '-';
        int out = 0;
        if(isNeg)
          c = input.read();
        do {
          out *= 10;
          out += c - '0';
          c = input.read();
        } while (c <= '9' && c >= '0');
        return (isNeg)? -out: out;
      }
    public static int skipSpace() throws IOException{
        int s = input.read();
        while(s == ' ' || s == '\n' || s == '\r') {
          s = input.read();
        }
        return s;
      }
}