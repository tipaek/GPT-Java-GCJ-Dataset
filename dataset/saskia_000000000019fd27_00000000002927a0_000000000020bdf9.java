import java.io.BufferedReader;
import java.io.InputStreamReader;
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
            StringBuilder outputString = new StringBuilder(new String(""));
            int tasks = in.nextInt();
            if (tasks >= 0) {
                TreeMap<Integer, Integer> tasksCBegin = new TreeMap<>();
                TreeMap<Integer, Integer> tasksJBegin = new TreeMap<>();

                for (int j = 0; j < tasks; j++) {
                    int begin = in.nextInt();
                    //System.out.println(begin);
                    int end = in.nextInt();
                    //System.out.println(end);

                    if (j == 0 && !outputString.equals("IMPOSSIBLE")) {
                        tasksCBegin.put(begin, end);
                        outputString.append("C");
                    } else if (!outputString.equals("IMPOSSIBLE")) {
                        Integer begC = 0;
                        Integer begJ = 0;
                        int endC = 0;
                        int endJ = 0;
                        if (tasksCBegin.containsKey(begin) && tasksJBegin.containsKey(begin)) {
                            outputString = new StringBuilder(new String("IMPOSSIBLE"));
                        } else {
                            begC = tasksCBegin.higherKey(begin);
                            begJ = tasksJBegin.higherKey(begin);
                            boolean cPos = false;
                            boolean jPos = false;

                            boolean cPosB = false;
                            boolean jPosB = false;
                            Integer k = tasksCBegin.lowerKey(begin);
                            Integer l = tasksJBegin.lowerKey(begin);
                            if (k != null)
                                endC = tasksCBegin.get(k);
                            if (l != null)
                                endJ = tasksJBegin.get(l);

                            if (k != null && l != null) {
                                if (endC <= begin && endJ <= begin) {
                                    cPos = true;
                                    jPos = true;
                                } else if (endC <= begin) {
                                    cPos = true;
                                } else if (endJ <= begin) {
                                    jPos = true;
                                }
                            } else if (k != null && endC <= begin) {
                                cPos = true;
                            } else if (l != null && endJ <= begin) {
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

                            if (begC == null || (begC >= end)) {
                                cPosB = true;
                            }

                            if (begJ == null || (begJ >= end)) {
                                jPosB = true;
                            }

                            // decide which parent is better suited for this / closer to last task
                            if (cPos && cPosB && jPos && jPosB) {
                                int distC = 0;
                                int distJ = 0;
                                if (k != null)
                                    distC = begin - endC;
                                else
                                    distC = begin;

                                if (l != null)
                                    distJ = begin - endJ;
                                else
                                    distJ = begin;

                                if (distC <= distJ) {
                                    outputString.append("C");
                                    tasksCBegin.put(begin, end);
                                } else {
                                    outputString.append("J");
                                    tasksJBegin.put(begin, end);
                                }
                            } else if (cPos && cPosB) {
                                outputString.append("C");
                                tasksCBegin.put(begin, end);
                            } else if (jPos && jPosB) {
                                outputString.append("J");
                                tasksJBegin.put(begin, end);
                            } else {
                                outputString = new StringBuilder(new String("IMPOSSIBLE"));
                            }
                            //System.out.println(outputString);
                        }
                    }
                }
            }

            int caseNo = i+1;
            System.out.println("Case #" + caseNo + ": " + outputString);

        }

    }
}
