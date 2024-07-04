import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeMap;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int testCases = in.nextInt();
        //System.out.println(testCases);
        if (testCases == 0 )
            return;
        for (int i = 0; i < testCases; i++) {

            int tasks = in.nextInt();
            StringBuilder outputString = new StringBuilder("");
            for (int j = 0; j < tasks; j++)
                outputString.append(" ");
            if (tasks >= 0) {

                Task_Obj[] task_list = new Task_Obj[tasks];
                //System.out.println("Task Length: " + task_list.length);
                for (int j = 0; j < tasks; j++) {
                    int b = in.nextInt();
                    int e = in.nextInt();
                    task_list[j] = new Task_Obj(j, b, e);
                    //System.out.println(b + " " + task_list[j]);
                }

                Arrays.sort(task_list);

                TreeMap<Integer, Integer> tasksCBegin = new TreeMap<>();
                TreeMap<Integer, Integer> tasksJBegin = new TreeMap<>();

                for (Task_Obj t : task_list) {

                    if (!outputString.toString().equals("IMPOSSIBLE")) {
                        Integer begC = 0;
                        Integer begJ = 0;
                        int endC = 0;
                        int endJ = 0;
                        if (tasksCBegin.containsKey(t.begin) && tasksJBegin.containsKey(t.begin)) {
                            outputString = new StringBuilder(new String("IMPOSSIBLE"));
                        } else {
                            begC = tasksCBegin.higherKey(t.begin);
                            begJ = tasksJBegin.higherKey(t.begin);
                            boolean cPos = false;
                            boolean jPos = false;

                            boolean cPosB = false;
                            boolean jPosB = false;
                            Integer k = tasksCBegin.lowerKey(t.begin);
                            Integer l = tasksJBegin.lowerKey(t.begin);
                            if (k != null)
                                endC = tasksCBegin.get(k);
                            if (l != null)
                                endJ = tasksJBegin.get(l);

                            if (k != null && l != null) {
                                if (endC <= t.begin && endJ <= t.begin) {
                                    cPos = true;
                                    jPos = true;
                                } else if (endC <= t.begin) {
                                    cPos = true;
                                } else if (endJ <= t.begin) {
                                    jPos = true;
                                }
                            } else if (k != null && endC <= t.begin) {
                                cPos = true;
                            } else if (l != null && endJ <= t.begin) {
                                jPos = true;
                            }
                            if (k == null && l == null) {
                                cPos = true;
                                jPos = true;
                            } else if (k == null) {
                                cPos = true;
                            } else if (l == null) {
                                jPos = true;
                            }

                            if (tasksCBegin.containsKey(t.begin))
                                cPos = false;

                            if (tasksJBegin.containsKey(t.begin))
                                jPos = false;

                            if (begC == null || (begC >= t.end)) {
                                cPosB = true;
                            }

                            if (begJ == null || (begJ >= t.end)) {
                                jPosB = true;
                            }

                            // decide which parent is better suited for this / closer to last task
                            if (cPos && cPosB && jPos && jPosB) {
                                int distC = 0;
                                int distJ = 0;
                                if (k != null)
                                    distC = t.begin - endC;
                                else
                                    distC = t.begin;

                                if (l != null)
                                    distJ = t.begin - endJ;
                                else
                                    distJ = t.begin;

                                if (distC <= distJ) {
                                    outputString.replace(t.pos, t.pos+1, "C");
                                    tasksCBegin.put(t.begin, t.end);
                                } else {
                                    outputString.replace(t.pos, t.pos+1, "J");
                                    tasksJBegin.put(t.begin, t.end);
                                }
                            } else if (cPos && cPosB) {
                                outputString.replace(t.pos, t.pos+1, "C");
                                tasksCBegin.put(t.begin, t.end);
                            } else if (jPos && jPosB) {
                                outputString.replace(t.pos, t.pos+1, "J");
                                tasksJBegin.put(t.begin, t.end);
                            } else {
                                outputString = new StringBuilder(new String("IMPOSSIBLE"));
                            }
                            //System.out.println(outputString);
                        }
                    }
                }

                int caseNo = i+1;
                System.out.println("Case #" + caseNo + ": " + outputString);
            }

        }
    }

    public static class Task_Obj implements Comparable<Task_Obj> {
        public int pos;
        public int begin;
        public int end;

        public Task_Obj(int pos, int begin, int end) {
            this.pos = pos;
            this.begin = begin;
            this.end = end;
        }

        @Override
        public int compareTo(Task_Obj obj) {

            int x = Integer.compare(this.begin, obj.begin);
            if (x == 0) {
                x = Integer.compare(this.begin, obj.begin);
            }
            //System.out.println(this.begin + " " + this.end + " " + obj.begin + " " + obj.end + " " + x);
            return x;

        }
    }
}

