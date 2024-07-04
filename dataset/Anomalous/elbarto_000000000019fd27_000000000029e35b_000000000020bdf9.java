import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long cases = scanner.nextLong();

        for (long index = 1; index <= cases; index++) {
            boolean[] cameron = new boolean[24 * 60 + 3];
            boolean[] jamie = new boolean[24 * 60 + 3];
            int activities = scanner.nextInt();

            boolean isPossible = true;
            StringBuilder schedule = new StringBuilder();

            for (int a = 0; a < activities; a++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                start += 2;
                end++;

                boolean canAssignToCameron = true;
                for (int i = start; i <= end; i++) {
                    if (cameron[i]) {
                        canAssignToCameron = false;
                        break;
                    }
                }

                if (canAssignToCameron) {
                    schedule.append("C");
                    for (int i = start; i <= end; i++) {
                        cameron[i] = true;
                    }
                } else {
                    boolean canAssignToJamie = true;
                    for (int i = start; i <= end; i++) {
                        if (jamie[i]) {
                            canAssignToJamie = false;
                            break;
                        }
                    }

                    if (canAssignToJamie) {
                        schedule.append("J");
                        for (int i = start; i <= end; i++) {
                            jamie[i] = true;
                        }
                    } else {
                        isPossible = false;
                        break;
                    }
                }
            }

            if (isPossible) {
                System.out.printf("Case #%d: %s%n", index, schedule.toString());
            } else {
                System.out.printf("Case #%d: IMPOSSIBLE%n", index);
            }
        }
    }
}