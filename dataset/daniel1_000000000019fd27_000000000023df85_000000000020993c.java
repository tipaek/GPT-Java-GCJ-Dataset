import java.util.NoSuchElementException;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.List;
import java.util.Deque;
import java.util.Iterator;
import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Comparator;
import java.util.Random;
import java.util.BitSet;
import java.util.NavigableMap;
import java.util.TreeMap;
import java.util.AbstractMap;
import java.util.Objects;
import java.util.Scanner;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.math.BigInteger;

public class Solution{

	public static class Result {
		public int k, r, c;

		public Result(int k, int r, int c){
			this.k = k;
			this.r = r;
			this.c = c;
		}
	}

	public static Result checkLatin(List<List<Integer>> matrix){
		int k = 0;
		for(int i=0;i<matrix.size();i++){
			k+= matrix.get(i).get(i);
		}
		int r = 0;
		for(int i=0;i<matrix.size();i++){
			Set<Integer> foundNums = new HashSet<>();
			for(int j=0;j<matrix.get(i).size();j++){
				if(foundNums.contains(matrix.get(i).get(j))){
					r++;
					break;
				}
				foundNums.add(matrix.get(i).get(j));
			}
		}
		int c = 0;
		for(int i=0;i<matrix.get(0).size();i++){
			Set<Integer> foundNums = new HashSet<>();
			for(int j=0;j<matrix.size();j++){
				if(foundNums.contains(matrix.get(j).get(i))){
					c++;
					break;
				}
				foundNums.add(matrix.get(j).get(i));
			}
		}
		return new Result(k, r, c);
	}

	public static void main(String[] args){
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int T = sc.nextInt();
		for(int t=1;t<=T;t++){
			int n = sc.nextInt();
			List<List<Integer>> matrix = new ArrayList<>();
			for(int i=0;i<n;i++){
				List<Integer> row = new ArrayList<>();
				for(int j=0;j<n;j++){
					row.add(sc.nextInt());
				}
				matrix.add(row);
			}
			Result res = checkLatin(matrix);
			System.out.println("Case #"+t+": "+res.k+" "+res.r+" "+res.c);
		}
	}
}