import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        int caseNumber = 1;

        while (caseNumber <= testCases) {
            int n = sc.nextInt();
            int jStart = Integer.MAX_VALUE, jEnd = Integer.MAX_VALUE;
            int cStart = Integer.MAX_VALUE, cEnd = Integer.MAX_VALUE;
            StringBuilder ans = new StringBuilder();

            boolean possible = true;

            for (int i = 0; i < n; i++) {
                int start = sc.nextInt();
                int end = sc.nextInt();

                if (start >= jEnd || end <= jStart) {
                    jStart = start;
                    jEnd = end;
                    ans.append("J");
                } else if (start >= cEnd || end <= cStart) {
                    cStart = start;
                    cEnd = end;
                    ans.append("C");
                } else {
                    ans = new StringBuilder("IMPOSSIBLE");
                    possible = false;
                    break;
                }
            }

            if (possible) {
                System.out.println("Case #" + caseNumber + ": " + ans.toString());
            } else {
                System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
            }

            caseNumber++;
        }
        
        sc.close();
    }
}