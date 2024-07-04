import java.util.*;
class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int test = 1; test <= t; test++) {
            int n = sc.nextInt();
            int trace = 0;
            int rowCount = 0;
            int colCount = 0;
            
            HashSet<Integer> rowSet[] = new HashSet[n];
            HashSet<Integer> colSet[] = new HashSet[n];
            boolean[] isValidRow = new boolean[n];
            boolean[] isValidCol = new boolean[n];
            
            for (int i = 0; i < n; i++) {
                rowSet[i] = new HashSet<Integer>();
                colSet[i] = new HashSet<Integer>();
            }
            
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    int num = sc.nextInt();
                    
                    if (!isValidRow[i]) {
                        if (rowSet[i].contains(num)) {
                            isValidRow[i] = true;
                            rowCount++;
                        } else {
                            rowSet[i].add(num);
                        }
                    }  
                    
                    if (!isValidCol[j]) {
                        if (colSet[j].contains(num)) {
                            isValidCol[j] = true;
                            colCount++;
                        } else {
                            colSet[j].add(num);
                        }
                    }
                    
                    if (i == j) {
                        trace += num;
                    }
                }
            }
            
            System.out.println("Case #"+test+": " + trace + " " + rowCount + " " + colCount);
        }
    }
}