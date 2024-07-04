import java.util.*;
public class main
{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int p =1; p<=t; p++)
		{
		    int n = sc.nextInt();
		    int matrix[][] = new int[n][n];
		    int k = 0;
		    for(int i=0;i<n;i++){
		        for(int j=0;j<n;j++){
		            matrix[i][j] = sc.nextInt();
		            if(i == j){
		                k = k+matrix[i][j];
		            }
		        }
		    }
		    int r = 0;
		    int c = 0;
		    for(int i=0;i<n;i++){
		        HashSet<Integer> set = new HashSet<Integer>();
		        for (int j=0; j < n; j++) {
                   if (set.contains(matrix[i][j])){
                       r++;
                   }
                   set.add(matrix[i][j]);
		        }
		    }
		    for(int i=0;i<n;i++){
		        HashSet<Integer> set = new HashSet<Integer>();
		        for (int j=0; j < n; j++) {
                   if (set.contains(matrix[j][i])){
                       c++;
                   }
                   set.add(matrix[j][i]);
		        }
		    }
		    System.out.println("Case #"+p+": "+k+" "+r+" "+c);
		}
	}
}