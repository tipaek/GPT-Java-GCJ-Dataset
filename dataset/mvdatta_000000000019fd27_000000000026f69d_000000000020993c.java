import java.util.*;

public class Solution{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for(int t=1;t<=T;t++){
            int N = in.nextInt();
            int trace = 0;
            int rowCount = 0;
            int colCount = 0;
            
            boolean[][] rowmat = new boolean[N+1][N+1];
            boolean[][] colmat = new boolean[N+1][N+1];
            
            for(int i=1;i<=N;i++){
                for(int j=1;j<=N;j++){
                    int num = in.nextInt();
                    if(rowmat[i][num]){
                        if(!rowmat[i][0]){
                            rowCount++;   
                        }
                        rowmat[i][0] = true;
                    }
                    rowmat[i][num] = true;
                    
                    if(colmat[j][num]){
                        if(!colmat[j][0]){
                            colCount++;   
                        }
                        colmat[j][0] = true;
                    }
                    colmat[j][num] = true;
                    
                    if(i == j){
                        trace += num;
                    }
                }
            }
            
            System.out.println("Case #" + t + ": " + trace + " " + rowCount + " " + colCount);
        }
    }
}