

import java.util.*;
import java.io.*;

public class Solution {
    
    static PrintStream out = System.out;
    static Scanner in = new Scanner(System.in);
    
	public static void main (String[] args) {
        
        int START = 0;
        int END = 1;
        int COUNT = 2;
        
        int t = in.nextInt();
        boolean isImpossible = false;
        int time=0;
        int end=0;
        int activityRef=0;
        int w;
        int[][] key;
        int[][] list;
        int count=0;
        
		for (int i = 1; i <= t; ++i) {
			int[][] sched = new int[60*24][2];
			isImpossible = false;
			
			w = in.nextInt();
			key = new int[w][2];
			count = 0;

			list = new int[w][3];
            
			for (int j = 0; j < w; j++) {
				list[j][START] = in.nextInt();
				list[j][END] = in.nextInt();
				list[j][COUNT] = count++;
			}

			Arrays.sort(list, new java.util.Comparator<int[]>() {
				public int compare(int[] a, int[] b) {
					return Integer.compare(a[START], b[START]);
				}
			});

			for (int j = 0; j < w; j++) {
				time = list[j][START];
				end = list[j][END];
				activityRef = list[j][COUNT];
                
				boolean C_Available = true;
				boolean J_Available = true;

				for (int z = time; z < end; z++) {
					if (sched[z][START] == 1) {
						C_Available = false;
					}
				}

				
				if (C_Available) {
					for (int k = time; k < end; k++) {
						sched[k][START] = 1;
					}

					key[j] = new int[] {activityRef, 1};
				} else {
					for (int k = time; k < end; k++) {
						if (sched[k][END] == 1) {
							J_Available = false;
						}
					}

					if (J_Available) {
						for (int k = time; k < end; k++) {
							sched[k][END] = 1;
						}
						key[j] = new int[] {activityRef, COUNT};
					} else {
						isImpossible = true;
					}
				}
			}

			
			if (isImpossible) {
                out.println("Case #" + i + ": IMPOSSIBLE");
                continue;
            } 
            
            Arrays.sort(key, new java.util.Comparator<int[]>() {
                public int compare(int[] a, int[] b) {
                    return Integer.compare(a[START], b[START]);
                }
            });
            
            StringBuilder answer = new StringBuilder();

            for (int j = 0; j < key.length; j++) {
                if (key[j][END] == 1) {
                    answer.append('C');
                } else if (key[j][END] == 2) {
                    answer.append('J');
                }
            }
            out.println("Case #" + i + ": " + answer.toString());
			
		}
	}
}