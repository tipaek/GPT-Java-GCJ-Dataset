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
            String currentPerson = "C";
            int currentCameronEnd = 0, currentJamieEnd = 0;
            boolean isImpossible = false;

            for (int i = 0; i < N * 2; i += 2) {
                int start = intervals[i];
                int end = intervals[i + 1];

                if (currentPerson.equals("C")) {
                    if (i + 2 < N * 2 && end >= intervals[i + 2]) {
                        if (currentJamieEnd <= intervals[i + 2]) {
                            currentCameronEnd = end;
                            currentPerson = "J";
                            result.append(currentPerson);
                            currentJamieEnd = intervals[i + 3];
                        } else {
                            isImpossible = true;
                            break;
                        }
                    } else {
                        currentPerson = "C";
                        currentCameronEnd = intervals[i + 3];
                        result.append(currentPerson);
                    }
                } else if (currentPerson.equals("J")) {
                    if (currentCameronEnd <= intervals[i + 2]) {
                        currentPerson = "C";
                        currentCameronEnd = intervals[i + 3];
                        currentJamieEnd = end;
                        result.append(currentPerson);
                    } else if (currentJamieEnd <= intervals[i + 2]) {
                        currentPerson = "J";
                        currentJamieEnd = intervals[i + 3];
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