import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        solve();
    }

    private static void solve() {
        Scanner input = new Scanner(System.in);
        int numberT = input.nextInt();

        for (int caseNum = 1; caseNum <= numberT; caseNum++) {
            int numN = input.nextInt();
        	int[][] fields = new int[numN][3];
            for (int i = 0; i < numN; i++) {
            	int start = input.nextInt();
            	int end = input.nextInt();
            		fields[i][0] = start;
            		fields[i][1] = end;
            		fields[i][2] = i;
            }
            String answer = solver(numN, fields);
            System.out.println("Case #"+caseNum+": " + answer);
        }
    }

    private static String solver(int numN, int[][] fields) {
    	Data[] data = new Data[numN];
    	for (int i = 0; i < numN; i++) {
    		data[i] = new Data(fields[i][0], fields[i][1], fields[i][2]);
    	}
    	Arrays.sort(data);

    	String[] results = new String[numN];
    	int cEnd = 0;
    	int jEnd = 0;

    	for (int i = 0; i < numN; i++) {
    		if (i == 0) {
    			results[data[i].c] = "C";
    			cEnd = data[i].b;
    			continue;
    		}

    		int start = data[i].a;
    		int end = data[i].b;

    		if (start < cEnd) {
    			if (start < jEnd) {
    				return "IMPOSSIBLE";
    			} else {
    				results[data[i].c] = "J";
    				jEnd = end;
    			}
    		} else {
    			results[data[i].c] = "C";
    			cEnd = data[i].b;
    		}
    	}

    	return String.join("", results);
    }

    private static class Data implements Comparable<Data> {
        int a, b, c;
        public Data(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
        public int compareTo(Data other) {
            if (this.a == other.a) {
                return this.b - other.b;
            } else {
                return this.a - other.a;
            }
        }
    }
}
