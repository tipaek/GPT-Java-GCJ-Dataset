import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
   
	static int T;
	static int N; // 100 
	static int type, dir;
	static int map[][] = new int[102][102];
	static long k;
	static int r, c;
	static boolean check1[][] = new boolean[102][102];
	static boolean check2[][] = new boolean[102][102];
	static boolean checkr[] = new boolean[102];
	static boolean checkc[] = new boolean[102];
    public static void main(String[] args) throws NumberFormatException, IOException  {

    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	T = Integer.parseInt(br.readLine());
    	StringTokenizer st;
    	for(int testcase = 1; testcase <= T; testcase++) {
    		st = new StringTokenizer(br.readLine());
    		N = Integer.parseInt(st.nextToken());
    		k = r = c = 0;
    		for(int i = 1; i<= N; i++) {
    			checkr[i] = checkc[i] = false;
    			for(int j = 1; j<= N ; j++) check1[i][j] =  check2[i][j] = false;
    		}
    		for(int i = 1; i <= N; i++) {
        		st = new StringTokenizer(br.readLine());
        		for(int j = 1; j <= N; j++) {
        			map[i][j] = Integer.parseInt(st.nextToken());
            		if(i==j) k = k + map[i][j]; 
        			if(check1[i][map[i][j]]) {
        				checkr[i] = true;
        			}else {
        				check1[i][map[i][j]] = true;
        			}
        			if(check2[j][map[i][j]]) {
        				checkc[j] = true;
        			}else {
        				check2[j][map[i][j]] = true;
        			}
        		}
        	}
    		for(int i = 1; i <=N; i++) {
    			if(checkr[i]) r++;
    			if(checkc[i]) c++;
    		}
    		System.out.println("Case #" + testcase + ": " + k + " " + r + " " + c );
    	}
    	
    }
    
}