import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int T = sc.nextInt();
		int B = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			HashSet<String> HS = new HashSet<String>();
			char[] last = new char[10];
			char[] opposite = new char[10];
			for(int a=0;a<10;a++){
				System.out.println(a+1);
				System.out.flush();
				last[a]=sc.next().toCharArray()[0];
				opposite[a]=(char)('1'+'0'-last[a]);
			}
			String A = String.valueOf(last);
			String AP = String.valueOf(opposite);
			HashSet<String> BorBP = new HashSet<String>();
			boolean negated = false;
			int used = 1;
			for(;used<15;used++){
				for(int a=0;a<10;a++){
					System.out.println(a+1);
					System.out.flush();
					last[a]=sc.next().toCharArray()[0];
					opposite[a]=(char)('1'+'0'-last[a]);			
				}
				String cur = String.valueOf(last);
				if (cur.equals(A)){
					negated =false;
				} else if (cur.equals(AP)){
					negated = true;
				} else {
					BorBP.add(cur);
					if (BorBP.size()==2)break;
				}
			}
			
			
			
			
			if (B==10){
				System.out.println(String.valueOf(last));
				System.out.flush();
			
			} else {
				LinkedList<String> LEFT = new LinkedList<String>();
				LinkedList<String> RIGHT = new LinkedList<String>();
				for(String s : BorBP){
					LEFT.add(s);
					RIGHT.add(new StringBuilder(s).reverse().toString());
				}
				LEFT.add(A);
				LEFT.add(AP);
				RIGHT.add(new StringBuilder(A).reverse().toString());
				RIGHT.add(new StringBuilder(AP).reverse().toString());
				for(int a=0;a<10;a++){
					if (LEFT.size() == 1)break;
					HashSet<Integer> possible = new HashSet<Integer>();
					for(String s : LEFT){
						possible.add(s.charAt(a)+0);
					}
					if(possible.size()==2){
						System.out.print(a+1);
						System.out.flush();
						char res = sc.next().toCharArray()[0];
						LinkedList<String> remove = new LinkedList<String>();
						for(String s : LEFT){
							if (s.charAt(a)==res)remove.add(s);
						}
						LEFT.removeAll(remove);
						continue;
					}
				}
				
				for(int a=0;a<10;a++){
					if (RIGHT.size() == 1)break;
					HashSet<Integer> possible = new HashSet<Integer>();
					for(String s : RIGHT){
						possible.add(s.charAt(a)+0);
					}
					if(possible.size()==2){
						System.out.print(a+10+1);
						System.out.flush();
						char res = sc.next().toCharArray()[0];
						LinkedList<String> remove = new LinkedList<String>();
						for(String s : RIGHT){
							if (s.charAt(a)==res)remove.add(s);
						}
						RIGHT.removeAll(remove);
						continue;
					}
				}
				System.out.print(LEFT+""+RIGHT);
				System.out.flush();
			}
			//answer
			sc.next();
		}
	}
}
