import java.util.*;

class Solution{
    public static class pair implements Comparable<pair>{
        int s; int e; int idx;
        public pair(int s,int e,int idx){
            this.s=s;
            this.e=e;
            this.idx=idx;
        }
        public int compareTo(pair o){
            return this.s-o.s;
        }
        
    }
    public static String giveans(pair[] arr){
        int n = arr.length;
        int ca = 0;
        int ja=0;
        HashMap<Integer,Character> hm = new HashMap<>();
        for(int i=0;i<n;i++){
            pair p = arr[i];
            if(p.s>=ca){
                ca=p.e;
                hm.put(p.idx,'C');
            }else if(p.s>=ja){
                ja=p.e;
                hm.put(p.idx,'J');
            }else{
                return "IMPOSSIBLE";
            }
        }
        String ans="";
        for(int i=0;i<n;i++){
            ans+=hm.get(i);
        }
        return ans;
    }
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        int tc=1;
        while(t-->0){
            int n = scn.nextInt();
            pair[] arr = new pair[n];
            for(int i=0;i<n;i++){
                int a = scn.nextInt();
                int b = scn.nextInt();
                arr[i] = new pair(a,b,i);
            }
            Arrays.sort(arr);
            String ans =  giveans(arr);
            System.out.println("Case #"+tc+": "+ans);
            tc++;
        }
    }
}