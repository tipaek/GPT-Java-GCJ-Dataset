import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.TreeSet;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			TreeSet<String> START = new TreeSet<String>();
			TreeSet<String> END = new TreeSet<String>();
			StringBuilder SOLVE = new StringBuilder();
			for(int a=0;a<N;a++){
				String cur = sc.next();
				String[] split = cur.split("\\*", -1);
				if(split[0].length()!=0){
					START.add(split[0]);
				}
				if(split[split.length-1].length()!=0){
					END.add(split[split.length-1]);
				}
				for(int b=1;b<split.length-1;b++){
					SOLVE.append(split[b]);
				}
			}
			
			START = CONDENSESTART(START);
			END = CONDENSEEND(END);
			
//			System.out.println(START);
//			System.out.println(END);
			
			if (START.size() > 1 || END.size() > 1)
			{
				SOLVE = new StringBuilder("*");
			}
			else
			{
				if(START.size()==1){
					SOLVE.insert(0, START.first());
				}
				if(END.size()==1){
					SOLVE.append(END.first());
				}
				
				if(SOLVE.length()==0){
					SOLVE.append("EMPTY");
				}
			}
			
			System.out.printf("Case #%d: %s%n", t, SOLVE);
		}
	}
	
	private static TreeSet<String> CONDENSESTART(TreeSet<String> START) {
		TreeSet<String> RESULT = new TreeSet<String>();
		for(String S : START){
			boolean dupe = false;
			for(String SS: START){
				if (SS.startsWith(S) && !SS.equals(S)){
					dupe=true;
					break;
				}
			}
			if (!dupe){
				RESULT.add(S);
			}
		}

		return RESULT;
	}

	private static TreeSet<String> CONDENSEEND(TreeSet<String> END) {
		TreeSet<String> RESULT = new TreeSet<String>();
		for(String S : END){
			boolean dupe = false;
			for(String SS: END){
				if (SS.endsWith(S) && !SS.equals(S)){
					dupe=true;
					break;
				}
			}
			if (!dupe){
				RESULT.add(S);
			}
		}

		return RESULT;
	}
}
