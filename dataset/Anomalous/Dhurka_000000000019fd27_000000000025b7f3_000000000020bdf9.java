import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        int caseNumber = 1;
        
        while (t-- > 0) {
            int n = scanner.nextInt();
            int[] arrival = new int[n];
            int[] departure = new int[n];
            
            for (int i = 0; i < n; i++) {
                arrival[i] = scanner.nextInt();
                departure[i] = scanner.nextInt();
            }
            
            int[] jTime = new int[2]; // jTime[0] for arrival, jTime[1] for departure
            int[] cTime = new int[2]; // cTime[0] for arrival, cTime[1] for departure
            StringBuilder result = new StringBuilder();
            
            for (int i = 0; i < n; i++) {
                if (arrival[i] >= jTime[1]) {
                    jTime[1] = departure[i];
                    result.append("J");
                    jTime[0] = arrival[i];
                } else if (arrival[i] >= cTime[1]) {
                    cTime[1] = departure[i];
                    result.append("C");
                    cTime[0] = arrival[i];
                } else if (departure[i] <= jTime[0]) {
                    result.append("J");
                    jTime[0] = arrival[i];
                    jTime[1] = departure[i];
                } else if (departure[i] <= cTime[0]) {
                    result.append("C");
                    cTime[0] = arrival[i];
                    cTime[1] = departure[i];
                } else {
                    result = new StringBuilder("IMPOSSIBLE");
                    break;
                }
            }
            
            System.out.println("Case #" + caseNumber + ": " + result);
            caseNumber++;
        }
        
        scanner.close();
    }
}