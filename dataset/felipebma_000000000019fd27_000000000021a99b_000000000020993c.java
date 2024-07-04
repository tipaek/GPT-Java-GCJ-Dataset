import java.util.*;

class Solution{

    static Scanner in = new Scanner(System.in);
    public static void main(String args[]){
        int nCases = in.nextInt();
        for(int i=1;i<=nCases;i++){
            solve(i);
        }
    }

    static void solve(int nCase){
        int n = in.nextInt(), k=0, nLines = 0, nColumns = 0, num, trace=0;
        HashSet<Integer>[] lines = new HashSet[n], columns = new HashSet[n];
        for(int i=0;i<n;i++){
            lines[i] = new HashSet<Integer>();
        }
        for(int i=0;i<n;i++){
            columns[i] = new HashSet<Integer>();
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){ 
                num = in.nextInt();
                if(i==j) trace += num;
                if(!lines[i].contains(num)) lines[i].add(num);
                if(!columns[j].contains(num)) columns[j].add(num);
            }
        }
        for(HashSet<Integer> i:lines) if(i.size()<n) nLines++;
        for(HashSet<Integer> i:columns) if(i.size()<n) nColumns++;
        System.out.printf("Case #%d: %d %d %d\n", nCase, trace, nLines, nColumns);
    }
}

