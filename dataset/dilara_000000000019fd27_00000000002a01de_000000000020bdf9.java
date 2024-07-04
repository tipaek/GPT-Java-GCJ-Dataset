import java.util.*;
import java.io.*;
    public class Solution {
    	
    	private static int T;
    	private static List<List<Job>> chores;
    	public static void main(String[] args) {
    		readInput('W');
    	  
    		for(int i=0 ; i<T; i++) {
    			List<Job> chore = chores.get(i);
    			Collections.sort(chore);
    			//System.out.println(chore.get(0).index);
    			int N = chore.size();
    		    int[] minutes = new int[1440];
    		    char[] responsible = new char[N];
    		    boolean possible = true;
    		    for(int j = 0 ; j<N; j++) {
    		    	Job job = chore.get(j);
    		    	int start = job.start;
    		    	int end = job.end;
    		    	boolean J = false;
    		    	boolean C = false;
    		    	//System.out.println("Job number "+j);
    		    	for(int k = start ; k<end; k++) {
    		    		//System.out.println(minutes[k]);
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
    		    		responsible[job.index] = 'C';
    		    	}else if(C) {
    		    		responsible[job.index] = 'J';
    		    	}else {
    		    		responsible[job.index] = 'C';
    		    	}
    		    	for(int k = start ; k<end; k++) {
    		    		minutes[k]+=responsible[job.index];
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
  			chores = new ArrayList<List<Job>>();
  			
  			for(int i=0; i<T; i++) {
  				int N = Integer.parseInt(in.readLine());
  				List<Job> chore = new ArrayList<Job>();
  				for(int j = 0 ; j<N; j++) {
  					String[] row = in.readLine().split(" ");
  					Job job = new Job(j,row[0],row[1]);
  					chore.add(job);
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
    
    class Job implements Comparable<Job>{
  	  int index;
  	  int start;
  	  int end;
  	  
  	  public Job(int index, String start, String end) {
  		  this.index = index;
  		  this.start = Integer.parseInt(start);
  		  this.end = Integer.parseInt(end);
  	  }

		@Override
		public int compareTo(Job other) {
			return this.start - other.start;
		}
  	  
    }