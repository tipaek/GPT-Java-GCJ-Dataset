import java.util.Scanner;

class Solution {
    
    private static String getSol(Scanner scanner) {
        int n = scanner.nextInt();
        scanner.nextLine();
        char[] assignments = new char[n];
        boolean[] jBusy = new boolean[24 * 60];
        boolean[] cBusy = new boolean[24 * 60];
        int start;
        int end;
        boolean worksForJ;
        boolean worksForC;
        for (int i = 0; i < n; i++) {
            start = scanner.nextInt();
            end = scanner.nextInt();
            scanner.nextLine();
            worksForJ = true;
            worksForC = true;
            for (int time = start; time < end; time++) {
                if (jBusy[time]) {
                    worksForJ = false;
                    break;
                }
            }
            for (int time = start; time < end; time++) {
                if (cBusy[time]) {
                    worksForC = false;
                    break;
                }
            }
            if (!worksForJ && !worksForC) {
                return "IMPOSSIBLE";
            }
            if (worksForJ) {
                assignments[i] = 'J';
                for (int time = start; time < end; time++) {
                    jBusy[time] = true;
                }
            } else {
                assignments[i] = 'C';
                for (int time = start; time < end; time++) {
                    cBusy[time] = true;
                }
            }
        }
        return new String(assignments);
    }
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int t = scanner.nextInt();
    scanner.nextLine();
    for (int c = 1; c <= t; c++) {
        System.out.println("Case " + c + ": " + getSol(scanner));
    }
  }
}