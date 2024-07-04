import java.util.Scanner;

public class Solution {

    private static abstract class Square {
        int[][] matrix;
        int size;

        public Square(int size) {
            this.size = size;
            this.matrix = new int[size + 1][size + 1];
        }

        abstract void applyConfig(int trace, int caseNr);

        void printMatrix(int caseNr) {
            System.out.println("Case #" + caseNr + ": POSSIBLE");
            for (int i = 1; i <= size; i++) {
                for (int j = 1; j <= size; j++) {
                    System.out.print(matrix[i][j] + " ");
                }
                System.out.println();
            }
        }
    }

    private static class SquareTwo extends Square {
        public SquareTwo() {
            super(2);
        }

        @Override
        void applyConfig(int trace, int caseNr) {
            if (trace == 2 || trace == 4) {
                if (trace == 2) {
                    matrix[1][1] = 1; matrix[1][2] = 2;
                    matrix[2][1] = 2; matrix[2][2] = 1;
                } else if (trace == 4) {
                    matrix[1][1] = 2; matrix[1][2] = 1;
                    matrix[2][1] = 1; matrix[2][2] = 2;
                }
                printMatrix(caseNr);
            } else {
                System.out.println("Case #" + caseNr + ": IMPOSSIBLE");
            }
        }
    }

    private static class SquareThree extends Square {
        public SquareThree() {
            super(3);
        }

        @Override
        void applyConfig(int trace, int caseNr) {
            if (trace == 3 || trace == 6 || trace == 9) {
                if (trace == 3) {
                    matrix[1][1] = 1; matrix[1][2] = 2; matrix[1][3] = 3;
                    matrix[2][1] = 3; matrix[2][2] = 1; matrix[2][3] = 2;
                    matrix[3][1] = 2; matrix[3][2] = 3; matrix[3][3] = 1;
                } else if (trace == 6) {
                    matrix[1][1] = 2; matrix[1][2] = 1; matrix[1][3] = 3;
                    matrix[2][1] = 3; matrix[2][2] = 2; matrix[2][3] = 1;
                    matrix[3][1] = 1; matrix[3][2] = 3; matrix[3][3] = 2;
                } else if (trace == 9) {
                    matrix[1][1] = 3; matrix[1][2] = 1; matrix[1][3] = 2;
                    matrix[2][1] = 2; matrix[2][2] = 3; matrix[2][3] = 1;
                    matrix[3][1] = 1; matrix[3][2] = 2; matrix[3][3] = 3;
                }
                printMatrix(caseNr);
            } else {
                System.out.println("Case #" + caseNr + ": IMPOSSIBLE");
            }
        }
    }

    private static class SquareFour extends Square {
        public SquareFour() {
            super(4);
        }

