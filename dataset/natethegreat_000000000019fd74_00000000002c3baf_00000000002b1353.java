import java.util.*;

import java.io.*;



public class Solution {
	public class coor{
		public int r;
		public int c;
		
		public coor(int row, int col) {
			r = row;
			c = col;
		}
	}
	public ArrayList<ArrayList<Integer>> pascal;
	public ArrayList<coor> result = new ArrayList<>();
	public int sum;
	public int cur;
	
	public void start() {
		pascal = new ArrayList<>();
		pascal.add(new ArrayList<>());
		pascal.get(0).add(1);
	}
	
	public void addRow() {
		pascal.add(new ArrayList<>());
		int cur = pascal.size()-1;
		pascal.get(cur).add(1);
		for(int i = 1; i < (pascal.get(cur-1).size()-1); ++i) {
			pascal.get(cur).add(pascal.get(cur-1).get(i-1) + pascal.get(cur-1).get(i));
		}
		pascal.get(cur).add(1);
	}
	
	public void recPas(int i, int j) {
		if(i == pascal.size()) {
			addRow();
		}
		int value = pascal.get(i).get(j);
		if((cur + value) == sum) {
			result.add(new coor(i+1, j+1));
			return;
		}else if((cur+value) < sum) {
			cur += value;
			result.add(new coor(i+1, j+1));
			if(!result.contains(new coor(i+2, j+1))) {
				recPas(i+1, j);
			}else if(!result.contains(new coor(i+1, j+2))) {
				recPas(i, j+1);
			}
		}else {
			return;
		}
		result.remove(new coor(i+1, j+1));
		cur = cur-value;
		return;
		
	}
	
	public void solve(int s) {
		if(s == 1) {
			result.add(new coor(1,1));
			return;
		}
		sum = s;
		cur = 1;
		result.add(new coor(1,1));
		recPas(1, 0);
	}
	
	public void printResult(int i) {
		System.out.println("Case #" + i + ":");
		for(int j = 0; j < result.size(); ++j) {
			System.out.println(result.get(j).r + " " + result.get(j).c);
		}
		result = new ArrayList<>();
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int total = in.nextInt(); 
        Solution s = new Solution();
        s.start();
        for (int i = 1; i <= total; ++i) {
        	int sum = in.nextInt();
	         s.solve(sum);
	         s.printResult((i));
        }
        in.close();
	}

}
