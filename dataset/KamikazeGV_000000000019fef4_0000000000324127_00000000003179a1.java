import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		String output;
		ArrayList<String> allOutputs = new ArrayList<String>();
		int T;
		
		String U;
		
		String Q;
		String R;
		
		boolean found;
		
		ArrayList<Letter> table;

		//Create stream
		Scanner sc = new Scanner(System.in);
				
		//Reads T
		T=  Integer.parseInt( sc.next() );
		
		//Do T times
		for(int a=0; a<T; a++) {
			//Clears the table
			table= new ArrayList<Letter>();
			
			U=sc.next();
			
			for(int b=0; b<10000; b++) {
				Q=sc.next();
				R=sc.next();
				
				//For each character of R...
				for(int c=0; c<R.length(); c++) {
					found=false;
					//...check if that character has already appeared...
					for(Letter l: table) {
						//...and if so, increment it's frequency in table
						if(R.charAt(c)== l.symbol) {
							l.frequency++;
							found=true;
							break;
						}
					}
					//...if not, add it to the table
					if(found==false) {
						table.add( new Letter(R.charAt(c),1) );
					}
				}
				
				
			}
			
			//Sort the table by frequency
			Collections.sort(table, new Comparator<Letter>() {
					  
				public int compare(Letter l1, Letter l2) {
					return (l2.frequency -  l1.frequency);
				}
			});
			
			//Now, the most common numbers, should be by order: 1234567890
			output="";
			//We first create the "key" corresponding to 1234567890
			for(Letter l: table) {
				output=output+Character.toString(l.symbol);
			}
			//And then modify it to 0123456789
			output=output.substring(output.length()-1)+output.substring(0,output.length()-1);
			
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

class Letter {
	char symbol;
	int frequency;
	
	public Letter(char passedSymbol, int passedFrequency) {
		symbol=passedSymbol;
		frequency=passedFrequency;
	}
	
}
