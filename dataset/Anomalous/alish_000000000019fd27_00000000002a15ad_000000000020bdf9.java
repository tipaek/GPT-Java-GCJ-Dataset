import java.util.LinkedList;
import java.util.Scanner;

public class ParentingPartneringReturns {

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
                
                boolean stopCameron, stopJamie;
                for (int j = 3; j <= activities; j++) {
                    stopCameron = stopJamie = false;
                    int start = input.nextInt(), finish = input.nextInt();
                    stopCameron = checkAndUpdateList(cameron, start, finish, result, 'C');
                    
                    if (stopCameron) {
                        stopJamie = checkAndUpdateList(jamie, start, finish, result, 'J');
                    }
                    
                    if (stopCameron && stopJamie) {
                        result = new StringBuilder("IMPOSSIBLE");
                        break;
                    }
                }
                
                System.out.println("Case #" + i + ": " + result.toString());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static boolean checkAndUpdateList(LinkedList<Integer> list, int start, int finish, StringBuilder result, char person) {
        for (int k = 0; k < list.size(); k += 2) {
            if ((start > list.get(k) && start < list.get(k + 1)) || (finish > list.get(k) && finish < list.get(k + 1))) {
                return true;
            } else if (finish == list.get(k)) {
                list.set(k, start);
                result.append(person);
                return false;
            } else if (finish < list.get(k)) {
                list.add(k, finish);
                list.add(k, start);
                result.append(person);
                return false;
            } else if (start == list.get(k + 1)) {
                list.set(k + 1, finish);
                result.append(person);
                return false;
            } else if (k + 2 == list.size() && start > list.get(k + 1)) {
                list.addLast(start);
                list.addLast(finish);
                result.append(person);
                return false;
            }
        }
        return false;
    }
}