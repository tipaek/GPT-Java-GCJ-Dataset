import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Solution{
	public static void main(String[] args) {
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		Integer cases = sc.nextInt();
		
		ArrayList<String> matrix = new ArrayList<String>();
		for (int i = 0; i < cases; i++) {
			int matrixSize = sc.nextInt();
			
			int[][] arr= new int[matrixSize][matrixSize];
			for (int j = 0; j < matrixSize; j++) {
	            for (int k = 0; k< matrixSize; k++) {
	               
	                arr[j][k] = sc.nextInt();
	            }
	            sc.nextLine();
	            
	        }
			
			Integer trace=0;
			Integer duplicateRow=0;
			Integer duplicateCol=0;
			Boolean flag1=false;
			Boolean flag2=false;
			for (int j = 0; j < matrixSize; j++) {
				for (int k = 0; k< matrixSize; k++) {
					
		            if(j==k) {
		            	trace=trace+arr[j][k];
		            }
		            int num = arr[j][k];
		           if(flag1==false) {
		            for (int otherCol = k + 1; otherCol < matrixSize; otherCol++)
		            {
		                if (num == arr[j][otherCol])
		                {
		                	duplicateRow++;
		                	 flag1=true;
		                	 break;
		                }
		                
		               
		            }}
		            int num2 = arr[k][j];
		            if(flag2==false) {
		            for (int otherCol = k + 1; otherCol < matrixSize; otherCol++)
		            {
		                if (num2 == arr[otherCol][j])
		                {
		                	duplicateCol++;
		                	flag2=true;
		                	break;
		                }
		               
		            }}
		        
	            }
				  flag1=false;
				  flag2=false;
			}
			
			matrix.add(trace.toString()+" "+duplicateRow.toString()+" "+duplicateCol.toString());
			
		}
		sc.close();
		
		for (int i = 0; i <cases; i++) {
			System.out.println("Case #"+(i+1)+": "+matrix.get(i));
		}
    }
		
		
	}
		

