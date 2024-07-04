import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		
		int no_of_test_cases=in.nextInt();
		

		int diagonal_value = 0;
		int row_repeated = 0;
		int column_repeated = 0;
		int[][] answers = new int[no_of_test_cases][3];
		
		for(int i=0;i<no_of_test_cases;i++) {	
			int array_dimension=in.nextInt();
			int row=array_dimension;
			int column=array_dimension;
			
			int[][] arr = new int[array_dimension][array_dimension];
			for(int j=0;j<row;j++) {				
				for(int k=0;k<column;k++) {
					arr[j][k] = in.nextInt();
					
				}			
			}
			//print_array(array_dimension,arr);
			column_repeated=row_compare(array_dimension,arr);
			row_repeated=column_compare(array_dimension,arr);
			diagonal_value=diagonal_addition(array_dimension,arr);
			
			answers[i][0]=diagonal_value;
			answers[i][1]=row_repeated;
			answers[i][2]=column_repeated;
			
		}
		
	       for(int i=0; i<(no_of_test_cases); i++)
	       {
	    	   System.out.println("Case #"+(i+1)+": "+answers[i][0]+" "+answers[i][1]+" "+answers[i][2]);        
	           
	       }
		
		in.close();
	}
	

	
	public static int row_compare(int dimension,int[][] arr) {
		int row=dimension;
		int column=dimension;
		int i,j;
		int intArray[]=new int[dimension];
		int repeated_column_count=0;
	    for(i=0; i<column; i++)
	       {
	           for(j=0; j<row; j++)
	           {
	        	   //System.out.println("arr["+j+"]["+i+"]="+arr[i][j]);
	        	   intArray[j]=arr[j][i];
	        	   //System.out.println("intArray["+j+"]="+intArray[j]);
	           }
	           //linrar_array_print(intArray);
	           //System.out.println("\n");
	           repeated_column_count=repeated_column_count+linear_search(intArray);
	       }
	   //System.out.println("repeated_column_count:"+repeated_column_count);
	return repeated_column_count; 
	}
	
	public static int linear_search(int[] arr) {
		int repeated_count=0;
		int element = 0; 
		int count=0;
		for(int i=0;i<arr.length;i++) {			
			element=arr[i];
			for(int j=0;j<arr.length;j++) {			
				if(arr[j]==element) {
					count++;					
				}
				
			}	
			if(count>1) {
				//System.out.println(element+" is repeated");
				repeated_count=1;
			}
			count=0;
		}
		return repeated_count;
	}
	
	public static int column_compare(int dimension,int[][] arr) {	
		int row=dimension;
		int column=dimension;
		int i,j;
		int intArray[]=new int[dimension];
		int repeated_row_count=0;
	       for(i=0; i<row; i++)
	       {
	           for(j=0; j<column; j++)
	           {
	        	   intArray[j]=arr[i][j];
	           }
	          // linrar_array_print(intArray);
	           System.out.println("\n");
	           repeated_row_count=repeated_row_count+linear_search(intArray);
	       }
	       //System.out.println("repeated_row_count:"+repeated_row_count);
		return repeated_row_count; 
	}
	
	
	public static int diagonal_addition(int dimension,int[][] arr) {
		int diagonal_value=0;
		for(int i=0;i<dimension;i++) {
			diagonal_value=diagonal_value+arr[i][i];
		}
		//System.out.println("diagonal_value"+diagonal_value);
		return diagonal_value;
	}
	
	
	public static void print_array(int dimension,int[][] arr) {
		
		int row=dimension;
		int column=dimension;
		int i,j;
		 System.out.print("The Array is :\n");
	       for(i=0; i<row; i++)
	       {
	           for(j=0; j<column; j++)
	           {
	               System.out.print(arr[i][j]+ "  ");
	           }
	           System.out.println();
	       }
	}
	
	public static void linrar_array_print(int[] arr) {
		for (int i = 0; i < arr.length; i++)
			  System.out.println("Element at index " + i + " : "+ arr[i]);
	}
	
}
