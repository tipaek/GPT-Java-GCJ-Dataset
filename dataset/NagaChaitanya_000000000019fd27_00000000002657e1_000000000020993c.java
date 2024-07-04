import java.util.*;
class Solution
{
    public static void main(String[] args){
        // System.out.print("hi");
        Scanner in = new Scanner(System.in);
        
        int T = in.nextInt();
        for(int ti=0; ti<T; ti++){
            int n = in.nextInt();
            int arr[][] =new int[n][n];
            int cCnt=0, rCnt=0, trace=0;
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    arr[i][j]=in.nextInt();
                    if(i==j) trace+=arr[i][j];
                }
            }
            for(int i=0; i<n; i++){
                Set<Integer> rs = new HashSet<>();
                Set<Integer> cs = new HashSet<>();
                for(int j=0; j<n; j++){
                    rs.add(arr[i][j]);
                    cs.add(arr[j][i]);
                }
                if(rs.size()<n) rCnt++;
                if(cs.size()<n) cCnt++;
            }
            System.out.println("Case #"+(ti+1)+": "+trace+" "+rCnt+" "+cCnt);
        }
    }
}