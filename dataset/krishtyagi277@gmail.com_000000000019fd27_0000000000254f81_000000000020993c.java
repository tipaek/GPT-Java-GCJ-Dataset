import java.util.*;
public class Solution{
    
    public static void main(String args[]){
        
       Scanner sc = new Scanner(System.in);
       int testCase = sc.nextInt();
       for(int i=1;i<=testCase;i++){
           int size = sc.nextInt();
           int matrix[][] = new int[size][size];
           int row=0, col=0, count=0, trace=0;
          for(int j=0;j<size;j++){
              count = 0;
              Set<Integer> set = new HashSet<Integer>();
              for(int k=0;k<size;k++){
                  matrix[j][k] = sc.nextInt();
                  int value = matrix[j][k];
                  if (set.contains(value) && count==0)
			         count++;

	               if (count==0)
		        	set.add(value);
		        	
		        	if(j==k)
		        	trace+=value;
              }//first for loop ends
              row+=count;
          }//second for loop end
          
          for(int j=0;j<size;j++){
              count=0;
             Set<Integer> set = new HashSet<Integer>();
             for(int k=0;k<size;k++){
                 if (set.contains(matrix[k][j])){
			         count++;
			         break;
                 }

	             	set.add(matrix[k][j]);
             }//for loop for col
             col+=count;
          }//for loop for col
          
          System.out.println("case #"+i+": "+trace+" "+row+" "+col);
       }//main for loop
    }
}