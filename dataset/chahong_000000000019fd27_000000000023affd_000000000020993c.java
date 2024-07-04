
import java.util.*;
import java.io.*;
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int n = sc.nextInt();
		int t;
		int crossSum =0;
		int[][] matrix;
		int num;
		int[] colsum;
		int[] rowsum;
		boolean rowcheck =false;
		boolean colcheck = false;
		int row=0, col=0;
		for(int i=0; i<n;i++){
		    t = sc.nextInt();
		    crossSum=0;
		    row=0;
		    col=0;
		    matrix=new int[t+1][t+1];
		    for(int j=0;j<t;j++){
		        for(int k=0;k<t;k++){
		            num = sc.nextInt();
		            matrix[j][k]=num;
		            if(j==k){
		                crossSum+=num;
		            }
		        }
		    }
		    for(int j=0;j<t;j++){
		        colsum= new int[t+1];
		        rowsum= new int[t+1];
		        rowcheck = false;
		        colcheck = false;
		        for(int k=0;k<t;k++){
		        	rowsum[matrix[j][k]]++;
		        	colsum[matrix[k][j]]++;
		        	if(rowsum[matrix[j][k]]>=2 && !rowcheck) {
		        		row++;
		        		rowcheck= true;
		        	}
		        	if(colsum[matrix[k][j]]>=2 && !colcheck) {
		        		col++;
		        		colcheck= true;
		        	}
		        }
		    }
		    System.out.println("Case #" + (i+1) + ": " +(crossSum) + " " + (row) + " " + (col));
		    
		}
		

	}

}
