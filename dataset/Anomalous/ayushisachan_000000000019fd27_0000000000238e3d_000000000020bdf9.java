import java.util.Scanner;

class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int testCases = scanner.nextInt();
        for (int t = 0; t < testCases; t++) {
            int N = scanner.nextInt();
            int numEvents = N * 2;
            int[] events = new int[numEvents];

            for (int i = 0; i < numEvents; i++) {
                events[i] = scanner.nextInt();
            }

            StringBuilder result = new StringBuilder("C");
            String currentPerson = "C";
            int currentC = 0, currentJ = 0;
            boolean isImpossible = false;

            for (int i = 0; i < N * 2; i += 2) {
                if (currentPerson.equals("C")) {
                    if (events[i + 1] >= events[i + 2]) {
                        if (currentJ <= events[i + 2]) {
                            currentC = events[i + 1];
                            currentPerson = "J";
                            result.append(currentPerson);
                            currentJ = events[i + 3];
                        } else {
                            isImpossible = true;
                            break;
                        }
                    } else {
                        currentPerson = "C";
                        currentC = events[i + 3];
                        result.append(currentPerson);
                    }
                } else if (currentPerson.equals("J")) {
                    if (currentC <= events[i + 2]) {
                        currentPerson = "C";
                        currentC = events[i + 3];
                        currentJ = events[i + 1];
                        result.append(currentPerson);
                    } else if (currentJ <= events[i + 2]) {
                        currentPerson = "J";
                        currentJ = events[i + 3];
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