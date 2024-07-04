import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        long testCases = scanner.nextLong();

        for (long caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            long a = scanner.nextLong();
            long b = scanner.nextLong();

            long absA = Math.abs(a);
            long absB = Math.abs(b);

            if ((absA % 2) == (absB % 2)) {
                System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
                continue;
            }

            StringBuilder path = new StringBuilder();

            while (absA != 0 || absB != 0) {
                if (absA == 0 && absB == 1) {
                    path.append("N");
                } else if (absB == 0 && absA == 1) {
                    path.append("E");
                } else {
                    if ((absA & 2) != (absB & 2)) {
                        if (absA % 2 == 1) {
                            path.append("E");
                        } else {
                            path.append("N");
                        }
                    } else {
                        if (absA % 2 == 1) {
                            path.append("W");
                            absA += 1;
                        } else {
                            path.append("S");
                            absB += 1;
                        }
                    }
                }

                absA >>= 1;
                absB >>= 1;
            }

            StringBuilder finalPath = new StringBuilder();

            for (char direction : path.toString().toCharArray()) {
                switch (direction) {
                    case 'E':
                        finalPath.append(a < 0 ? 'W' : 'E');
                        break;
                    case 'W':
                        finalPath.append(a < 0 ? 'E' : 'W');
                        break;
                    case 'N':
                        finalPath.append(b < 0 ? 'S' : 'N');
                        break;
                    case 'S':
                        finalPath.append(b < 0 ? 'N' : 'S');
                        break;
                }
            }

            System.out.println("Case #" + caseNumber + ": " + finalPath);
        }
    }
}