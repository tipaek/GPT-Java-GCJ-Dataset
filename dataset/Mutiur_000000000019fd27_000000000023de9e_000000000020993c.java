import java.util.*;
class Main
{
    public static void main(String args[])
    {
       
      
  	
  	Scanner s = new Scanner(System.in);
  
      int t = s.nextInt();
  
  
  for(int x=1;x<=t;x++){
  
  	int n = s.nextInt();
  	
        int array[][]=new int[n][n];
	
 	for(int i = 0; i < n; i++)
  	{
   	    for(int j = 0; j < n; j++) 
     	    {
      	        array[i][j] = s.nextInt();
                
     	    }
        }
	
 int sum=0;
  	for(int i = 0; i < n; i++)
  	{  
    	    for( int j = 0; j < n; j++)
       	    {
                if(i == j)
            	 {
               	     sum = sum + (array[i][j]);
               	 }
            }
        }


int r=0;int c=0;
for(int i=0;i<n;i++){
Set<Integer> a = new HashSet<Integer>();

    for(int j=0;j<n;j++){
        a.add(array[i][j]);
    }

if(a.size()<array[i].length)
r++;

} 
for(int i=0;i<n;i++){
Set<Integer> b = new HashSet<Integer>();
int j;
    for( j=0;j<n;j++){
        b.add(array[j][i]);
    }

if(b.size()<array[j-1].length)
c++;

} 
             
System.out.println("Case #"+x+": "+sum+" "+r+ " "+c);

  }
        }
}