        @Override
        void applyConfig(int trace, int caseNr) {
            switch (trace) {
                case 4: case 8: case 12: case 16:
                    matrix[1][1] = trace == 4 ? 1 : trace == 8 ? 2 : trace == 12 ? 3 : 4;
                    matrix[1][2] = trace == 4 ? 2 : trace == 8 ? 3 : trace == 12 ? 4 : 3;
                    matrix[1][3] = trace == 4 ? 3 : trace == 8 ? 4 : trace == 12 ? 1 : 2;
                    matrix[1][4] = trace == 4 ? 4 : trace == 8 ? 1 : trace == 12 ? 2 : 1;
                    matrix[2][1] = matrix[1][4]; matrix[2][2] = matrix[1][1]; matrix[2][3] = matrix[1][2]; matrix[2][4] = matrix[1][3];
                    matrix[3][1] = matrix[1][3]; matrix[3][2] = matrix[1][4]; matrix[3][3] = matrix[1][1]; matrix[3][4] = matrix[1][2];
                    matrix[4][1] = matrix[1][2]; matrix[4][2] = matrix[1][3]; matrix[4][3] = matrix[1][4]; matrix[4][4] = matrix[1][1];
                    printMatrix(caseNr);
                    break;
                case 6: case 10: case 14:
                    matrix[1][1] = trace == 6 ? 1 : trace == 10 ? 2 : 3;
                    matrix[1][2] = trace == 6 ? 2 : trace == 10 ? 3 : 4;
                    matrix[1][3] = trace == 6 ? 3 : trace == 10 ? 1 : 1;
                    matrix[1][4] = trace == 6 ? 4 : trace == 10 ? 4 : 2;
                    matrix[2][1] = matrix[1][2]; matrix[2][2] = matrix[1][1]; matrix[2][3] = matrix[1][4]; matrix[2][4] = matrix[1][3];
                    matrix[3][1] = matrix[1][3]; matrix[3][2] = matrix[1][4]; matrix[3][3] = matrix[1][2]; matrix[3][4] = matrix[1][1];
                    matrix[4][1] = matrix[1][4]; matrix[4][2] = matrix[1][3]; matrix[4][3] = matrix[1][1]; matrix[4][4] = matrix[1][2];
                    printMatrix(caseNr);
                    break;
                case 7: case 9: case 11: case 13:
                    matrix[1][1] = trace == 7 ? 1 : trace == 9 ? 3 : trace == 11 ? 4 : 4;
                    matrix[1][2] = trace == 7 ? 2 : trace == 9 ? 1 : trace == 11 ? 1 : 2;
                    matrix[1][3] = trace == 7 ? 3 : trace == 9 ? 2 : trace == 11 ? 2 : 3;
                    matrix[1][4] = trace == 7 ? 4 : trace == 9 ? 4 : trace == 11 ? 3 : 1;
                    matrix[2][1] = matrix[1][3]; matrix[2][2] = matrix[1][1]; matrix[2][3] = matrix[1][4]; matrix[2][4] = matrix[1][2];
                    matrix[3][1] = matrix[1][4]; matrix[3][2] = matrix[1][2]; matrix[3][3] = matrix[1][3]; matrix[3][4] = matrix[1][1];
                    matrix[4][1] = matrix[1][2]; matrix[4][2] = matrix[1][4]; matrix[4][3] = matrix[1][1]; matrix[4][4] = matrix[1][3];
                    printMatrix(caseNr);
                    break;
                default:
                    System.out.println("Case #" + caseNr + ": IMPOSSIBLE");
                    break;
            }
        }
    }

    private static class SquareFive extends Square {
        public SquareFive() {
            super(5);
        }

