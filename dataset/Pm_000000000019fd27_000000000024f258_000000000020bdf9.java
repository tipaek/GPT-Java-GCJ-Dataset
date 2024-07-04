import java.util.*;
public class Solution{
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
     int t = sc.nextInt();
     int testCase = 1;
     while(t-->0){
         int n = sc.nextInt();
         int[] a = new int[n];
         int[] b = new int[n];
         int[] d = new int[n];
         Map<Integer, Integer> map = new HashMap<>();
         for(int i=0;i<n;i++){
             a[i] = sc.nextInt();
             d[i] = sc.nextInt();
             b[i] = d[i];

             int val =a[i];
             map.put(d[i], val);
         }
        Arrays.sort(d);
        for(int i=0;i<n;i++){
            a[i] = map.get(d[i]);
        }
        StringBuilder sb = new StringBuilder();
        int cd = -1;
        int jd = -1;
         Map<Integer, String> hm = new HashMap<>();
        for(int i=0;i<n;i++){
            if(a[i]>=cd){
                sb.append("C");
              // hm.put(a[], "C");
                cd = d[i];
            }else if(a[i]>=jd){
                sb.append("J");
               // hm.put(a[i], "J");
                jd = d[i];
            }else{
                break;
            }
        }

        if(sb.toString().length() !=n){
            System.out.println("Case #"+testCase+": IMPOSSIBLE");
        }else{
            // for(int i=0;i<n;i++){
            //     sb.append(hm.get(b[i]));
            // }
            System.out.println("Case #"+testCase+": "+sb.toString());
        }

         testCase++;
         
     }

    }
}