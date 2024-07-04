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
					for(int j=0; j<lastNum-num; j++){
						addClosing();
					}
				} else if(lastNum<num){
					for(int j=0; j<num-lastNum; j++){
						addOpening();
					}
				}
				output += num;
				lastNum = num;
			}
			while(par>0){
				addClosing();
			}
			while(par<0){
				addOpening();
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