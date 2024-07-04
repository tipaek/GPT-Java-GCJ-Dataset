import java.util.LinkedList;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int test_case = 1; test_case<= T; test_case++) {
			String answer = "";
			LinkedList<int[]> C_schedule = new LinkedList<int[]>();
			LinkedList<int[]> J_schedule = new LinkedList<int[]>();
			boolean impossible = false;
			int N = sc.nextInt();
			int[][] S = new int[N][2];
			for(int i = 0; i< N ; i++) {
				S[i][0] = sc.nextInt();
				S[i][1] = sc.nextInt();
			}
			
			for(int i=0; i<N; i++) {
				boolean C_available = true;
				boolean J_available = true;
				if(!impossible) {
					//TODO c_available, j_available calculation for current schedule
					if(!C_schedule.isEmpty()) {
						for(int k = 0;k < C_schedule.size(); k++) {
							int[] C_time = C_schedule.get(k);
							if((C_time[1] >= S[i][0] && C_time[0]<=S[i][0] ) || (C_time[0]<=S[i][1] && S[i][0] <= C_time[0])) {
//								System.out.println("C finishing time : "+C_time[1]);
//								System.out.println("S starting time : "+S[i][0]);
								C_available = false;
								
							}
							
						}

					}
					if(!J_schedule.isEmpty()) {
						for(int k = 0;k < J_schedule.size(); k++) {
							int[] J_time = J_schedule.get(k);
							if((J_time[1] >= S[i][0]  && J_time[0]<=S[i][0])|| (J_time[0]<=S[i][1] && S[i][0] <= J_time[0])) {
//								System.out.println("J finishing time : "+J_time[1]);
//								System.out.println("S starting time : "+S[i][0]);
								J_available = false;
								
							}
							
						}
					}
					if(C_available&& J_available) {
						answer = answer+"C";
						int[] C_time = new int[2];
						C_time[0] = S[i][0];
						C_time[1] = S[i][1];
						C_schedule.add(C_time);
					}
					else if(C_available||J_available) {
						if(C_available) {
							answer = answer+"C";
							int[] C_time = new int[2];
							C_time[0] = S[i][0];
							C_time[1] = S[i][1];
							C_schedule.add(C_time);
						}
						else {
							answer = answer+"J";
							int[] J_time = new int[2];
							J_time[0] = S[i][0];
							J_time[1] = S[i][1];
							J_schedule.add(J_time);
						}
					}
					
					else if(!C_available && !J_available){
						answer = "IMPOSSIBLE";
						impossible = true;
					}
//					System.out.println(answer);
				}
				
			}
			System.out.println("Case #"+ test_case +": "+ answer);
		}
		sc.close();
	}
}

