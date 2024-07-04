import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		int cases = kb.nextInt();
		for(int cc = 1; cc <= cases; cc++) {
			System.out.print("Case #" + cc + ": ");
			int events = kb.nextInt();
			ArrayList<Integer> starts = new ArrayList<>();
			ArrayList<Integer> ends = new ArrayList<>();
			for(int i = 0; i < events; i++) {
				starts.add(kb.nextInt());
				ends.add(kb.nextInt());
			}
			String result = "";
			boolean impossible = false;
			ArrayList<Integer> cStarts = new ArrayList<>();
			ArrayList<Integer> jStarts = new ArrayList<>();
			ArrayList<Integer> cEnds = new ArrayList<>();
			ArrayList<Integer> jEnds = new ArrayList<>();
			outer: for(int i = 0; i < events; i++) {
				int eStart = starts.remove(0);
				int eEnd = ends.remove(0);
				if(cStarts.size() == 0) {
					cStarts.add(eStart);
					cEnds.add(eEnd);
					result+="C";
				}
				else {
					breaker: for(int j = 0; j < cEnds.size(); j++) {
						if(cEnds.get(j) > eStart) {
							if(cStarts.get(j) < eEnd) {
								if(jStarts.size() == 0){
										jStarts.add(eStart);
										jEnds.add(eEnd);
										result+="J";
										break breaker;
								}
								else{
									for(int k = 0; k < jEnds.size(); k++) {
										if(jEnds.get(k) > eStart) {
											if(jStarts.get(k) < eEnd) {
												impossible = true;
												break outer;
											}
											else {
												jStarts.add(eStart);
												jEnds.add(eEnd);
												result+="J";
												break breaker;
											}
										}
										else {
											jStarts.add(eStart);
											jEnds.add(eEnd);
											result+="J";
											break breaker;
										}
									}
								}
							}
							else {
								cStarts.add(eStart);
								cEnds.add(eEnd);
								result+="C";
								break breaker;
							}
						}
						else {
							cStarts.add(eStart);
							cEnds.add(eEnd);
							result+="C";
							break breaker;
						}
					}
				}
			}
			if(impossible) System.out.println("IMPOSSIBLE");
			else System.out.println(result);
		}
	}
}
