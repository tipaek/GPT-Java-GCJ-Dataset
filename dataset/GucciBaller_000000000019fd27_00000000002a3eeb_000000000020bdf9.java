import java.util.ArrayList;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int T = input.nextInt();
		for (int i = 0; i < T; i++) {
			int N = input.nextInt();
			int[][] schedule = new int[N][2];
			for (int j = 0; j < N; j++) {
				schedule[j][0]=input.nextInt();
				schedule[j][1] = input.nextInt(); 
			}
			System.out.println("Case #"+(i+1)+": "+Pattern(schedule));
		}
		input.close();
	}
	public static String Pattern(int[][] schedule) {
		String answer = "C"; //Use arraylists to track all start-end times?
		ArrayList<Integer> CS = new ArrayList<Integer>();
		ArrayList<Integer> CE = new ArrayList<Integer>();
		ArrayList<Integer> JS = new ArrayList<Integer>();
		ArrayList<Integer> JE = new ArrayList<Integer>();
		CS.add(schedule[0][0]); CE.add(schedule[0][1]);
		for (int i = 1; i < schedule.length; i++) {
			boolean validC = true;
			boolean validJ = true;
			int START = schedule[i][0];
			int END = schedule[i][1];
			/*Cases:
			 * If start time is between another commitment's duration
			 * If activity is entirely within another commitment
			 * If activity starts before and ends after another commitment
			 * If end time is between another commitment's duration*/
			for (int j = 0; j < CS.size(); j++) {
				if (START<CE.get(j)&&START>=CS.get(j)) {
					validC=false;
				}else if (START>=CS.get(j)&&END<=CE.get(j)) validC=false;
				else if (START<CS.get(j)&&END>CE.get(j)) validC=false;
				else if (END>CS.get(j)&&END<=CE.get(j)) validC=false;
				if(!validC) break;
			}
			for (int j = 0; j < JS.size(); j++) {
				if (START<JE.get(j)&&START>=JS.get(j)) {
					validJ=false;
				}else if (START>=JS.get(j)&&END<=JE.get(j)) validJ=false;
				else if (START<JS.get(j)&&END>JE.get(j)) validJ=false;
				else if (END>JS.get(j)&&END<JE.get(j)) validJ=false;
				if(!validJ) break;
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
			if (!validC&&!validJ) return "IMPOSSIBLE"; //if string hasn't been updated yet
		}
		return answer;
	}
}