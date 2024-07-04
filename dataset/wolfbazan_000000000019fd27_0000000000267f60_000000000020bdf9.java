import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Solution {
    PrintStream out = System.out;
    Scanner in  = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    private void solve(int testcase) {
        int numTasks = in.nextInt();
        ArrayList<TaskTimeLine> CTimeLines = new ArrayList<>();
        ArrayList<TaskTimeLine> JTimeLines = new ArrayList<>();
        ArrayList<TaskTimeLine> taskTimes  = new ArrayList<>();

        int i;
        for(i = 0; i < numTasks; ++i) {
            taskTimes.add(new TaskTimeLine(in.nextInt(), in.nextInt(), i));
        }
        //sort follow time start
        taskTimes.sort(Comparator.comparingInt(t -> t.start));

        boolean isImpossible = false;
        for(i= 0; i < numTasks; ++i) {
            TaskTimeLine taskAssign = taskTimes.get(i);
            if(canAssign(CTimeLines, taskAssign)) {
                taskAssign.setAssignee("C");
            } else if(canAssign(JTimeLines, taskAssign)) {
                taskAssign.setAssignee("J");
            } else {
                isImpossible = true;
                break;
            }
        }
        StringBuilder stringBuffer = new StringBuilder();
        if(isImpossible) {
            stringBuffer.append("IMPOSSIBLE");
        } else {
            //return index
            taskTimes.sort(Comparator.comparingInt(t -> t.index));
            for(i = 0; i < numTasks; ++i) {
                stringBuffer.append(taskTimes.get(i).assignee);
            }
        }

        out.println("Case #" + testcase + ": " + stringBuffer.toString());
    }

    boolean canAssign(ArrayList<TaskTimeLine> listTimeLines, TaskTimeLine task) {
        int size = listTimeLines.size();
        if(size == 0) {
            listTimeLines.add(task);
            return true;
        }
        int i;
        for(i = 0; i < size ; ++i) {
            TaskTimeLine current = listTimeLines.get(i);
            if(task.start >= current.end) {
                int nextTaskIndex = i + 1;
                if (nextTaskIndex < size) {
                    TaskTimeLine next = listTimeLines.get(nextTaskIndex);
                    if(task.end <= next.start) {
                        listTimeLines.add(task);
                        sort(listTimeLines);
                        return true;
                    }
                } else {
                    listTimeLines.add(task);
                    sort(listTimeLines);
                    return true;
                }
            }
            if(task.end <= current.start) {
                if(i == 0) {
                    listTimeLines.add(task);
                    sort(listTimeLines);
                    return true;
                }
            }
        }

        return false;
    }

    void sort(ArrayList<TaskTimeLine> listTimelines) {
        listTimelines.sort((o1, o2) -> Integer.compare(o1.start, o2.end));
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
        int start, end, index;
        String assignee;
        public TaskTimeLine(int start, int end, int index) {
            this.start = start;
            this.end = end;
            this.index = index;
        }
        void setAssignee(String assignee) {
            this.assignee = assignee;
        }
    }
}
