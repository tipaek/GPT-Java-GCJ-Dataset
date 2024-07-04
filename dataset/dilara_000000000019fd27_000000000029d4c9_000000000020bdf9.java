import java.util.*;
import java.io.*;
    public class Solution {
    	
    	private static int T;
    	private static List<int[][]> chores;
    	public static void main(String[] args) {
    		readInput('W');
    	  
    		for(int i=0 ; i<T; i++) {
    			int[][] chore = chores.get(i);
    			int N = chore.length;
    		    int[] minutes = new int[1440];
    		    char[] responsible = new char[N];
    		    boolean possible = true;
    		    for(int j = 0 ; j<N; j++) {
    		    	int start = chore[j][0];
    		    	int end = chore[j][1];
    		    	boolean J = false;
    		    	boolean C = false;
    		    	
    		    	for(int k = start ; k<end; k++) {
    		    		if(minutes[k] == 'J') {
    		    			if(C) {
    		    				possible = false;
    		    				break;
    		    			}
    		    			J = true;
    		    		}else if(minutes[k] == 'C') {
    		    			if(J) {
    		    				possible = false;
    		    				break;
    		    			}
    		    			C = true;
    		    		}else if(minutes[k] == 'J'+'C'){
    		    			//both are doing jobs
    		    			possible = false;
    		    			break;
    		    		}
    		    	}
    		    	
    		    	if(!possible) {
    		    		break;
    		    	}
    		    	
    		    	if(J && C) {
    		    		//this shouldnt happen but still check
    		    		possible = false;
    		    		break;
    		    	}
    		    	
    		    	if(J) {
    		    		responsible[j] = 'C';
    		    	}else if(C) {
    		    		responsible[j] = 'J';
    		    	}else {
    		    		responsible[j] = 'J';
    		    	}
    		    	for(int k = start ; k<end; k++) {
    		    		minutes[k]+=responsible[j];
    		    	}
    		    	
    		    }
    		   
    		    if(possible) {
    		    	System.out.println("Case #"+(i+1)+": "+new String(responsible));
    		    }else {
    		    	System.out.println("Case #"+(i+1)+": IMPOSSIBLE");
    		    }
    			
    			
    			
  		  
  		  
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
  			chores = new ArrayList<int[][]>();
  			
  			for(int i=0; i<T; i++) {
  				int N = Integer.parseInt(in.readLine());
  				int[][] chore = new int[N][2];
  				for(int j = 0 ; j<N; j++) {
  					String[] row = in.readLine().split(" ");
  					for(int k = 0 ; k<2 ; k++) {
  						chore[j][k] = Integer.parseInt(row[k]);
  					}
  				}
  				chores.add(chore);  				
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