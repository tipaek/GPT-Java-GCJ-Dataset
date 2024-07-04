import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;


public class Solution {
	
	public static void main(String[] args){
		
		
		
		Scanner inn = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		
		try {
		    	
		   
		    	
		    	int num_cases = Integer.parseInt(inn.nextLine());
		    	
		    	
		    	for ( int k = 0; k < num_cases ; k++){
		    		
		    	   
		    		String input = inn.nextLine();
		    		
		    		int N = Integer.parseInt(input);
		    		
		    		//String[] ranges = new String[N];
		    		
		    		int[] start = new int[N];
		    		int[] end = new int[N];
		    		
		    		for(int i=0; i<N; i++){
		    			
		    			String str = inn.nextLine();
		    			start[i] = Integer.parseInt(str.split(" ")[0]);
		    			end[i] = Integer.parseInt(str.split(" ")[1]); 
		    		}
		    		
		    		String outstring = "";
		    		ArrayList<Integer> Js = new ArrayList<Integer>();
		    		ArrayList<Integer> Je = new ArrayList<Integer>();
		    		ArrayList<Integer> Cs = new ArrayList<Integer>();
		    		ArrayList<Integer> Ce = new ArrayList<Integer>();
		    		
		    		for (int i = 0 ; i<N ; i++){
		    			
		    			if(valid(start[i],end[i],Cs, Ce)){
		    				outstring = outstring +"C";
		    				Cs.add(start[i]);
		    				Ce.add(end[i]);
		    			} else if (valid(start[i], end[i],Js, Je)){
		    				outstring = outstring +"J";
		    				Js.add(start[i]);
		    				Je.add(end[i]);
		    			} else{
		    				outstring = "IMPOSSIBLE";
		    				break;
		    			}
		    			
		    		}
		    		
		    		String results = ""+outstring; 
		    		
		    	
		    		//String result = computePath(start);
		    		System.out.println("Case #"+(k+1)+": "+results);	
		    	   	    		 
		    	}
		    	 	
		
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		//s.close();
		
	}
	
	
	public static boolean valid(int st, int en, ArrayList<Integer> Ls,ArrayList<Integer> Le ){
		
		boolean out  = false;
		
		if(Ls.isEmpty()){
			return true;
		}
		
		int startnew = st; 
		int endnew = en;
		
		for (int i =0; i<Ls.size(); i++ ){
			
			int startold = Ls.get(i);
			int endold = Le.get(i);
			
			if( (endnew<=startold)   || (startnew >= endold) ){
				out = true;
				
			}else {
				out = false;
				break;
			}
			
		}
		
		return out;
	}
	
	

}
