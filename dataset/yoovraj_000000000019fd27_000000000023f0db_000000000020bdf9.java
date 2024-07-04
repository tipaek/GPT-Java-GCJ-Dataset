/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 *
 * @author yoovraj.shinde
 */
public class Solution {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
//            System.out.println("-----");
            int N = in.nextInt();
            Task[] taskArray = new Task[N];
            for (int j = 0; j <  N; j++) {
                taskArray[j] = new Task();
                taskArray[j].taskNumber = j;
                taskArray[j].sTime = in.nextInt();
                taskArray[j].eTime = in.nextInt();
            }
            solve(taskArray, N, i);

        }
    }
    
    public static void solve(final Task[] taskArray, final int N, int testCaseNumber) {
        Arrays.sort(taskArray, new SortByStartTime());
//            Task.printAllTasks(taskArray);

        int CFreeAt = -1, JFreeAt = -1;
        for (int k = 0; k < N; k++) {
            Task currentTask = taskArray[k];

            // Check workload on each user
            int st = currentTask.sTime;
            if (st < JFreeAt && st < CFreeAt) {
                // both are busy, impossible to assign
                System.out.println("Case #" + testCaseNumber + ": IMPOSSIBLE");
                return;
            } else if (st >= JFreeAt && st >= CFreeAt) {
                // both are free, so select one person based on previous workload
                // for now use biased approach
                CFreeAt = currentTask.eTime;
                currentTask.assignee = 'C';
            } else if (st < JFreeAt) {
                // J is still busy
                CFreeAt = currentTask.eTime;
                currentTask.assignee = 'C';
            } else if (st < CFreeAt) {
                // S is still busy
                JFreeAt = currentTask.eTime;
                currentTask.assignee = 'J';
            }

        }
        Arrays.sort(taskArray, new SortByTaskNumber());
        char[] taskAssignment = new char[N];
        for (int k = 0; k < N; k++) {
            taskAssignment[k] = taskArray[k].assignee;
        }
        System.out.println("Case #" + testCaseNumber + ": " + new String(taskAssignment));
    }
}
class Task {
    int taskNumber;
    int sTime, eTime;
    char assignee;
    public void print() {
        System.out.println("Task " + taskNumber + " " + sTime + " - " + eTime + " => " + assignee);
    }
    
    public static void printAllTasks(Task[] taskList) {
        for (Task t : taskList) {
            t.print();
        }
    }
}
 class SortByTaskNumber implements Comparator<Task> {

    @Override
    public int compare(Task o1, Task o2) {
        return o1.taskNumber - o2.taskNumber;
    }
     
 }

class SortByStartTime implements Comparator<Task> {
    @Override
    public int compare(Task o1, Task o2) {
        return o1.sTime - o2.sTime;
    }
}