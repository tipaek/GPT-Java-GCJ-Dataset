import java.util.Scanner;

public class Solution {

    private static final String NEW_LINE = System.getProperty("line.separator");

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int n = scanner.nextInt();
            StringBuilder result = new StringBuilder();

            switch (n) {
                case 1:
                    result.append("1 1");
                    break;
                case 2:
                    result.append("1 1").append(NEW_LINE).append("2 1");
                    break;
                case 3:
                    result.append("1 1").append(NEW_LINE).append("2 1").append(NEW_LINE).append("2 2");
                    break;
                case 4:
                    result.append("1 1").append(NEW_LINE).append("2 1").append(NEW_LINE).append("3 2");
                    break;
                default:
                    boolean hasLine = false;
                    boolean isLeft = true;
                    for (int i = 20; i >= 0; i--) {
                        int lineSum = (int) Math.pow(2, i);
                        if (lineSum + i - 1 <= n) {
                            if (lineSum + i <= n) {
                                appendFullLine(result, i + 1, isLeft);
                                n -= lineSum;
                            } else {
                                appendPartialLine(result, i + 1, isLeft);
                                n -= lineSum;
                                n++;
                            }
                            hasLine = true;
                            isLeft = !isLeft;
                        } else if (hasLine) {
                            result.append(NEW_LINE).append(i + 1).append(" ").append(isLeft ? 1 : (i + 1));
                            n--;
                        }
                    }
                    break;
            }

            System.out.println("Case #" + testCase + ":");
            System.out.println(result.toString());
        }
    }

    private static void appendFullLine(StringBuilder result, int k, boolean isLeft) {
        if (isLeft) {
            for (int i = 1; i <= k; i++) {
                result.append(NEW_LINE).append(k).append(" ").append(i);
            }
        } else {
            for (int i = k; i >= 1; i--) {
                result.append(NEW_LINE).append(k).append(" ").append(i);
            }
        }
    }

    private static void appendPartialLine(StringBuilder result, int k, boolean isLeft) {
        if (isLeft) {
            for (int i = 1; i < k; i++) {
                result.append(NEW_LINE).append(k).append(" ").append(i);
            }
        } else {
            for (int i = k; i >= 2; i--) {
                result.append(NEW_LINE).append(k).append(" ").append(i);
            }
        }
    }
}