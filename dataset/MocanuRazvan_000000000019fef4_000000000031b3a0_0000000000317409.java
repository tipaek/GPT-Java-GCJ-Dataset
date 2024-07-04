import java.util.Scanner;

public class Solution{


	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int nr = scanner.nextInt();
		Integer x[] = new Integer[100];
		Integer y[] = new Integer[100];
		String m[]=new String[100];

		for (int i=0;i<nr;i++) {
			x[i]=scanner.nextInt();
			y[i]=scanner.nextInt();
			m[i]=scanner.next();
		}

		scanner.close();

		
		Integer ok[] = new Integer[100];
		Integer min[] = new Integer[100];
		
		
		
		
		for (int i=0;i<nr;i++) {
			ok[i]=1;
			min[i]=-1;

			int length =m[i].length();
			int xaux=x[i];
			int yaux=y[i];
			int dist=x[i]+y[i];
			
			for (int j=0;j<length;j++) {
				
				if(m[i].charAt(j)=='N') {
					yaux++;
				}
				else if(m[i].charAt(j)=='S') {
					yaux--;
				}
				else if(m[i].charAt(j)=='E') {
					xaux++;
				}
				else if(m[i].charAt(j)=='W') {
					xaux--;
				}
				else {
					ok[i]=0;
				}
				
				if(ok[i]==1) {
					int modulx=xaux,moduly=yaux;
					if (xaux<0)modulx=-xaux;
					if (yaux<0)moduly=-yaux;
					dist = modulx+moduly;
					if (dist<=j+1&&min[i]==-1) {
						min[i]=j+1;
					}
				}
				
			}
			
			
			
			
			int i1=i+1;
			if (ok[i]==0||min[i]==-1)
				System.out.println("Case #"+i1+": IMPOSSIBLE");
			else
				System.out.println("Case #"+i1+": "+min[i]);
		}

	}
}
	