import java.io.*;
import java.util.*;
class Solution{


    static void findAnswer(int[][] m, int n, int testNo){
        int trace = 0;
        int nRows = 0, nCols = 0;
        String ro = new String();
        String co = new String();
        for(int i=0;i<n;i++){
           trace+=m[i][i];
        for(int j=0;j<n;j++){
            if(!ro.contains(Integer.toString(m[i][j])))
              ro = ro + Integer.toString(m[i][j]);
            if(!co.contains(Integer.toString(m[j][i])))
            co = co + Integer.toString(m[j][i]);
        }
        if(ro.length()<n)
          nRows++;
        if(co.length()<n)
          nCols++;
        ro = "";
        co = "";
        }
        System.out.println("Case #"+testNo+": "+trace+" "+nRows+" "+nCols);
        
    }

    public static void main(String args[])throws IOException{

        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);
        int t = Integer.parseInt(br.readLine());
        for(int k=1;k<=t;k++){
            int n = Integer.parseInt(br.readLine());
            int[][] matrix = new int[n][n];
            for(int i=0;i<n;i++){
                String[] rowRead = br.readLine().split(" ");
                for(int j=0;j<n;j++)
                    matrix[i][j] = Integer.parseInt(rowRead[j]);                
            }
            findAnswer(matrix, n, k);            
        }

    }
}