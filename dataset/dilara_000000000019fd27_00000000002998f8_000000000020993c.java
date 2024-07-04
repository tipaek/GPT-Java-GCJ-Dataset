import java.util.*;
import java.io.*;
    public class Solution {
    	
    	private static int T;
    	private static List<int[][]> squares;
    	public static void main(String[] args) {
    		readInput('W');
    	  
    		for(int i=0 ; i<T; i++) {
    			int[][] square = squares.get(i);
    			int N = square.length;
    		    int rr = 0;
    		    int rc = 0;
    		    int trace = 0;
    		    
    		    for(int j = 0; j < N; j++) {
    		    	trace+= square[j][j];
    		    }
    		    
    		    for(int j = 0; j < N; j++) {
    		    	Set<Integer> row = new HashSet<Integer>();
    		    	for(int k = 0; k<N; k++) {
    		    		if(!row.add(square[j][k])) {
    		    			rr++;
    		    			break;
    		    		}
    		    	}
    		    }
    		    
    		    for(int j = 0; j < N; j++) {
    		    	Set<Integer> column = new HashSet<Integer>();
    		    	for(int k = 0; k<N; k++) {
    		    		if(!column.add(square[k][j])) {
    		    			rc++;
    		    			break;
    		    		}
    		    	}
    		    }
    		    
    			System.out.println("Case #"+(i+1)+": "+trace+" "+rr+" "+rc);
    			
    			
  		  
  		  
    	  }
  		    
  		    
  		
  	}
  	
  

      private static void readInput(char mode) {
    	  BufferedReader in = null;
    	  if(mode == 'E') {
    		  try {
				in = new BufferedReader(new FileReader("input.txt"));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	  }else {
    		  in = new BufferedReader(new InputStreamReader(System.in));
    	  }
  		
  		
  		try {
  			T = Integer.parseInt(in.readLine());
  			squares = new ArrayList<int[][]>();
  			
  			for(int i=0; i<T; i++) {
  				int N = Integer.parseInt(in.readLine());
  				int[][] square = new int[N][N];
  				for(int j = 0 ; j<N; j++) {
  					String[] row = in.readLine().split(" ");
  					for(int k = 0 ; k<N ; k++) {
  						square[j][k] = Integer.parseInt(row[k]);
  					}
  				}
  				squares.add(square);  				
  			}
  		} catch (NumberFormatException e) {
  			// TODO Auto-generated catch block
  			e.printStackTrace();
  		} catch (IOException e) {
  			// TODO Auto-generated catch block
  			e.printStackTrace();
  		}
  	}
 }