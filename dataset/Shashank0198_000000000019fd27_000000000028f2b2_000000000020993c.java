
import java.util.Scanner;

 
public class trace {
	public static void main(String args[])
    {
        int array[][]=new int[10][10];
        int i, j;
        int a,b;
       
int sum=0;
int count=0;
        System.out.println("Enter total cases");
  	Scanner sc=new Scanner(System.in);
	int t=sc.nextInt();
  	while(t != 0)
  	{
    System.out.println("Enter size of array");
    int n=sc.nextInt();
  	
  	int row = n;
  	int column = n;
	System.out.println("Enter matrix:");
 	for(i = 0; i < row; i++)
  	{
   	    for(j = 0; j < column; j++) 
     	    {
      	        array[i][j] = sc.nextInt();
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

    for(i = 0; i < row;i++ )
  	{ 
     
    	    for(j = 0; j < column; j++)
       	    {a =array[i][0];
                if( a== array[i][j+1] || array[i][j]== array[i][j+1]){
				count+=1;
				
				break;
				} 
				
            }
    	    
        }
    System.out.println(count);
	count=0;
    
        
    
   for(i = 0; i < row; i++)
  	{ 
    
    	    for(j = 0; j < column; j++)
       	    { b=array[0][i];
                if(b == array[j+1][i] || array[j][i] == array[j+1][i])
                {
				count+=1;
				
				break;
				} 
                
				
            }
    	   
        }
    System.out.println(count);
    
      t--;  
  	}
  	sc.close();
    } 

}
