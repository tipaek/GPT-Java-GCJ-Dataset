import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static Scanner in = new Scanner(System.in);
	public static void main(String[] args) {
		int t = in.nextInt();
		int b = in.nextInt();
		in.nextLine();
		for(int tt=0;tt<t;tt++) {
			int[] database = new int[b];
			Arrays.fill(database, -1);
			for(int i=0;i<5;i++) {
				database[i] = ask((i+1));
			}
			for(int i=0;i<5;i++) {
				database[b-1-i] = ask((b-i));
			}
			boolean good = false;
			int ind1 = 0;
			int ind2 = 1;
			int val1 = -1;
			int val2 = -1;
			int oval1 = -1;
			int oval2 = -1;
			int index = 5;
			for(int i=0;i<5;i++) {
				for(int j=0;j<i;j++) {
					int sum = database[i]+database[j]+database[b-1-i]+database[b-1-j];
					if(sum==1||sum==3) {
						ind1=i;
						ind2=j;
						good = true;
					}
				}
			}
			val1 = database[ind1];
			val2 = database[ind2];
			oval1 = database[b-1-ind1];
			oval2 = database[b-1-ind2];
			if(2*index == b) {
				boolean correct = answer(print(database));
				if(!correct) {
					return;
				}
			} else {
				while(2*index < b) {
					int test1 = ask((ind1+1));
					int test2 = ask((ind2+1));
					if(test1==val1 && test2==val2) {
						//do nothing;
					} else if(test1 != val1 && test2 != val2) {
						database = invert(database);
					} else if(test1==oval1 && test2 == oval2) {
						database = reverse(database);
					} else {
						database = reverse(invert(database));
					}
					val1 = database[ind1];
					val2 = database[ind2];
					oval1 = database[b-1-ind1];
					oval2 = database[b-1-ind2];
					for(int i=0;i<4;i++) {
						database[index] = ask((index+1));
						database[b-1-index] = ask((b-index));
						index++;
					}
					if(!good) {
						for(int i=0;i<index;i++) {
							for(int j=0;j<i;j++) {
								int sum = database[i]+database[j]+database[b-1-i]+database[b-1-j];
								if(sum==1||sum==3) {
									ind1=i;
									ind2=j;
									val1 = database[i];
									val2 = database[j];
									oval1 = database[b-1-i];
									oval2 = database[b-1-j];
									good = true;
								}
							}
						}
					}
				}
				boolean correct = answer(print(database));
				if(!correct) {
					return;
				}
			}
		}
		in.close();
	}
	public static String print(int[] a) {
		String ret = "";
		for(int i=0;i<a.length;i++) {
			ret = ret + a[i];
		}
		return ret;
	}
	public static boolean answer(String a) {
		System.out.println(a);
		String bob = in.nextLine();
		if(bob.equals("Y")) return true;
		return false;
	}
	public static int ask(int loc) {
		System.out.println(loc);
		String bob = in.nextLine();
		if(bob.equals("N")) {
			throw new Error();
		}
		return Integer.parseInt(bob);
	}
	public static int[] reverse(int[] a) {
		int[] b = new int[a.length];
		for(int i=0;i<a.length;i++) {
			b[i] = a[a.length-1-i];
		}
		return b;
	}
	public static int[] invert(int[] a) {
		for(int i=0;i<a.length;i++) {
			if(a[i]==-1) continue;
			a[i] = 1 - a[i];
		}
		return a;
	}
}