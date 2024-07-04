import java.util.*;
import java.io.*;

public class Solution {

	static int par = 0;
	static String output = "";

	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt();
		in.nextLine();
		
		for(int x = 1; x <= t; ++x) {
			par = 0;
			output = "";

			String nums = in.nextLine();
			int lastNum = -1;

			for(int i=0; i<nums.length(); i++){
				int num = Integer.parseInt(nums.charAt(i)+"");
				if(par==0){
					for(int j=0; j<num; j++){
						addOpening();
					}
				} else if(lastNum>num){
					addClosing();
				} else if(num<lastNum){
					addOpening();
				}
				output += num;
				lastNum = num;
			}
			
			while(par>0){
				addClosing();
			}
			System.out.println("Case #"+x+": "+output);
		}
		
	}

	public static void addOpening(){
		par += 1;
		output += "(";
	}

	public static void addClosing(){
		par -= 1;
		output += ")";
	}
}