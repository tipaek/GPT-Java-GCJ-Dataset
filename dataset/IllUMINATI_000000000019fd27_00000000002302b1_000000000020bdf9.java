import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = Integer.parseInt(in.nextLine());
        for (int i = 1; i <= t; i++) {
            ArrayList<Task> data = new ArrayList<>();
            int input = Integer.parseInt(in.nextLine());
            for (int j = 1; j <= input; j++) {
                String[] parts = in.nextLine().split(" ");
                data.add(new Task(j - 1, parts[0], parts[1]));
            }
            String s = parentingPartneringReturns(data);
            System.out.printf("Case #%d: %s\n", i, s);
        }
    }

    private static String parentingPartneringReturns(ArrayList<Task> input) {
        int length = input.size();

        char[] output = new char[length];
        input.sort(Comparator.comparing(Task::getStart));
        int c = input.get(0).getEnd();
        output[input.get(0).getI()] = 'C';
        int j = input.get(1).getEnd();
        output[input.get(1).getI()] = 'J';
        for (int i = 2; i < length; i++) {
            Task task = input.get(i);
            if (task.getStart() >= c) {
                output[task.getI()] = 'C';
                c = task.getEnd();
            } else if (task.getStart() >= j) {
                output[task.getI()] = 'J';
                j = task.getEnd();
            } else {
                return "IMPOSSIBLE";
            }
        }


        return new String(output);
    }


}


class Task {
    private int i;
    private int start;
    private int end;

    public Task(int i, String start, String end) {
        this.i = i;
        this.start = Integer.parseInt(start);
        this.end = Integer.parseInt(end);
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }
}

