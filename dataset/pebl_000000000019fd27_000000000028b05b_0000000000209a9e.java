import java.util.Scanner;

public class Solution {
	static int B;
	static boolean[] Bs;
	static int flipIndex = -1;
	static int revIndex = -1;	
	
	private static void flip() {
		for(int i=0; i<Bs.length; i++) {
			Bs[i] = !Bs[i]; 
		}
	}

	private static void rev() {
		for(int i=0; i<Bs.length/2; i++) {
			int other = B-i-1;
			boolean tmp = Bs[i];
			Bs[i] = Bs[other];
			Bs[other] = tmp;			
		}
	}

	private static String toBsString() {
		StringBuilder sb = new StringBuilder(B);
		for(int i=0; i<B; i++) {
			if (Bs[i])
				sb.append('1');
			else
				sb.append('0');			
		}
		
		return sb.toString();
	}

	private static boolean readBit(Scanner sc, int index) {
		System.out.println(index+1);
		String bitS = sc.next();
		return !bitS.equals("0");		
	}
	
	private static void flip_rev(Scanner sc) {
		// System.out.println("Flip_Rev");
		if (flipIndex == -1 && revIndex == -1) {
			readBit(sc, 0);
			readBit(sc, 0);			
		} else if (revIndex == -1) {
			boolean flipBit = readBit(sc, flipIndex);
			if (flipBit != Bs[flipIndex]) 
				flip();
			readBit(sc, 0);			
		} else if (flipIndex == -1) {
			boolean flipBit = readBit(sc, revIndex);
			if (flipBit != Bs[revIndex]) 
				flip();
			readBit(sc, 0);			
		} else {
			boolean flipBit = readBit(sc, flipIndex);
			if (flipBit != Bs[flipIndex]) 
				flip();
			boolean revBit = readBit(sc, revIndex);
			if (revBit != Bs[revIndex]) 
				rev();
		}
	}
	
	private static void readBits(Scanner sc, int index) {
		boolean bit = readBit(sc, index);
		Bs[index] = bit;
				
		int other = B-index-1;
		boolean bitR = readBit(sc, other);
		Bs[other] = bitR;
		
		if (bit == bitR) 
			flipIndex = index;
		else
			revIndex = index;		
	}
	
	
	private static void solve(int nr, Scanner sc) {
		Bs = new boolean[B];
		flipIndex = -1;
		revIndex = -1;
		int index = 0;
		int endIndex = (B+1)/2;
		
		while(index < endIndex) {
			flip_rev(sc);
			for(int r=0; r<4 && index < endIndex; r++) {
				// System.out.println("reading "+index);
				readBits(sc, index);
				index++;
			}
		}

		// System.out.println("Solution "+index);

		System.out.println(toBsString());
		String ok = sc.next();
		if (!ok.equals("Y"))
			System.exit(-1);		
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		B = sc.nextInt(); 
		for(int i=0; i<T; i++) {
			solve(i+1,sc);
		}
	}
}
