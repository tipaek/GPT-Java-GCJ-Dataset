import java.io.*;
import java.util.*;

public class Solution {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * create three arrays, one to represent each's schedule, one to contain the details
		 * of each activity
		 * ofc, it'll go by time like in the current system
		 * same, but outwards for safer
		 */
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int cases = sc.nextInt();
		for ( int i = 0 ; i < cases; i++ ) {
			int slots = sc.nextInt();
			int[] time = new int[2000];
			int[][] schedule = new int[slots][4];
			boolean isImpossible = false;
			for ( int j = 0; j < slots; j++ ) {
				int lower = sc.nextInt();
		    	int higher = sc.nextInt();
		    	schedule[j][0] = lower;
		    	schedule[j][1] = higher;
		    	schedule[j][2] = j;
			}
			
			Arrays.sort(schedule, new Comparator<int[]>() {
				@Override
				public int compare(int[] obj1, int[] obj2 ) {
					if ( obj1[0] < obj2[0] )
						return -1;
					else if ( obj1[0] == obj2[0] )
						return 0;
					return 1;
				}
			});
			
		    for ( int j = 0; j < slots; j++ ) {
		    	int lower = schedule[j][0];
		    	int higher = schedule[j][1];
		    	
		    	if ( isImpossible )
					continue;
		    	
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
				schedule[j][3] = CorJ;
		    }
		    
			if ( isImpossible )
				out.println("Case #" + (i+1) +": "+"IMPOSSIBLE");
			else {
				Arrays.sort(schedule, new Comparator<int[]>() {
					@Override
					public int compare(int[] obj1, int[] obj2 ) {
						if ( obj1[2] < obj2[2] )
							return -1;
						else if ( obj1[2] == obj2[2] )
							return 0;
						return 1;
					}
				});
				String a = "";
				for ( int k = 0; k < slots; k++ ) {
					if ( schedule[k][3]%2 == 0 )
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
