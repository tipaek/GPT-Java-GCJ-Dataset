import java.lang.*;
import java.util.*;
import java.io.*;

public class Solution {
  
    
    public static void main (String [] args){
        
        //Scanner
        Scanner input = new Scanner(System.in);
        
        int T = input.nextInt();    //test cases
        
        for(int i=0; i<T; i++){
            
            int N = input.nextInt();
            int [][] mat = new int [N][N];  //Matrix
            
            int x = i+1;      //case #
            int k = 0;      //trace of matrix
            int r = 0;      //rows with repeated
            int c = 0;      //columns with repeated
            int flag = 0;  
            
            for(int j = 0; j<N; j++){       //filling matrix
                for(int l = 0; l<N; l++)
                    mat[j][l] = input.nextInt();
            }
            
            for(int j=0; j<N; j++)      //getting trace
                k += mat[j][j];
            
            for(int j=0; j<N; j++){     //check rows
                for(int l=0; l<N-1; l++){
                    for(int o=l+1; o<N; o++){
                        if(mat[j][l] == mat[j][o]){
                            r++;
                            flag = 1;
                            break;
                        }
                    }
                    if(flag == 1){
                        flag = 0;
                        break;
                    }
                }
            }
            
            for(int j=0; j<N; j++){     //check columns
                for(int l=0; l<N-1; l++){
                    for(int o=l+1; o<N; o++){
                        if(mat[l][j] == mat[o][j]){
                            c++;
                            flag = 1;
                            break;
                        }
                    }
                    if(flag == 1){
                        flag = 0;
                        break;
                    }
                }
            }
            
            System.out.println("Case #" + x + ": " + k + " " + r + " " + c);
            
        }
    }
}
