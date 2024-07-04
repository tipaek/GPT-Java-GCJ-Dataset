import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        
        for (int i = 1; i <= t; i++) {
            int n = scanner.nextInt();
            int[] intervals = new int[n * 2];
            
            for (int j = 0; j < n * 2; j++) {
                intervals[j] = scanner.nextInt();
            }
            
            if ((intervals[0] == 0 && intervals[1] == 1440 && n > 2) || (n > 1 && intervals[2] > intervals[0] && intervals[3] < intervals[1])) {
                System.out.println("Case #" + i + ": IMPOSSIBLE");
                continue;
            }
            
            StringBuilder result = new StringBuilder();
            String firstPerson, secondPerson;
            
            if (n <= 3) {
                firstPerson = "C";
                secondPerson = "J";
                result.append("C");
            } else {
                firstPerson = "J";
                secondPerson = "C";
                result.append("J");
            }
            
            for (int k = 2; k < n * 2; k += 2) {
                if ((intervals[k] < intervals[k-1] && intervals[k] > intervals[k-2]) || (intervals[k+1] > intervals[k-2] && intervals[k+1] < intervals[k-1])) {
                    result.append(secondPerson);
                } else if ((intervals[k] < intervals[k-1] && intervals[k] < intervals[k-2]) || (intervals[k+1] < intervals[k-2] && intervals[k+1] > intervals[k-1])) {
                    result.append(result.charAt(result.length() - 1) == 'J' ? secondPerson : firstPerson);
                } else if (intervals[k] == intervals[k-1]) {
                    result.append(result.charAt(result.length() - 1));
                } else {
                    result.append(firstPerson);
                }
            }
            
            System.out.println("Case #" + i + ": " + result.toString());
        }
        
        scanner.close();
    }
}