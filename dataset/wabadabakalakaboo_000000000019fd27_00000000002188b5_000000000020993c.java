import java.io.*;
import java.math.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        
        int queries = sc.nextInt();
        int caseNum = 0;
        while (queries --> 0) {
        	caseNum++;
        	int size = sc.nextInt();
        	int[][] arr = new int[size][size];
        	for (int i = 0; i < arr.length; i++) {
        		for (int j = 0; j < arr.length; j++) {
        			arr[i][j] = sc.nextInt();
        		}
        	}
        	int trace = 0;
        	for (int i = 0; i < arr.length; i++) {
        		trace += arr[i][i];
        	}
        	int badRow = 0;
        	for (int i = 0; i < arr.length; i++) {
        		hi:
        		for (int j = 0; j < arr.length; j++) {
        			for (int k = j+1; k < arr.length; k++) {
        				if (arr[i][j] == arr[i][k]) {
        					badRow++;
        					break hi;
        				}
        			}
        		}
        	}
        	int badCol = 0;
        	for (int i = 0; i < arr.length; i++) {
        		hi:
        		for (int j = 0; j < arr.length; j++) {
        			for (int k = j+1; k < arr.length; k++) {
        				if (arr[j][i] == arr[k][i]) {
        					badCol++;
        					break hi;
        				}
        			}
        		}
        	}
        	pw.println("Case #" + caseNum + ": " + trace + " " + badRow + " " + badCol);
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