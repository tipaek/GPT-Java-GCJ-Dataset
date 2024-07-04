import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

 class MatrixTrace {

    public MatrixTrace(int n, Scanner scanner, int t) {
        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
        for (int j = 0; j < n; j++) {

            matrix.add(new ArrayList<>());

        }
        for (int i = 0; i < n; i++) {

            for (int j = 0; j < n; j++) {

                int matrixElement = scanner.nextInt();
                matrix.get(i).add(matrixElement);

            }


        }
        int rowOccurence = 0;
        for (int i = 0; i < n; i++) {

            for (int j = 0; j < n; j++) {

                int currentNm = matrix.get(i).get(j);
                int occurenceTracing = rowOccurence;
                for (int k = 0; k < n; k++) {
                    if (matrix.get(i).get(k) == currentNm && k != j) {

                        rowOccurence++;
                        break;
                    }

                }
                if (rowOccurence > occurenceTracing)
                    break;


            }


        }
        int coulmnOccurence = 0;
        for (int i = 0; i < n; i++) {

            for (int j = 0; j < n; j++) {

                int currentNm = matrix.get(j).get(i);
                int occurenceTracing = coulmnOccurence;
                for (int k = 0; k < n; k++) {
                    if (matrix.get(k).get(i) == currentNm && k != j) {

                        coulmnOccurence++;
                        break;
                    }

                }
                if (coulmnOccurence > occurenceTracing)
                    break;


            }


        }
        int matrixTrace = 0;
        for (int k = 0; k < n; k++) {

            matrixTrace = matrixTrace+ matrix.get(k).get(k);

            }
        System.out.println("Case #"+(t+1) +": "+ matrixTrace+" "+rowOccurence+" "+coulmnOccurence);
      /*  System.out.println(rowOccurence);
        System.out.println(coulmnOccurence);*/
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 0;i<t;i++){
            int n = scanner.nextInt();
            new MatrixTrace(n, scanner, i);
        }


    }
}
