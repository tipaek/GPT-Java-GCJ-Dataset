
public class Solution {
    public static void main(String arg[]) {
        Scanner scanner = new Scanner(System.in);
        Integer numberOfCase, currentCase;
        int[][] matrix;
        int[][] cases;
        int sum, rowRepeat, colRepeat;
        boolean flag = false;

        numberOfCase = scanner.nextInt();
        cases = new int[numberOfCase][3];
        for(int k = 0; k < numberOfCase; k++) {
            sum = 0;
            rowRepeat = 0;
            colRepeat = 0;
            currentCase = scanner.nextInt();
            matrix = new int[currentCase][currentCase];
            for(int i = 0; i < currentCase; i++) {
                for(int j = 0; j < currentCase; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }
            for(int j = 0; j < currentCase; j++) {
                for(int i = 0; i < currentCase; i++) {
                    if (i == j)
                        sum += matrix[i][j];
                }
            }
            cases[k][0] = sum;
            for(int i = 0; i < currentCase; i++) {
                for(int j = 0; j < currentCase - 1; j++) {
                    for(int l = j + 1; l < currentCase; l++) {
                        if (matrix[i][j] == matrix[i][l]) {
                            flag = true;
                        }
                    }
                }
                if(flag){
                    rowRepeat++;
                    flag = false;
                }
            }
            cases[k][1] = rowRepeat;
            for(int j = 0; j < currentCase; j++) {
                for(int i = 0; i < currentCase - 1; i++) {
                    for(int l = i + 1; l < currentCase; l++) {
                        if (matrix[i][j] == matrix[l][j]) {
                            flag = true;
                        }
                    }
                }
                if(flag){
                    colRepeat++;
                    flag = false;
                }
            }
            cases[k][2] = colRepeat;
        }
        for(int i = 0; i < numberOfCase; i++) {
            System.out.println("Case #" + (i + 1) + ": " + cases[i][0] + " " + cases[i][1] + " " + cases[i][2] + "\n");
        }
    }
}