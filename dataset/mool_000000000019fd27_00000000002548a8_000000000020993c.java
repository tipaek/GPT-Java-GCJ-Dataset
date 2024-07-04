import java.util.HashSet;
import java.util.Scanner;

public class Solution{
	static Scanner s=new Scanner(System.in);
	static int rowcount;
	static int columncount;
	static int add;
	public static void main(String args[]){
		int nofarr,n;
		nofarr=s.nextInt();
		for(int i=0;i<nofarr;i++) {
			rowcount=0;
			columncount=0;
			n=s.nextInt();
			takeInput(n,i);
		}
	}
	static void takeInput(int n,int caseno){
		int temp,i,j,k=0;
        int mat[][] = new int[n][n];  
        for(j=0;j<n;j++) {
        	for(k=0;k<n;k++) {
        	        if (s.hasNextInt())
        	        		mat[j][k]=s.nextInt();
        	        else 
        	            s.next();
        	}
        }
        add=0;
        for (i = 0; i < n; i++) { 
            		add=mat[i][i]+add;
        }
        rowcount=0;
        columncount=0;
        for(i=0;i<n;i++) {
        	noDupesinRow(mat,i,n);
        }
        
		printCase(add,caseno+1);
	}
	static void noDupesinRow(int[][] array,int row,int n) {
	        HashSet<Integer> rowset = new HashSet<Integer>();
	        int j=0;
	        for (j=0; j < array.length; j++) {
	            rowset.add(array[row][j]);
	        }
	        if(rowset.size()<n) {
            	rowcount++;
	        }
	        rowset=new HashSet<Integer>();
	        for (j=0; j < array.length; j++) {
	            rowset.add(array[j][row]);
	        }
	        if(rowset.size()<n) {
            	columncount++;
	        }
	}
	static void printCase(int sum,int n){
        System.out.println("Case #"+n+": "+sum+" "+rowcount+" "+columncount);
	}
}