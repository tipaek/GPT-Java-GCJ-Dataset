import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		String output;
		ArrayList<String> allOutputs = new ArrayList<String>();
		int T;
		
		String input;
		int number;
		int noOfOpenPars;
		int remainingPars;
		int parsToClose;
		//Create stream
		Scanner sc = new Scanner(System.in);
				
		//Reads T
		T=  Integer.parseInt( sc.next() );
		
		//Do T times
		for(int a=0; a<T; a++) {
			input= sc.next();
			
			noOfOpenPars=0;
			output=new String();
			output="";
			
			//Read first character
			number= Integer.parseInt( Character.toString( input.charAt(0) )  );
			for(int b=0; b<number; b++) {
				output=output+"(";
			}
			noOfOpenPars= number;
			output=output+Integer.toString( number );
			
			
			//Read input character by character ( number by number), after the first character of course
			for( int b=1; b< input.length(); b++) {
				number= Integer.parseInt( Character.toString( input.charAt(b) )  );
				
				if(noOfOpenPars==number) {
					output=output+Integer.toString( number );
				}else if (noOfOpenPars<number) {
					//Open number-noOfOpenPars parentheses
					remainingPars=number-noOfOpenPars;
					for(int c=0; c<remainingPars; c++) {
						output=output+"(";
					}
					noOfOpenPars+=remainingPars;
					output=output+Integer.toString( number );
				} else if( noOfOpenPars>number ) {
					//Close noOfOpenPars-number parentheses
					parsToClose=noOfOpenPars-number;
					for(int c=0; c<parsToClose; c++) {
						output=output+")";
					}
					noOfOpenPars-=parsToClose;
					output=output+Integer.toString( number );
				}
				
			}
			
			//After reading all the characters close all the remaining open parentheses
			while( noOfOpenPars>0 ) {
				output=output+")";
				noOfOpenPars--;
			}
		
			allOutputs.add(output);
		}
		
		for(int i=1; i<allOutputs.size(); i++) {
			System.out.print("Case #"+i+": ");
			System.out.println( allOutputs.get(i-1) );
		}
		int i=allOutputs.size();
		System.out.print( "Case #"+i+": "+ allOutputs.get(i-1) );
		
		//Closes stream
		sc.close();
		
	}
}