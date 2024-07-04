import java.util.HashMap;
import java.util.Scanner;

public class main {

	public static void main(String[] args) {

		Scanner read=new Scanner(System.in);
		int r=0;
		int c=0;
		int trace=0;
		HashMap listR=new HashMap();
		HashMap listC=new HashMap();
		int testCase=read.nextInt();
		int loop=1;
		
		while(loop<=testCase) {
			
			int N=read.nextInt();
			int[][] e=new int[N][N];
			trace=0;
			r=0;
			c=0;
			
			for(int row=0; row<N;row++) {
				for(int col=0; col<N;col++) {
					e[row][col]=read.nextInt();
					
					if(row==col) {
						trace=trace+e[row][col];
					}	
				}
			}
			
			
			for(int col=0; col<N;col++) {
				listC.clear();
				for(int row=0; row<N;row++) {
					
					if(listC.containsKey(e[row][col])) {
						c++;
						break;
					}
					else
						listC.put(e[row][col], e[row][col]);
				}
			}
			
			for(int row=0; row<N;row++) {
				listR.clear();
				for(int col=0; col<N;col++) {
					
					if(listR.containsKey(e[row][col])) {
						r++;
						break;
					}
					else
						listR.put(e[row][col], e[row][col]);
				}
			}
			
			
			System.out.println("Case #"+loop+": "+trace+" "+r+" "+c);
			loop++;
			
		}
		
		read.close();
		
		
	}

}
