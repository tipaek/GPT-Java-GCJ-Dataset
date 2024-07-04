import java.util.*;

class Activity {
    int start, finish;

    Activity(int start, int finish) {
        this.start = start;
        this.finish = finish;
    }
}

class Solution {

    public static String changePerson(String person) {
        return person.equals("C") ? "J" : "C";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCaseCount = sc.nextInt();

        for (int k = 1; k <= testCaseCount; k++) {
            int n = sc.nextInt();
            List<Activity> activities = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                int startTime = sc.nextInt();
                int endTime = sc.nextInt();
                activities.add(new Activity(startTime, endTime));
            }

            activities.sort(Comparator.comparingInt(a -> a.finish));

            int[] taskAssign = new int[n];
            taskAssign[0] = 1; // C is represented by 1

            for (int i = 1; i < n; i++) {
                Activity prev = activities.get(i - 1);
                Activity curr = activities.get(i);

                if (curr.start >= prev.finish) {
                    taskAssign[i] = 1;
                }
            }

            Activity prevTaskJ = null;
            for (int i = 1; i < n; i++) {
                if (taskAssign[i] == 0) {
                    if (prevTaskJ == null || activities.get(i).start >= prevTaskJ.finish) {
                        taskAssign[i] = 2; // J is represented by 2
                        prevTaskJ = activities.get(i);
                    }
                }
            }

            boolean isPossible = true;
            StringBuilder sequence = new StringBuilder();
            for (int i = 0; i < n; i++) {
                if (taskAssign[i] == 0) {
                    isPossible = false;
                    break;
                }
                sequence.append(taskAssign[i] == 1 ? "C" : "J");
            }

            if (isPossible) {
                System.out.println("Case #" + k + ": " + sequence);
            } else {
                System.out.println("Case #" + k + ": IMPOSSIBLE");
            }
        }
    }
}