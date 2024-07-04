//package codejam_2020;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Solution {

    static Set<Task> set = new TreeSet<>();

    private static void processSet(int num) {
        StringBuilder sol = new StringBuilder("");
        Task CTask = null;
        Task JTask = null;
        System.out.println(set);
        boolean isImpossible = false;
        for (Task task : set) {
            if (CTask == null || CTask.end <= task.start) {
                CTask = task;
                sol.append('C');
                continue;
            }
            if (JTask == null || JTask.end <= task.start) {
                JTask = task;
                sol.append('J');
                continue;
            }
            isImpossible = true;
        }
        if(isImpossible) {
            System.out.println("Case #"+num+": "+  "IMPOSSIBLE");
            return;
        }
        System.out.println("Case #"+num+": "+ sol);


    }

    public static void main(String args[]) {
        try (Scanner scanner = new Scanner(System.in);) {
            int testCount = Integer.parseInt(scanner.nextLine());
            for (int testNumber = 1; testNumber <= testCount; testNumber++) {
                int taskCount = Integer.parseInt(scanner.nextLine());
                for (int i = 0; i < taskCount; i++) {
                    String testString = scanner.nextLine();
                    String[] inputParam = testString.split(" ");
                    set.add(new Task(Integer.parseInt(inputParam[0]), Integer.parseInt(inputParam[1]), i));
                }
                processSet(testNumber);
                set = new TreeSet<>();
            }
        }
    }
}

class Task implements Comparable {
    int start;

    @Override
    public String toString() {
        return "Task{" +
                "start=" + start +
                ", end=" + end +
                ", id=" + id +
                '}';
    }

    int end;
int id;
    static int counter = 0;

    public Task(int start, int end, int id) {
        this.start = start;
        this.end = end;
        this.id = id;
    }

    public Task(int start, int end) {
        this.start = start;
        this.end = end;
        this.id = counter;
        counter++;
    }

    @Override
    public int compareTo(Object o) {
        if (this.start > ( (Task) o ).start) {
            return 1;
        }
        if (this.start > ( (Task) o ).start) {
            return 1;
        }
        return -1;
    }

}