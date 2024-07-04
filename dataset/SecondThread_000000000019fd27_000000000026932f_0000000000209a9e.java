import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Solution {

	static Scanner fs=new Scanner(System.in);
	static boolean local=false;
	
	public static void main(String[] args) {
		int T=fs.nextInt(), n=fs.nextInt();
		if (n%10!=0) throw null;
		for (int tt=0; tt<T; tt++) {
			curQuery=0;
			realArray=null;
			boolean[] set=new boolean[n];
			boolean[] a=new boolean[n];
			getBit(0, n);
			while (true) {
				if (curQuery%10==1) {
					//check if inverted
					int used=0;
					for (int i=0; i<n; i++) {
						if (set[i] && (a[i]==a[n-1-i])) {
							//keep even queries
							used++;
							if (getBit(i, n)^a[i]) {
								for (int j=0; j<n; j++) a[j]^=true;
							}
							break;
						}
					}
					//check if reversed
					for (int i=0; i<n; i++) {
						if (set[i] && (a[i]^a[n-1-i])) {
							used++;
							if (getBit(i, n)^a[i]) {
								for (int j=0; j<n/2; j++) {
									boolean temp=a[j];
									a[j]=a[n-1-j];
									a[n-1-j]=temp;
								}
							}
							break;
						}
					}
					if (used%2!=0) getBit(0, n);
				}
				
				//find blank index
				int blankIndex=-1;
				for (int i=0; i<n; i++) if(!set[i]) blankIndex=i;
				if (blankIndex==-1) {
					printAnswer(a);
					break;
				}
				set[blankIndex]=set[n-1-blankIndex]=true;
				a[blankIndex]=getBit(blankIndex, n);
				a[n-1-blankIndex]=getBit(n-1-blankIndex, n);
				StringBuilder sb=new StringBuilder();
				for (int i=0; i<n; i++)
					if (!set[i]) sb.append('?');
					else if (a[i]) sb.append('1');
					else sb.append('0');
//				if (local) System.out.println("  "+sb.toString());
			}
		}
	}
	
	//homemade tester
	static boolean[] realArray;
	static int curQuery=0;
	static Random random=new Random(10);
	static boolean getBit(int index, int n) {
		curQuery++;
		if (local) {
			if (curQuery==1) {
				realArray=new boolean[n];
				for (int i=0; i<n; i++) realArray[i]=random.nextBoolean();
//				System.out.println("Generated array: "+bitString(realArray));
			}
			
			boolean toReturn=realArray[index];
//			System.out.println("Queried index "+index+" returning "+toReturn);
			if (curQuery%10==1) {
				if (random.nextBoolean())
					for (int i=0; i<n; i++) realArray[i]^=true;
				if (random.nextBoolean())
					for (int i=0; i<n/2; i++) {
						boolean t=realArray[i];
						realArray[i]=realArray[n-1-i];
						realArray[n-1-i]=t;
					}
//				System.out.println("  after swaps, real array: "+bitString(realArray));
			}
			if (curQuery>=150) throw null;
			return toReturn;
		}
		else {
			System.out.println(index+1);
			System.out.flush();
			int type=fs.nextInt();
			return type==1;
		}
	}
	
	static void printAnswer(boolean[] array) {
		if (local) {
			System.out.println("Printed answer "+bitString(array));
			System.out.println("Real answer: "+bitString(realArray));
			for (int i=0; i<array.length; i++)
				if (array[i]!=realArray[i]) throw null;
			System.out.println("testcase passed...");
		}
		else {
			System.out.println(bitString(array));
			System.out.flush();
			String ans=fs.next();
			if (!ans.equals("Y")) while (true);
		}
	}

	static String bitString(boolean[] a) {
		StringBuilder sb=new StringBuilder("");
		for (boolean b:a) sb.append(b?1:0);
		return sb.toString();
	}
}
