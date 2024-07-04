
import java.util.*;
public class Trace
{
    public static void main(String args[])
    {
        int array[][]=new int[10][10];
        int i, j;
        double sum = 0, square = 0, result = 0;
  	System.out.println("Enter total rows and columns: ");
  	Scanner s = new Scanner(System.in);
  	int row = s.nextInt();
  	int column = s.nextInt();
	System.out.println("Enter matrix:");
 	for(i = 0; i < row; i++)
  	{
   	    for(j = 0; j < column; j++) 
     	    {
      	        array[i][j] = s.nextInt();
                System.out.print(" ");
     	    }
        }
	System.out.println("Tohe entered Matrix is :");
 	for(i = 0; i < row; i++)
        {
      	    for(j = 0; j < column; j++)
            {
         	System.out.print(array[i][j]+" ");
            }
            System.out.println(" ");
    	}
        System.out.println("The Trace of the above matrix is ");
  	for(i = 0; i < row; i++)
  	{  
    	    for(j = 0; j < column; j++)
       	    {
                if(i == j)
            	 {
               	     sum = sum + (array[i][j]);
               	 }
            }
        }
        System.out.println(sum);  
    }}