import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int numTest = sc.nextInt();
        
        for (int test = 0; test < numTest; ++test) {
            int numActivities = sc.nextInt();
            List<List<Integer>> jaimeList = new ArrayList<>();
            List<List<Integer>> cameronList = new ArrayList<>();
            List<Character> result = new ArrayList<>();
            
            boolean impossibleCombination = false;
            sc.nextLine();
            
            for (int i = 0; i < numActivities && !impossibleCombination; ++i) {
                String[] formatTask = sc.nextLine().split(" ");
                int start = Integer.parseInt(formatTask[0]);
                int finish = Integer.parseInt(formatTask[1]);
                
                if (canDoActivity(cameronList, start, finish)) {
                    cameronList.add(List.of(start, finish));
                    result.add('C');
                } else if (canDoActivity(jaimeList, start, finish)) {
                    jaimeList.add(List.of(start, finish));
                    result.add('J');
                } else {
                    impossibleCombination = true;
                }
            }
            
            System.out.print("Case #" + (test + 1) + ": ");
            if (impossibleCombination) {
                System.out.println("IMPOSSIBLE");
            } else {
                for (char c : result) {
                    System.out.print(c);
                }
                System.out.println();
            }
        }
    }
    
    public static boolean canDoActivity(List<List<Integer>> myList, int start, int finish) {
        for (List<Integer> task : myList) {
            if ((start >= task.get(0) && start < task.get(1)) || (finish > task.get(0) && finish <= task.get(1))) {
                return false;
            }
        }
        return true;
    }
}