import java.util.*;
public class Solution{
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
     int t = sc.nextInt();
     int testCase = 1;
     while(t-->0){
         int n = sc.nextInt();
         int[] a = new int[n];
         int[] d = new int[n];
         Map<Integer, Integer> map = new HashMap<>();
         for(int i=0;i<n;i++){
             a[i] = sc.nextInt();
             d[i] = sc.nextInt();
             map.put(a[i], d[i]);
         }
        Arrays.sort(a);
        for(int i=0;i<n;i++){
            d[i] = map.get(a[i]);
        }
        StringBuilder sb = new StringBuilder();
        int cd = 0;
        int jd = 0;

        for(int i=0;i<n;i++){
            if(a[i]>=cd){
                sb.append("C");
                cd = d[i];
            }else if(a[i]>=jd){
                sb.append("J");
                jd = d[i];
            }
        }

        if(sb.toString().length() !=n){
            System.out.println("Case #"+testCase+": IMPOSSIBLE");
        }else{
            System.out.println("Case #"+testCase+": "+sb.toString());
        }

         testCase++;
         
     }

    }
}