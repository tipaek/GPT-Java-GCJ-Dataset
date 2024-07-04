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
                    if (j == 0) {
                        tasksCBegin.put(begin, end);
                        outputString.append("C");
                    } else {
                        boolean spaceFound = false;
                        if (!tasksCBegin.containsKey(begin)) {
                            Integer bC = tasksCBegin.lowerKey(begin);
                            if (bC != null && tasksCBegin.get(bC) <= begin) {
                                //System.out.println("Case 1");
                                tasksCBegin.put(begin, end);
                                outputString.append("C");
                                spaceFound = true;
                            }

                            if (!spaceFound && bC == null) {
                                bC = tasksCBegin.higherKey(begin);
                                if ((bC != null && bC >= end) || bC == null) {
                                    //System.out.println("Case 2");
                                    tasksCBegin.put(begin, end);
                                    outputString.append("C");
                                    spaceFound = true;
                                }
                            }
                        }

                        if (!tasksJBegin.containsKey(begin)) {
                            Integer bJ = tasksJBegin.lowerKey(begin);
                            if (!spaceFound && bJ != null && tasksJBegin.get(bJ) <= begin) {
                                //System.out.println("Case 3");
                                tasksJBegin.put(begin, end);
                                outputString.append("J");
                                spaceFound = true;
                            }

                            if (!spaceFound && bJ == null) {
                                bJ = tasksJBegin.higherKey(begin);
                                if ((bJ != null && bJ >= end) || bJ == null) {
                                    //System.out.println("Case 4");
                                    tasksJBegin.put(begin, end);
                                    outputString.append("J");
                                    spaceFound = true;
                                }
                            }
                        }

                        if (!spaceFound) {
                            outputString = new StringBuilder(new String("IMPOSSIBLE"));
                            j = tasks;
                        }


                    }
                }
            }

            int caseNo = i+1;
            System.out.println("Case #" + caseNo + ": " + outputString);

        }

    }
}
