import java.util.*;


public class Solution {
    public static void main(String[] args) {

        Scanner n = new Scanner(System.in);

        int testCases = n.nextInt();

        if(testCases >= 1 && testCases <= 100) {


            for (int cases = 1; cases <= testCases; cases++) {

                int matSize = n.nextInt();

                if(!(matSize >= 2 && matSize <= 100)){
                    System.exit(0);
                }
                int[][] inputArray = new int[matSize][matSize];
                int trace = 0;

                for (int i = 0; i < matSize; i++) {
                    for (int j = 0; j < matSize; j++) {

                        inputArray[i][j] = n.nextInt();

                        if(!(inputArray[i][j] >= 1 && inputArray[i][j] <= matSize)){
                            System.exit(0);

                        }
                        if (i == j) {
                            trace += inputArray[i][i];
                        }
                    }
                }
                int repeatedRows = 0;

                for (int i = 0; i < matSize; i++) {

                    ArrayList<Integer> tempList = new ArrayList<>();

                    for (int j = 0; j < matSize; j++) {

                        if (!tempList.contains(inputArray[i][j])) {

                            tempList.add(inputArray[i][j]);
                        } else {
                            repeatedRows++;
                            break;
                        }
                    }
                }
                int repeatedColumns = 0;
                for (int i = 0; i < matSize; i++) {

                    ArrayList<Integer> tempList = new ArrayList<>();

                    for (int j = 0; j < matSize; j++) {

                        if (!tempList.contains(inputArray[j][i])) {

                            tempList.add(inputArray[j][i]);
                        } else {
                            repeatedColumns++;
                            break;
                        }
                    }
                }
                System.out.println();
                System.out.println("Case #" + cases + ": " + trace + " " + repeatedRows + " " + repeatedColumns);
            }
        }
    }
}
