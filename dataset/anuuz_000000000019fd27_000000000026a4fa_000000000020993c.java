import java.util.Scanner;
import java.util.Arrays;
public class Solution{
    public static void main(String []args){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt(),n;
        int mat[][][]=new int[t][][];
        int trace=0;
        
        for(int k=0;k<t;k++){
            n=sc.nextInt();
            mat[k]=new int[n][n];
            
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++)
                    mat[k][i][j]=sc.nextInt();
            }    
            
            
        }
        

        
        for(int i=0;i<t;i++){
            System.out.print("Case #"+(i+1)+":");
        
            for(int j=0;j<mat[i].length;j++)
                trace+=mat[i][j][j];
                
            System.out.print(" "+trace);
            trace=0;
            
             //transpose
            int temp[][]=new int[mat[i].length][mat[i].length];
            for(int j=0;j<mat[i].length;j++){
                for(int k=0;k<mat[i].length;k++)
                    temp[j][k]=mat[i][k][j];
            }
            
            System.out.print(" "+rows(mat[i]));
            
           
          
            System.out.println(" "+rows(temp));
        }
        
    }
    
    public static int rows(int m[][]){
        int count=0;
        for(int i=0;i<m.length;i++){
            Arrays.sort(m[i]);
            
            for(int j=0;j<m.length-1;j++){
                if(m[i][j]==m[i][j+1]){
                    count++;
                    break;
                }
            }
        }
        return count;
    }
}