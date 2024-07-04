// package Round_1A_2020;

import java.io.BufferedReader; 
import java.io.IOException; 
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner; 
import java.util.StringTokenizer; 
public class Solution {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FastReader s=new FastReader(); 
        int t = s.nextInt(); 
        for(int m = 0 ; m < t ; m++) {
        	int n = s.nextInt();
        	ArrayList<String> arr = new ArrayList<>();
        	for(int i = 0 ; i < n ; i++)arr.add(s.next());
        	String prev = arr.get(0);
        	int flag = 0;
        	for(int i = 1 ; i < n ; i++) {
        		String curr = arr.get(i);
        		prev = isMatch(prev,curr);
        		if(prev.equals("")) {
        			flag = 1;
        			break;
        		}
        	}
        	if(flag == 1)
        	System.out.println("Case #"+(m+1)+": "+"*");
        	else {
        		String temp = "";
        		for(int i = 0 ; i < prev.length() ; i++) {
        			if(prev.charAt(i) != '*') temp += prev.charAt(i);
        		}
        		System.out.println("Case #"+(m+1)+": "+ temp);
        	}
        }
			
	}

	public static String find(int[][] dp , String A, String B){
        int i = A.length();
        int j = B.length();
        String ans = "";
        if(dp[i][j] == 0) return "";
        while(i > 0 && j > 0){
            if(A.charAt(i-1) == B.charAt(j-1) && A.charAt(i-1) != '*'){
                ans = A.charAt(i-1) + ans;
                i--;
                j--;
            }else if(B.charAt(j-1) == '*' && A.charAt(i-1) != '*'){
                ans = A.charAt(i-1) + ans;
                i--;
            }else if(B.charAt(j-1) != '*' && A.charAt(i-1) == '*'){
                ans = B.charAt(j-1) + ans;
                j--;
            }else if(B.charAt(j-1) == '*' && A.charAt(i-1) == '*'){
                if(dp[i][j-1] == 1){
                    ans = B.charAt(j-1) + ans;
                    j--;
                }else{
                    ans = B.charAt(j-1) + ans;
                    i--;
                }
            }
            
        }
        return ans;
    }
    public static String isMatch(final String A, final String B) {
        int n = A.length()+1;
        int m = B.length()+1;
        int dp[][] = new int[n][m];
        int[] curr = new int[m];
        int[] prev = new int[m];
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                
                if(i == 0 && j == 0) curr[j] = 1;
                else if(j == 0 ) {
                    if(A.charAt(i-1) == '*' && prev[j] == 1) curr[j] = 1;  
                }
                else if(i == 0){
                    if(B.charAt(j-1) == '*' && curr[j-1] == 1) curr[j] = 1;     
                }else{
                    // System.out.print(i+" "+A.charAt(i-1)+" , "+j+" "+B.charAt(j-1)+" ");
                    if(A.charAt(i-1) == B.charAt(j-1) && A.charAt(i-1) != '*'){
                        if(prev[j-1] == 1 ) curr[j] = 1;
                        else curr[j] = 0;
                    }else if(B.charAt(j-1) == '*' && A.charAt(i-1) != '*'){
                        if(prev[j] == 1 ) curr[j] = 1 ;
                        else curr[j] = 0;
                    }else if(B.charAt(j-1) != '*' && A.charAt(i-1) == '*'){
                        if(curr[j-1] == 1 ) curr[j] = 1 ;
                        else curr[j] = 0;
                    }else if(B.charAt(j-1) == '*' && A.charAt(i-1) == '*'){
                        if(prev[j] == 1 || curr[j-1] == 1 ) curr[j] = 1 ;
                        else curr[j] = 0;
                    }else{
                        curr[j] = 0;
                    }
                }
            }
            prev = curr;
            curr = new int[m];
            // System.out.println();
            for(int j = 0 ; j < m ; j++){
//                System.out.print(prev[j]+" ");
                dp[i][j] = prev[j];
            }
//            System.out.println();
        }
//        System.out.println(find(dp,A,B));
        return find(dp,A,B);
//        return prev[m-1];
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

