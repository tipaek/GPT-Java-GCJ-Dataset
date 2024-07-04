import java.util.ArrayList;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {

			// TODO Auto-generated method stub
			Scanner sc = new Scanner(System.in);
			int test_cases = sc.nextInt();
			ArrayList<String> results = new ArrayList<String>(test_cases);
			for (int i=0 ; i<test_cases; i++) {
				
				results.add(expg(sc));
			}
			
			test_cases = 1;
			for(String result : results) {
				StringBuilder sb = new StringBuilder();
				sb.append("Case #");
				sb.append(test_cases);
				sb.append(": ");
				sb.append(result);
				System.out.println(sb.toString());
				test_cases++;
			}
	}
	
	public static String expg(Scanner sc) {
		
		int X = sc.nextInt();
		int Y = sc.nextInt();
		
		boolean xneg = false;
		boolean yneg = false;
		
		if(X < 0) {
			xneg = true;
			X = X*-1;
		}
		
		if(Y < 0) {
			yneg = true;
			Y = Y*-1;
		}
		
		int[] bin = new int[31];
		char[] op = null;
		for(int i=0; i<31; i++) {
			bin[i] = (int) Math.pow(2, i);
		}
		
		ArrayList<Integer> xval = new ArrayList<Integer>();
		ArrayList<Integer> yval = new ArrayList<Integer>();
		int bin_val;
		for(int i=0; i<30 ; i++) {
			if( (X & bin[i]) != 0)
				xval.add(i);
		}
		int xcal = 0;
		for(int i : xval) {
			xcal = xcal+bin[i];
		}
		if(xcal !=  X ) {
			System.out.println(1);
			return "IMPOSSIBLE";
		}
		for(int i=0; i<30; i++) {
			if((Y&bin[i]) != 0) {
				//if(!xval.contains(i))
					yval.add(i);
			}
		}
		int ycal = 0;
		
		for(int i : yval) {
			if(!xval.contains(i))
			ycal = ycal+bin[i];
		}
		
		
		if(ycal != Y) {
			int largest = yval.get(yval.size()-1);
			largest++;
			if(xval.contains(largest)) {
				System.out.println(2);
				return"IMPOSSIBLE";}
			int needed = bin[largest]-Y;
			yval.clear();
			for(int i=0; i<30; i++){
				if((needed&bin[i]) != 0) {
					if(!xval.contains(i))
						yval.add(i);
				}
			}
			ycal = 0;
			for(int i : yval) {
				ycal = ycal+bin[i];
			}
			if(ycal != needed) {
				System.out.println(3);
				return "IMPOSSIBLE";}
			
			
			for(int i=0; i<(xval.size()+yval.size()); i++) {
				if(! (xval.contains(i) || yval.contains(i))) {
					System.out.println(4);
					return "IMPOSSIBLE";}
			}
			op = new char[xval.size()+yval.size()+1];
			
			if (!xneg) {
				for(int i : xval) {
					op[i] = 'E';
				}
			}else {
				for(int i : xval) {
					op[i] = 'W';
				}
			}
			
			if (!yneg) {
				for(int i : yval) {
					op[i] = 'S';
				}
				op[largest] = 'N';
				
			}else {
				for(int i : yval) {
					op[i] = 'N';
				}
				op[largest] = 'S';
			}
							
			return (new String(op));	
		}
		
		for(int i=0; i<(xval.size()+yval.size()); i++) {
			if(! (xval.contains(i) || yval.contains(i)))
				return "IMPOSSIBLE";
		}
		op = new char[xval.size()+yval.size()];
		if (!xneg) {
			for(int i : xval) {
				op[i] = 'E';
			}
		}else {
			for(int i : xval) {
				op[i] = 'W';
			}
		}
		
		if(!yneg) {
			for(int i :yval) {
				op[i] = 'N';
			}
		}
		else {
			for(int i :yval) {
				op[i] = 'S';
			}
		}
		
		return (new String(op));
		
	}

}
