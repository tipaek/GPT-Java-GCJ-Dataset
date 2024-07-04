import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

class ArUIdiot {

    public static void main(String[] args) throws NullPointerException,ArrayIndexOutOfBoundsException {
        Scanner scanner = new Scanner(System.in);

        int trace=0;
        int text = Integer.parseInt(scanner.nextLine());
            for(int koll=0; koll<text;koll++) {
                int matrixsize = Integer.parseInt(scanner.nextLine());
                int[][] matrix = new int[matrixsize][matrixsize];

                String[] chast;
                if (scanner.hasNextLine()) {
                for (int stroka = 0; stroka < matrixsize; stroka++) {
                        chast = scanner.nextLine().split(" ");
                        for (int column = 0; column < matrixsize; column++) {
                            matrix[stroka][column] = Integer.parseInt(chast[column]);
                            if (column == stroka)
                                trace = trace + matrix[stroka][stroka];
                        }
                        
                    }
                }


            Set<Integer> brows = new LinkedHashSet<>();
            Set<Integer> bcol = new LinkedHashSet<>();
            boolean[][] foundInRow = new boolean[matrixsize][matrixsize];
            boolean[][] foundInCol = new boolean[matrixsize][matrixsize];
            for (int row = 0; row < matrixsize; row++) {
                for (int col = 0; col < matrixsize; col++) {
                    int idx = matrix[row][col] - 1;
                    if (foundInRow[row][idx])
                        brows.add(row);
                    if (foundInCol[col][idx])
                        bcol.add(col);
                    foundInRow[row][idx] = foundInCol[col][idx] = true;
                }
            }

            System.out.println("Case #" + (koll + 1) + " " + trace + " " + brows.size() + " " + bcol.size());
            bcol.clear();
            brows.clear();
            trace = 0;


        }

        }
    }



