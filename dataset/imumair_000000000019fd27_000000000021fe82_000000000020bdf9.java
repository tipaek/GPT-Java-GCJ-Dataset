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
		    		
		    		String[] ranges = new String[N];
		    		
		    		for(int i=0; i<N; i++){
		    			
		    			ranges[i] = inn.nextLine();
		    		}
		    		
		    		String outstring = "";
		    		ArrayList<String> J = new ArrayList<String>();
		    		ArrayList<String> C = new ArrayList<String>();
		    		
		    		for (int i = 0 ; i<N ; i++){
		    			
		    			if(valid(ranges[i],J)){
		    				outstring = outstring +"J";
		    			} else if (valid(ranges[i],C)){
		    				outstring = outstring +"C";
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
	
	
	public static boolean valid(String in, ArrayList<String> L){
		
		boolean out  = false;
		
		if(L.isEmpty()){
			L.add(in);
			return true;
		}
		
		int startnew = Integer.parseInt(in.split(" ")[0]); 
		int endnew = Integer.parseInt(in.split(" ")[1]);
		
		for (int i =0; i<L.size(); i++ ){
			
			int startold = Integer.parseInt(L.get(i).split(" ")[0]);
			int endold = Integer.parseInt(L.get(i).split(" ")[1]);
			
			if( (startnew>startold && startnew<endold)|| (endnew>startold && endnew<endold) || (startnew==startold && endnew==endold)||(startnew<startold && endnew>endold)){
				out = false;
				break;
			}else {
				out = true;
			}
			
		}
		
		return out;
	}
	
	

}
