import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int cases = input.nextInt();

        for (int i = 1; i <= cases; i++) {
            int activities = input.nextInt();
            StringBuilder result = new StringBuilder();
            List<int[]> cameron = new ArrayList<>();
            List<int[]> jamie = new ArrayList<>();
            
            cameron.add(new int[]{input.nextInt(), input.nextInt()});
            jamie.add(new int[]{input.nextInt(), input.nextInt()});
            result.append("CJ");
            
            boolean isImpossible = false;

            for (int j = 3; j <= activities; j++) {
                int start = input.nextInt();
                int finish = input.nextInt();
                
                if (!addActivity(cameron, start, finish)) {
                    if (!addActivity(jamie, start, finish)) {
                        result = new StringBuilder("IMPOSSIBLE");
                        isImpossible = true;
                        break;
                    } else {
                        result.append("J");
                    }
                } else {
                    result.append("C");
                }
            }
            
            if (!isImpossible) {
                System.out.println("Case #" + i + ": " + result.toString());
            } else {
                System.out.println("Case #" + i + ": IMPOSSIBLE");
            }
        }
        input.close();
    }

    private static boolean addActivity(List<int[]> schedule, int start, int finish) {
        for (int[] interval : schedule) {
            if (start < interval[1] && finish > interval[0]) {
                return false;
            }
        }
        schedule.add(new int[]{start, finish});
        return true;
    }
}