import java.util.*;

class Solution {
    static boolean leftSide = false;

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        for (int c = 1; c <= t; ++c) {
            long n = s.nextLong();
            long rows = getNumberOfRowsToComplete(n);
            long remaining = n - sumOfGp(rows) + 1;
            leftSide = getStartSide(rows);
            System.out.println("Case #" + c + ":");
            printCompleteRows(rows-1);
            printAllValsButOne(rows);
            printRemaining(rows,remaining);
        }
    }

    private static boolean getStartSide(long rows) {
        return rows%2 == 0;
    }

    private static void printAllValsButOne(long row) {
        long r = row;
        long c = 1;
        int cDiff = 1;
        long end = row;
        if(!leftSide) {
            c = row;
            cDiff = -1;
            end = 1;
        }
        while(c!=end){
            System.out.println(r + " " + c);
            c+=cDiff;
        }
    }

    private static void printRemaining(long lastRow, long remaining) {
        long nextRow = lastRow+1;
        while(remaining>nextRow) {
            System.out.println(nextRow + " 2");
            remaining-=nextRow;
            nextRow++;
        }
        nextRow--;
        while(remaining>0) {
            System.out.println(nextRow + " 1");
            remaining--;
            nextRow++;
        }
    }

    private static void printCompleteRows(long n) {
        for(long i = 1; i <= n; ++i) {
            long r = i;
            long c = 1;
            int cDiff = 1;
            long end = i+1;
            if(!leftSide) {
                c = i;
                cDiff = -1;
                end = 0;
            }
            while(c!=end){
                System.out.println(r + " " + c);
                c+=cDiff;
            }
            leftSide = !leftSide;
        }
    }

    private static long sumOfGp(long n) {
        long val = (long)Math.pow(2,n) - 1;
        return val;
    }

    private static long getNumberOfRowsToComplete(long n) {
        long val = (long)(Math.log(n)/Math.log(2))+1;
        if(n<Math.pow(2,val)-1)
            val--;
        return val;
    }
}