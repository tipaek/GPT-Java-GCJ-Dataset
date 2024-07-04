package patternMatching;

import java.util.Scanner;


public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
	    int T = Integer.parseInt(scanner.nextLine());
	    for(int i = 0; i < T; i++) { //T test cases
	    	int N = Integer.parseInt(scanner.nextLine());
	    	//create array of pairs of start and endtimes
	    	String[] pattern = new String[N];
	    	for(int j = 0; j < N; j++) {
	    		pattern[j] = scanner.nextLine().toUpperCase();
	    		for(int aa = 0; aa < pattern[j].length(); aa++) {
	    			String out = "";
	    			if(pattern[j].charAt(aa) == '*' && aa == 0) {
	    				out += "|*";
	    			}else if(pattern[j].charAt(aa) == '*' && aa == pattern[j].length()-1) {
	    				out += "*|";
	    			}else if(pattern[j].charAt(aa) == '*'){
	    				out += "*|*";
	    			}else {
	    				out += pattern[j].charAt(aa);
	    			}
	    		}
	    	}
	    	//now we have an input of strings
	    	/*int k = 0; //max num of * in an input string
	    	for(int j = 0; j < N; j++) {
	    		String[] splitted = pattern[j].split("*");
	    		if(splitted.length > k) {
	    			k = splitted.length;
	    		}
	    	}
	    	System.out.println("splittedLengthMax = "+k);
	    	
	    	String[][] placements = new String[k][k];*/
	    	String first = "";
	    	String middle = "";
	    	String last = "";
	    	String finalOutput = "";
	    	boolean match = true;
	    	for(int j = 0 ; j < N; j++) {
	    		String rules[] = pattern[j].split("|");
	    		for(int yy = 0; yy < rules.length; yy++) {
		    		if(rules[yy].charAt(0) == '*' && rules[yy].charAt(rules[yy].length()-1) == '*') {//middle
		    			middle += pattern[j];
		    		}else if(rules[yy].charAt(rules[yy].length()-1) == '*'){//first
		    			if(last.equals("")) {//empty
		    				last += rules[yy];
		    			}else {
		    				//see which one is larger
		    				if(first.length() > rules[yy].length()) { //first larger
		    					for(int n = 0; n < rules[yy].length(); n++) {
		    						if(rules[yy].charAt(n) == first.charAt(n)) {
		    							continue;
		    						}else if((rules[yy].charAt(n) == '*' || first.charAt(n) != '*')){
		    							break;
		    						}else {
		    							match=false;
		    							break;
		    						}
		    					}
		    				}else if(first.length() < rules[yy].length()){//either <
		    					for(int n = 0; n < first.length(); n++) {
		    						if(first.charAt(n) == rules[yy].charAt(n)) {
		    							continue;
		    						}else if(rules[yy].charAt(n) == '*' && first.charAt(n) != '*'){
		    							break;
		    						}else if(first.charAt(n) == '*'){
		    							for(int gg = n; gg <rules[yy].length(); gg++) {
		    								first += rules[yy].charAt(gg);
		    							}
		    							first+="*";
		    						}else {
		    							match=false;
		    							break;
		    						}
		    					}
		    				}else if(first.length() == rules[yy].length()){
		    					if(first.equals(rules[yy]) == false) {
		    						match=false;
		    						break;
		    					}
		    				}
		    			}
		    		}else if(pattern[j].charAt(0) == '*') {//last
		    			if(last.equals("")) {//empty
		    				last += pattern[j];
		    			}else {
		    				//see which one is larger
		    				if(last.length() > rules[yy].length()) { //last is larger
		    					for(int n = rules[yy].length()-1; n > 0; n--) {
		    						if(rules[yy].charAt(n) == last.charAt(n)) {
		    							continue;
		    						}else if(rules[yy].charAt(n) == '*' && last.charAt(n) != '*'){
		    							break;
		    						}else {
		    							match=false;
		    							break;
		    						}
		    					}
		    				}else if(last.length() < rules[yy].length()){//either <
		    					for(int n = rules[yy].length()-1; n > 0; n--) {
		    						if(last.charAt(n) == rules[yy].charAt(n)) {
		    							continue;
		    						}else if(last.charAt(n) != '*'){
		    							for(int gg = n; gg  > 0; gg++) {
		    								last = rules[yy].charAt(gg) + last;
		    							}
		    							last ="*"+last;
		    						}else {
		    							match=false;
		    							break;
		    						}
		    					}
		    				}else if(last.length() == rules[yy].length()){
		    					if(last.equals(rules[yy]) == false) {
		    						match=false;
		    						break;
		    					}
		    				}
		    			}
		    		}
	    		}
	    	}
	    	if(match) {
	    		finalOutput = first+middle+last;
	    	}else {
	    		finalOutput = "*";
	    	}
	    	int xx = i+1;
	    	System.out.println("Case #"+xx+": "+finalOutput);
	    	
	    }
	}

}