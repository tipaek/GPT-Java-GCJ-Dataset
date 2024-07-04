import java.util.*;
public class Solution{
	static int testCases = 0;
	static Scanner s;
	public static void main(String[] args){
		s = new Scanner(System.in);
		testCases = s.nextInt();
		s.nextLine();
		String output = "";
		for(int i=0;i<testCases;i++){
			output = output + runTestCase(i+1);
		}

		System.out.println(output);
	}

	public static String runTestCase(int c){
		String tokens;
		tokens = s.nextLine();
		
		
		return "Case #"+c+": "+ getOutput(tokens) +"\n";
	}	
	public static String getOutput(String t){

		int open = 0;
		int close = 0;
		int tmp = 0;
		String c;
		String output = ""; 
		for(int i= 0;i<t.length();i++){
			c = t.substring(i,i+1);
			int x = Integer.parseInt(c);
			if(i==0){
				while(tmp < x){
					output = output + "(";
					tmp++;
				}
				open = x;
				output = output + x;
			}else{

				tmp = open - x;
				// tmp is positive...add )'s 
				// tmp is negative...add ('s
				if(tmp < 0){
					while(tmp < 0){
						tmp++;
						output = output+ "(";
						open++;
					}

				}else if(tmp > 0){
					while(tmp > 0){
						tmp--;
						output = output+")";
						open--;
					}
				}
				output = output + x;

			}


		}
		tmp = open;
		while(tmp > 0){
			output = output + ")";
			tmp--;
		}



		return output;
	}

}