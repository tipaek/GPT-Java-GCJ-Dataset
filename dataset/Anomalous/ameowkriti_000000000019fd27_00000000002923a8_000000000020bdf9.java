import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Solution {

    static class Quad {
        int start;
        int end;
        int index;
        char ch;

        public Quad(int start, int end, int index) {
            this.start = start;
            this.end = end;
            this.index = index;
        }
    }

    static class StartComparator implements Comparator<Quad> {
        @Override
        public int compare(Quad a, Quad b) {
            return Integer.compare(a.start, b.start);
        }
    }

    static class IndexComparator implements Comparator<Quad> {
        @Override
        public int compare(Quad a, Quad b) {
            return Integer.compare(a.index, b.index);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        int caseNumber = 1;

        while (testCases-- > 0) {
            int N = scanner.nextInt();
            ArrayList<Quad> intervals = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                intervals.add(new Quad(scanner.nextInt(), scanner.nextInt(), i));
            }

            Collections.sort(intervals, new StartComparator());
            String result = assignTasks(intervals);

            System.out.printf("Case #%d: %s%n", caseNumber++, result);
        }
    }

    public static String assignTasks(ArrayList<Quad> intervals) {
        ArrayList<Quad> cTasks = new ArrayList<>();
        ArrayList<Quad> jTasks = new ArrayList<>();

        int cMaxEnd = Integer.MIN_VALUE;
        int jMaxEnd = Integer.MIN_VALUE;

        Quad firstTask = intervals.get(0);
        cTasks.add(firstTask);
        firstTask.ch = 'C';
        cMaxEnd = firstTask.end;

        for (int i = 1; i < intervals.size(); i++) {
            Quad currentTask = intervals.get(i);

            if (currentTask.start >= cMaxEnd) {
                cTasks.add(currentTask);
                currentTask.ch = 'C';
                cMaxEnd = currentTask.end;
            } else if (currentTask.start >= jMaxEnd) {
                jTasks.add(currentTask);
                currentTask.ch = 'J';
                jMaxEnd = currentTask.end;
            } else {
                return "IMPOSSIBLE";
            }
        }

        cTasks.addAll(jTasks);
        Collections.sort(cTasks, new IndexComparator());

        StringBuilder result = new StringBuilder();
        for (Quad task : cTasks) {
            result.append(task.ch);
        }

        return result.toString();
    }
}