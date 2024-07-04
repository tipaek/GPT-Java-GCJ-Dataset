import java.util.*;
public class Solution{
    public static void main(String[] args){
    Scanner inp = new Scanner(System.in);
    int testCases = inp.nextInt();
    int tc = 1;
    while(tc <= testCases){
        int size = inp.nextInt();
        
        int matrix[][] = new int[size][size];
        int trace = 0;
        
        for(int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++) {
			    
				matrix[i][j] = inp.nextInt();
			    if(i == j) 
			    	trace += matrix[i][j];
				
			}
		}
       
       
		int duprow = 0;
		int dupCol = 0;
		
		for(int i = 0; i < size; i++) {
            Set<Integer> dup = new HashSet<Integer>();
            int j;
			for(j = 0; j < size; j++) {
			    
			    if(dup.contains(matrix[i][j]))
			        break;
			    dup.add(matrix[i][j]);   
			}
			
			if(j != size)
			    duprow++;
		}
		
		ArrayList<Set<Integer>> dupCols = new ArrayList<Set<Integer>>();
		for(int i = 0; i < size; i++) {
			dupCols.add(new HashSet<>());
		}
		for(int i = 0; i < size; i++) {
			
			for(int j = 0; j < size; j++) {
				
			    dupCols.get(j).add(matrix[i][j]);
			       
			}
			
		}
		for(Set<Integer> s: dupCols){
		    if(s.size() < size)
		        dupCol++;
		}
		
		System.out.println("Case #"+tc+": "+trace+" "+duprow+" "+dupCol);
        tc++;
    }
}
}