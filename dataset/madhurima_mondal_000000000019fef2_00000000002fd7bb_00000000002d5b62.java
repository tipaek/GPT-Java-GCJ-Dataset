
import java.util.Scanner;

public class Solution {
	String moves = "NSEW";
	int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
	String res= "IMPOSSIBLE";
	private void directions(int jumpcount, String curr, int x, int y,int currx, int curry, int currjumpcount) {
		
		if(curr.length()==jumpcount && currx==x && curry==y) {
			res = curr;
			return;
		}
		else if(curr.length()>jumpcount)
			return;
		else {
			String currdir="";
			for(int i = 0;i<moves.length();i++) {
				if(!res.contentEquals("IMPOSSIBLE"))
					break;
				char c = moves.charAt(i);
				currx += dir[i][0]* Math.pow(2, currjumpcount);
				curry += dir[i][1]* Math.pow(2, currjumpcount);
				directions(jumpcount, curr+c,x,y,currx,curry,currjumpcount+1);
				currx -= dir[i][0]* Math.pow(2, currjumpcount);
				curry -= dir[i][1]* Math.pow(2, currjumpcount);
			}
//			
//			return currdir;
		}

	}
	private String findDirections(int x,int y) {
		res= "IMPOSSIBLE";
		int totalmoves = Math.abs(x)+Math.abs(y);
		int sum= 0;
		int jumpcount= 0;
		while(sum<totalmoves) {
			sum += Math.pow(2, jumpcount);
			jumpcount++;
		}
			 directions(jumpcount,"",x,y,0,0,0);
			 return res;
	}
	public static void main(String args[]){
		Solution sol = new Solution();
		Scanner  sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int i=1;i<=t;i++) {
			
		    int x = sc.nextInt();
		    int y = sc.nextInt();
		    System.out.println("Case #"+i+": "+sol.findDirections(x,y));
			
		}
		sc.close();
				
	    }
}
