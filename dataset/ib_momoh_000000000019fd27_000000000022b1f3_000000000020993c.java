import java.util.*;
import java.io.*;
public class Solution {
	public static void main(String[] args) {
	
	
		 Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testcase = in.nextInt();  
       
        
        for(int i = 0 ; i< testcase ; i++){
            int matrixLength = in.nextInt();
           
            int [][]  matrix = new int[matrixLength][matrixLength];
            
            for(int k =0; k < matrixLength; k++){
                for(int y = 0 ; y< matrixLength; y++){
                 matrix[k][y] = in.nextInt();
                }
            }
            
             System.out.println("Case #"+ (i+1) + ": " + sumoftrace(matrix) + " " + rowWithRepeat(matrix)+ " " 
             + columnWithRepeat(matrix));
            
            
        }
        
    
	}
	
	
	public static int sumoftrace(int[][] matrix){
	    
	   int sum = 0; 
	    for(int i = 0; i< matrix.length; i++){
	      sum+=matrix[i][i];  
	    }
	    
	    return sum;
	}
	
	
		public static int rowWithRepeat(int[][] matrix){
		    int repeats = 0;
		    
		  for(int k =0; k < matrix.length; k++){
		      Set<Integer> rows = new HashSet<>();
                for(int y = 0 ; y< matrix.length; y++){
                    if(rows.contains(matrix[k][y])){
                        repeats++;
                        break;
                    }
                    rows.add(matrix[k][y]);
                }
              
            } 
            
            return repeats;
		}
		
		
		public static int columnWithRepeat(int[][] matrix){
		    int repeats = 0;
		    
		  for(int k =0; k < matrix.length; k++){
		      Set<Integer> rows = new HashSet<>();
                for(int y = 0 ; y< matrix.length; y++){
                    if(rows.contains(matrix[y][k])){
                        repeats++;
                        break;
                    }
                    rows.add(matrix[y][k]);
                }
              
            } 
            
            return repeats;
		}
}