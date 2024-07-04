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


        StringBuffer stringBuffer = new StringBuffer();
        boolean faild = false;
        for(int i= 0; i < numTasks; ++i) {
            int start   = in.nextInt();
            int end     = in.nextInt();
            if(faild) continue;

            if(canAssign(CTimeLines, start, end)) {
                stringBuffer.append("C");
            } else if(canAssign(JTimeLines, start, end)) {
                stringBuffer.append("J");
            } else {
                stringBuffer = new StringBuffer();
                stringBuffer.append("IMPOSSIBLE");
                faild = true;
            }
        }

        out.println("Case #" + testcase + ": " + stringBuffer.toString());
    }

    boolean canAssign(ArrayList<TaskTimeLine> listTimeLines, int start, int end) {
        if(start > end) return false;
        if(start == end) return true;

        int size = listTimeLines.size();
        if(size == 0) {
            listTimeLines.add(new TaskTimeLine(start, end));
            return true;
        }
        for(int i = 0; i < size ; ++i) {
            TaskTimeLine current = listTimeLines.get(i);

            if(start >= current.end || end <= current.start) {
                if(start >= current.end) {
                    if (i + 1 < size) {
                        TaskTimeLine temp = listTimeLines.get(i + 1);
                        if(end <= temp.start) {
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
                    if(i - 1 > 0) {
                        TaskTimeLine temp = listTimeLines.get(i - 1);
                        if(start >= temp.end) {
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
        new ParentingPartneringReturns().run();
    }

    public class TaskTimeLine {
        int start, end;
        public TaskTimeLine(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
