import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		int T;
		
		int A;
		int B;
		
		String answer;
		boolean foundCenter;
		
		//Create stream
		Scanner sc = new Scanner(System.in);
				
		//Reads T
		T=  Integer.parseInt( sc.next() );
		A=  Integer.parseInt( sc.next() );
		B=  Integer.parseInt( sc.next() );
		
		//Do T times
		for(int a=0; a<T; a++) {
		foundCenter=false;	
		
			for(int x=-5; x<=5; x++) {
				for(int y=-5; y<=5; y++) {
					System.out.println(x+" "+y);
					
					answer=sc.next();
					if( answer.equals("CENTER") ) {
						foundCenter=true;
						break;
					}
				}
				if ( foundCenter ) {
					break;
				}
			}	
		}
		
		//Closes stream
		sc.close();
		
	}
}