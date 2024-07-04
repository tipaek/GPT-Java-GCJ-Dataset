import java.util.*;
import java.io.*;

class Solution{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int N = 0;
        String result = "";
        while(T<1||T>100){
            T = Integer.parseInt(br.readLine());
        }
        for(int i=0; i<T; i++){
            while(N<2 || N>100){
                N = Integer.parseInt(br.readLine());
            }
            result = matrix(N);
            System.out.println("Case #"+i+": "+result);
			//br.flush();
        }
    }
    public static String matrix(int n) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int sum=0, rmax=0 ,cmax=0, rc=0, cc=0;
        int[][] mat = new int[n][n];
        int count = 0;
        String[] input;
        for(int i=0; i<n; i++){
            input = br.readLine().split(" ");
            for(int j=0; j<n; j++){
				//System.out.println(count+ " "+ j);
                mat[count][j] = Integer.parseInt(input[j]);
            }
            count++;
        }
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(i==j){
					sum+=mat[i][j];
				}
				for(int k=0;k<n;k++){
					if(k!=j && mat[i][j]==mat[i][k]){
						rc++;
					}
				}
				for(int k=0;k<n; k++){
					if(k!=i && mat[i][j]==mat[k][j]){
						cc++;
					}
				}
				if(rc>rmax){
					rmax=rc;
				}
				
				if(cc>cmax){
					cmax=cc;
				}
				System.out.println(rmax+" "+cmax+" "+rc+" "+cc);
				rc=0;
				cc=0;
            }
        }
		if(rmax>0){
			rmax++;
		}
		if(cmax>0){
			cmax++;
		}
		return ""+sum+" "+rmax+" "+cmax;
    }
    
}