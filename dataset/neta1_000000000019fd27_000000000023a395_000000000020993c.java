/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/
import java.util.*;
public class Solution
{
	public static void main(String[] args) {
		//System.out.println("Hello World");
		Scanner sc= new Scanner(System.in); //System.in is a standard input stream  
        int T= sc.nextInt();              
        int n;
        int sum;
        int r;
        int c;
        
        
        for(int i = 1 ; i<= T; i++){
            
            System.out.print("Case #"+T+": ");
            n = sc.nextInt();
            int[][] array = new int[n][n];  
            for(int j = 0; j < n ; j++){
                for(int k = 0; k < n; k++){
                    array[j][k] = sc.nextInt();
                }
            }
            sum = 0;
            for(int j = 0; j<n; j++){
                sum = sum + array[j][j];
            }
            System.out.print(sum+" ");
            r=0;
            int[] r_array = new int[n];
            for(int j = 0; j<n; j++){
                r_array[j] = 0;
            }
            for(int a=0; a<n; a++){
                for(int b=0; b<n; b++){
                    if(r_array[array[a][b]-1] == 1){
                        r++;
                        break;
                    }
                    else
                    {
                        r_array[array[a][b]-1] = 1;
                    }
                }
                 for(int j = 0; j<n; j++){
                    r_array[j] = 0;
                }
                
                
            }
            System.out.print(r+" ");
            
            c=0;
            
            
            for(int a=0; a<n; a++){
                for(int b=0; b<n; b++){
                    if(r_array[array[b][a]-1] == 1){
                        c++;
                        break;
                    }
                    else
                    {
                        r_array[array[b][a]-1] = 1;
                    }
                }
                 for(int j = 0; j<n; j++){
                    r_array[j] = 0;
                }
                
                
            }
            System.out.println(c);
            
            
            
           
        }
	}
}



// 1
// 2
// 1 2
// 2 1

 
// 3
// 4
// 1 2 3 4
// 2 1 4 3
// 3 4 1 2
// 4 3 2 1