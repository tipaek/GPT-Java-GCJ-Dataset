import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int T = scanner.nextInt();
        for (int t = 0; t < T; t++) {
            int N = scanner.nextInt();
            int[] intervals = new int[N * 2];

            for (int i = 0; i < N * 2; i++) {
                intervals[i] = scanner.nextInt();
            }

            StringBuilder result = new StringBuilder("C");
            String current = "C";
            int currentC = 0, currentJ = 0;
            boolean impossible = false;

            for (int i = 0; i < N * 2; i += 2) {
                if (current.equals("C")) {
                    if (intervals[i + 1] >= intervals[i + 2]) {
                        if (currentJ <= intervals[i + 2]) {
                            currentC = intervals[i + 1];
                            current = "J";
                            result.append(current);
                            currentJ = intervals[i + 3];
                        } else {
                            impossible = true;
                            break;
                        }
                    } else {
                        current = "C";
                        currentC = intervals[i + 3];
                        result.append(current);
                    }
                } else if (current.equals("J")) {
                    if (currentC <= intervals[i + 2]) {
                        current = "C";
                        currentC = intervals[i + 3];
                        currentJ = intervals[i + 1];
                        result.append(current);
                    } else if (currentJ <= intervals[i + 2]) {
                        current = "J";
                        currentJ = intervals[i + 3];
                        result.append(current);
                    } else {
                        impossible = true;
                        break;
                    }
                }
            }

            if (impossible) {
                System.out.println("IMPOSSIBLE");
            } else {
                System.out.println(result.toString());
            }
        }

        scanner.close();
    }
}