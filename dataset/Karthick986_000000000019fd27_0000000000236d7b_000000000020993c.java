import java.util.Scanner;

class Solution {
    
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
    
                int sum = 0;
                
                for(int i=0; i<rc; i++)  {
                    for(int j=0; j<rc; j++) { 
                         if(i==j) {
                             sum += matrix[i][j];
                         }
                    }
                }
    
                int row_count = 0;
                int col_count = 0;
                int com_ele;
    
                for(int i=0; i<rc; i++)  {
                    for(int j=0; j<rc-1; j++) {

                                if(matrix[i][j] == matrix[i][j+1]) {

                                    row_count++;
                                }
                    }
                }

                for(int i=0; i<rc-1; i++)  {
                    for(int j=0; j<rc; j++) {
                        if(matrix[i][j] == matrix[i+1][j]) {

                            col_count++;
                        }
                    }
                }
    
                // System.out.println(row_count);
                // System.out.println(col_count);

                System.out.println("Case #" +count_testcases+ ": " +sum+ " " +row_count+ " " +col_count);
    
                count_testcases++;
                
            }
            sc.close();
        }
       
    }