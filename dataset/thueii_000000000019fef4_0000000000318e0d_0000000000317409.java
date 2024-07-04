import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int nCases = scanner.nextInt();
        for (int caseNo = 1; caseNo <= nCases; ++caseNo) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            String sequence = scanner.nextLine().trim();
            int length = sequence.length();
            boolean found = false;
            int solution = -1;
            for (int i = 0; i < length; ++i) {
                switch (sequence.charAt(i)) {
                    case 'E':
                        ++x;
                        break;
                    case 'S':
                        --y;
                        break;
                    case 'W':
                        --x;
                        break;
                    case 'N':
                        ++y;
                        break;
                    default:
                }
//                System.err.println(String.format("%d %d", x, y));
                if (Math.abs(x) + Math.abs(y) <= i + 1) {
                    found = true;
                    solution = i + 1;
                    break;
                }
            }
            if (found) {
                System.out.println(String.format("Case #%d: %d", caseNo, solution));
            } else {
                System.out.println(String.format("Case #%d: IMPOSSIBLE", caseNo));
            }
        }
    }

}
