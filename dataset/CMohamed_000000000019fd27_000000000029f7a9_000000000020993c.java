import java.util.*;

class Solution {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int o = 0; o<t; o++) {
            int n = in.nextInt();
            int m[][] = new int[n][n];
            HashSet<Integer> rowSets[] = new HashSet[n];
            HashSet<Integer> colSets[] = new HashSet[n];
            int k=0, r=0, c=0;
            for(int i = 0; i<n; i++) {
                rowSets[i] = new HashSet<Integer>();
                for(int j = 0; j<n; j++) {
                    colSets[j] = ( colSets[j] == null ) ? new HashSet<Integer>() : colSets[j];
                    m[i][j] = in.nextInt();
                    rowSets[i].add(m[i][j]);
                    colSets[j].add(m[i][j]);
                    k = (i==j) ? k+m[i][j] : k;
                }
            }
            for(int i = 0; i<n; i++) {
                if (rowSets[i].size() != n) r++;
                if (colSets[i].size() != n) c++;
            }
            System.out.println("Case #"+(o+1)+": "+k+" "+r+" "+c);
        }
    }
}