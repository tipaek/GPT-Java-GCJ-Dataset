import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int n = scanner.nextInt();
            int[] intervals = new int[n * 2];
            for (int j = 0; j < n * 2; j++) {
                intervals[j] = scanner.nextInt();
            }

            String firstPerson = "";
            String secondPerson = "";
            StringBuilder schedule = new StringBuilder();

            if ((intervals[0] == 0 && intervals[1] == 1440 && n > 2) || (intervals[2] > intervals[0] && intervals[3] < intervals[1])) {
                System.out.println("Case #" + testCase + ": IMPOSSIBLE");
                continue;
            }

            if (n <= 3) {
                firstPerson = "C";
                secondPerson = "J";
                schedule.append("C");
            } else {
                firstPerson = "J";
                secondPerson = "C";
                schedule.append("J");
            }

            for (int k = 2; k < n * 2; k += 2) {
                if ((intervals[k] < intervals[k - 1] && intervals[k] > intervals[k - 2]) || (intervals[k + 1] > intervals[k - 2] && intervals[k + 1] < intervals[k - 2])) {
                    schedule.append(secondPerson);
                } else if ((intervals[k] < intervals[k - 1] && intervals[k] < intervals[k - 2]) || (intervals[k + 1] < intervals[k - 2] && intervals[k + 1] > intervals[k - 2])) {
                    if (schedule.charAt(schedule.length() - 1) == 'J') {
                        schedule.append(secondPerson);
                    } else {
                        schedule.append(firstPerson);
                    }
                } else if (intervals[k] == intervals[k - 1]) {
                    schedule.append(schedule.charAt(schedule.length() - 1));
                } else {
                    schedule.append(firstPerson);
                }
            }

            System.out.println("Case #" + testCase + ": " + schedule);
        }

        scanner.close();
    }
}