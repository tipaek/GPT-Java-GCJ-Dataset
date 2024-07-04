import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

	
	static HashSet<Integer> findFactors(int x){
		HashSet<Integer> res = new HashSet<Integer>();
		for(int j = 0; Math.pow(2, j) <= x; j++){
			if(x % Math.pow(2, j) != 0){
				res.add((int) Math.pow(2, j-1));
				x-=Math.pow(2,j-1);
			}
			if(x==Math.pow(2,j)){
				res.add((int) Math.pow(2, j));
			}
		}
		return res;
	}
	
    public static void main(String[] args) throws IOException {
    	
    	Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int i = 1; i <= T; i++){
			int X = sc.nextInt();
			int Y = sc.nextInt();
			int signX = 0;
			int signY = 0;
			if(X!=0)
				signX = X/Math.abs(X);
			if(Y!=0)
				signY = Y/Math.abs(Y);
			int x = Math.abs(X);
			int y = Math.abs(Y);
			/*int k1 = (int)Math.ceil(Math.log(x)/Math.log(2));
			int k2 = (int)Math.ceil(Math.log(y)/Math.log(2));

			int opt2x = (int) (Math.pow(2, k1) - x);
			int opt2y = (int) (Math.pow(2, k2) - y);

			HashSet<Integer> x1 = findFactors(x);
			HashSet<Integer> x2 = findFactors(opt2x);
			HashSet<Integer> y1 = findFactors(y);
			HashSet<Integer> y2 = findFactors(opt2y);*/
			StringBuilder sb = new StringBuilder();
			int j = 0;
			boolean imp = false;
			while((x!= 0 || y!= 0) && !imp){
				int step = (int) Math.pow(2, j);
				
				if(x==step && Math.abs(y)!=step){
					x-=step;
					sb.append('W');
				}else if(x==-step && Math.abs(y)!=step){
					x+=step;
					sb.append('E');
				}else if(y==-step && Math.abs(x)!=step){
					y+=step;
					sb.append('N');
				}else if(y==step && Math.abs(x)!=step){
					y-=step;
					sb.append('S');
				}
				
				else if(x % (step*2) != 0 && y % (step*2) != 0){
					System.out.println("Case #"+i+ ": IMPOSSIBLE");
					imp = true;
				}else if(x % (step*2) != 0){
					//x needs a 1 but y doesn't.
					
					if(y % (step*4)==0){ //y doesn't need a 2
						//make sure x does!
						if((x+step) % (step*4) != 0){//if true, x+step will need a 2
							x+=step;
							sb.append('E');
						}else{
							x-=step;
							sb.append('W');
						}
					}else{
						//make sure x doesn t!
						if((x+step) % (step*4) != 0){//if true, x+step will need a 2
							x-=step;
							sb.append('W');
						}else{
							x+=step;
							sb.append('E');
						}
					}
					
				}else if(y % (step*2) != 0){
					//choose so that in next step neither x or y have same step (i.e. x seet ech brauch eng 2)
					if(x % (step*4)==0){ //y doesn't need a 2
						//make sure x does!
						if((y+step) % (step*4) != 0){//if true, x+step will need a 2
							y+=step;
							sb.append('N');
						}else{
							y-=step;
							sb.append('S');
						}
					}else{
						//make sure x doesn t!
						if((y+step) % (step*4) != 0){//if true, x+step will need a 2
							y-=step;
							sb.append('S');
						}else{
							y+=step;
							sb.append('N');
						}
					}
				}else{
					System.out.println("Case #"+i+ ": IMPOSSIBLE");
					imp = true;
				}
				j++;
			}

			String res = sb.toString();
			if(signX>0){
				String t = res.replace('W', 'X');
				String r = t.replace('E', 'W');
				res = r.replace('X', 'E');
			}
			if(signY>0){
				String t = res.replace('N', 'X');
				String r = t.replace('S', 'N');
				res = r.replace('X', 'S');
			}
			if(!imp)
				System.out.println("Case #"+i+ ": " + res);
		}
        sc.close();
    }
}
