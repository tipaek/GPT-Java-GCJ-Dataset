import java.lang.Math;
class LatinMatrixTest{
    static void MatrixTest(int n, int[][] matrix){
        int[] row_count = new int[n];
        int[] collumn_count = new int[n];
        boolean not_printed = true;
        int rep_count = 0;
        boolean row_rep = false;
        boolean collumn_rep = false;
        for (int i1 = 0, j1 = 0; i1 < n && j1 < n; i1++, j1++){
            for (int i2 = 0, j2 = 0; i2 < n && j2 < n; i2++, j2++){
                if (!row_rep){
                    row_count[matrix[i1][j2]-1] += 1;
                }
                if (!collumn_rep){
                    collumn_count[matrix[i2][j1]-1] += 1;
                }
                if (row_count[matrix[i1][j2]-1] > 1 || collumn_count[matrix[i2][j1]-1] > 1){
                    if (not_printed){
                        System.out.println("Not a Natural Latin Matrix.");
                        not_printed = false;
                    }
                    if (row_count[matrix[i1][j2]-1] > 1){
                        if (!row_rep){
                            rep_count++;
                        }
                        row_rep = true;
                        j2--;
                    }
                    if (collumn_count[matrix[i2][j1]-1] > 1){
                        if (!collumn_rep){
                            rep_count++;
                        }
                        collumn_rep = true;
                        i2--;
                    }
                    if (row_rep && collumn_rep){
                        break;
                    }
                } 
            }
            row_count = new int[n];
            collumn_count = new int[n];
            row_rep = false;
            collumn_rep = false;
        } 
        if (not_printed){
            System.out.println("This is a Natural Latin Matrix.");
        } else {
            System.out.println("There are " + rep_count + " repititions.");
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter the length of the sides for the matrix: ");
        int n = sc.nextInt();
        System.out.println();

        System.out.println("Enter numbers for the matrix");
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                matrix[i][j] = sc.nextInt();
            }
        }
        
        MatrixTest(n, matrix);
    }
}