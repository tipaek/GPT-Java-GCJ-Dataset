import java.util.Scanner;
class Main{
    public static void main(String args[]){
       Scanner sc=new Scanner(System.in); 
       int T=sc.nexInt();
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
	System.out.println("The entered Matrix is :");
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
  }
}