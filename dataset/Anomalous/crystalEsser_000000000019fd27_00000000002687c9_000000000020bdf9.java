import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = Integer.parseInt(scanner.nextLine());
        
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(scanner.nextLine());
            int[][] activities = new int[N][3];
            String[] assignedPersons = new String[N];
            
            for (int j = 0; j < N; j++) {
                String[] input = scanner.nextLine().split(" ");
                activities[j][0] = Integer.parseInt(input[0]);
                activities[j][1] = Integer.parseInt(input[1]);
                activities[j][2] = j;
            }
            
            Arrays.sort(activities, Comparator.comparingInt(activity -> activity[0]));
            
            boolean isImpossible = false;
            int endC = activities[0][1];
            int endJ = -1;
            assignedPersons[0] = "C";
            
            for (int j = 1; j < N; j++) {
                if (activities[j][0] >= endC) {
                    assignedPersons[j] = "C";
                    endC = activities[j][1];
                } else if (activities[j][0] >= endJ) {
                    assignedPersons[j] = "J";
                    endJ = activities[j][1];
                } else {
                    isImpossible = true;
                    break;
                }
            }
            
            if (isImpossible) {
                System.out.println("Case #" + (i + 1) + ": IMPOSSIBLE");
            } else {
                String[] result = new String[N];
                for (int j = 0; j < N; j++) {
                    result[activities[j][2]] = assignedPersons[j];
                }
                System.out.print("Case #" + (i + 1) + ": ");
                for (String person : result) {
                    System.out.print(person);
                }
                System.out.println();
            }
        }
    }
}