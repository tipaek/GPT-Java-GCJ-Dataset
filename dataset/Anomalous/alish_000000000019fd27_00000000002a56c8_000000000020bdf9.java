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
                
                cameron.add(input.nextInt());
                cameron.add(input.nextInt());
                jamie.add(input.nextInt());
                jamie.add(input.nextInt());
                result.append("CJ");
                
                boolean conflictCameron, conflictJamie;
                for (int j = 3; j <= activities; j++) {
                    conflictCameron = conflictJamie = false;
                    int start = input.nextInt();
                    int finish = input.nextInt();
                    
                    conflictCameron = checkAndUpdateSchedule(cameron, start, finish, 'C', result);
                    
                    if (conflictCameron) {
                        conflictJamie = checkAndUpdateSchedule(jamie, start, finish, 'J', result);
                    }

                    if (conflictCameron && conflictJamie) {
                        skipRemainingActivities(input, activities, j);
                        result.setLength(0);
                        result.append("Case #").append(i).append(": IMPOSSIBLE");
                        break;
                    }
                }
                
                if (result.length() > 0 && !result.toString().contains("IMPOSSIBLE")) {
                    System.out.println("Case #" + i + ": " + result);
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    private static boolean checkAndUpdateSchedule(LinkedList<Integer> schedule, int start, int finish, char person, StringBuilder result) {
        for (int k = 0; k < schedule.size(); k += 2) {
            if ((start > schedule.get(k) && start < schedule.get(k + 1)) || (finish > schedule.get(k) && finish < schedule.get(k + 1))) {
                return true;
            } else if (finish == schedule.get(k)) {
                schedule.set(k, start);
                result.append(person);
                return false;
            } else if (finish < schedule.get(k)) {
                schedule.add(k, start);
                schedule.add(k + 1, finish);
                result.append(person);
                return false;
            } else if (start == schedule.get(k + 1)) {
                schedule.set(k + 1, finish);
                result.append(person);
                return false;
            } else if (k + 2 == schedule.size() && start > schedule.get(k + 1)) {
                schedule.addLast(start);
                schedule.addLast(finish);
                result.append(person);
                return false;
            }
        }
        return false;
    }

    private static void skipRemainingActivities(Scanner input, int totalActivities, int currentActivity) {
        for (int j = currentActivity; j <= totalActivities; j++) {
            input.nextInt();
            input.nextInt();
        }
    }
}