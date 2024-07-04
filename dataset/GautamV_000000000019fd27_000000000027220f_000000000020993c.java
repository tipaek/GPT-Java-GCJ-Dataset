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
        }
    }
    public static String matrix(int n) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		List<Integer> r = new ArrayList<>();
		List<Integer> c = new ArrayList<>();
		int sum=0, rmax=0 ,cmax=0;
        int[][] mat = new int[n][n];
        int count = 0;
        String[] input;
        for(int i=0; i<n; i++){
            input = br.readLine().split(" ");
            for(int j=0; j<n; j++){
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
						r.add(i);
					}
				}
				for(int k=0;k<n; k++){
					if(k!=i && mat[i][j]==mat[k][j]){
						c.add(j);
					}
				}
            }
        }
		Set<Integer> rc = new HashSet<Integer>(r);
		Set<Integer> cc = new HashSet<Integer>(c);
		return ""+sum+" "+rc.size()+" "+cc.size();
    }
    
}