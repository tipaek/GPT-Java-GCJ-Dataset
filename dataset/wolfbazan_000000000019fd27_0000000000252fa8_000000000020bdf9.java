import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Solution {
    PrintStream out = System.out;
    Scanner in  = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    private void solve(int testcase) {
        int numTasks = in.nextInt();
        ArrayList<TaskTimeLine> CTimeLines = new ArrayList<>();
        ArrayList<TaskTimeLine> JTimeLines = new ArrayList<>();

        int[] tasks = new int[numTasks * 2];
        for(int i = 0; i < numTasks; ++i) {
            tasks[i * 2] = in.nextInt();
            tasks[i * 2 + 1] = in.nextInt();
        }

        StringBuffer stringBuffer = new StringBuffer();
        for(int i= 0; i < numTasks; ++i) {
            int start   = tasks[i * 2];
            int end     = tasks[i * 2 + 1];

            if(canAssign(CTimeLines, start, end)) {
                stringBuffer.append("J");
            } else if(canAssign(JTimeLines, start, end)) {
                stringBuffer.append("C");
            } else {
                stringBuffer = new StringBuffer();
                stringBuffer.append("IMPOSSIBLE");
                break;
            }
        }

        out.println("Case #" + testcase + ": " + stringBuffer.toString());
    }

    boolean canAssign(ArrayList<TaskTimeLine> listTimeLines, int start, int end) {
        int size = listTimeLines.size();
        if(size == 0) {
            listTimeLines.add(new TaskTimeLine(start, end));
            return true;
        }
        for(int i = 0; i < size ; ++i) {
            TaskTimeLine current = listTimeLines.get(i);
            if(start >= current.end) {
                int nextTaskIndex = i + 1;
                if (nextTaskIndex < size) {
                    TaskTimeLine next = listTimeLines.get(nextTaskIndex);
                    if(end <= next.start) {
                        listTimeLines.add(new TaskTimeLine(start, end));
                        sort(listTimeLines);
                        return true;
                    }
                } else {
                    listTimeLines.add(new TaskTimeLine(start, end));
                    sort(listTimeLines);
                    return true;
                }
            }
            if(end <= current.start) {
                int prevTaskIndex = i - 1;
                if(prevTaskIndex >= 0) {
                    TaskTimeLine prev = listTimeLines.get(prevTaskIndex);
                    if(start >= prev.end) {
                        listTimeLines.add(new TaskTimeLine(start, end));
                        sort(listTimeLines);
                        return true;
                    }
                } else {
                    listTimeLines.add(new TaskTimeLine(start, end));
                    sort(listTimeLines);
                    return true;
                }
            }
        }

        return false;
    }

    void sort(ArrayList listTimelines) {
        Collections.sort(listTimelines, new Comparator<TaskTimeLine>() {
            @Override
            public int compare(TaskTimeLine o1, TaskTimeLine o2) {
                if(o1.start < o2.end) {
                    return -1;
                } else return 1;
            }
        });

    }

    void run() {
        int t = in.nextInt();
        for (int i = 1; i <= t; i++) {
            solve(i);
        }
        in.close();
        out.close();
    }

    public static void main(String[] args) {
        new Solution().run();
    }

    public class TaskTimeLine {
        int start, end;
        public TaskTimeLine(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
