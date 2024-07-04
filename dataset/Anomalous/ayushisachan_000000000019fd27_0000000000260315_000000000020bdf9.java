import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int T = scanner.nextInt();
        for (int j = 0; j < T; j++) {
            int N = scanner.nextInt();
            int noe = N * 2;
            int[] activities = new int[noe];

            for (int i = 0; i < noe; i++) {
                activities[i] = scanner.nextInt();
            }

            StringBuilder result = new StringBuilder("C");
            String currentPerson = "C";
            int currentC = 0, currentJ = 0;
            boolean isImpossible = false;

            for (int i = 0; i < N * 2; i += 2) {
                if (currentPerson.equals("C")) {
                    if (activities[i + 1] >= activities[i + 2]) {
                        if (currentJ <= activities[i + 2]) {
                            currentC = activities[i + 1];
                            currentPerson = "J";
                            result.append(currentPerson);
                            currentJ = activities[i + 3];
                        } else {
                            isImpossible = true;
                            break;
                        }
                    } else {
                        currentPerson = "C";
                        currentC = activities[i + 3];
                        result.append(currentPerson);
                    }
                } else if (currentPerson.equals("J")) {
                    if (currentC <= activities[i + 2]) {
                        currentPerson = "C";
                        currentC = activities[i + 3];
                        currentJ = activities[i + 1];
                        result.append(currentPerson);
                    } else if (currentJ <= activities[i + 2]) {
                        currentPerson = "J";
                        currentJ = activities[i + 3];
                        result.append(currentPerson);
                    } else {
                        isImpossible = true;
                        break;
                    }
                }
            }

            if (isImpossible) {
                System.out.println("IMPOSSIBLE");
            } else {
                System.out.println(result.toString());
            }
        }

        scanner.close();
    }
}