import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Solution {


	static Solution sol = new Solution();
	private static long launch = 0;

	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);  // Create a Scanner object
		int T = scann.nextInt();


		for(int usease = 0; usease< T;usease++) {
			long A = scann.nextInt(); //Number of activitie
			long B = scann.nextInt(); 

			long X = ThreadLocalRandom.current().nextLong(-1_000_000_000, -1_000_000_001);
			long Y = ThreadLocalRandom.current().nextLong(-1_000_000_000, -1_000_000_001);
			
			while(!send(scann, X, Y).contentEquals("MISS")) {
				X = ThreadLocalRandom.current().nextLong(-1_000_000_000, -1_000_000_001);
				Y = ThreadLocalRandom.current().nextLong(-1_000_000_000, -1_000_000_001);
			}
			
			findPoint(scann,X,Y,A);
			



		}


	}

	private static void findPoint(Scanner scann,long x,long y, long step) {

		long hitX = x;
		boolean shootAgain = true;
		x += step;
		
		while(shootAgain) {
			String response =send(scann,x,y);
			if(response.contentEquals("HIT")) {
				x += step;
				hitX = x;
			}
			else if(response.contentEquals("MISS")) {
				step = -step /2;
				x +=step;
				if(Math.abs(x-hitX)==1) {
					x = hitX;
					shootAgain = false;
				}
			}
			else if(response.contentEquals("CENTER")) {
				return;
			}
		}
		
		// premier point X , Y 
		
		//Trouver y2
		long y2 = findY2(scann, x, y, step);
		long x2 = findX2(scann, x, y2, step);
		
		
		
		long centerX = (x +x2)/2 ;
		long centerY = (y +y2)/2 ;
		String response =send(scann,centerX,centerY);
		if(response.contentEquals("CENTER")) 
			return;
		
	}

	private static long findY2(Scanner scann, long x, long y, long step) {
		boolean shootAgain;
		long x2 =	x;
		long y2 = y + step;
		long y3 = y - step;
		shootAgain = true;
		boolean y2Ok = false;
		boolean y3OK = false;
		String response1 =send(scann,x2,y2);
		String response2 =send(scann,x2,y3);
		while(shootAgain) {
			
			if(response1.contentEquals("MISS")) {
				shootAgain = false;
				y2 -= step;
				y2Ok = true;
				
			}
			else if(response2.contentEquals("MISS")) {
				shootAgain = false;
				y3+=step;
				y3OK = true;
				
			}
			else {
				y2 += step;
				y3 -= step;
				 response1 =send(scann,x2,y2);
				 response2 =send(scann,x2,y3);
			}
		}
		if(y2Ok) {
			return y2;
		}
		else if(y3OK) {
			return y3;
		}
		return -1_000_000_001;
	}
	private static long findX2(Scanner scann, long x, long y, long step) {
		boolean shootAgain;
		long y2 =	y;
		long x2 = x + step;
		long x3 =	x - step;
		shootAgain = true;
		boolean x2Ok = false;
		boolean x3OK = false;
		String response1 =send(scann,x2,y2);
		String response2 =send(scann,x3,y2);
		while(shootAgain) {
			
			if(response1.contentEquals("MISS")) {
				shootAgain = false;
				x2 -= step;
				x2Ok = true;
				
			}
			else if(response2.contentEquals("MISS")) {
				shootAgain = false;
				x3+=step;
				x3OK = true;
				
			}
			else {
				x2 += step;
				x3 -= step;
				 response1 =send(scann,x2,y2);
				 response2 =send(scann,x3,y2);
			}
		}
		if(x2Ok) {
			return x2;
		}
		else if(x3OK) {
			return x3;
		}
		return -1_000_000_001;
	}
	private static String send(Scanner scann, long X, long Y) {
		System.out.print(X+" "+Y);
		launch++;
		System.out.flush();
		String response = scann.next();
		if(response.contentEquals("WRONG"))	System.exit(0);
		return response;
	}






}
