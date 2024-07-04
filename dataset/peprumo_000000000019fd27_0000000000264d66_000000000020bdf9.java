import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    static class Duration {
        public long start;
        public long end;
    }

    public static void main(String[] args) {
        
        System.out.println("Case #1: IMPOSSIBLE");
    }

    private static boolean isFree(List<Duration> person, Duration newTask) {
        for (Duration task : person) {
            if ((newTask.start < task.start && newTask.end > task.start) ||
                    (newTask.start > task.start && newTask.end < task.end) ||
                    (newTask.start < task.end && newTask.end > task.end)) {
                return false;
            }
        }
        return true;
    }
}
