import java.util.ArrayList;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            int cases = input.nextInt();
            
            for (int i = 1; i <= cases; i++) {
                int activities = input.nextInt();
                StringBuilder result = new StringBuilder();
                ArrayList<Integer> cameron = new ArrayList<>();
                ArrayList<Integer> jamie = new ArrayList<>();

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
                    
                    conflictCameron = checkConflictAndUpdate(cameron, start, finish, result, 'C');
                    if (conflictCameron) {
                        conflictJamie = checkConflictAndUpdate(jamie, start, finish, result, 'J');
                    }
                    
                    if (conflictCameron && conflictJamie) {
                        for (int k = j + 1; k <= activities; k++) {
                            input.nextInt();
                            input.nextInt();
                        }
                        result = new StringBuilder("IMPOSSIBLE");
                        break;
                    }
                }
                
                System.out.println("Case #" + i + ": " + result);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static boolean checkConflictAndUpdate(ArrayList<Integer> schedule, int start, int finish, StringBuilder result, char person) {
        for (int k = 0; k < schedule.size(); k += 2) {
            if ((start > schedule.get(k) && start < schedule.get(k + 1)) || (finish > schedule.get(k) && finish < schedule.get(k + 1))) {
                return true;
            } else if (finish == schedule.get(k)) {
                schedule.set(k, start);
                result.append(person);
                return false;
            } else if (finish < schedule.get(k)) {
                schedule.add(k, finish);
                schedule.add(k, start);
                result.append(person);
                return false;
            } else if (k + 2 == schedule.size() && start > schedule.get(k + 1)) {
                schedule.add(start);
                schedule.add(finish);
                result.append(person);
                return false;
            } else if (start == schedule.get(k + 1)) {
                schedule.set(k + 1, finish);
                result.append(person);
                return false;
            }
        }
        return true;
    }
}