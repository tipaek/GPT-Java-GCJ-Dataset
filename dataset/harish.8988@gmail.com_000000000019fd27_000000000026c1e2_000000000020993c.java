import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution
{
	public static void main(String[] args)
	{		
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
	    byte t = in.nextByte();
	    byte N;
	    byte [][]matrix;
	    byte []rows;
	    byte []cols;
	    
	    byte prevRow, prevCol, row, col;
	    
	    int sum;
	    
	    for (byte z = 1; z <= t; z++) 
	    {
	    	N = in.nextByte();
	    	
	    	matrix = new byte[N][N];
	    	prevRow = prevCol = row = col = 0;
	    	sum = 0;
	    	
	    	for(byte i=0; i<N; i++)
	    		for(byte j=0; j<N; j++)
	    			matrix[i][j] = in.nextByte();
	    	
	    	for(byte i=0; i<N; i++)
	    	{
	    		rows = new byte[N+1];
		    	cols = new byte[N+1];
		    	
	    		for(byte j=0; j<N; j++)
	    		{ 			
	    			if( rows[matrix[i][j]] == 0 )
	    				rows[matrix[i][j]] = 1;
	    			
	    			else if(prevRow+1 != row)
	    			{
	    				prevRow = row;
	    				row++;
	    			}
	    			
	    			if( cols[matrix[j][i]] == 0)
	    				cols[matrix[j][i]] = 1;
	    			
	    			else if(prevCol+1 != col)
	    			{
	    				prevCol = col;
	    				col++;
	    			}
	    		}
	    		
	    		sum += matrix[i][i];
	    		prevRow = row;
	    		prevCol = col;
	    	}
	    	
	    	System.out.println("Case #"+z+": "+sum+" "+row+" "+col);
	    }   	
	}
}