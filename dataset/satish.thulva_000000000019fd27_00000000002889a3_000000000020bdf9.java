import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @author satish.thulva. Generated on 04/04/20
 **/
public class Solution {

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int numTests = Integer.parseInt(reader.readLine());
            for (int i = 0; i < numTests; i += 1) {
                parseAndProcessTest(i + 1, reader);
            }
        }
    }

    private static void parseAndProcessTest(int testNumber, BufferedReader reader) throws IOException {
        int numTasks = Integer.parseInt(reader.readLine());
        Task[] start = new Task[numTasks];
        for (int i = 0; i < numTasks; i += 1) {
            String[] fields = reader.readLine().split(" ", -1);
            start[i] = new Task(i + 1, Integer.parseInt(fields[0]), Integer.parseInt(fields[1]));
        }
        Arrays.sort(start, Comparator.comparing(Task::getStartMinute));
        Task[] end = Arrays.copyOf(start, start.length);
        Arrays.sort(end, Comparator.comparingInt(Task::getEndMinute));

        char[] taskAssignment = new char[numTasks];
        int numOverlappingTasks = 0;
        int carolFreeTime = 0;
        boolean isImpossible = false;
        int i = 0, j = 0;
        for (; i < numTasks && j < numTasks; ) {
            if (start[i].getStartMinute() <= end[j].getEndMinute()) {
                numOverlappingTasks += 1;
                int taskNum = start[i].getNumber() - 1;
                if (carolFreeTime <= start[i].getStartMinute()) {
                    taskAssignment[taskNum] = 'C';
                    carolFreeTime = start[i].getEndMinute() + 1;
                } else {
                    taskAssignment[taskNum] = 'J';
                }
                i += 1;
            } else {
                numOverlappingTasks -= 1;
                j += 1;
            }

            if (numOverlappingTasks > 2) {
                isImpossible = true;
                break;
            }
        }
        if (i < numTasks) {
            taskAssignment[start[i].getNumber() - 1] = carolFreeTime <= start[i].getStartMinute() ? 'C' : 'J';
        }

        System.out.print("Case #" + testNumber + ":");
        if (isImpossible) {
            System.out.println("IMPOSSIBLE");
        } else {
            System.out.println(new String(taskAssignment));
        }
    }

    private static class Task {
        private int number;
        private int startMinute;
        private int endMinute;

        public Task(int number, int startMinute, int endMinute) {
            this.number = number;
            this.startMinute = startMinute;
            this.endMinute = endMinute - 1;
        }

        public int getNumber() {
            return number;
        }

        public int getStartMinute() {
            return startMinute;
        }

        public int getEndMinute() {
            return endMinute;
        }

        public boolean overlap(Task o) {
            return getStartMinute() <= o.getEndMinute() && getEndMinute() >= o.getStartMinute();
        }
    }

}