        @Override
        void applyConfig(int trace, int caseNr) {
            switch (trace) {
                case 5: case 10: case 15: case 20: case 25:
                    matrix[1][1] = trace == 5 ? 1 : trace == 10 ? 2 : trace == 15 ? 3 : trace == 20 ? 4 : 5;
                    matrix[1][2] = trace == 5 ? 2 : trace == 10 ? 3 : trace == 15 ? 4 : trace == 20 ? 5 : 1;
                    matrix[1][3] = trace == 5 ? 3 : trace == 10 ? 4 : trace == 15 ? 5 : trace == 20 ? 1 : 2;
                    matrix[1][4] = trace == 5 ? 4 : trace == 10 ? 5 : trace == 15 ? 1 : trace == 20 ? 2 : 3;
                    matrix[1][5] = trace == 5 ? 5 : trace == 10 ? 1 : trace == 15 ? 2 : trace == 20 ? 3 : 4;
                    matrix[2][1] = matrix[1][5]; matrix[2][2] = matrix[1][1]; matrix[2][3] = matrix[1][2]; matrix[2][4] = matrix[1][3]; matrix[2][5] = matrix[1][4];
                    matrix[3][1] = matrix[1][4]; matrix[3][2] = matrix[1][5]; matrix[3][3] = matrix[1][1]; matrix[3][4] = matrix[1][2]; matrix[3][5] = matrix[1][3];
                    matrix[4][1] = matrix[1][3]; matrix[4][2] = matrix[1][4]; matrix[4][3] = matrix[1][5]; matrix[4][4] = matrix[1][1]; matrix[4][5] = matrix[1][2];
                    matrix[5][1] = matrix[1][2]; matrix[5][2] = matrix[1][3]; matrix[5][3] = matrix[1][4]; matrix[5][4] = matrix[1][5]; matrix[5][5] = matrix[1][1];
                    printMatrix(caseNr);
                    break;
                case 7: case 8: case 9: case 11: case 12: case 13: case 14: case 16: case 17: case 18: case 19: case 21: case 22: case 23:
                    matrix[1][1] = trace == 7 ? 2 : trace == 8 ? 1 : trace == 9 ? 3 : trace == 11 ? 1 : trace == 12 ? 3 : trace == 13 ? 2 : trace == 14 ? 4 : trace == 16 ? 2 : trace == 17 ? 1 : trace == 18 ? 3 : trace == 19 ? 2 : trace == 21 ? 3 : trace == 22 ? 5 : 4;
                    matrix[1][2] = trace == 7 ? 1 : trace == 8 ? 2 : trace == 9 ? 1 : trace == 11 ? 3 : trace == 12 ? 2 : trace == 13 ? 3 : trace == 14 ? 2 : trace == 16 ? 4 : trace == 17 ? 5 : trace == 18 ? 4 : trace == 19 ? 5 : trace == 21 ? 5 : trace == 22 ? 4 : 5;
                    matrix[1][3] = trace == 7 ? 3 : trace == 8 ? 3 : trace == 9 ? 2 : trace == 11 ? 2 : trace == 12 ? 1 : trace == 13 ? 1 : trace == 14 ? 1 : trace == 16 ? 1 : trace == 17 ? 2 : trace == 18 ? 1 : trace == 19 ? 1 : trace == 21 ? 1 : trace == 22 ? 1 : 1;
                    matrix[1][4] = trace == 7 ? 4 : trace == 8 ? 4 : trace == 9 ? 4 : trace == 11 ? 4 : trace == 12 ? 4 : trace == 13 ? 4 : trace == 14 ? 3 : trace == 16 ? 3 : trace == 17 ? 3 : trace == 18 ? 2 : trace == 19 ? 3 : trace == 21 ? 2 : trace == 22 ? 3 : 2;
                    matrix[1][5] = trace == 7 ? 5 : trace == 8 ? 5 : trace == 9 ? 5 : trace == 11 ? 5 : trace == 12 ? 5 : trace == 13 ? 5 : trace == 14 ? 5 : trace == 16 ? 5 : trace == 17 ? 4 : trace == 18 ? 5 : trace == 19 ? 4 : trace == 21 ? 4 : trace == 22 ? 2 : 3;
                    matrix[2][1] = matrix[1][4]; matrix[2][2] = matrix[1][1]; matrix[2][3] = matrix[1][5]; matrix[2][4] = matrix[1][2]; matrix[2][5] = matrix[1][3];
                    matrix[3][1] = matrix[1][3]; matrix[3][2] = matrix[1][4]; matrix[3][3] = matrix[1][1]; matrix[3][4] = matrix[1][5]; matrix[3][5] = matrix[1][2];
                    matrix[4][1] = matrix[1][5]; matrix[4][2] = matrix[1][2]; matrix[4][3] = matrix[1][3]; matrix[4][4] = matrix[1][1]; matrix[4][5] = matrix[1][4];
                    matrix[5][1] = matrix[1][2]; matrix[5][2] = matrix[1][3]; matrix[5][3] = matrix[1][4]; matrix[5][4] = matrix[1][5]; matrix[5][5] = matrix[1][1];
                    printMatrix(caseNr);
                    break;
                default:
                    System.out.println("Case #" + caseNr + ": IMPOSSIBLE");
                    break;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int noTests = scanner.nextInt();

        Square[] squares = new Square[6];
        squares[2] = new SquareTwo();
        squares[3] = new SquareThree();
        squares[4] = new SquareFour();
        squares[5] = new SquareFive();

        for (int t = 1; t <= noTests; t++) {
            int size = scanner.nextInt();
            int trace = scanner.nextInt();
            if (size >= 2 && size <= 5) {
                squares[size].applyConfig(trace, t);
            } else {
                System.out.println("Case #" + t + ": IMPOSSIBLE");
            }
        }
    }
}