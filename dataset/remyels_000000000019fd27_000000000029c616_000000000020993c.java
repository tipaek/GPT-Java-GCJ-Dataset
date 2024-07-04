import java.util.*;
import java.io.*;

public class Solution {
    static int n;
    
    static int[][] graph;
    
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int t = console.nextInt();
        for (int i = 0; i<t;i++) {
            System.out.print("Case #"+(i+1)+": ");
            n = console.nextInt();
            graph = new int[n][n];
            for (int j = 0; j<n; j++) {
                for (int k = 0; k<n; k++) {
                    graph[j][k] = console.nextInt();
                }
            }
            solve();
        }
    }
    
    public static void solve() {
        int trace = 0;
        for (int i = 0; i<n; i++) {
            trace+= graph[i][i];
        }
        int dupCol = 0;
        int dupRow = 0;
        for (int i = 0; i<n; i++) {
            Set<Integer> count = new HashSet<>();
            for (int j = 0; j<n; j++) {
                count.add(graph[i][j]);
            }
            if (count.size()!=n) {
                dupRow++;
            }
        }
        for (int i = 0; i<n; i++) {
            Set<Integer> count = new HashSet<>();
            for (int j = 0; j<n; j++) {
                count.add(graph[j][i]);
            }
            if (count.size()!=n) {
                dupCol++;
            }
        }
        System.out.println(trace+" "+dupRow+" "+dupCol);
        int[] number = new int[num.length()];
        for (int i = 0; i<num.length(); i++) {
            number[i] = num.charAt(i)-'0';
        }
        int[] other = new int[num.length()];
        for (int i = 0; i<number.length; i++) {
            if (number[i] == 4) {
                other[i] = 1;
                number[i] = 3;
            }
        }
		int start = 0;
        while (start < number.length && other[start] == 0) {
            start++;
        }
		if (start == number.length) {
			String temp = "0";
			if (number[0] == 5) {
				temp = "2";
				number[0] = 3;
			}
			else {
				temp = "1";
				number[0] -=1;
			}
			while (temp.length() != num.length()) temp += "0";
			System.out.println(num+" "+0);
			return;
		}
        for (int i = 0; i<number.length; i++) {
            System.out.print(number[i]);
        }
        System.out.print(" ");
        for (int i = start; i<other.length; i++) {
            System.out.print(other[i]);
        }
        System.out.println();
    }
}