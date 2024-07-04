import java.util.*;
import java.io.*;
public class Solution {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int qry (int n) throws IOException{
        if (n<1) return -1;
        System.out.println(n);
        System.out.flush();
        return Integer.parseInt(br.readLine());
        //int ar[] = {1, 0, 1, 1, 0, 1, 0, 1, 1, 0};
        //return ar[n-1];
    }
    static void solve (int t) throws IOException{
        int N = Integer.parseInt(br.readLine());
        boolean[] ar1 = new boolean[N+1]; //ar[i] = 1 if ar[i] == ar[N+1-i], 0 otherwise
        boolean[] ar2 = new boolean[N+1];
        /*  if i is same, compare to sameCmp, if i is diff compare to diffCmp
        
        */
        int nor1 = qry(1);
        ArrayList<Integer> same = new ArrayList<Integer>();
        ArrayList<Integer> diff = new ArrayList<Integer>();
        for (int i = 1; i<=N/2; i++){
            int a = qry(i);
            int b = qry(N+1-i);
            if (a==b){
                ar1[i] = true;
                same.add(i);
            }
            else{
                ar1[i] = false;
                diff.add(i);
            }
        }
        int sameCmp = -1;
        int diffCmp = -1;
        if (!same.isEmpty()){
            sameCmp = same.get(0);
            ar2[sameCmp] = true;
            same.remove(0);
        }
        if (!diff.isEmpty()){
            diffCmp = diff.get(0);
            ar2[diffCmp] = true;
            diff.remove(0);
        }
        int cnt = 1;
        int sameCmpVal = qry(sameCmp);
        cnt++;
        while(!same.isEmpty()){
            if (cnt%10==1){
                sameCmpVal = qry(sameCmp);
                cnt++;
                continue;
            }
            ar2[same.get(0)] = (sameCmpVal==qry(same.get(0)));
            cnt++;
            same.remove(0);
        }
        int diffCmpVal = qry(diffCmp);
        cnt++;
        while(!diff.isEmpty()){
            if (cnt%10==1){
                diffCmpVal = qry(diffCmp);
                cnt++;
                continue;
            }
            ar2[diff.get(0)] = (diffCmpVal==qry(diff.get(0)));
            cnt++;
            diff.remove(0);
        }
        if (cnt%10==0) qry(1);
        int [] ans = new int[N+1];
        sameCmpVal = qry(sameCmp);
        diffCmpVal = qry(diffCmp);
        for (int i = 1; i<=N/2; i++){
            if (ar1[i]){//same
                if (ar2[i]){//same as sameCmp
                    ans[i] = sameCmpVal;
                    //System.out.println("Same, Same: "+i);
                }
                else{
                    ans[i] = 1-sameCmpVal;
                    //System.out.println("Same, Diff: "+i);
                }
                ans[N+1-i] = ans[i];
            }
            else{
                if (ar2[i]){
                    ans[i] = diffCmpVal;
                    //System.out.println("Diff, Same: "+i);
                }
                else{
                    ans[i] = 1-diffCmpVal;
                    //System.out.println("Diff, Diff: "+i);
                }
                ans[N+1-i] = 1-ans[i];
            }
        }
        for (int i = 1; i<=N; i++) System.out.print(ans[i]);
        System.out.println();
        char C = br.readLine().charAt(0);
        if (C=='N'){
            int c = 1/0;
        }
    }
    public static void main(String[] args) throws IOException{
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t<=T; t++){
            solve(t);
        }
        
    }
}