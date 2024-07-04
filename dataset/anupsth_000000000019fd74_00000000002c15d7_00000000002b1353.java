import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;

public class Solution {
	static final HashMap<Pair, Integer> map = new HashMap<>();
	static final int[][] moves = new int[][] {
		{-1,-1},
		{-1,0},
		{0,-1},
		{0,1},
		{1,0},
		{1,1}
	};
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		int T = input.nextInt();
		for (int ks = 1; ks <= T; ks++) {
			int N = input.nextInt();
			Pair pair = new Pair(1, 1);
			final Set<Pair> visited = new LinkedHashSet<>();
			visited.add(pair);
			solve(visited, pair, 1,N);
			System.out.println("Case #"+ks+":");
			int sum= 0 ;
			for(Pair p:visited) {
				int value = getValue(p);
				sum+=value;
				System.out.println(p.getR()+" "+p.getK());
			}
		}
	}
	static boolean solve(Set<Pair> visited, Pair pair, int sum, int N) {
		if(sum==N) {
			return true;
		}
		for(int[] move: moves) {
			if(isValidMove(pair, move)) {
				Pair movedPair = getMoved(pair,move);
				if(isSafe(visited,movedPair,sum, N)) {
					visited.add(movedPair);
					if(solve(visited,movedPair,sum+getValue(movedPair),N)) {
						return true;
					}else {
						visited.remove(movedPair);
					}
				}
			}
		}
		return false;
	}
	static Pair getMoved(Pair p, int[] move) {
		return new Pair(p.r+move[0],p.k+move[1]);
	}
	static boolean isValidMove(Pair pair, int[] move) {
		int r = pair.r+move[0];
		int k = pair.k+move[1];
		return r>0 && k>0 && k<=r ;
	}
	static boolean isSafe(Set<Pair> visited, Pair pair, int sum, int N) {
		if(visited.contains(pair))
			return false;
		int value = getValue(pair);
		if (value+sum>N)
			return false;
		return true;
	}
	static int getValue(Pair pair) {
		return getValue(pair.getR(),pair.getK());
	}

	static int getValue(int r, int k) {
		if (k == 1 || r == k)
			return 1;
		Pair key = new Pair(r, k);
		if (map.containsKey(key)) {
			return map.get(key);
		} else {
			int value = getValue(r - 1, k - 1) + getValue(r - 1, k);
			map.put(key, value);
			return value;
		}

	}
	

}
class Pair{
	int r,k;
	public Pair(int r,int k) {
		this.r=r;
		this.k=k;
	}
	public int getR() {
		return r;
	}
	public int getK() {
		return k;
	}
	public int hashCode() {
		return Objects.hash(r,k);
	}
	public boolean equals(Object other) {
		if(other instanceof Pair) {
			Pair otherPair = (Pair)other;
			return otherPair==this|| otherPair.k==this.k && otherPair.r==this.r;
		}
		return false;
	}
}

