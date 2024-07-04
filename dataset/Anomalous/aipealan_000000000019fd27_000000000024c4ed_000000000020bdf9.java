import java.util.Scanner;
import java.util.Arrays;

class Task {
    int id, start, end;
    String worker;

    public Task(int id, int start, int end) {
        this.id = id;
        this.start = start;
        this.end = end;
        this.worker = null;
    }

    public void assignWorker(String workerId) {
        this.worker = workerId;
    }

    public void print() {
        System.out.println("Start : " + start + ", End :" + end);
    }
}

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int testcaseCount = in.nextInt();
        in.nextLine();

        for (int testCase = 0; testCase < testcaseCount; testCase++) {
            int taskCount = in.nextInt();
            in.nextLine();
            String output = "";
            Task[] tasks = new Task[taskCount];

            for (int j = 0; j < taskCount; j++) {
                tasks[j] = new Task(j, in.nextInt(), in.nextInt());
                in.nextLine();
            }

            Arrays.sort(tasks, (a, b) -> Integer.compare(a.start, b.start));

            boolean isCWorking = false, isJWorking = false;
            int endTimeC = -1, endTimeJ = -1;

            for (Task task : tasks) {
                if (!isCWorking && !isJWorking) {
                    isCWorking = true;
                    endTimeC = task.end;
                    task.assignWorker("C");
                } else if (isCWorking && isJWorking) {
                    String nextWorker = (endTimeC <= task.start) ? "C" : (endTimeJ <= task.start) ? "J" : null;
                    if (nextWorker != null) {
                        if (nextWorker.equals("C")) {
                            endTimeC = task.end;
                            task.assignWorker("C");
                        } else {
                            endTimeJ = task.end;
                            task.assignWorker("J");
                        }
                    } else {
                        output = "IMPOSSIBLE";
                        break;
                    }
                } else if (isCWorking) {
                    isJWorking = true;
                    endTimeJ = task.end;
                    task.assignWorker("J");
                } else {
                    isCWorking = true;
                    endTimeC = task.end;
                    task.assignWorker("C");
                }
            }

            Arrays.sort(tasks, (a, b) -> Integer.compare(a.id, b.id));

            if (!output.equals("IMPOSSIBLE")) {
                StringBuilder result = new StringBuilder();
                for (Task task : tasks) {
                    result.append(task.worker);
                }
                output = result.toString();
            }

            System.out.println("Case #" + (testCase + 1) + ": " + output);
        }
    }
}