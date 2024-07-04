import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int R = sc.nextInt();
			int S = sc.nextInt();
			LinkedList<Integer> test = new LinkedList<Integer>();
			for(int b=0;b<S;b++){
				for(int a=0;a<R;a++){
					test.add(a);
				}
			}
			
			LinkedList<State> LL = new LinkedList<State>();
			LL.add(new State(test,new StringBuilder(),0));
			State best = null;
			all: while(!LL.isEmpty()){
				State cur = LL.poll();
//				System.out.println(cur.stuff);
				for(int a=1;a<cur.stuff.size();a++){
					LinkedList<Integer> V1 = (LinkedList<Integer>) cur.stuff.clone();
					LinkedList<Integer> V2 = new LinkedList<Integer>();
					for(int aa=0;aa<a;aa++){
						V2.add(V1.poll());
					}
					for(int b=1;b<=V1.size();b++){
						LinkedList<Integer> V3 = (LinkedList<Integer>) V1.clone();
						LinkedList<Integer> V4 = new LinkedList<Integer>();
						for(int aa=0;aa<b;aa++){
							V4.add(V3.poll());
						}
						LinkedList<Integer> V5 = new LinkedList<Integer>();
//						System.out.println(V4);
//						System.out.println(V2);
//						System.out.println(V1);
//						System.out.println(V5);
						V5.addAll(V4);
						V5.addAll(V2);
						V5.addAll(V3);
						StringBuilder SB = new StringBuilder(cur.moves);
						SB.append("\n"+a+" "+(b));
						State temp = new State(V5,SB, cur.mm+1);
						if(IsSorted(V5)){
							best = temp;
							break all;
						}
						LL.add(temp);
					}
				}
			}
			
			System.out.printf("Case #%d: %d%s%n", t, best.mm, best.moves);
		}
	}
	private static boolean IsSorted(LinkedList<Integer> stuff) {
		int cur = 0;
		for(int a : stuff){
			if(cur>a)return false;
			cur = a;
		}
		return true;
	}
	static class State{
		LinkedList<Integer> stuff;
		StringBuilder moves;
		int mm;
		
		State(LinkedList<Integer> s, StringBuilder m, int mmm){
			stuff=s;
			moves=m;
			mm = mmm;
		}
	}
}
