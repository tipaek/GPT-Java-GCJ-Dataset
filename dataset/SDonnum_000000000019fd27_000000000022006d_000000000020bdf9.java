import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int cases = sc.nextInt();

        for(int i = 1; i <= cases; i++) {
            int n = sc.nextInt();
            int[] starts = new int[n];
            int[] endings = new int[n];
            int[] preSort = new int[n];
            for(int j = 0; j < n; j++) {
                int start = sc.nextInt();
                int end = sc.nextInt();

                starts[j] = start;
                preSort[j] = start;
                endings[j] = end;
                
                
            }

            simpleSort(starts, endings);
            //for(int y = 0; y < n; y++){
                //System.out.println(starts[y] + " - " + endings[y]);
            //}
            String solution = solve(starts, endings, preSort);
            System.out.print("Case #" + i + ": " + solution);
            
        }
    }

    public static void simpleSort(int[] s, int[] e) {
        int n = s.length;
        for(int i = 0; i < n-1; i++) {
            for(int j = 0; j < n-i-1; j++) {
                if(s[j] > s[j+1]) {
                    int tempS = s[j];
                    int tempE = e[j];
                    s[j] = s[j+1];
                    e[j] = e[j+1];
                    s[j+1] = tempS;
                    e[j+1] = tempE;
                }
            }
        }
    }

    public static String solve(int[] s, int[] e, int[] original) {
        String toReturn = "";

        boolean impossible = false;

        // Used to store when C or J is available again
        int cEnd = 0;
        int jEnd = 0;
        int[] cStarts = new int[s.length];
        int[] jStarts = new int[s.length];


        for(int i = 0; i < s.length; i++) {
            if(s[i] >= cEnd) {
                cEnd = e[i];
                cStarts[i] = s[i];
                continue;
            } else if (s[i] >= jEnd) {
                jEnd = e[i];
                jStarts[i] = s[i];
                continue;
            } else {
                impossible = true;
            }



        }

        if(impossible) {
            toReturn = "IMPOSSIBLE";
        } else {
            for(int j = 0; j < s.length; j++) {
                int curr = original[j];
                if(contains(cStarts, curr)) {
                    toReturn += "C";
                } else {
                    toReturn += "J";
                }
            }
        }
        return toReturn;
    }

    public static boolean contains(int[] arr, int val) {
        for( int i = 0; i < arr.length; i++) {
            if (arr[i] == val) {
                return true;
            }
        }
        return false;
    }
}