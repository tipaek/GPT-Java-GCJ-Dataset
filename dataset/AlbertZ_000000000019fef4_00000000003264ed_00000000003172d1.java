import java.io.*;
import java.util.*;

public class Solution {
    static Scanner sc = new Scanner(System.in);
    static PrintWriter out = new PrintWriter(System.out);
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    long mod = 1000000000;
    double[] logFac;
    double ln2 = Math.log(2);
    long target;
    public static void main(String[] args)throws IOException {
//        String[] buf = reader.readLine().split(" ");
//        int T = Integer.parseInt(buf[0]);
        Solution sl = new Solution();
        int T = sc.nextInt();
        for(int i=1;i<=T;i++){
            out.print(String.format("Case #%d: ",i));
            out.println(sl.solve());
        }
        out.flush();
        System.exit(0);
    }
    long solve() {
        int n = sc.nextInt(), d= sc.nextInt();
        long[] a = new long[n];
        for(int i=0;i<n;i++){
            a[i] =  d*sc.nextLong();
        }
        Arrays.sort(a);
        long ans= d;
        Set<Long> used = new HashSet<>();
        for(int start=0;start<n;start++){
            ArrayList<Long> list = new ArrayList<>();
            for(int i=start;i<n;i++) list.add(a[i]);
            TreeSet<Long> fac = facs(a[start]);
            for(long num:fac){
                if(!used.add(num)) continue;
                target = num;
                Collections.sort(list,new mycom());
                long temp = helper(list, d);
                ans = Math.min(ans,temp);
            }
        }
        return ans;
    }
    long helper(ArrayList<Long> list, long d){
        int sum = 0;
        for(int i=0;i<list.size()&&d>0;i++){
            long cur = list.get(i);
            if(cur==target){
                 d -= 1;
                 continue;
            }
            if(cur%target==0){
               if(cur/target<=d){
                   d -= cur/target;
                   sum += cur/target-1;
               } else{
                   sum += d;
                   d = 0;
               }
            } else{
                long max = cur/target;
                sum += Math.min(d,max);
                d -= Math.min(d,max);
            }
        }
        return d==0?sum:Long.MAX_VALUE;
    }
    TreeSet<Long> facs(long n){
        TreeSet<Long> ans = new TreeSet<>();
        for(long i=1;i*i<=n;i++){
            if(n%i!=0) continue;
            ans.add(i); ans.add(n/i);
        }
        return ans;
    }
    class mycom implements Comparator<Long>{
        public int compare(Long o1, Long o2){
            if(o1%target==0&&o2%target!=0) return -1;
            if(o1%target!=0&&o2%target==0) return 1;
            return Long.compare(o1,o2);
        }
    }
}
