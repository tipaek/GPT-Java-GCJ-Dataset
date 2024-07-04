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
		    		
		    		int[][] inputs = new int[N][N];
		    		
		    		//Populate the input
		    		
		    		for(int i = 0; i <N ; i++){
	                    String row = inn.nextLine();
                        String[] rows = row.split(" ");		    			
		    			for(int j = 0; j<N;j++){
		    				
		    				inputs[i][j] = Integer.parseInt(rows[j]); 
		    			}
		    		}
		    		
		    		int trace = 0;
		    		int sofn = 0;
		    		
		    		// Compute trace and sum of N numbers
		    		for(int i =0; i<N; i++){
		    			trace = trace + inputs[i][i];
		    			sofn = sofn + (i+1);
		    		}
		    		
		    		 
		    		
		    		int r = 0; 
		    		int c = 0;
		    		HashSet<Integer> h;
		    		// Compute r for repeatd rows
		    		
		    		for (int i = 0 ; i <N ; i++){
		    			int sum = 0;
		    			h = new HashSet<Integer>();
		    			for(int j = 0; j<N;j++){
		    				if(!h.isEmpty()&& h.contains(inputs[i][j])){
		    					r = r+1;
		    					break;
		    				}else {
		    					h.add(inputs[i][j]);
		    				}
		    			}
		    		}
		    		// COmpute c for repeated columns
		    		for (int i = 0 ; i <N ; i++){
		    			int sum = 0;
		    			h = new HashSet<Integer>();
		    			for(int j = 0; j<N;j++){
		    				if(!h.isEmpty()&& h.contains(inputs[j][i])){
		    					c = c+1;
		    					break;
		    				}else {
		    					h.add(inputs[j][i]);
		    				}
		    			}
		    			
		    		}
		    		
		    		
		    		String results = ""+trace+" "+r+" "+c; 
		    		
		    		
		    		
		    	
		    		//String result = computePath(start);
		    	   
		    		System.out.println("Case #"+(k+1)+": "+results);	
		    	   	    		 
		    	}
		    	 	
		
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		//s.close();
		
	}
	
	
	
	

}
