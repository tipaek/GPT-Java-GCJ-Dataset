import java.io.*;
import java.util.*;
class Solution{


    static void findAnswer(int[][] m, int n, int testNo){
        int trace = 0;
        int nRows = 0, nCols = 0;
        ArrayList<Integer> ro = new ArrayList<Integer>();
        ArrayList<Integer> co = new ArrayList<Integer>();
        for(int i=0;i<n;i++){
           trace+=m[i][i];
        for(int j=0;j<n;j++){
            if(!ro.contains(m[i][j]))
              ro.add(m[i][j]);
            if(!co.contains(m[j][i]))
            co.add(m[j][i]);
        }
        if(ro.size()<n)
          nRows++;
        if(co.size()<n)
          nCols++;
        ro.clear();
        co.clear();
        }
        PrintWriter writer = new PrintWriter(System.out);    
        writer.write("Case #"+testNo+": "+trace+" "+nRows+" "+nCols+"\n");
        writer.flush();
        
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