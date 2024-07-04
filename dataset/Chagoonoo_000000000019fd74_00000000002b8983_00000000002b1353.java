
import java.util.*;

public class Solution {
    public static int[][] matrix;
    public static void main(String[] args) {
        Scanner sc = new Scanner((System.in));
        matrix=makeMatrix(500);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            if(n<=501){
                System.out.println("Case #"+(i+1)+":");
                System.out.println("1 1");
                System.out.println("2 1");
                int sum=2;
                int j=1;
                while(sum<n){
                    System.out.println((j+1)+" "+(j+1));
                    j++;
                    sum++;
                }
            }else if(n<=1000){
                int sum=3;
                System.out.println("Case #"+(i+1)+":");
                System.out.println("1 1");
                System.out.println("2 1");
                System.out.println("2 2");
                int r=3;
                while(sum<n){
                    if(sum+matrix[r][r-2]<=n){
                        sum+=matrix[r][r-2];
                        r++;
                        System.out.println((r+1)+" "+(r-1));
                    }else{
                        sum+=matrix[r][r-1];
                        r++;
                        System.out.println((r+1)+" "+r);
                    }
                }
            }

        }
    }

    public static int[][] makeMatrix(int n){
        int lastL=0;
        if(matrix==null){
            
        }else{
            lastL=matrix.length;
        }
        if(n>lastL){
            int[][] newMatrix=new int[n][];
//            copyArray(matrix, newMatrix);
            for (int i = lastL; i < newMatrix.length; i++) {
                newMatrix[i]=new int[i+1];
                for (int j = 0; j < newMatrix[i].length; j++) {
                    if(j==0||j==newMatrix[i].length-1){
                        newMatrix[i][j]=1;
                    }else{
                        newMatrix[i][j]=newMatrix[i-1][j-1]+newMatrix[i-1][j];
                    }
                    
                }
            }
            return newMatrix;
        }
        return matrix;
    }
  
    public static void copyArray(int[][] in1,int[][] in2){
        
        for (int i = 0; i < in1.length; i++) {
            for (int j = 0; j < in1[i].length; j++) {
                in2[i][j]=in1[i][j];
            }
        }
        
        
    }

}
