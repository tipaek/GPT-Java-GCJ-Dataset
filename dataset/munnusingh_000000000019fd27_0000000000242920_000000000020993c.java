import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Vestigium {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
    
		Scanner s = new Scanner(System.in);
		
		
		int T= s.nextInt();
		for(int t=1;t<=T;t++) {
			
			
			int N= s.nextInt();
			int [][]mat= new int[N][N];
			for(int r=0;r<N;r++) {
				for(int c=0;c<N;c++) {
					mat[r][c]=s.nextInt();
				}
			}
			calculateRes(t,N,mat);
			
		}
	}
	public static void calculateRes(int t,int n,int[][]mat) {
		Set<Integer> setRow= new HashSet();
		Set<Integer> setCol= new HashSet();
		int trace=0;
		
	    int rowsWithDups=0;
		int columnsWithDups=0;
		
		for(int r=0;r<n;r++)
		{
			for(int c=0;c<n;c++) {
				if(r==c)
				trace= trace+ mat[r][c];
				setRow.add(mat[r][c]);
				setCol.add(mat[c][r]);
			}
			if(setRow.size()<n) {
				rowsWithDups++;
			}
			if(setCol.size()<n) {
				columnsWithDups++;
			}
			setRow.clear();
			setCol.clear();
		}
		System.out.println("Case #"+t+": "+trace+" 	"+rowsWithDups+" "+columnsWithDups);
	}

}
