import java.util.Scanner;
public class Solution {
     public static void main(String args[]){
         Scanner s = new Scanner(System.in);
         int N=s.nextInt();
        for (int count=0;count<N;count++)  {

  	int size = s.nextInt();
  	int array[][]=new int[size][size];
	int sum = 0;
        int r =0;
        int c =0;
 	for(int i = 0; i < size; i++)
  	{
   	    for(int j = 0; j < size; j++) 
     	    {
      	        array[j][i] = s.nextInt();
               
     	    }
        }
	
        
  	for(int i = 0; i < size; i++)
  	{  
    	    for(int j = 0; j < size; j++)
       	    {
                if(i == j)
            	 {
               	     sum = sum + (array[i][j]);
               	 }
            }
        }
        // row check 
         int k = 0;
         while(k<size){
        for (int i = 1; i <size; ++i) { 
             
               int pointer = array[i][k];
               int j = i - 1; 
  
            
            while (j >= 0  ) { 
                if(array[j][k] == pointer){
                r=r+1;                 
                break;
                }
              
                j = j - 1; 
                
            } 
            if (j<0){
                j=0;
                }
       if(array[j][k] == array[i][k]){
       break;
       }
        }
         k++;
         }
         //collumn check
         int l = 0;
         while(l<size){
        for (int i = 1; i <size; ++i) { 
             
               int pointer = array[l][i];
               int j = i - 1; 
  
            
            while (j >= 0  ) { 
                if(array[l][j] == pointer){
                c=c+1; 
                 break;
                }
              
                j = j - 1; 
                
            } 
            if (j<0){
                j=0;
                }
       if(array[l][j] == array[l][i]){
           break;
       }
        }
         l++;
         }
        
        
        System.out.println("Case #"+count+": "+sum+" "+r+" "+c);  
        
    }
     }
}



