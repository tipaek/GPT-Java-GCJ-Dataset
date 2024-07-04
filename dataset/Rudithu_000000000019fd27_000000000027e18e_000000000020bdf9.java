
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();

        for (int i=1; i <= t; i++) {
            int activities = in.nextInt();

            List<int[]> cTask = new ArrayList<>();
            List<int[]> jTask = new ArrayList<>();
            StringBuffer sb = new StringBuffer("Case #" + i +": ");

            for (int j=0;j<activities;j++) {
                int start = in.nextInt();
                int end = in.nextInt();

                if (canAssign(cTask, new int[]{start, end})){
                    sb.append("C");

                } else if (canAssign(jTask, new int[]{start, end})){
                    sb.append("J");

                } else {
                    sb = new StringBuffer("Case #" + i +": IMPOSSIBLE");
                    break;
                }
            }
            System.out.println(sb.toString());

        }
    }

    private static boolean canAssign(List<int[]> allTask, int[] currentTask) {
//        System.out.println();
//        System.out.println(currentTask[0] + "====================" + currentTask[1]);

        boolean in = false;
        if (allTask.size() == 0) {
            in = true;
            allTask.add(currentTask);
        } else if (currentTask[1] <= allTask.get(0)[0]) {
            in = true;
            allTask.add(0, currentTask);
        } else if (currentTask[0] >= allTask.get(allTask.size()-1)[1]) {
            in = true;
            if (currentTask[0] == allTask.get(allTask.size()-1)[1]) {
                allTask.get(allTask.size()-1)[1] = currentTask[1];
            } else {
                allTask.add(currentTask);
            }
        } else {
            for (int i = 0; i < allTask.size(); i++) {

                int[] task = allTask.get(i);

                if (currentTask[0] >= task[1]) {
                    if ((i + 1) < allTask.size()) {
                        if (currentTask[1] <= allTask.get(i + 1)[0]) {
                            in = true;
                            if (currentTask[0] == task[1] && currentTask[1] == allTask.get(i + 1)[0]) {
                                task[1] = allTask.get(i+1)[1];
                                allTask.remove(i+1);
                            } else if (currentTask[0] == task[1]) {
                                task[1] = currentTask[1];
                            } else if (currentTask[1] == allTask.get(i + 1)[0]) {
                                allTask.get(i + 1)[0] = currentTask[0];
                            } else {
                                allTask.add(i+1, currentTask);
                            }
                            break;

                        }
                    } else {
                        in = true;
                        if (task[1] == currentTask[0]) {
                            task[1] = currentTask[1];
                        } else {
                            allTask.add(currentTask);
                        }
                        break;
                    }

                } else {
                    break;
                }
            }
        }

//        System.out.print(in + "------>");
//        for (int[] t : allTask) {
//            System.out.print("("+t[0]+" - "+t[1]+")");
//        }
//        System.out.println();
        return in;
    }


}
