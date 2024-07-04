import java.io.*;
import java.util.*;
public class first{
  public static void main(String[] args) throws IOException{
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    boolean[] checkr;
    boolean[] checkc;
    int tot = t;
    while(t-->0) {
    	int totalr = 0;
    	int totalc = 0;
    	boolean ar = false;
    	boolean ac = false;
    	int a = sc.nextInt();
    	int[][] board = new int[a][a];
    	checkr = new boolean[a+1];
    	checkc = new boolean[a+1];
    	int r = 0;
    	int c = 0;
    	for(int i=0; i<a; i++) {
    		Arrays.fill(checkr, false);
    		ar = false;
    		for(int j=0; j<a; j++) {
    			int next = sc.nextInt();
    			if(checkr[next] == true&&!ar) {
    				ar = true;
    				totalr++;
    			}
    			checkr[next] = true;
    			board[i][j] = next;
    		}
    	}
    	for(int i=0; i<a; i++) {
    		Arrays.fill(checkc, false);
    		ac = false;
    		for(int j=0; j<a; j++) {
    			int next = board[j][i];
    			if(checkc[next] == true&&!ac) {
    				ac = true;
    				totalc++;
    			}
    			checkc[next] = true;
    		}
    	}
    	int sum = 0;
    	for(int i=0; i<a; i++) {
    		sum+=board[i][i];
    	}
    	System.out.println("Case #"+(tot-t-1)+": " +sum  + " " + totalr + " " + totalc);
    }
    sc.close();
  }
}