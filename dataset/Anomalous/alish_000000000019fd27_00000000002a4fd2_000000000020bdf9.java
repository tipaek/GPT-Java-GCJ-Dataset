import java.util.LinkedList;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            int cases = input.nextInt();
            
            for (int i = 1; i <= cases; i++) {
                int activities = input.nextInt();
                StringBuilder result = new StringBuilder();
                LinkedList<Integer> cameron = new LinkedList<>();
                LinkedList<Integer> jamie = new LinkedList<>();

                // Initialize the first two activities for Cameron and Jamie
                cameron.add(input.nextInt());
                cameron.add(input.nextInt());
                jamie.add(input.nextInt());
                jamie.add(input.nextInt());
                result.append("CJ");

                boolean stopCameron, stopJamie;
                for (int j = 3; j <= activities; j++) {
                    stopCameron = stopJamie = false;
                    int start = input.nextInt();
                    int finish = input.nextInt();
                    
                    stopCameron = isConflict(cameron, start, finish);
                    if (!stopCameron) {
                        addActivity(cameron, start, finish, result, 'C');
                    } else {
                        stopJamie = isConflict(jamie, start, finish);
                        if (!stopJamie) {
                            addActivity(jamie, start, finish, result, 'J');
                        } else {
                            skipRemainingActivities(input, activities, j);
                            result = new StringBuilder("IMPOSSIBLE");
                            break;
                        }
                    }
                }
                
                System.out.println("Case #" + i + ": " + result);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static boolean isConflict(LinkedList<Integer> schedule, int start, int finish) {
        for (int k = 0; k < schedule.size(); k += 2) {
            int scheduledStart = schedule.get(k);
            int scheduledFinish = schedule.get(k + 1);
            if ((start > scheduledStart && start < scheduledFinish) || (finish > scheduledStart && finish < scheduledFinish)) {
                return true;
            }
        }
        return false;
    }

    private static void addActivity(LinkedList<Integer> schedule, int start, int finish, StringBuilder result, char person) {
        for (int k = 0; k < schedule.size(); k += 2) {
            int scheduledStart = schedule.get(k);
            int scheduledFinish = schedule.get(k + 1);
            if (finish == scheduledStart) {
                schedule.set(k, start);
                result.append(person);
                return;
            } else if (finish < scheduledStart) {
                schedule.add(k, finish);
                schedule.add(k, start);
                result.append(person);
                return;
            } else if (start == scheduledFinish) {
                schedule.set(k + 1, finish);
                result.append(person);
                return;
            } else if (k + 2 == schedule.size() && start > scheduledFinish) {
                schedule.addLast(start);
                schedule.addLast(finish);
                result.append(person);
                return;
            }
        }
    }

    private static void skipRemainingActivities(Scanner input, int activities, int currentActivity) {
        for (int j = currentActivity; j < activities; j++) {
            input.nextInt();
            input.nextInt();
        }
    }
}