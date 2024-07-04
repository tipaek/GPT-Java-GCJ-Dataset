import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Scanner;

public class Solution {
	int tc;
	int num;
	Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
	
	public void input() {
		tc = in.nextInt();
	}

	public void input_num() {
		num = in.nextInt();
	}
	
	public char[] input_matrix() {
		char map[] = new char[num];
		
	    for (int i = 0; i < num; i++) {
	    	 map[i] = in.next().charAt(0);
	     }
	   return map;
	}
	
	public void solve(int casenum, char map[][]) {
		int sum = 0;
		int row = 0;
		int col = 0;
		HashMap<Character, Integer> unique = new HashMap<>();
		
		for(int i=0;i<num;i++) {
			unique.clear();
			sum = sum + Integer.parseInt(map[i][i]+"");			
			for(int j=0;j<num;j++) {
				if(!unique.containsKey(map[i][j])) {
					unique.put(map[i][j], 1);
				}
				else if(unique.get(map[i][j]) == 1){
					row++;
					break;
				}
			}
		}
		
		unique.clear();
		for(int i=0;i<num;i++) {
			unique.clear();
			for(int j=0;j<num;j++) {
				if(!unique.containsKey(map[j][i])) {
					unique.put(map[j][i], 1);
				}
				else if(unique.get(map[j][i]) == 1){
					col++;
					break;
				}
			}
		}
		
		System.out.printf("Case #%d: %d %d %d\n", casenum, sum, row, col);
	}
	
	public static void main(String[] args) {
		Solution s = new Solution();
		s.input();
		
		for(int j=0;j<s.tc;j++) {
			s.input_num();
			char[][] matrix = new char[s.num][s.num];
			
			for(int i=0; i< s.num; i++) {
				matrix[i] = s.input_matrix();
			}
			s.solve(j+1, matrix);
		}
	}

}
