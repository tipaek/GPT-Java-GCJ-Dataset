import java.util.*;

public class Solution {

    public static class Activity {
        public int id;
        public int from;
        public int to;

        public Activity(int id, int from, int to) {
            this.id = id;
            this.from = from;
            this.to = to;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int tt = 1; tt <= t; ++tt) {
            List<Activity> activities = new ArrayList<>();
            int n = sc.nextInt();
            for (int i = 0; i < n; ++i) {
                int from = sc.nextInt();
                int to = sc.nextInt();
                activities.add(new Activity(i, from, to));
            }
            activities.sort((a0, a1) -> {
                int temp = Integer.compare(a0.from, a1.from);
                if (temp == 0) {
                    return Integer.compare(a0.to, a1.to);
                }
                return temp;
            });
            int deadline0 = -1;
            int deadline1 = -1;
            String result = "";
            boolean invalid = false;
            Map<Integer, Integer> solution = new HashMap<>();
            for (Activity a : activities) {
                if (deadline0 == -1) {
                    deadline0 = a.to;
                    solution.put(a.id, 0);
                } else {
                    if (deadline1 == -1) {
                        deadline1 = a.to;
                        solution.put(a.id, 1);
                    } else {
                        if (deadline0 <= a.from) {
                            deadline0 = a.to;
                            solution.put(a.id, 0);
                        } else {
                            if (deadline1 <= a.from) {
                                deadline1 = a.to;
                                solution.put(a.id, 1);
                            } else {
                                invalid = true;
                                break;
                            }
                        }
                    }
                }
            }
            System.out.print("Case #" + tt + ": ");
            if (invalid) {
                System.out.println("IMPOSSIBLE");
            } else {
                for (int i = 0; i < n; ++i) {
                    System.out.print(solution.get(i) == 0 ? "C" : "J");
                }
                System.out.println();
            }
        }
    }
}
