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
		    		
		    		char[] N = input.toCharArray();
		    		
		    		int[] in = new int[N.length];
		    		
		    		for(int i=0; i<N.length;i++){
		    			in[i] = Integer.parseInt(Character.toString(N[i]));
		    		}
		    		
		    		String instr  = "";
		    		
		    		
		    		for(int i =0; i<in.length ;i++){
		    			String s = ""+in[i];
		    			for(int j =0; j <in[i]; j++){
		    				s = "("+s+")"; 
		    			}
		    			instr = instr + s;
		    		}
		    		
		    		while(true){
		    			String[] check = instr.split("\\)\\(");
		    			
		    			if(check.length ==1){
		    				break;
		    			}
		    			instr = "";
		    			for(int i=0; i <check.length;i++){
		    			  	instr = instr+check[i];
		    			}
		    			
		    		}
		    		
		    		
		    		String results = ""+instr; 
		    		
		    	
		    		//String result = computePath(start);
		    	   
		    		System.out.println("Case #"+(k+1)+": "+results);	
		    	   	    		 
		    	}
		    	 	
		
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		//s.close();
		
	}
	
	
	
	

}
