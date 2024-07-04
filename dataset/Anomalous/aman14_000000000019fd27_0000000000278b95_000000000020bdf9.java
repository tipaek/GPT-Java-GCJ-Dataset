import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int caseNumber = 1;

        while (t-- > 0) {
            int n = sc.nextInt();
            int[][] intervals = new int[n][2];
            char[] assignments = new char[n];
            String result = "";

            for (int i = 0; i < n; i++) {
                intervals[i][0] = sc.nextInt();
                intervals[i][1] = sc.nextInt();
            }

            assignments[0] = 'C';
            result += 'C';

            for (int i = 1; i < n; i++) {
                boolean conflict = false;
                char currentChar = 'J';
                char previousChar = 'J';

                for (int j = 0; j < i; j++) {
                    if ((intervals[i][0] < intervals[j][1] && intervals[i][1] > intervals[j][0])) {
                        conflict = true;
                        currentChar = result.charAt(j);
                        if (currentChar == previousChar) {
                            conflict = false;
                            break;
                        }
                        previousChar = currentChar;
                    }
                }

                if (conflict) {
                    if (currentChar == 'J') {
                        result += 'C';
                    } else {
                        result += 'J';
                    }
                } else {
                    result += 'C';
                }
            }

            if (result.chars().filter(ch -> ch == 'I').count() > 0) {
                result = "IMPOSSIBLE";
            }

            System.out.println("Case #" + caseNumber + ": " + result);
            caseNumber++;
        }

        sc.close();
    }
}