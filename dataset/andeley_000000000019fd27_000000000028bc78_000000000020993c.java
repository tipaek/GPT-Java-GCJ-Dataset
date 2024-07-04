import java.util.Scanner;

/**
 *
 * @author Angie
 */
public class Solution {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        int cp = sc.nextInt();
        int c= 1;
       while(cp-->0){
        int n = sc. nextInt();
        int matrix [][] = new int [n][n];
        int conF = 0;
        int conC = 0;
        int sumaDiag = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                int colum = sc.nextInt();
                matrix [i][j]=colum;
               
            }
            
        }
         for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                  //  System.out.println(matrix[i][j]);
                  if(i==j){
                      sumaDiag+= matrix[i][j];  
                        
                    }
                }
         }
        
            for (int i = 0; i < matrix.length; i++) {
                outerloop:
                for (int j = 0; j < matrix[i].length; j++) {
                  //  System.out.println(matrix[i][j]);
                  
                    int k = j;
                    for (k = j; k < n-1; k++) {
                    // if(k<n-1){
                      
                        if(matrix[i][j]==matrix[i][k+1]){
                             conF++;
                             
                             break outerloop;  
                        }
                    }
                }
            }
            
            for (int i = 0; i < n; i++) {
                outerloop2:
                for (int j = 0; j < n; j++){
                    for (int k = j; k < n-1; k++) {
                        if (matrix[j][i]==matrix[k+1][i]){
                            conC++;
                            break outerloop2;
                        }
                   // }  
                    }
                    if(conC==n){
                            break outerloop2;
                        }
            
                }
            }
        
            System.out.println("Case #"+c+": "+sumaDiag + " " + conF + " "+ conC);
            c++;
       }
    }
    
}

