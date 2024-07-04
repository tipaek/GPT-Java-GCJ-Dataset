import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String args[]) {
		Scanner scan = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int T = scan.nextInt();

		for(int i=0; i<T; i++) {
			int try_num = scan.nextInt();
			int[][] arr = new int[try_num][2];
			int[] order = new int[try_num];
			
			for(int k=0; k<try_num; k++) {
				for(int j=0; j<2; j++) {
					arr[k][j] = scan.nextInt();
				}
				order[k] = k;
			}//input success
			
			for(int sort=0; sort<try_num; sort++) {
				for(int sort_p=sort+1; sort_p<try_num; sort_p++) {
					if(arr[sort][0]>arr[sort_p][0]) {
						int temp_start = arr[sort][0];
						int temp_end = arr[sort][1];
						int temp_order = order[sort];
						
						arr[sort][0] = arr[sort_p][0];
						arr[sort][1] = arr[sort_p][1];
						order[sort] = order[sort_p];
						
						arr[sort_p][0] = temp_start;
						arr[sort_p][1] = temp_end;
						order[sort_p] = temp_order;
					}//after this processing sorted <<<
					
					
				}
			}
			
			//now calulate using for loop
			
			String answer = "";
			
			int J_end = 0;
			int C_end = 0;
			
			for(int try_=0; try_<try_num; try_++) {
				
				if(J_end>arr[try_][0] && C_end>arr[try_][0]) {
					answer = "IMPOSSIBLE";
					break;
				}
				
				if(C_end<=arr[try_][0]) {
					C_end = arr[try_][1];
					answer+="C";
					continue;
				}
				
				if(J_end<=arr[try_][0]) {
					J_end = arr[try_][1];
					answer+="J";
					continue;
				}
				
				
			}
			
			
			String real_answer = "";
			if(answer.equals("IMPOSSIBLE")){
				real_answer = "IMPOSSIBLE";
			}
			else {
			for(int al=0; al<try_num; al++) {
				for(int tam=0; tam<try_num; tam++) {
					if(order[tam]==al) {
						String temp = String.valueOf(answer.charAt(tam));
						real_answer+=temp;
					}
				}
			}
			}

			System.out.println("Case #"+(i+1)+": "+ real_answer);
		}
		}
	}
