import java.io.*;
import java.math.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        
        int queries = sc.nextInt();
        while (queries --> 0) {
        	int length = sc.nextInt();
        	if (length == 10) {
        		int[] arr = new int[10];
        		for (int i = 1; i <= 10; i++) {
        			pw.println(i);
        			pw.flush();
        			String str = sc.next();
        			arr[i-1] = Integer.parseInt(str);
        		}
        		for (int i = 0; i < arr.length; i++) {
        			pw.print(arr[i]);
        		}
        		pw.println();
        		pw.flush();
        		String str = sc.next();
        		if (str.equals("N")) {
        			System.exit(0);
        		}
        		else continue;
        	}
        }
        
        pw.close();
    }
	static void shuffle(int[] a) {
		Random get = new Random();
		for (int i = 0; i < a.length; i++) {
			int r = get.nextInt(a.length);
			int temp = a[i];
			a[i] = a[r];
			a[r] = temp;
		}
	}
	static void shuffle(long[] a) {
		Random get = new Random();
		for (int i = 0; i < a.length; i++) {
			int r = get.nextInt(a.length);
			long temp = a[i];
			a[i] = a[r];
			a[r] = temp;
		}
	}
}