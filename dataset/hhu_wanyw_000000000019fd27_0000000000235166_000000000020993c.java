package com.company;

        import java.lang.reflect.Field;
        import java.util.*;
        import java.util.concurrent.ArrayBlockingQueue;
        import java.util.concurrent.ConcurrentHashMap;
        import java.util.concurrent.ThreadPoolExecutor;
        import java.util.concurrent.TimeUnit;
        import java.util.concurrent.atomic.AtomicInteger;
public class Main {
    public static final long MOD =100000007;
    public int gcd(int a, int b) {
        return b==0?a:gcd(b,a%b);
    }

    long powMod(long a, long p) {
        long ans = 1;
        while (p != 0) {
            if ((p & 1) == 1) ans = (ans*a) % MOD;
            p >>= 1;
            a = (a*a) % MOD;
        }
        return ans%MOD;
    }
    class TrieNode{
        TrieNode[] childs;
        int count=0;
        public TrieNode(){
            childs=new TrieNode[26];
            count=0;
        }
        public TrieNode get(char c){
            if(childs[c-'a']==null){
                childs[c-'a']=new TrieNode();
                count++;
            }
            return childs[c-'a'];
        }
    }
    public int minimumLengthEncoding(String[] words) {
        TrieNode tries=new TrieNode();
        HashMap<TrieNode,Integer> map=new HashMap<>();
        for(int i=0;i<words.length;i++){
            int len=words[i].length();
            TrieNode tmp=tries;
            for(int k=0;k<len;k++) tmp=tmp.get(words[i].charAt(len-k-1));
            map.put(tmp,i);
        }
        int ans=0;
        for(TrieNode node:map.keySet()){
            if(node.count==0){
                ans+=words[map.get(node)].length()+1;
            }
        }
        return ans;
    }
    public int minPathSum(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int[][] st=new int[m][n];
        for(int i=0;i<n;i++){
            if(i>0)st[0][i]=grid[0][i]+st[0][i-1];
        }
        for(int i=0;i<n;i++){
           if(i>0) st[i][0]=grid[i][0]+st[i-1][0];
        }
        st[0][0]=grid[0][0];
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                st[i][j]=Math.min(st[i-1][j],st[i][j-1])+grid[i][j];
            }
        }
        return st[n-1][m-1];
    }
    void solve(){
        Scanner in=new Scanner(System.in);
        int t=in.nextInt();
        for(int l=1;l<=t;l++){
            int n=in.nextInt();
            int[] cnt=new int[n+1];
            int[][] grid=new int[n+1][n+1];
            int trace=0,rc=0,cc=0;
            for(int i=0;i<n;i++){
                boolean counted=false;
                for(int j=0;j<n;j++){
                    grid[i][j]=in.nextInt();
                    if(i==j) trace+=grid[i][j];
                    cnt[grid[i][j]]++;
                if(!counted&&cnt[grid[i][j]]>1){
                    rc++;
                    counted=true;
                }
                }
                Arrays.fill(cnt,0);
            }
            for(int i=0;i<n;i++){
                boolean counted=false;
                for(int j=0;j<n;j++){
                    cnt[grid[j][i]]++;
                    if(!counted&&cnt[grid[j][i]]>1) {
                        cc++;
                        counted=true;
                    }
                }
                Arrays.fill(cnt,0);
            }
            System.out.println("Case #"+l+": "+trace+" "+rc+" "+cc);
        }
    }
    public static void main(String[] args){
        new Main().solve();
    }
}
