import java.util.*;
import java.io.*;

public class Solution{
   public static void main(String arg[]){
       
        Scanner read = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int nCases=read.nextInt();
        
        for(int i=0;i<nCases;i++){
            int size=read.nextInt();
            int matrix[][]=new int[size][size];
            int trace=0,cols=0,rows=0;
            
            for(int j=0;j<size;j++){
                HashSet<Integer> row=new HashSet<Integer>();
                boolean counted=false;
                for(int k=0;k<size;k++){
                    matrix[j][k]=read.nextInt();
                    if(j==k) trace+=matrix[j][k];
                    if(!counted && !row.add(matrix[j][k])){
                        rows++;
                        counted=true;
                    }
                }
            }
            for(int col=0;col<size;col++){
                boolean counted=false;
                HashSet<Integer> colSet=new HashSet<Integer>();
                for(int row=0;row<size;row++){
                    if(!counted && !colSet.add(matrix[row][col])){
                        counted=true;
                        cols++;
                    }
                }
            }
            System.out.println("Case #"+(i+1)+" "+trace+" "+rows+" "+cols);
        }
   }
}