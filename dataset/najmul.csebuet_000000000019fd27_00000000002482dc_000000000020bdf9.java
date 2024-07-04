//package Codejam.Year2020.Qualification.ParentingPartneringReturns;

import java.io.*;
import java.util.*;

class Task {

    public int index, start, end;
    public char assignedTo = 'C';

    public boolean isOverlapTo(Task task) {

        if (start < task.start && task.start < end)return true;
        if (start < task.end && task.end < end)return true;

        if (start == task.start)return true;
        if (end == task.end)return true;

        return false;
    }

    public boolean isOverlapTo(List<Task> taskList) {

        for (int i = 0; i < taskList.size(); i++) {
            if (taskList.get(i).isOverlapTo(this)) {
                return true;
            }
        }

        return false;
    }
}

public class Solution {
    public static PrintWriter out;

    public static void main(String[] args) throws IOException {

        boolean fileInOut = Solution.class.getPackage() != null;

        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(fileInOut ? Solution.class.getResourceAsStream("in.txt") : System.in)));
        out = new PrintWriter(new BufferedOutputStream(fileInOut ? new FileOutputStream("out.txt") : System.out), true);

        int totalTestCase = sc.nextInt();

        for (int testCaseNumber = 1; testCaseNumber <= totalTestCase; testCaseNumber++) {

            int N = sc.nextInt();
            List<Task> taskList = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                Task task  = new Task();
                task.index = i;
                task.start = sc.nextInt();
                task.end = sc.nextInt();
                taskList.add(task);
            }

            new Solution().solve(testCaseNumber, taskList);
        }

        if (fileInOut) {
            verify(Solution.class.getResource("ans.txt").getFile());
        }
    }

    public static void verify(String ansFile) throws IOException {

        String outputFile = "out.txt";

        BufferedReader reader1 = new BufferedReader(new FileReader(ansFile));
        BufferedReader reader2 = new BufferedReader(new FileReader(outputFile));

        String line1 = reader1.readLine();
        String line2 = reader2.readLine();

        boolean areEqual = true;
        int lineNum = 1;

        while (line1 != null || line2 != null) {

            if (line1 == null || line2 == null) {

                areEqual = false;
                break;
            } else if (!line1.equals(line2)) {

                areEqual = false;
                break;
            }

            line1 = reader1.readLine();
            line2 = reader2.readLine();

            lineNum++;
        }

        if (areEqual) {

            System.out.println("All Test Cases Passed !");
        } else {

            System.out.println("Output differ at line " + lineNum);
            System.out.println("ans.txt has " + line1 + " and out.txt has " + line2 + " at line " + lineNum);
        }

        reader1.close();
        reader2.close();
    }

    public void solve(int testCaseNumber, List<Task> taskList) {

        Collections.sort(taskList, Comparator.comparingInt(ta -> ta.start));

        /*int[] overLapTracker = new int[24*60 + 1];

        for (int i = 0; i < taskList.size(); i++) {

            Task task = taskList.get(i);
            int num = 1;

            for (int j = task.start; j <= task.end; j++) {
                if (overLapTracker[j] == 0) {
                    overLapTracker[j] = num;
                }
                else if ((j+1) <= (overLapTracker.length-1) && overLapTracker[j] == overLapTracker[j+1]) {
                    ++overLapTracker[j];
                }
            }
        }

        for (int i = 0; i < overLapTracker.length; i++) {
            if (overLapTracker[i] > 2) {
                out.println("Case #" + testCaseNumber + ": IMPOSSIBLE");
                return;
            }
        }*/

        List<Task> cList = new ArrayList<>();
        List<Task> jList = new ArrayList<>();

        for (int i = 0; i < taskList.size(); i++) {

            Task task = taskList.get(i);

            if (!task.isOverlapTo(cList)) {
                cList.add(task);
            }
            else if (!task.isOverlapTo(jList)) {
                task.assignedTo = 'J';
                jList.add(task);
            }
            else {
                out.println("Case #" + testCaseNumber + ": IMPOSSIBLE");
                return;
            }
        }

        Collections.sort(taskList, Comparator.comparingInt(ta -> ta.index));

        out.print("Case #" + testCaseNumber + ": ");

        for (int i = 0; i < taskList.size(); i++) {
            out.print(taskList.get(i).assignedTo);
        }

        out.println();
    }
}
