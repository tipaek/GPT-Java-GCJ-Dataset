import java.io.*;
import java.util.*;
import java.math.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        int cnt = sc.nextInt();
        for(int cc=0; cc<cnt; cc++) {
            int metricSize = sc.nextInt();
            int sumttrace=0,rerow=0, recolumn = 0;
            Set<Integer>[] columnSet = new Set[metricSize];
            for (int i=0; i<  metricSize; i++) {
                columnSet[i] = new HashSet();
            }
            boolean[] columnFalg = new boolean[metricSize];
            for (int i=0; i< metricSize; i++) {
                Set<Integer> rowSet = new HashSet<>();
                boolean rowFlag = false;
                for (int j=0; j<metricSize; j++) {
                    int value = sc.nextInt();
                    if (i == j) sumttrace = sumttrace + value;
                    if (rowFlag == false) {
                        if (rowSet.contains(value)) {
                            rerow ++;
                            rowFlag = true;
                        } else {
                            rowSet.add(value);
                        }
                    }
                    if (columnFalg[j] == false) {
                        if (columnSet[j].contains(value)) {
                            recolumn ++;
                            columnFalg[j] = true;
                        } else {
                            columnSet[j].add(value);
                        }
                    }
                }
            }
            System.out.println("Case #" + cc+1 + ": "+sumttrace+" "+rerow+" " +recolumn);
        }
    }
}
