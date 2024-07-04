    import java.util.HashSet;
    import java.util.Scanner;
    
    public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
    	int testCount = in.nextInt();
        for (int t = 1; t <= testCount; t++) {
        	
        	int n = in.nextInt();
        	String a[][] = new String[n][n];
    		in.nextLine();
    		for(int row = 0; row < n;row++) {
    			a[row] = in.nextLine().split(" ");
    		}
    		
    		checkVestigium(a, n, t);
        }
	}
	
	private static void checkVestigium(String [][] a,int n,int t) {
		int r =0 ,c = 0,k=0;
		for(int i = 0; i < n;i++) {
			k += Integer.parseInt(a[i][i]);
			r += checkRow(a[i], n);
			c += checkCol(a,i, n);
		}
		System.out.println("Case #"+t+": "+k+" "+r+" "+c);
		
	}
	
	private static int checkRow(String []row,int n) {
		HashSet s = new HashSet<>();
		for(int i = 0; i < n ; i++ ) {
			if(s.add(row[i]) == false)
				return 1;
		}
		return 0;
	}
	
	private static int checkCol(String [][]a,int i,int n) {
		HashSet s = new HashSet<>();
		for(int j = 0; j < n ; j++ ) {
			if(s.add(a[j][i]) == false)
				return 1;
		}
		return 0;
	}

}