/*import java.util.*;
import java.io.*;
class Soluctio{
		public static void main(String[] args) {
		Scanner sc=new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int cas=sc.nextInt();
        String [] ou=new String[cas];
		for(int i=0;i<cas;i++){
		int size=sc.nextInt();
		int [][] arr = new int[size][size];
		for(int j=0;j<size;j++){
		for(int k=0;k<size;k++){
		arr[j][k]=sc.nextInt();
		}
		}
		int dia=0;//diagonal(arr);
		int col=0;//coloumn(arr);
		int row=0;//row_num(arr);
		ou[i]="Case #"+i+": "+dia+" "+row+" "+col;

	}
         for(int i=0;i<cas;i++){
           System.out.println(ou[i]);}

}

	private static int row_num(int[][] arr) {
		int count=0;
		for(int k=0;k<arr.length;k++) {
	label:	for(int i=0;i<arr.length;i++) {
			for(int j=i+1;j<arr[0].length;j++) {
				if(arr[k][i]==arr[k][j]) {
					count++;
					//System.out.println(k+" "+i+" "+j);
					break label;
			}
			}
		}
		}
		return count;
	}

	private static int coloumn(int[][] arr) {
		int count=0;
		for(int k=0;k<arr.length;k++) {
	label:	for(int i=0;i<arr.length;i++) {
			for(int j=i+1;j<arr[0].length;j++) {
				if(arr[i][k]==arr[j][k]) {
					count++;
					//System.out.println(k+" "+i+" "+j);
					break label;
			}
			}
			
		}
		}
		return count;
	}
	public static int diagonal(int [][] arr){
		int sum=0;
		for(int i=0;i<arr.length;i++){
		sum=sum+arr[i][i];
		}
		return sum;
    }
}*/
import java.util.*;
    import java.io.*;
    public class Solution {
      public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
          int n = in.nextInt();
          int [][] arr = new int[n][n];
		  for(int j=0;j<n;j++){
		  for(int k=0;k<n;k++){
		    arr[j][k]=in.nextInt();
		}
		}
		int dia=diagonal(arr);
		int col=coloumn(arr);
		int row=row_num(arr);
		System.out.println("Case #"+i+": "+dia+" "+row+" "+col);
          
        }
      }
      public static int diagonal(int [][] arr){
		int sum=0;
		for(int i=0;i<arr.length;i++){
		sum=sum+arr[i][i];
		}
		return sum;
    }
    
    	private static int row_num(int[][] arr) {
		int count=0;
		for(int k=0;k<arr.length;k++) {
	label:	for(int i=0;i<arr.length;i++) {
			for(int j=i+1;j<arr[0].length;j++) {
				if(arr[k][i]==arr[k][j]) {
					count++;
					//System.out.println(k+" "+i+" "+j);
					break label;
			}
			}
		}
		}
		return count;
	}
	
		private static int coloumn(int[][] arr) {
		int count=0;
		for(int k=0;k<arr.length;k++) {
	label:	for(int i=0;i<arr.length;i++) {
			for(int j=i+1;j<arr[0].length;j++) {
				if(arr[i][k]==arr[j][k]) {
					count++;
					//System.out.println(k+" "+i+" "+j);
					break label;
			}
			}
			
		}
		}
		return count;
	}
    }
