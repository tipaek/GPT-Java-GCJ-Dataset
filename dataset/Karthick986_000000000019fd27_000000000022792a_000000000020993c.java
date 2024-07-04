import java.util.Scanner;

class Codejam {
    Scanner sc = new Scanner(System.in);
    int test_cases = sc.nextInt();
    int count_testcases = 1;

    
    
    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);
        int test_cases = sc.nextInt();
        int count_testcases = 1;

            while (count_testcases<=test_cases) {
    
                //System.out.println("Enter dimension of sq matrix: ");
                int rc = sc.nextInt();
                int matrix[][] = new int[rc][rc]; 
    
                //System.out.println("Enter elements: ");
                for(int i=0; i<rc; i++) {
                    for(int j=0; j<rc; j++) { 
                         matrix[i][j] = sc.nextInt();
                    }
                }
    
                //System.out.println("Case #"+count_testcases);
    
                int sum = 0;
                
                for(int i=0; i<rc; i++)  {
                    for(int j=0; j<rc; j++) { 
                         if(i==j) {
                             sum += matrix[i][j];
                         }
                    }
                }
    
                System.out.println(sum);
    
                // int row_count = 0;
                // int col_count = 0;
    
                // for(int i=0; i<rc; i++)  {
                //     for(int j=0; j<rc; j++) { 
                //         for(int r=i+1; r<rc; r++) {
                //             for(int c=j+1; c<rc; c++) {
    
                //                 if(matrix[i][j] == matrix[i][j]) {
    
                //                 }
                //             }
                //         }
                //     }
                // }
    
                // System.out.println(col_count);
                // System.out.println(row_count);
    
                count_testcases++;
            }
            sc.close();
        }
       
    }