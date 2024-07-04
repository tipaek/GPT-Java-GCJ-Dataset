//  package qualificaitonRound2020;

import java.io.BufferedReader; 
import java.io.IOException; 
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner; 
import java.util.StringTokenizer; 
public class Solution {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FastReader s=new FastReader(); 
        int t = s.nextInt(); 
        for(int m = 0 ; m < t ; m++) {
        	int n = s.nextInt();
        	int arr[][] = new int[n][4];
        	for(int i = 0 ; i < n ; i++) {
        		arr[i][0] = s.nextInt();
        		arr[i][1] = s.nextInt();
        		arr[i][2] = i;
        	}
        	Arrays.sort(arr, new Comparator<int[]>() {
        		public int compare(int[] o1,int[] o2){
        			if(o1[1] > o2[1]) return 1;
        			else if(o1[1] < o2[1]) return -1;
        			return 0;
        		}
        	});
        	int C = -1;
        	int J = -1;
        	int flag = 0;
        	StringBuilder ans = new StringBuilder();
        	for(int[] temp : arr) {
        		if(temp[0] >= J) {
        			J = temp[1];
        			temp[3] = 0;
        		}else if(temp[0] >= C){
        			C = temp[1];
        			temp[3] = 1;
        		}else {
        			flag = 1;
        			break;
        		}
        	}
        	if(flag == 1) {
        		String str = "IMPOSSIBLE";
            	System.out.println("Case #"+(m+1)+": "+str);
        	}else {
        		Arrays.sort(arr, new Comparator<int[]>() {
            		public int compare(int[] o1,int[] o2){
            			if(o1[2] > o2[2]) return 1;
            			else if(o1[2] < o2[2]) return -1;
            			return 0;
            		}
            	});
        		for(int[] temp : arr) {
        			if(temp[3] == 0)ans.append("J");
        			else ans.append("C");
        		}
        		String str = ans.toString();
            	System.out.println("Case #"+(m+1)+": "+str);
        	}
//        	System.out.println("Case #"+(m+1)+": "+trace+" "+row+" "+column);
        }
			
	}

	public static class FastReader 
    { 
        BufferedReader br; 
        StringTokenizer st; 
  
        public FastReader() 
        { 
            br = new BufferedReader(new
                     InputStreamReader(System.in)); 
        } 
  
        String next() 
        { 
            while (st == null || !st.hasMoreElements()) 
            { 
                try
                { 
                    st = new StringTokenizer(br.readLine()); 
                } 
                catch (IOException  e) 
                { 
                    e.printStackTrace(); 
                } 
            } 
            return st.nextToken(); 
        } 
  
        int nextInt() 
        { 
            return Integer.parseInt(next()); 
        } 
  
        long nextLong() 
        { 
            return Long.parseLong(next()); 
        } 
  
        double nextDouble() 
        { 
            return Double.parseDouble(next()); 
        } 
  
        String nextLine() 
        { 
            String str = ""; 
            try
            { 
                str = br.readLine(); 
            } 
            catch (IOException e) 
            { 
                e.printStackTrace(); 
            } 
            return str; 
        } 
    }
}
