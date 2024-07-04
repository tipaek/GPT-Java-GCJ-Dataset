import java.util.Scanner;

class Solution {
    
    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);
        int test_cases = sc.nextInt();
        int count_testcases = 1;

            while (count_testcases<=test_cases) {
    
                System.out.println("Enter dimension of sq matrix: ");
                int rc = sc.nextInt();
                int matrix[][] = new int[rc][rc]; 
    
                System.out.println("Enter elements: ");
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
    
                //System.out.println(sum);
    
                int row_count = 0;
                int col_count = 0;
    
                 for(int i=0; i<rc; i++)  {
                    
                    forrow: for(int j=0; j<rc-1; j++) {
                    
                         for(int k=j; k<rc-1; k++) {

                                if(matrix[i][j] == matrix[i][k+1]) {
                                   
                                    row_count++;

                                    break forrow;
                            }
                        }
                    }
                }

                for(int j=0; j<rc; j++)  {
                    forcol: for(int i=0; i<rc; i++) {
                        for(int k=i; k<rc-1; k++)
                           
                            if(matrix[i][j] == matrix[k+1][j]) {
                                col_count++;
                                break forcol;
                            }                                  
                    }
                }

                // System.out.println(col_count);
                // System.out.println(row_count);
    
                System.out.println("Case #" +count_testcases+ ": " +sum+ " " +row_count+ " " +col_count);

                count_testcases++;
            }
            sc.close();
        }
       
    }