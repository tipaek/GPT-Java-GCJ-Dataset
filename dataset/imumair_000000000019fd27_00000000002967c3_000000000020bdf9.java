import java.awt.List;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
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
		    		ArrayList<String> J = new ArrayList<String>();
		    		ArrayList<String> C = new ArrayList<String>();
		    		
		    		for (int i = 0 ; i<N ; i++){
		    			
		    			if(valid(start[i],end[i],J)){
		    				outstring = outstring +"J";
		    				J.add(start[i]+" "+end[i]);
		    			} else if (valid(start[i], end[i],C)){
		    				outstring = outstring +"C";
		    				C.add(start[i]+" "+end[i]);
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
	
	
	public static boolean valid(int st, int en, ArrayList<String> L){
		
		boolean out  = false;
		
		if(L.isEmpty()){
			return true;
		}
		
		int startnew = st; 
		int endnew = en;
		
		for (int i =0; i<L.size(); i++ ){
			
			int startold = Integer.parseInt(L.get(i).split(" ")[0]);
			int endold = Integer.parseInt(L.get(i).split(" ")[1]);
			
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
