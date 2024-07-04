import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class Vestigium {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner input_text = new Scanner(System.in);
		int case_runs      = input_text.nextInt();
		for(int xx=1 ; xx <= case_runs ; xx ++)
		{
			int size_of_matrix = input_text.nextInt() ;
			int[][] matrix_box = new int[size_of_matrix][size_of_matrix] ;
				
			for(int i = 0 ;i < size_of_matrix ; i ++)
			{
				for(int j=0 ; j < size_of_matrix ; j++)
				{
					matrix_box[i][j] = input_text.nextInt();
				}
			}
		
			int trace_value = trace_value(matrix_box, size_of_matrix) ;		
			int repeating_row = check_row_repeater(matrix_box, size_of_matrix);
			int repeating_column = check_column_repeater(matrix_box, size_of_matrix);
			
			System.out.println("Case #"+xx+": "+trace_value+" "+repeating_row+" "+repeating_column);
		
		}
	}
	
	static int trace_value(int matrix_box[][],int size_of_matrix)
	{
		int sum = 0; 
	    for (int i=0; i<size_of_matrix; i++) 
	        sum += matrix_box[i][i]; 
	    return sum; 		
	}
	
	static int check_row_repeater(int matrix_box[][],int size_of_matrix)
	{
		int repeating_row = 0;
		ArrayList arrayrow = new ArrayList();
		for(int i = 0 ; i < size_of_matrix ; i++)
		{
			arrayrow.removeAll(arrayrow);
			for(int j=0 ; j < size_of_matrix ; j++)
			{
				if(arrayrow.contains(matrix_box[i][j]))
				{
					repeating_row ++ ;
					break ; 
				}
				arrayrow.add(matrix_box[i][j]);
			}
		}
		
		return repeating_row;
	}
	
	static int check_column_repeater(int matrix_box[][],int size_of_matrix)
	{
		int repeating_column = 0 ;
		ArrayList arrayrow = new ArrayList();
		
		for(int i = 0 ; i < size_of_matrix ; i++)
		{	
			arrayrow.removeAll(arrayrow);
			for(int j=0;j<size_of_matrix;j++)
			{
				if(arrayrow.contains(matrix_box[j][i]))
				{
					repeating_column ++ ;
					break;
				}
				arrayrow.add(matrix_box[j][i]);
			}
		}
		
		return repeating_column; 
	}

}
