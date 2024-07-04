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

	public static void main(String[] args) {
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int T = sc.nextInt();
		int B = sc.nextInt();
		for(int t=1;t<=T;t++){
			StringBuilder sb = new StringBuilder();
			for(int i=0;i<B;i++){
				System.out.println(i+1);
				sb.append(sc.next());
			}
			System.out.println(sb.toString());
			String response = sc.next();
			if("N".equals(response)){
				break;
			}
		}
	}
}