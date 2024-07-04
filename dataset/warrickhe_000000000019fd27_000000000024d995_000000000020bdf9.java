import java.io.*;
import java.util.*;

public class Solution {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int cases = sc.nextInt();
		for ( int i = 0 ; i < cases; i++ ) {
			int slots = sc.nextInt();
			int[] time = new int[2000];
			int[][] schedule = new int[slots][3];
			boolean isImpossible = false;
		    for ( int j = 0; j < slots; j++ ) {
		    	
				int lower = sc.nextInt();
				int higher = sc.nextInt();
				if ( isImpossible )
					continue;
				schedule[j][0] = lower;
				boolean has1 = false;
				boolean has2 = false;
				boolean has3 = false;
				
				for ( int k = lower; k < higher; k++ ) { // 1 is C, 2 is J, 3 is C&J
					if ( time[k] == 1 )
						has1 = true;
					else if ( time[k] == 2 )
						has2 = true;
					else if ( time[k] == 3 )
						has3 = true;
				}
				if ( has3 || ( has1 && has2 ) ) {
					isImpossible = true;
					continue;
				}
				int CorJ = 1;
				if ( has1 )
					CorJ = 2;
				
				for ( int k = lower; k < higher; k++ ) { // 1 is C, 2 is J, 3 is C&J
					if ( time[k] == 0 ) 
						time[k] = CorJ;	
					else
						time[k] = 3;
				}
				schedule[j][1] = CorJ;
				schedule[j][2] = j;
		    }
		    
			if ( isImpossible )
				out.println("Case #" + (i+1) +": "+"IMPOSSIBLE");
			else {
				String a = "";
				for ( int k = 0; k < slots; k++ ) {
					if ( schedule[k][1]%2 == 0 )
						a += "C";
					else
						a += "J";
				}
				out.println("Case #" + (i+1) +": "+a);
			}
		}
		out.close();
	}
}
