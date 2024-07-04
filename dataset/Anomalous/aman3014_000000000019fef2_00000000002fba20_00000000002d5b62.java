import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();

            int absA = Math.abs(a);
            int absB = Math.abs(b);

            if (absA % 2 == absB % 2) {
                System.out.println("Case #" + testCase + ": IMPOSSIBLE");
                continue;
            }

            StringBuilder path = new StringBuilder();

            while (absA != 0 || absB != 0) {
                if (absA == 0 && absB % 2 == 1) {
                    path.append("N");
                } else if (absB == 0 && absA % 2 == 1) {
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

            System.out.println("Case #" + testCase + ": " + finalPath.toString());
        }
    }
}