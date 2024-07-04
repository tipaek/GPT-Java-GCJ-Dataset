import java.util.*;
class Solution {
    public static void main(String[] args) {
        Scanner ob = new Scanner(System.in);
        int t = ob.nextInt();
        for(int tim=1;tim<=t;tim++) {
            int n = ob.nextInt();
            int k = ob.nextInt();
            int mid = k/n;
            List<List<Integer>> arr = new LinkedList();

            for(int i=0;i<n;i++) {
                List<Integer> row = new ArrayList<>(n);
                for(int j=0;j<n;j++) {
                    int p = n-i;
                    int val = ((p+j)%n)+mid;
                    if(val>n)
                        val-=n;
                    row.add(val);
                }
                arr.add(row);
            }
            int trace=0;
            for(int i=0;i<n;i++) {
                for(int j=0;j<n;j++) {
                    if(i==j)
                        trace+=arr.get(i).get(j);
                }
            }
            if(trace==k) {
                System.out.println("Case #"+tim+": POSSIBLE");
                for(int i=0;i<n;i++) {
                    for(int j=0;j<n;j++) {
                        System.out.print(arr.get(i).get(j)+" ");
                    }
                    System.out.println();
                }
            } else 
                System.out.println("Case #"+tim+": IMPOSSIBLE");
        }
    }
}