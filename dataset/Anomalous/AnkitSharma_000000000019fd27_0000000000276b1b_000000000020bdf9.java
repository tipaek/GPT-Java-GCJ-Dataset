import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int intervals = scanner.nextInt();
            StringBuilder schedule = new StringBuilder();
            boolean[] cOccupied = new boolean[1441];
            boolean[] jOccupied = new boolean[1441];
            boolean isPossible = true;
            
            for (int i = 0; i < intervals; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                boolean cAvailable = true;
                boolean jAvailable = true;
                
                for (int time = start; time < end; time++) {
                    if (cOccupied[time]) {
                        cAvailable = false;
                        break;
                    }
                }
                
                if (cAvailable) {
                    for (int time = start; time < end; time++) {
                        cOccupied[time] = true;
                    }
                    schedule.append("C");
                } else {
                    for (int time = start; time < end; time++) {
                        if (jOccupied[time]) {
                            jAvailable = false;
                            break;
                        }
                    }
                    if (jAvailable) {
                        for (int time = start; time < end; time++) {
                            jOccupied[time] = true;
                        }
                        schedule.append("J");
                    } else {
                        isPossible = false;
                        break;
                    }
                }
            }
            
            if (!isPossible) {
                schedule = new StringBuilder("IMPOSSIBLE");
            }
            
            System.out.println("Case #" + caseNumber + ": " + schedule);
        }
        
        scanner.close();
    }
}