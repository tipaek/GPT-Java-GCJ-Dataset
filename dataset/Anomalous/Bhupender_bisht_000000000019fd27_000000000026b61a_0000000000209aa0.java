import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        int caseNumber = 1;

        while (t-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            sb.append("Case #").append(caseNumber).append(": ");

            if (n == 5) {
                handleCaseForN5(k, sb);
            } else if (n == 4) {
                handleCaseForN4(k, sb);
            } else if (n == 3) {
                handleCaseForN3(k, sb);
            } else if (n == 2) {
                handleCaseForN2(k, sb);
            }

            caseNumber++;
        }

        System.out.print(sb.toString());
        sc.close();
    }

    private static void handleCaseForN5(int k, StringBuilder sb) {
        switch (k) {
            case 6:
            case 24:
                sb.append("IMPOSSIBLE\n");
                break;
            case 5:
                printMatrix(sb, new int[][]{
                    {1, 4, 5, 3, 2}, {2, 1, 3, 4, 5}, {3, 5, 1, 2, 4},
                    {5, 2, 4, 1, 3}, {4, 3, 2, 5, 1}
                });
                break;
            case 7:
                printMatrix(sb, new int[][]{
                    {1, 2, 4, 5, 3}, {5, 1, 2, 3, 4}, {2, 3, 1, 4, 5},
                    {3, 4, 5, 2, 1}, {4, 5, 3, 1, 2}
                });
                break;
            case 8:
                printMatrix(sb, new int[][]{
                    {1, 2, 4, 3, 5}, {3, 1, 2, 5, 4}, {5, 3, 1, 4, 2},
                    {4, 5, 3, 2, 1}, {2, 4, 5, 1, 3}
                });
                break;
            case 9:
                printMatrix(sb, new int[][]{
                    {1, 2, 4, 3, 5}, {4, 3, 5, 1, 2}, {5, 1, 2, 4, 3},
                    {3, 5, 1, 2, 4}, {2, 4, 3, 5, 1}
                });
                break;
            case 10:
                printMatrix(sb, new int[][]{
                    {1, 4, 3, 5, 2}, {5, 3, 2, 4, 1}, {4, 2, 1, 3, 5},
                    {3, 1, 5, 2, 4}, {2, 5, 4, 1, 3}
                });
                break;
            case 11:
                printMatrix(sb, new int[][]{
                    {2, 3, 4, 5, 1}, {1, 5, 3, 2, 4}, {3, 2, 1, 4, 5},
                    {5, 4, 2, 1, 3}, {4, 1, 5, 3, 2}
                });
                break;
            case 12:
                printMatrix(sb, new int[][]{
                    {1, 5, 4, 3, 2}, {2, 3, 1, 4, 5}, {4, 2, 3, 5, 1},
                    {5, 4, 2, 1, 3}, {3, 1, 5, 2, 4}
                });
                break;
            case 13:
                printMatrix(sb, new int[][]{
                    {3, 2, 5, 4, 1}, {1, 5, 3, 2, 4}, {5, 4, 1, 3, 2},
                    {2, 3, 4, 1, 5}, {4, 1, 2, 5, 3}
                });
                break;
            case 14:
                printMatrix(sb, new int[][]{
                    {3, 4, 2, 1, 5}, {2, 1, 3, 5, 4}, {5, 3, 4, 2, 1},
                    {1, 2, 5, 4, 3}, {4, 5, 1, 3, 2}
                });
                break;
            case 15:
                printMatrix(sb, new int[][]{
                    {5, 4, 1, 2, 3}, {3, 1, 2, 4, 5}, {2, 5, 4, 3, 1},
                    {4, 3, 5, 1, 2}, {1, 2, 3, 5, 4}
                });
                break;
            case 16:
                printMatrix(sb, new int[][]{
                    {1, 3, 5, 4, 2}, {5, 4, 1, 2, 3}, {2, 1, 3, 5, 4},
                    {4, 5, 2, 3, 1}, {3, 2, 4, 1, 5}
                });
                break;
            case 17:
                printMatrix(sb, new int[][]{
                    {4, 5, 3, 2, 1}, {3, 1, 5, 4, 2}, {5, 3, 2, 1, 4},
                    {2, 4, 1, 5, 3}, {1, 2, 4, 3, 5}
                });
                break;
            case 18:
                printMatrix(sb, new int[][]{
                    {4, 3, 2, 1, 5}, {5, 1, 4, 2, 3}, {2, 4, 5, 3, 1},
                    {1, 5, 3, 4, 2}, {3, 2, 1, 5, 4}
                });
                break;
            case 19:
                printMatrix(sb, new int[][]{
                    {3, 2, 4, 1, 5}, {1, 5, 3, 2, 4}, {2, 3, 5, 4, 1},
                    {5, 4, 1, 3, 2}, {4, 1, 2, 5, 3}
                });
                break;
            case 20:
                printMatrix(sb, new int[][]{
                    {3, 4, 1, 5, 2}, {4, 5, 2, 1, 3}, {5, 3, 4, 2, 1},
                    {1, 2, 3, 4, 5}, {2, 1, 5, 3, 4}
                });
                break;
            case 21:
                printMatrix(sb, new int[][]{
                    {4, 5, 3, 1, 2}, {1, 4, 2, 3, 5}, {2, 3, 5, 4, 1},
                    {3, 2, 1, 5, 4}, {5, 1, 4, 2, 3}
                });
                break;
            case 22:
                printMatrix(sb, new int[][]{
                    {5, 4, 3, 2, 1}, {4, 5, 2, 1, 3}, {1, 2, 4, 3, 5},
                    {3, 1, 5, 4, 2}, {2, 3, 1, 5, 4}
                });
                break;
            case 23:
                printMatrix(sb, new int[][]{
                    {4, 3, 1, 2, 5}, {1, 5, 2, 4, 3}, {2, 4, 5, 3, 1},
                    {3, 1, 4, 5, 2}, {5, 2, 3, 1, 4}
                });
                break;
            case 25:
                printMatrix(sb, new int[][]{
                    {5, 1, 2, 3, 4}, {4, 5, 1, 2, 3}, {3, 4, 5, 1, 2},
                    {2, 3, 4, 5, 1}, {1, 2, 3, 4, 5}
                });
                break;
            default:
                sb.append("IMPOSSIBLE\n");
                break;
        }
    }

    private static void handleCaseForN4(int k, StringBuilder sb) {
        switch (k) {
            case 5:
            case 15:
                sb.append("IMPOSSIBLE\n");
                break;
            case 4:
                printMatrix(sb, new int[][]{
                    {1, 2, 3, 4}, {4, 1, 2, 3}, {3, 4, 1, 2}, {2, 3, 4, 1}
                });
                break;
            case 6:
                printMatrix(sb, new int[][]{
                    {1, 3, 2, 4}, {3, 2, 4, 1}, {2, 4, 1, 3}, {4, 1, 3, 2}
                });
                break;
            case 7:
                printMatrix(sb, new int[][]{
                    {1, 4, 2, 3}, {3, 2, 1, 4}, {4, 1, 3, 2}, {2, 3, 4, 1}
                });
                break;
            case 8:
                printMatrix(sb, new int[][]{
                    {2, 3, 4, 1}, {1, 2, 3, 4}, {4, 1, 2, 3}, {3, 4, 1, 2}
                });
                break;
            case 9:
                printMatrix(sb, new int[][]{
                    {4, 2, 3, 1}, {3, 1, 4, 2}, {2, 3, 1, 4}, {1, 4, 2, 3}
                });
                break;
            case 10:
                printMatrix(sb, new int[][]{
                    {1, 2, 3, 4}, {2, 4, 1, 3}, {3, 1, 4, 2}, {4, 3, 2, 1}
                });
                break;
            case 11:
                printMatrix(sb, new int[][]{
                    {4, 2, 1, 3}, {3, 1, 2, 4}, {2, 3, 4, 1}, {1, 4, 3, 2}
                });
                break;
            case 12:
                printMatrix(sb, new int[][]{
                    {3, 4, 1, 2}, {2, 3, 4, 1}, {1, 2, 3, 4}, {4, 1, 2, 3}
                });
                break;
            case 13:
                printMatrix(sb, new int[][]{
                    {4, 2, 1, 3}, {1, 3, 4, 2}, {3, 4, 2, 1}, {2, 1, 3, 4}
                });
                break;
            case 14:
                printMatrix(sb, new int[][]{
                    {3, 1, 4, 2}, {1, 4, 2, 3}, {4, 2, 3, 1}, {2, 3, 1, 4}
                });
                break;
            case 16:
                printMatrix(sb, new int[][]{
                    {4, 1, 2, 3}, {3, 4, 1, 2}, {2, 3, 4, 1}, {1, 2, 3, 4}
                });
                break;
            default:
                sb.append("IMPOSSIBLE\n");
                break;
        }
    }

    private static void handleCaseForN3(int k, StringBuilder sb) {
        switch (k) {
            case 4:
            case 5:
            case 7:
            case 8:
                sb.append("IMPOSSIBLE\n");
                break;
            case 3:
                printMatrix(sb, new int[][]{
                    {1, 2, 3}, {3, 1, 2}, {2, 3, 1}
                });
                break;
            case 6:
                printMatrix(sb, new int[][]{
                    {2, 3, 1}, {1, 2, 3}, {3, 1, 2}
                });
                break;
            case 9:
                printMatrix(sb, new int[][]{
                    {3, 1, 2}, {2, 3, 1}, {1, 2, 3}
                });
                break;
            default:
                sb.append("IMPOSSIBLE\n");
                break;
        }
    }

    private static void handleCaseForN2(int k, StringBuilder sb) {
        switch (k) {
            case 3:
                sb.append("IMPOSSIBLE\n");
                break;
            case 2:
                printMatrix(sb, new int[][]{
                    {1, 2}, {2, 1}
                });
                break;
            case 4:
                printMatrix(sb, new int[][]{
                    {2, 1}, {1, 2}
                });
                break;
            default:
                sb.append("IMPOSSIBLE\n");
                break;
        }
    }

    private static void printMatrix(StringBuilder sb, int[][] matrix) {
        sb.append("POSSIBLE\n");
        for (int[] row : matrix) {
            for (int num : row) {
                sb.append(num).append(" ");
            }
            sb.append("\n");
        }
    }
}