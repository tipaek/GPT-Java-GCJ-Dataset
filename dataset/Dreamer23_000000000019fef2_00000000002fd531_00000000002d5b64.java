import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

	private static void test() throws IOException {
		String s;
		BufferedReader read = new BufferedReader(new FileReader("data/testIn"));
		String total = "";
		while((s = read.readLine())!= null) total += s + "\n";
		InputStream testInput = new ByteArrayInputStream( total.getBytes("UTF-8") );
		System.setIn(testInput);
		read.close();
	}

	
	public static void main(String[] args) throws IOException {
//		test();
		final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		final int t = Integer.parseInt(in.nextLine());
		for (int c = 1; c <= t; ++c) {
			System.out.println("Case #" + c + ": " + getResult(in));
		}
		in.close();
	}

	// Theory: find the bottom-most card that is incorrect, and exchange with the top-most one that would be correct down there.
	// Repeat. Not sure if it's really gonna be minimal n, but let's give it a shot.
	// If not, swap to brute-forcing the small one.
	private static String getResult(final Scanner in) {
		String[] s = in.nextLine().split(" ");
		int tR = Integer.parseInt(s[0]);
		int tS = Integer.parseInt(s[1]);
		final int size = tR * tS;
		Card[] cards = new Card[size];
		for(int i = 0; i < size; i++) cards[i] = new Card((i % tR), (i / tR));
		List<Swap> swaps = new ArrayList<>();
		int next;
		while((next = findNextIncorrectCard(cards, tS, size)) != -1) {
			int expectedR = next / tS;
			int a = findFirstCardWithR(cards, expectedR, size);
			//System.out.println(next + " - " + a + " /// " + (a + 1) + " /// " + (next - a));
			swaps.add(new Swap(a + 1, next - a));
			cards = swapCards(cards, a, next, size);
			//for(Card c : cards) System.out.println(c.r + " - " + c.s);
			//return "";
		}
		return swapsToOutput(swaps);
	}
	
	private static String swapsToOutput(List<Swap> swaps) {
		StringBuilder sb = new StringBuilder(""+swaps.size());
		for(Swap s : swaps) sb.append("\n" + s.a + " " + s.b);
		return sb.toString();
	}
	
	private static Card[] swapCards(Card[] input, int a, int b, int size) {
		//System.out.println("Swap: " + a + " / " + b + " / " + size);
		Card[] output = new Card[size];
		int offset = a+1;
		for(int i = offset; i <= b; i++) output[i - offset] = input[i];
		offset = b - a;
		for(int i = 0; i <= a; i++) output[i + offset] = input[i];
		for(int i = b+1; i < size; i++) output[i] = input[i];
		return output;
	}
	
	private static int findNextIncorrectCard(Card[] cards, int s, int size) {
		for(int i = size - 1; i > 0; i--) {
			if(cards[i].r != i / s) return i;
		}
		return -1;
	}
	
	private static int findFirstCardWithR(Card[] cards, int r, int size) {
		for(int i = 0; i < size; i++) {
			if(cards[i].r == r) return i;
		}
		return -1;
	}
	
	private static class Swap {
		final int a, b;
		private Swap(int a, int b) {
			this.a = a;
			this.b = b;
		}
	}
	
	private static class Card {
		final int r, s;
		private Card(int r, int s) {
			this.r = r;
			this.s = s;
		}
	}

}
