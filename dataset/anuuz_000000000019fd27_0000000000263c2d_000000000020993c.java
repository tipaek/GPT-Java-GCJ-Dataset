import java.util.Scanner;
import java.util.Arrays;
public class test{
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
            System.out.print("Case #"+i+":");
        
            for(int j=0;j<mat[t].lenght;j++)
                trace+=mat[i][j][j];
            System.out.print(" "+trace);
            trace=0;
            System.out.print(" "+rows(mat[t]));
            
            //transpose
            int temp[][]=new int[mat[t].length][mat[t].length];
            for(int j=0;j<mat[t].lenght;j++){
                for(int k=0;k<mat[t].lenght;k++)
                    temp[j][i]=mat[t][i][j];
            }
            
            System.out.print(" "+rows(mat[t]));
        }
        
    }
    
    public static int rows(int m[][]){
        int count=0;
        for(int i=0;i<m.length;i++){
            Arrays.sort(m[i]);
            
            for(int j=0;i<m.length-1;j++){
                if(m[i][j]==m[i][j+1]){
                    count++;
                    break;
                }
            }
        }
    }
}