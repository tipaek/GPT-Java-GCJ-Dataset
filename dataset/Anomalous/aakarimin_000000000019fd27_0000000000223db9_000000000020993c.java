package ca.mobilelive.investor.api.v1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Verdict {

    public static void main(String[] args) {
        List<Integer> row1 = new ArrayList<>();
        row1.add(1);
        row1.add(2);
        row1.add(3);
        
        List<Integer> row2 = new ArrayList<>();
        row2.add(3);
        row2.add(2);
        row2.add(3);
        
        List<Integer> row3 = new ArrayList<>();
        row3.add(2);
        row3.add(3);
        row3.add(1);
        
        List<List<Integer>> lines = new ArrayList<>();
        lines.add(row1);
        lines.add(row2);
        lines.add(row3);
        
        Verdict.findDuplicate(lines);
    }

    private static void findDuplicate(List<List<Integer>> lines) {
        int caseNumber = 1;
        for (List<Integer> row : lines) {
            Set<Integer> finalSet = new HashSet<>();
            Set<Integer> comparingSet = new HashSet<>();
            StringBuilder sb = new StringBuilder();
            
            for (Integer integer : row) {
                if (!comparingSet.add(integer)) {
                    finalSet.add(integer);
                }
            }
            
            if (!finalSet.isEmpty()) {
                sb.append("Case #").append(caseNumber).append(":");
                for (Integer x : row) {
                    sb.append(" ").append(x);
                }
                caseNumber++;
                System.out.println(sb.toString().trim());
            }
        }
    }
}