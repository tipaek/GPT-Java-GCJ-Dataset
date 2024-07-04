import java.io.*;
import java.util.*;

public class Solution {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int cases = Integer.parseInt(sc.nextLine());
		for ( int i = 0 ; i < cases; i++ ) {
			String s = sc.nextLine();
			int[] arr = new int[s.length()];
			int[] digitI = new int[s.length()];
			int max = 0;
			int maxIndex = 0;
			String answer = "";
			for ( int j = 0; j < arr.length; j++ ) {
				arr[j] = Integer.parseInt(s.charAt(j)+"");
				answer+=arr[j];
				if ( max <= arr[j] ) {
					max = arr[j];
					maxIndex = j;
				}
				digitI[j] = j;
			}
			while ( arr[maxIndex] != 0 ) {
				max = arr[maxIndex];
				for ( int j = 0; j < arr.length; j++ ) {
					if ( arr[j] == max ) {
						int k = j;
						while ( k < arr.length && arr[k] == max )
							k++;
						k -= 1;
						answer = answer.substring(0,digitI[j])+"("+
							answer.substring(digitI[j],digitI[k]+1)+")"+
								answer.substring(digitI[k]+1);
						for ( int a = j; a <= k; a++ ) {
							digitI[a] = digitI[a]+1;
							arr[a] = arr[a] - 1;
						}
						for ( int a = k+1; a < digitI.length; a++ ) {
							digitI[a] = digitI[a]+2;
						}
					}
				}
			}
			out.println("Case #" + (i+1) +": "+answer);
		}
		out.close();
	}
}

