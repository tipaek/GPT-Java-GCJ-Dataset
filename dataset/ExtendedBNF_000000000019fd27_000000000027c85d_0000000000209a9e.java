import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		int B = s.nextInt();
		for (int i = 0; i < t; i++) {
			solve(s, B);
			System.out.flush();
			String r = s.next();
			if(r.equals("N")) break;
			
		}

	}
	
	public static void solve(Scanner s, int B) {
	
		int[] array = new int[B + 1];
		int paarGleich = -1;
		int paarVer = -1;
		int last = 5;
		
		//initialize
		for(int i = 0; i < B + 1; i++) {
			array[i] = -1;
		}
		
		// first 10 digits
		for(int i = 1; i < 6; i++) {
			System.out.println(i);
			System.out.flush();
			int value1 = s.nextInt();
			System.out.println(B - i + 1);
			System.out.flush();
			int value2 = s.nextInt();
			array[i] = value1;
			array[B - i + 1] = value2;
			if(value1 == value2) {
				paarGleich = i;
			} else {
				paarVer = i;
			}
		}

		
		while(!finished(array)) {
			updateArray(array, checkChange(array, paarGleich, paarVer, s));
			
			for (int i = last + 1; !finished(array) && i < last + 5; i++) {
				System.out.println(i);
				System.out.flush();
				int x = s.nextInt();
				System.out.println(B - i + 1);
				System.out.flush();
				int y = s.nextInt();
				if(paarGleich == -1 && x == y) paarGleich = i;
				if(paarVer == -1 && x != y) paarVer = i;
				array[i] = x;
				array[B - i + 1] = y;
			}
			last += 4;
		}
		
		for(int i = 1; i < array.length; i++) {
			System.out.print(array[i]);
		}
		System.out.flush();
		System.out.println();
	}
	
	
	// 1: Spiegeln 2: Invert 3: Both 4: Lassen
	public static int checkChange(int[] a, int paarGleich, int paarVer, Scanner s) {
		
		if(paarGleich != -1 && paarVer != -1) {
			System.out.println(paarGleich);
			System.out.flush();
			int neuG = s.nextInt();
			System.out.println(paarVer);
			System.out.flush();
			int neuV = s.nextInt();
			if(neuG == a[paarGleich]) {
				if(neuV == a[paarVer]) {
					return 4;
				} else return 1;
			} else {
				if(neuV == a[paarVer]) {
					return 3;
				} else return 2;
			}
		} else {
			if(paarGleich == -1) {
				System.out.println(paarVer);
				System.out.flush();
				int neuV = s.nextInt();
				if(neuV == a[paarVer]) {
					return 4;
				}
				return 2;
			} else {
				System.out.println(paarGleich);
				System.out.flush();
				int neuG = s.nextInt();
				if(neuG == a[paarGleich]) {
					return 4;
				} else return 2;
			}
		}
		
	}
	
	public static void updateArray(int[] a, int act) {
		if(act == 4) return;
		// Spiegeln
		if(act == 1) {
			for(int i = 0; i < a.length / 2; i++) {
				int temp = a[i + 1];
				a[i + 1] = a[a.length - 1 - i];
				a[a.length - 1 -i] = temp;
			}
		}
		// Invert
		if(act == 2) {
			for(int i = 1; i < a.length; i++) {
				if(a[i] == 1) {
					a[i] = 0;
				} else if(a[i] == 0) a[i] = 1;
			}
		}
		
		if(act == 3) {
			updateArray(a, 1);
			updateArray(a, 2);
		}
		
	}
	
	public static boolean finished(int[] a) {
		for(int i = 1; i < a.length; i++) {
			if(a[i] == -1) return false;
		}
		return true;
	}
}
