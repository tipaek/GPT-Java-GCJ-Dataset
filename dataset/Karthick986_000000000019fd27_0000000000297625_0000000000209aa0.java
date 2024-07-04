import java.util.Scanner;

class Solution {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int test_cases = sc.nextInt();
        int test_count = 1;

        while(test_count <= test_cases) {

            System.out.println("Enter dimension: ");
            int dimen = sc.nextInt();
    
            System.out.println("Sum of diagonal: ");
            int sumdiag = sc.nextInt();

            int diag_ele = sumdiag / dimen;

            if(sumdiag % dimen != 0) {
                System.out.println("IMPOSSIBLE");
            } 

            else if(sumdiag % dimen == 0 && diag_ele <= dimen) {

                int matrix[][] = new int[dimen][dimen];

            try {              

                System.out.println("Case #" +test_count+ ": ");
                for(int i=0; i<dimen; i++) {
                    for(int j=0; j<dimen; j++) {

                            if(i==j) {
                                matrix[i][j] = diag_ele;
                            }
                    }
                }


                for(int i=0; i<dimen; i++) {
     
                    int temp = dimen;

                 for(int j=0; j<dimen; j++) {
                     
                    fork: for(int k=temp; k<=dimen; k--)

                            if(i != j) {
                                matrix[i][j] = k;
                                temp = diag_ele-1;
                                break fork;
                            }
                    }
                }

                // for(int i=0; i<dimen; i++) {
                //     for(int j=0; j<dimen; j++) {
                //      fore: for(int k=diag_ele-1; k>=1; k++)
 
                //              if(i != j) {
                //                  matrix[i][j] = k;
                //                  break fore;
                //              }
                //      }
                //  }

                System.out.println("POSSIBLE");
                
                for(int i=0; i<dimen; i++) {
                    for(int j=0; j<dimen; j++) {
                        System.out.print(matrix[i][j]+ "\t");
                
                    }
                    System.out.println("\n");
                }
            }

            catch(Exception e) {
                System.out.println("Error Occurred" +e);
            }
        }
        else {
            System.out.println("IMPOSSIBLE");
        }
        test_count++;
    }
        sc.close();
       
    }
}