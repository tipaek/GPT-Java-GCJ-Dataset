import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
        int numTestCase = in.nextInt();
        int []X = new int[numTestCase];
        int []Y = new int[numTestCase];
        String []M = new String[numTestCase];
        for (int i = 0; i < numTestCase; ++i) {
        	X[i] = in.nextInt();
        	Y[i] = in.nextInt();
        	M[i] = in.next();
        }
        in.close();
        for (int i = 0; i < numTestCase; i++) {
        	System.out.print("Case #" + (i + 1) + ": ");
        	run(X[i], Y[i], M[i]);
        }
	}
	
	static void run(int x, int y, String m) {
		int min = Integer.MAX_VALUE;
		
		for(int i = 0; i < m.length(); i++){
			if(m.charAt(i) == 'S'){
				y --;
			}
			else if(m.charAt(i) == 'N'){
				y ++;
			}
			else if(m.charAt(i) == 'W'){
				x --;
			}
			else if(m.charAt(i) == 'E'){
				x ++;
			}
			
			if(i + 1 >= Math.abs(x) + Math.abs(y)){
				min = Math.min(min, i + 1);
			}
		}
		
		if(min == Integer.MAX_VALUE){
			System.out.println("IMPOSSIBLE");
		}
		else{
			System.out.println(min);
		}
	}
}	