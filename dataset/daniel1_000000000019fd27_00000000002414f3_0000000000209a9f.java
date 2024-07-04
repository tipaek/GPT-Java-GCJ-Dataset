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

	public static String solve(String s){
		StringBuilder sb = new StringBuilder();
		int openParens = 0;
		for(int i=0;i<s.length();i++){
			if(s.charAt(i)=='0'){
				if(openParens>0){
					sb.append(')');
					openParens--;
				}
				sb.append('0');
			} else {
				if(openParens==0){
					sb.append('(');
					openParens++;
				}
				sb.append('1');
			}
		}
		if(openParens>0){
			sb.append(')');
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int T = sc.nextInt();
		for(int t=1;t<=T;t++){
			System.out.println("Case #"+t+": "+solve(sc.next()));
		}
	}
}