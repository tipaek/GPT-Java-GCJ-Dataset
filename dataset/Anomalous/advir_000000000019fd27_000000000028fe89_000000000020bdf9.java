import java.util.Scanner;

class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        for (int i = 0; i < t; i++) {
            int m = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            int[][] q = new int[m][2];

            for (int j = 0; j < m; j++) {
                String[] qItems = scanner.nextLine().split(" ");
                q[j][0] = Integer.parseInt(qItems[0]);
                q[j][1] = Integer.parseInt(qItems[1]);
            }

            int[] jamie = new int[1440];
            int[] cameron = new int[1440];
            String[] sch = new String[m];
            boolean isImpossible = false;

            // Sort the tasks by start time
            Arrays.sort(q, Comparator.comparingInt(a -> a[0]));

            for (int j = 0; j < m; j++) {
                int start = q[j][0];
                int stop = q[j][1];
                boolean jbusy = false;
                boolean cbusy = false;

                // Check if Jamie is available
                for (int sec = start; sec < stop; sec++) {
                    if (jamie[sec] != 0) {
                        jbusy = true;
                        break;
                    }
                }

                if (!jbusy) {
                    // Assign to Jamie
                    Arrays.fill(jamie, start, stop, 1);
                    sch[j] = "C";
                } else {
                    // Check if Cameron is available
                    for (int sec = start; sec < stop; sec++) {
                        if (cameron[sec] != 0) {
                            cbusy = true;
                            break;
                        }
                    }

                    if (!cbusy) {
                        // Assign to Cameron
                        Arrays.fill(cameron, start, stop, 1);
                        sch[j] = "J";
                    } else {
                        isImpossible = true;
                        break;
                    }
                }
            }

            System.out.print("Case #" + (i + 1) + ": ");
            if (isImpossible) {
                System.out.println("IMPOSSIBLE");
            } else {
                for (String s : sch) {
                    System.out.print(s);
                }
                System.out.println();
            }
        }
        scanner.close();
    }
}