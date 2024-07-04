import java.util.*;

class Solution{

    static Scanner in = new Scanner(System.in);
    public static void main(String args[]){
        int nCases = in.nextInt();
        for(int i=1;i<nCases;i++){
            solve(i);
            System.out.println();
        }
        solve(nCases);
    }

    static void solve(int nCase){
        int n = in.nextInt(), k=0, nLines = 0, nColumns = 0, cum = 0, num, trace=0;
        for(int i=1;i<=n;i++){
            cum^=i;
        }
        int[] lines = new int[n], columns = new int[n];
        Arrays.fill(lines,cum);
        Arrays.fill(columns,cum);
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){ 
                num = in.nextInt();
                if(i==j) trace += num;
                lines[i] ^= num;
                columns[j] ^= num;
            }
        }
        for(int i:lines) if(i!=0) nLines++;
        for(int i:columns) if(i!=0) nColumns++;
        System.out.printf("Case #%d: %d %d %d", nCase, trace, nLines, nColumns);
    }
}