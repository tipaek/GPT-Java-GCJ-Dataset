import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
        	int n = in.nextInt();
        	int[] m = new int[1441];
        	for(int j = 0; j < 1441; j++) {
        		m[j] = 0;
        	}
        	int[] a = new int[n];
        	int[] b = new int[n];
        	for(int j = 0; j < n; j++) {
        		a[j] = in.nextInt();
        		b[j] = in.nextInt();
        		for(int k = a[j]; k < b[j]; k++) {
        			m[k] += 1;
        		}
        	}
        	
        	boolean impossible = false;
        	for(int j = 0; j < 1441; j++) {
        		if(m[j] > 2) {
        			System.out.println("Case #" + i + ": IMPOSSIBLE");
        			impossible = true;
        			break;
        		}
        	}
        	if(impossible) {
        		continue;
        	}
        	int[] c = new int[n];
        	for(int j = 0; j < n; j++) {
        		c[j] = 0;
        	}
        	for(int j = 0; j < n; j++) {
        		for(int k = a[j]; k <= b[j]; k++) {
        			if(m[k] == 2) {
        				c[j] = 1;
        			}
        		}
        	}
        	char[] answer = new char[n];
        	for(int j = 0; j < n; j++) {
        		if(c[j] == 0) {
        			answer[j] = 'C';
        		}
        	}
        	Integer[] sorted = new Integer[n];
        	for(int j = 0; j < n; j++) {
        		sorted[j] = j;
        	}
        	Arrays.sort(sorted, new Comparator<Integer>() {
				@Override
				public int compare(Integer o1, Integer o2) {
					// TODO Auto-generated method stub
					if(a[o1] < a[o2])
						return -1;
					else if(a[o1] == a[o2])
						return 0;
					else
						return 1;
				}
        	});
        	int[] cam = new int[1441];
        	int[] jam = new int[1441];
        	
        	for(int j = 0; j < n; j++) {
        		int index = sorted[j];
        		if(c[index] == 1) {
        			int start = a[index];
        			if(cam[start] == 0) {
        				for(int k = start; k < b[index]; k++) {
        					cam[k] = 1;
        					answer[index] = 'C';
        				}
        			} else {
        				for(int k = start; k < b[index]; k++) {
        					jam[k] = 1;
        					answer[index] = 'J';
        				}
        			}
        		}
        	}/*
        	for(int j = 0; j < 1441; j++) {
        		System.out.println("cam " + j + ": " + cam[j]);
        	}
        	for(int j = 0; j < 1441; j++) {
        		System.out.println("jam " + j + ": " + jam[j]);
        	}*/
            System.out.println("Case #" + i + ": " + String.valueOf(answer));
        }
        
    }
}