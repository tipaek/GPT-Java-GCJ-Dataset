import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Solution {
	public static BufferedReader br;
    public static void main(String[] args) throws NumberFormatException, IOException {
    	br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for(int i = 1; i <= t; i++){
        	//each case
        	testCase(i);
        }
        br.close();
    }
    
    public static void testCase(int x) throws NumberFormatException, IOException{
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	int N = Integer.parseInt(st.nextToken());
    	int D = Integer.parseInt(st.nextToken());
    	String as = br.readLine();
    	
    	if(D == 0){
    		System.out.println("Case #" + x + ": 0");
    		return;
    	}
    	
    	if(N < D){
    		System.out.println("Case #" + x + ": 0");
    		return;
    	}
    	
    	if(N == D){
    		System.out.println("Case #" + x + ": " + (N - 1));
    		return;
    	}
    	
    	st = new StringTokenizer(as);
    	int gcd = -1;
    	for(int i = 0; i < N; i ++){
    		int A = Integer.parseInt(st.nextToken());
    		if(gcd < 0){
    			gcd = A;
    		}else{
    			gcd = gcd(gcd, A);
    		}
    	}
    	
    	st = new StringTokenizer(as);
    	int divisions;
    	for(int i = 0; i < N; i ++){
    		int A = Integer.parseInt(st.nextToken());
    		divisions += A / gcd - 1;
    	}
    	
        System.out.println("Case #" + x + ": " + divisions);
    }
    
    public static int gcd(int a, int b){ 
        if (a == 0) 
            return b; 
        return gcd(b % a, a); 
    } 
}
