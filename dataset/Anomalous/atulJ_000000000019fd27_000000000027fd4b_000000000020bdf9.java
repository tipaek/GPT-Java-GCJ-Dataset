import java.util.Scanner;

class NewsScheduler {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();
        for (int x = 0; x < t; x++) {
            int n = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            int[][] tasks = new int[n][2];
            for (int i = 0; i < n; i++) {
                String[] parts = scanner.nextLine().split(" ");
                tasks[i][0] = Integer.parseInt(parts[0]);
                tasks[i][1] = Integer.parseInt(parts[1]);
            }

            StringBuilder schedule = new StringBuilder("C");
            int lastC = 0, lastJ = -1;
            boolean possible = true;

            for (int i = 1; i < n; i++) {
                if (tasks[i][0] >= tasks[lastC][1]) {
                    schedule.append("C");
                    lastC = i;
                } else if (lastJ == -1 || tasks[i][0] >= tasks[lastJ][1]) {
                    schedule.append("J");
                    lastJ = i;
                } else {
                    System.out.println("Case #" + (x + 1) + ": IMPOSSIBLE");
                    possible = false;
                    break;
                }
            }

            if (possible) {
                System.out.println("Case #" + (x + 1) + ": " + schedule.toString());
            }
        }

        scanner.close();
    }
}