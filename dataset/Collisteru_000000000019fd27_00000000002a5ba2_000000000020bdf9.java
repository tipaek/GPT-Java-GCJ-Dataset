import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
public class Solution{
	public static void main(String args[]) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int limit = in.nextInt();
		for(int l = 0; l<limit; l++) { //Main loop
			int events = in.nextInt();
			int[][] Cameron = new int[events][2];
			int[][] Jamie = new int[events][2];
			boolean impossible = false;
			StringBuilder out =  new StringBuilder();
			events: for(int e = 0; e<events; e++) {
				if(e==0) { //Cameron has the first task
					Cameron[0][0] = in.nextInt();
					Cameron[0][1] = in.nextInt();
					out.append("C");
				}
				else {
					int begin = in.nextInt();
					int end = in.nextInt();
					boolean cposs = true;
					boolean jposs = true;
					for(int c = 0; c<(e); c++) {
						if(/*Test for subsets and overlaps*/ (Cameron[c][0] < begin && begin < Cameron[c][1] || Cameron[c][0] < end && end < Cameron[c][1]) ||
								/*Test for supersets*/(begin <= Cameron[c][0] && end >= Cameron[c][1]) ||
								/*Overlaps of boundary*/ (begin == Cameron[c][0] || end == Cameron[c][1])) {
							cposs = false;
						}
						if(/*Test for subsets and overlaps*/ (Jamie[c][0] < begin && begin < Jamie[c][1] || Jamie[c][0] < end && end < Jamie[c][1]) ||
								/*Test for supersets*/(begin < Jamie[c][0] && end > Jamie[c][1]) ||
						/*Overlaps of boundary*/ (begin == Jamie[c][0] || end == Jamie[c][1])) {
							jposs = false;
						}
					}
					if(cposs) { //Revise, should Cameron always be given precednece
						Cameron[e][0] = begin;
						Cameron[e][1] = end;
						out.append("C");
					}
					else if(jposs) {
						Jamie[e][0] = begin;
						Jamie[e][1] = end;
						out.append("J");
					}
					else {
						impossible = true;
						break events;
					}
				}
			}
			System.out.print("Case #" + (l+1) + ": ");
			if(impossible == true) {
				System.out.println("IMPOSSIBLE");
			}
			else {
				System.out.println(out.toString());
			}
		}
		in.close();
	}
}
