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

public class Solution {

	public static int solve(int x, int y, String movestr){
		char[] moves = movestr.toCharArray();
		int[] posX = new int[moves.length+1];
		int[] posY = new int[moves.length+1];
		posX[0] = x;
		posY[0] = y;
		for(int i=0;i<moves.length;i++){
			posX[i+1] = posX[i];
			posY[i+1] = posY[i];
			if(moves[i]=='N'){
				posY[i+1] = posY[i] + 1;
			} else if(moves[i]=='S'){
				posY[i+1] = posY[i] - 1;
			} else if (moves[i]=='E'){
				posX[i+1] = posX[i] + 1;
			} else if (moves[i]=='W'){
				posX[i+1] = posX[i] - 1;
			}
			int totalDist = Math.abs(posX[i+1]) + Math.abs(posY[i+1]);
			if(totalDist <= i+1){
				return i+1;
			}
		}
		return -1;
	}

	public static void main(String[] args){
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int T = sc.nextInt();
		for(int t=1;t<=T;t++){
			int x = sc.nextInt();
			int y = sc.nextInt();
			String moves = sc.next();
			int minTime = solve(x, y, moves);
			if(minTime == -1){
				System.out.println("Case #"+t+": IMPOSSIBLE");
			} else {
				System.out.println("Case #" + t + ": " + minTime);
			}
		}
	}
}