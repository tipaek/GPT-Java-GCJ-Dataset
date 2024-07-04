import java.util.*;
public class Solution{
    public static int col(int[][] square,int n){
		int colcount = 0;
        for(int i=0 ;i<n; i++){
			HashSet<Integer> colcheck = new HashSet();
			for(int j=0; j<n; j++){
				int x = new Integer(square[j][i]);
				colcheck.add(x);
			}
			if(colcheck.size()<n) colcount++;
		}
		return colcount;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
		int s = 1;
        while(s<=t){
            int n = sc.nextInt();
            int[][] square = new int[n][n];
            int sum = 0;
			int rowcount = 0;
            for(int i=0; i<n; i++){
				HashSet<Integer> rowcheck = new HashSet();
				for(int j=0; j<n; j++){
                square[i][j] = sc.nextInt();
				Integer x = new Integer(square[i][j]);
				rowcheck.add(x);
                if(i==j) sum+=square[i][j];
              }
			  if(rowcheck.size()<n) rowcount++;
			}
            int colcount = col(square,n);
			System.out.println("Case #"+s+": "+sum+" "+rowcount+" "+colcount);
            s++;
        }
    }
}
