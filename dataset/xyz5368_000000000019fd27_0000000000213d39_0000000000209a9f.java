import java.util.*;
import java.io.*;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt();
		in.nextLine();
		for(int i = 0; i < t; i++){
		    String ret = "";
		    String s = in.nextLine();
			int[] nums = new int[s.length()];
			//read nums
			for(int j = 0; j < s.length(); j++){
				nums[j] = Integer.parseInt(s.substring(j,j+1));
			}
			//System.out.println(Arrays.toString(nums));
			for(int j = 0; j < nums[0]; j++){
				ret += "(";
			}
			ret += nums[0];
			//System.out.println(ret);
			for(int j = 1; j < nums.length; j++){
				//System.out.println(nums[j]-nums[j-1]);
				if(nums[j]-nums[j-1] < 0){
					for(int l = 0; l < nums[j-1]-nums[j]; l++){
						ret += ")";
					}
				}else if(nums[j]-nums[j-1] > 0){
					for(int l = 0; l < nums[j]-nums[j-1]; l++){
						ret += "(";
					}
				}
				ret += nums[j];
			}
			//close after last term
			for(int j = 0; j < nums[nums.length-1]; j++){
				ret += ")";
			}
			System.out.printf("Case #%d: %s\n",i+1,ret);
		}
	}

}
