public class Solution{
    public static void main(String[] arg){
		java.util.Scanner input = new java.util.Scanner(System.in);
		int t = input.nextInt();
		for(int x=1; x<=t; x++) {
			int n = input.nextInt();
			int k=0,r=0, c=0;
			boolean[][] arrR = new boolean[n][n];
			boolean[][] arrC = new boolean[n][n];
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					int temp = input.nextInt();
					if(i==j)
						k += temp;
					arrR[i][temp-1] = true;
					arrC[j][temp-1] = true;
				}
			}
			for(int i=0; i<n; i++)
				for(int j=0; j<n; j++)
					if( !arrR[i][j] ) {
						r++;
						break;
					}
			for(int i=0; i<n; i++)
				for(int j=0; j<n; j++)
					if( !arrC[i][j] ) {
						c++;
						break;
					}
			System.out.println("case #"+x+": "+k+" "+r+" "+c);
		}
		input.close();
	}
}