import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
	public static void main(String args[]) throws Exception{
	    BufferedReader stdReader = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(stdReader.readLine());
		for(int i = 0 ; i < T ; i++){
			String[] str = stdReader.readLine().split(" ");
			int R = Integer.parseInt(str[0]);
			int S = Integer.parseInt(str[1]);
			ArrayList<String> s = new ArrayList<String>();
			int res = 0;
			if(R == 2 && S == 2) {
				res = 1;
				s.add("2 1");
			}else if(R == 2 && S == 3) {
				res = 2;
				s.add("2 3");
				s.add("2 2");
			}else if(R == 2 && S == 4) {
				res = 3;
				s.add("6 1");
				s.add("5 1");
				s.add("4 1");
			}else if(R == 2 && S == 5) {
				res = 4;
				s.add("8 1");
				s.add("7 1");
				s.add("6 1");
				s.add("5 1");
			}else if(R == 2 && S == 6) {
				res = 5;
				s.add("10 1");
				s.add("9 1");
				s.add("8 1");
				s.add("7 1");
				s.add("6 1");
			}else if(R == 2 && S == 7) {
				res = 6;
				s.add("12 1");
				s.add("11 1");
				s.add("10 1");
				s.add("9 1");
				s.add("8 1");
				s.add("7 1");
			}else if(R == 3 && S == 2) {
				res = 2;
				s.add("3 2");
				s.add("2 1");
			}else if(R == 3 && S == 3) {
				res = 4;
				s.add("6 2");
				s.add("5 2");
				s.add("4 1");
				s.add("3 1");
			}else if(R == 3 && S == 4) {
				res = 6;
				s.add("9 2");
				s.add("8 2");
				s.add("7 2");
				s.add("6 1");
				s.add("5 1");
				s.add("4 1");
			}else if(R == 3 && S == 5) {
				res = 8;
				s.add("12 2");
				s.add("11 2");
				s.add("10 2");
				s.add("9 2");
				s.add("8 1");
				s.add("7 1");
				s.add("6 1");
				s.add("5 1");
			}else if(R == 4 && S == 2) {
				res = 3;
				s.add("4 3");
				s.add("3 2");
				s.add("2 1");
			}else if(R == 4 && S == 3) {
				res = 6;
				s.add("8 3");
				s.add("7 3");
				s.add("6 2");
				s.add("5 2");
				s.add("4 1");
				s.add("3 1");
			}else if(R == 5 && S == 2) {
				res = 4;
				s.add("5 4");
				s.add("4 3");
				s.add("3 2");
				s.add("2 1");
			}
			System.out.println("Case #"+(i+1)+": "+res);
			for(int j = 0 ; j < s.size(); j++) {
				System.out.println(s.get(j));
			}
		}
		stdReader.close();
	}
}