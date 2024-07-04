import java.util.*;

class Solution {

    
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int n= input.nextInt();
        int[][][] v=new int[n][][];
        int[][] matrix;
        int N;
        for(int q=0;q<n;q++){
            N=input.nextInt();
            v[q]= new int[N][N];
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    v[q][i][j]=input.nextInt();
                }
            }
        }
        for(int q=0;q<n;q++){
            matrix= v[q];
            N=matrix.length;
            int trace=0,row=0,col=0;
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    if(i==j){
                        trace+=matrix[i][j];
                    }
                    for(int k=j+1;k<N;k++){
                        if(matrix[i][j]==matrix[i][k]){
                            row++;
                            j=N+10;
                            break;
                        }
                    }
                }
            }
            // end trace and search rows
            for(int j=0;j<N;j++){
                for(int i=0;i<N;i++){
                    for(int k=i+1;k<N;k++){
                        if(matrix[i][j]==matrix[k][j]){
                            col++;
                            i=N+10;
                            break;
                        }
                    }
                }
            }
            System.out.println("Case #"+(q+1)+ ": "+trace + " " +row+" "+col);
        }
    }
    
}