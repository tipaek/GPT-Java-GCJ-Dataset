import java.util.*;

public class Solution{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int testcase = sc.nextInt();
        for(int t=1;t<=testcase;t++){
            int n = sc.nextInt();
            HashMap<Integer,HashSet<Integer>> c = new HashMap();
            HashMap<Integer,HashSet<Integer>> r = new HashMap();
            int rc=0;
            int cc=0;
            HashSet<Integer> rs=new HashSet<Integer>();
            HashSet<Integer> cs=new HashSet<Integer>();
            int trace = 0;
            for(int row=0;row<n;row++){
                for(int col=0;col<n;col++){
                    int a = sc.nextInt();
                    if(row==col) trace+=a;
                    if(!rs.contains(row) && r.get(row)!=null && r.get(row).contains(a)) {
                        rc++;
                        rs.add(row);
                    }
                    if(!cs.contains(col) && c.get(col)!=null && c.get(col).contains(a)) {
                        cc++;
                        cs.add(col);
                    }
                    if(r.get(row)==null)r.put(row,new HashSet<Integer>());
                    if(c.get(col)==null)c.put(col,new HashSet<Integer>());
                    r.get(row).add(a);
                    c.get(col).add(a);
                }
            }
            System.out.println("Case #"+t+": "+trace+" "+rc+" "+cc);
        }
    }
}


