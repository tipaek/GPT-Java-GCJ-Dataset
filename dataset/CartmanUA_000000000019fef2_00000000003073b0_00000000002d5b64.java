import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {		
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int tests = in.nextInt();
		int n1;
		int n2;
		for (int test=1; test<=tests;test++) {
			n1 = in.nextInt();
			n2 = in.nextInt();
			int[][] deck = new int[n1*n2][2];
			int deck_count = 0;
			for (int i=1; i<=n2; i++) {
				for (int j=1; j<=n1; j++) {
					deck[deck_count][0] = j;
					deck[deck_count][1] = i;
					deck_count++;
				}
			}
			print(test, deck, n1, n2);
		}
	}
	
	private static void print(int test, int[][] deck, int r, int s) {
		ArrayList<int[]> list = new ArrayList<int[]>();
		String answer = "Case #" + test +": ";
		boolean finish = true;
		int[] correct = new int[r*s];
		int new_r=1;
		int new_s=1;
		int count = 0;
		for (int i=0; i<correct.length;i++) {
			correct[i]=new_r;
			new_s++;
			if (new_s > s) {
				new_r++;
				new_s=1;
			}
		}

		while(true) {
			int a = -1;
			int b = -1;
			int correct_a=-1;
			count++;
			finish = true;
			for (int i=deck.length-1; i>0; i--) {
				if (deck[i][0] < correct[i] && b == -1) {
					b = i+1;
					correct_a = correct[i];
					//System.out.println("b "+b);
				} else if (deck[i][0] == correct_a && b != -1) {
					a = i+1;
					b = b - a;
					//System.out.println("a "+a+" "+b);
					finish = false;
					deck = rebuild_deck(deck, a, b);
					break;
				}
			}
			if (finish) break;
			list.add(new int[] {a, b});
		}
		System.out.println(answer+count);
		for(int g=0; g<list.size();g++) {
			System.out.println(list.get(g)[0]+" "+list.get(g)[1]);
		}
	}
	
	private static int[][] rebuild_deck(int[][] deck, int a, int b){
		int[][] deck_a = new int[a][2];
		int[][] deck_b = new int[b][2];
		int[][] return_deck = new int[deck.length][2];
		for(int i = 0; i<a; i++) {
			deck_a[i][0]=deck[i][0];
			deck_a[i][1]=deck[i][1];
		}
		for(int i = 0; i<b; i++) {
			deck_b[i][0]=deck[i+a][0];
			deck_b[i][1]=deck[i+a][1];
		}
		for(int i = 0; i<b; i++) {
			return_deck[i][0]=deck_b[i][0];
			return_deck[i][1]=deck_b[i][1];
		}
		for(int i = 0; i<a; i++) {
			return_deck[b+i][0]=deck[i][0];
			return_deck[i+b][1]=deck[i][1];
		}
		for(int i = a+b; i<deck.length; i++) {
			return_deck[i][0]=deck[i][0];
			return_deck[i][1]=deck[i][1];
		}
		return return_deck;
	}
}
