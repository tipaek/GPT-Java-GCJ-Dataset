import java.util.*;
import java.io.*;

public class Solution {
    static Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

    public static void main(String[] args) {

        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        in.nextLine();
        for (int caseNo = 1; caseNo <= t; ++caseNo) {
            String line = in.nextLine();
            solveNestingDepth(caseNo, line);
        }
    }

    public static void solveNestingDepth(int caseNo, String line){
        StringBuilder sb = new StringBuilder(line.length());
        int openCount = 0;

        for(char ch : line.toCharArray()){
            int num = ch - '0';
            if (openCount > num){
                while (openCount != num){
                    sb.append(')');
                    openCount--;
                }
            }
            else { // openCount <= num
                while (openCount != num){
                    sb.append('(');
                    openCount++;
                }
            }
            sb.append(ch);
        }
        while (openCount > 0){
            sb.append(')');
            openCount--;
        }
        System.out.println("Case #"+ caseNo + ": " + sb.toString());
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

        System.out.println("Case #"+ caseNo + ": " + trace + " " + repeatedRow.size() + " " + repeatedColumn.size());
    }
}