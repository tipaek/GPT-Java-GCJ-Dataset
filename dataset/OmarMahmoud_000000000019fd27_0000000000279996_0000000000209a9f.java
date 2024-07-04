import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        StringBuilder sb = new StringBuilder();
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            String str = in.next();
            char[] ca = str.toCharArray();
            int[] ia = new int[ca.length];
            for(int j=0; j<ca.length; j++) ia[j] = (int)ca[j]-48; 
            String sol = getSol(ia, 0, ca.length-1, 0);
            sb.append("Case #: " + sol +"\r\n");
        }
        System.out.println(sb);
    }

	public static String getSol(int[] arr, int start, int end, int prevParen) {
		StringBuilder sb = new StringBuilder();
		int min = getMin(arr, start, end);
		for(int i=0; i<min-prevParen; i++) {
			sb.append("(");
		}
		
		if(start==end) {
			sb.append(arr[start]);
		}
		else {
			int p1 = start, p2 = end;
			
			while(p1<= end && p2 <= end) {
				while(p1 <= end && arr[p1] == min) {
					sb.append(arr[p1]);
					p1++;
				}
				
				if(p1>end) break;
				
				p2 = p1;
				while(p2 <= end && arr[p2] != min) p2++;
				p2--;
				
				sb.append(getSol(arr, p1, p2, min));
				p1=p2+1;
			}
		}
		
		
		for(int i=0; i<min-prevParen; i++) {
			sb.append(")");
		}
		
		return sb.toString();
	}

	private static int getMin(int[] arr, int start, int end) {
		int min = Integer.MAX_VALUE;
		for(int i=start; i<=end; i++) {
			if(arr[i]<min) min = arr[i];
		}
		
		return min;
	}

}

