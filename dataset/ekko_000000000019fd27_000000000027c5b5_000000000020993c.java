import java.util.*;
import java.io.*;

public class Solution {
    static Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

    public static void main(String[] args) {

        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int caseNo = 1; caseNo <= t; ++caseNo) {
            int n = in.nextInt();
            solveVestigium(caseNo, n);
        }
    }

    public static void solveVestigium(int caseNo, int n){
        HashSet<Integer> rows[] = new HashSet[n];
        HashSet<Integer> cols[] = new HashSet[n];

        for(int i = 0; i < n; i++){
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
        }

        HashSet<Integer> repeatedRow = new HashSet<>();
        HashSet<Integer> repeatedColumn = new HashSet<>();
        int trace = 0;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                int num = in.nextInt();
                if(!rows[i].add(num)) repeatedRow.add(i);
                if(!cols[j].add(num)) repeatedColumn.add(j);
                if(i == j) trace += num;
            }
        }

        System.out.println("Case #"+ caseNo + " " + trace + " " + repeatedRow.size() + " " + repeatedColumn.size());
    }
}