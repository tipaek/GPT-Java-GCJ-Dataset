import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            System.out.print("Case #" + i + ": ");
            int n = in.nextInt();
            QualCTask[] tasks = new QualCTask[n];
            for(int j=0; j<n; j++) {
                int start = in.nextInt();
                int end = in.nextInt();
                tasks[j] = new QualCTask(j, start, end);
            }
            testCase(n, tasks);
        }
    }
    private static void testCase(int n, QualCTask[] tasks) {
        Comparator<QualCTask> a = new QualCTaskCompA();
        Comparator<QualCTask> b = new QualCTaskCompB();
        Arrays.sort(tasks, a);
        
        // if both of the couple can do the task, Jamie will do :)
        boolean isJamieWorking = false;
        int jamieFinishes = 0;
        boolean isCameronWorking = false;
        int cameronFinishes = 0;
        for(int i=0; i<n; i++) {
            QualCTask task = tasks[i];
            
            // finished?
            if(isJamieWorking && jamieFinishes<=task.start) {
                isJamieWorking = false;
            }
            if(isCameronWorking && cameronFinishes<=task.start) {
                isCameronWorking = false;
            }
            if(isJamieWorking && isCameronWorking) {
                System.out.println("IMPOSSIBLE");
                return;
            }
            
            if(isJamieWorking) {
                isCameronWorking = true;
                cameronFinishes = task.end;
                task.worker = 'C';
            }
            else {
                isJamieWorking = true;
                jamieFinishes = task.end;
                task.worker = 'J';
            }
        }
        Arrays.sort(tasks, b);
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++) {
            sb.append(tasks[i].worker);
        }
        System.out.println(sb.toString());
    }
}
class QualCTask {
    public int taskID;
    public int start;
    public int end;
    public char worker = 'x';
    
    public QualCTask(int id, int start, int end) {
        this.taskID = id;
        this.start = start;
        this.end = end;
    }
}
class QualCTaskCompA implements Comparator<QualCTask> {
    @Override
    public int compare(QualCTask o1, QualCTask o2) {
        return o1.start - o2.start;
    }
}
class QualCTaskCompB implements Comparator<QualCTask> {
    @Override
    public int compare(QualCTask o1, QualCTask o2) {
        return o1.taskID - o2.taskID;
    }
}
