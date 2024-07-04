import java.util.*;
import java.io.*;

public class Solution {
	
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int numberTest = in.nextInt();
	for (int i = 0; i < numberTest; i++) {
		in.nextLine();
		int size = in.nextInt();
		int test[][] = new int[size][size];
		int trace = 0;
		int rows = 0;
		int column = 0;
		boolean happened = false;
		for (int j = 0; j < size; j++) {
			in.nextLine();
			ArrayList<Integer> numbers = new ArrayList<Integer>();
			happened = false;
			for (int k = 0; k < size; k++) {
				int curr = in.nextInt();
				if (numbers.contains(curr) && !happened) {
					happened = true;
					rows++;
				}
				numbers.add(curr);
				test[j][k] = curr;
				if (j == k) {
					trace += test[j][k];
				}
			}
		}
		for(int j = 0; j < size; j++) {
			ArrayList<Integer> numbers = new ArrayList<Integer>();
			happened = false;
			for (int k = 0; k < size; k++) {
				int curr = test[k][j];
				if (numbers.contains(curr) && !happened) {
					happened = true;
					column++;
				}
				numbers.add(curr);
			}
		}
		System.out.println("Case #" + (i+1) + " " + trace + " " + rows + " " + column);
	}
  }
}