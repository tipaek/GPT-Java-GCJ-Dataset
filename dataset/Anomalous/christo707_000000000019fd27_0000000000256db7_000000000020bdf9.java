import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        
        for (int i = 1; i <= t; i++) {
            int n = scanner.nextInt();
            int[] arrC = new int[24 * 60 + 1];
            int[] arrJ = new int[24 * 60 + 1];
            boolean possible = true;
            StringBuilder schedule = new StringBuilder();

            for (int k = 0; k < n; k++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                boolean availableForC = true;
                boolean availableForJ = true;

                for (int time = start + 1; time <= end; time++) {
                    if (arrC[time] == 1) {
                        availableForC = false;
                        break;
                    }
                }

                if (availableForC) {
                    for (int time = start; time <= end; time++) {
                        arrC[time] = 1;
                    }
                    schedule.append("C");
                } else {
                    for (int time = start + 1; time <= end; time++) {
                        if (arrJ[time] == 1) {
                            availableForJ = false;
                            break;
                        }
                    }

                    if (availableForJ) {
                        for (int time = start; time <= end; time++) {
                            arrJ[time] = 1;
                        }
                        schedule.append("J");
                    } else {
                        possible = false;
                        break;
                    }
                }
            }

            if (possible) {
                System.out.println("Case #" + i + ": " + schedule.toString());
            } else {
                System.out.println("Case #" + i + ": IMPOSSIBLE");
            }
        }
    }
}