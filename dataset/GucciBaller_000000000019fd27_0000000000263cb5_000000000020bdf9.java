import java.util.ArrayList;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int T = input.nextInt();
		for (int i = 0; i < T; i++) {
			int N = input.nextInt();
			String answer = "C";
			int[][] schedule = new int[N][2];
			for (int j = 0; j < N; j++) {
				schedule[j][0]=input.nextInt();
				schedule[j][1] = input.nextInt();
			}
			//Arrays.sort(schedule, (a,b)->Integer.compare(a[0], b[0]));
			if (N==2) {
				if (schedule[1][0]>=schedule[0][1]) answer+=answer.substring(0,1);
				else answer+="J";
			}else {
				/*for (int j = 0; j<N-2; j++) {
					int START1 = schedule[j][0]; int START2 = schedule[j+1][0]; int START3 = schedule[j+2][0];
					int END1 = schedule[j][1]; int END2 = schedule[j+1][1]; int END3 = schedule[j+2][1];
					if (START2>=END1) {
						answer+=answer.substring(j,j+1);
					}else {
						if (answer.charAt(j)=='C') answer+="J";
						else answer+="C";
					}
					if (START3>=END2) answer+=answer.substring(j+1,j+2);
					int LOWER = START1;
					int HIGHER = Math.max(END1, END2);
					if (START3>LOWER&&END3<HIGHER) {
						answer = "impossible";
						break;
					} 
				}*/
				answer = Pattern(schedule);
			}
			System.out.println("Case #"+(i+1)+": "+answer);
		}
	}
	public static String Pattern(int[][] schedule) {
		String answer = "C"; //Use arraylists to track all start-end times?
		int curCSTART = schedule[0][0]; int curC = schedule[0][1];
		int curJSTART = 0; int curJ = 0;
		ArrayList<Integer> CS = new ArrayList<Integer>();
		ArrayList<Integer> CE = new ArrayList<Integer>();
		ArrayList<Integer> JS = new ArrayList<Integer>();
		ArrayList<Integer> JE = new ArrayList<Integer>();
		CS.add(schedule[0][0]); CE.add(schedule[0][1]);
		for (int i = 1; i < schedule.length; i++) {
			/*if (schedule[i][0]>schedule[i-1][0]) {
				answer+="J";
				curJ = schedule[i][1];
			}*/
			boolean validC = true;
			boolean validJ = true;
			int START = schedule[i][0];
			int END = schedule[i][1];
			for (int j = 0; j < CS.size(); j++) {
				if (START<CE.get(j)&&START>CS.get(j)) {
					validC=false;
				}else if (START>CS.get(j)&&END<CE.get(j)) validC=false;
				else if (START<CS.get(j)&&END>CE.get(j)) validC=false;
				else if (END>CS.get(j)&&END<CE.get(j)) validC=false;
				if(!validC) break;
			}
			for (int j = 0; j < JS.size(); j++) {
				if (START<JE.get(j)&&START>JS.get(j)) {
					validJ=false;
				}else if (START>JS.get(j)&&END<JE.get(j)) validJ=false;
				else if (START<JS.get(j)&&END>JE.get(j)) validJ=false;
				else if (END>JS.get(j)&&END<JE.get(j)) validJ=false;
				if(!validJ) break;
			}
			for (int j = 0; j < JS.size(); j++) {
				if (schedule[i][0]<JE.get(j)&&schedule[i][0]>JS.get(j)) {
					validJ=false;
				}
			}
			if (validC) {
				answer+="C";
				CS.add(schedule[i][0]);
				CE.add(schedule[i][1]);
			}else if (validJ){
				answer+="J";
				JS.add(schedule[i][0]);
				JE.add(schedule[i][1]);
			}
			/*if (schedule[i][0]>=curJ) {
				answer+="J";
				curJSTART = schedule[i][0];
				curJ = schedule[i][1];
			}else if (schedule[i][1]<=curCSTART) {
				answer+="C";
				curC = schedule[i][1];
				curCSTART = schedule[i][0];
			}
			else if (schedule[i][1]<=curJSTART) {
				answer+="J";
				curJ = schedule[i][1];
				curJSTART = schedule[i][0];
			}*/
			//System.out.println(curC+" "+curJ);
			if (!validC&&!validJ) return "IMPOSSIBLE"; //if string hasn't been updated yet
		}
		return answer;
	}
}
