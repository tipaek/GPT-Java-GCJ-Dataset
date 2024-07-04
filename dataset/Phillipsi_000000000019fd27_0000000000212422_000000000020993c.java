import java.io.*;
import java.util.*;
public class Solution{
	public static void main(String[] args) throws IOException{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
        int c = Integer.parseInt(st.nextToken());
        for(int counter = 0; counter<c; counter++){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int[][] m = new int[n][n];
            int k = 0;
            for(int i = 0; i< n; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j<n; j++){
                    m[i][j]=Integer.parseInt(st.nextToken());
                }
                k+=m[i][i];
            }
            int colCounter = 0;
            int rowCounter = 0;
            for(int i = 0; i<n; i++){
                boolean colFinished = false;
                boolean rowFinished = false;
                boolean[] cols = new boolean[n+1];
                boolean[] rows = new boolean[n+1];
                for(int j = 0; j<n; j++){
                    if(!colFinished){
                        if(cols[m[j][i]]){
                            colCounter++;
                            colFinished = true;
                        }else{
                            cols[m[j][i]]=true;
                        }
                    }
                    if(!rowFinished){
                        if(rows[m[i][j]]){
                            rowCounter++;
                            rowFinished = true;
                        }else{
                            rows[m[i][j]]=true;
                        }
                    }
                }
            }
            System.out.println("Case #"+(counter+1)+": "+ k + " " + rowCounter + " "+colCounter);
        }
   }
}
