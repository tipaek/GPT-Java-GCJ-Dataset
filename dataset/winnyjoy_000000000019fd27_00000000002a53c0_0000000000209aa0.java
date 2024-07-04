import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt(); // num test cases
		for(int i = 1; i <= t; ++i){
			int k = in.nextInt();
			int target = in.nextInt();
			List<Integer> temp = new ArrayList<>();
			String output = dobackTracking(target, k, temp, 1);
			System.out.println("Case #"+ i+ ": "+ output);
		}
	}


	public static String dobackTracking(int target, int k, List<Integer> temp, int start){

		if(target == 0)
			return "POSSIBLE";

		for(int i = start ; i < k; ++i ){
			int remainingTarget = target - i;
			if(remainingTarget >= 0){
				temp.add(i);
				dobackTracking(remainingTarget, k, temp, i);
				temp.remove(temp.size()-1);
			}

		}

		return "POSSIBLE";
	}
}
