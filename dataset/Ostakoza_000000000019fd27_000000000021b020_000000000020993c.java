
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;


public class Solution {
	
	
	
	
	
	    static ArrayList<Integer> array= new ArrayList<Integer>();
	    static int enumerator =1;
	    static ArrayList<Integer> array2= new ArrayList<Integer>();

	    static String answer="";
	    public static  void getcolumne(int[][] matrix)
	    {	int Stringer=0;
	         for(int i =0;i<matrix.length;i++)
	         {
	 	          
	 	        boolean yes=true;
	 	       for(int j =0;j<matrix.length;j++)
	             {
	            	 
	            	 for(int k =j+1;k<matrix.length;k++)
	            	 {
	            		 if(matrix[i][j]==matrix[i][k] && yes == true)
	 	                {
	 	                    Stringer=Stringer+1;
	 	                    yes=false;
	 	                    break;
	 	                  
	 	                    
	 	                }

	 	             }
	     	 	        array2.add(Stringer);

	            	 }
	                
		        

	         }
	 	        answer=answer+" "+Stringer+"\n";
	 	        
	 	        array.clear();
	    }
	    
	    
	    public static  void getrow(int[][] matrix)
	    {	 	        int  Stringer=0;

	         for(int i =0;i<matrix.length;i++)
	         {

	 	        boolean yes= true;
	             for(int j =0;j<matrix.length;j++)
	             {
	            	 
	            	 for(int k =j+1;k<matrix.length;k++)
	            	 {
	            		 if(matrix[j][i]==matrix[k][i] && yes==true)
	 	                {
	 	                    Stringer=Stringer+1;
	 	                   yes=false;
	 	                    break;
	 	                }

	 	             }

	     	 	        array2.add(Stringer);

	            	 }
	                
		        
		        

	 	     

	         }
	         
	 	        answer=answer+" "+Stringer;
	 	        array.clear();;
	    }
	    
	    
	    
	    public static  void getdiag(int[][] matrix)
	    {	int  Stringer=0;
	         for(int i =0;i<matrix.length;i++)
	         {
	 	        

	            Stringer= Stringer+matrix[i][i];
	 	      
	 	        

	         }
	 	        answer=answer+" "+Stringer;

	    }
	    
	    public	static int getLargest(ArrayList<Integer> array)
	    {	
	    	
	    	
	    	int greater=0;
	    	for(int i=0; i+1<array.size();i++)
	    	{	if(i==0) 
	    		{
	    			greater=array.get(i);
	    		}
	    		if(greater<array.get(i+1))
	    		{
	    			greater=array.get(i+1);
	    		}
	    		
	    	}
	    	return greater;
	    }
	    
	    
	    
	    
	    
	    
	    public static void main (String args[])
	    {
	    	
	    	 Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
	    	    String t = in.nextLine();
					

			
			
			
			
			int Numberoftestcases= Integer.parseInt(t);
			
			for(int i=1; i<=Numberoftestcases;i++)
			{
			    answer = answer+"Case #" +i+":";
			    int matrixsize = Integer.parseInt(in.nextLine()); 
			    int [][] matrix = new int[matrixsize][matrixsize];
			    
			    enumerator++;
			    int l =0;
			    for(int j =0;j<matrixsize;j++)
			    {
			        String[] row=in.nextLine().split(" ");
			        enumerator++;
			        for(int k=0;k<matrix.length ;k++)
			        {
			        	matrix[k][l]=Integer.parseInt(row[k]);
			        }
			        l++;
			        
			    }
			    getdiag(matrix);
			    getrow(matrix);

			    getcolumne(matrix);
			    
			}
	        
	        System.out.println(answer);
	        
	        
	        
	        
	    }
	    
	    
	    
	    
	    
	    
	
}
