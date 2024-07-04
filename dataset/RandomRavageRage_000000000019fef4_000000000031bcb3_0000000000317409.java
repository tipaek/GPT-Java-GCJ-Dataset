import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
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
    	int A = Integer.parseInt(st.nextToken());
    	int B = Integer.parseInt(st.nextToken());
    	
    	String movements = st.nextToken();
    	
    	int minTime = 0;
    	int time = 0;
    	for(int i = 0; i < movements.length(); i++){
    		time++;
    		char M = movements.charAt(i);
    		switch(M){
    			case 'N':
    				B++;
    				break;
    			case 'E':
    				A++;
    				break;
    			case 'S':
    				B--;
    				break;
    			case 'W':
    				A--;
    			default: break;
    		}
    		System.out.println(A + " : " + B);
    		if(Math.abs(A) + Math.abs(B) <= time){
    			System.out.println("Case #" + x + ": " + time);
    			return;
    		}
    	}
    	
        System.out.println("Case #" + x + ": IMPOSSIBLE");
    }
}
