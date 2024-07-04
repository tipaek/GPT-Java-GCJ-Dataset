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
             b[i] = a[i];
             d[i] = sc.nextInt();
             int val =d[i];
             map.put(a[i], val);
         }
        Arrays.sort(a);
        for(int i=0;i<n;i++){
            d[i] = map.get(a[i]);
        }
        StringBuilder sb = new StringBuilder();
        int cd = -1;
        int jd = -1;
         Map<Integer, String> hm = new HashMap<>();
        for(int i=0;i<n;i++){
            if(a[i]>=cd){
               // sb.append("C");
               hm.put(a[i], "C");
                cd = d[i];
            }else if(a[i]>=jd){
                //sb.append("J");
                hm.put(a[i], "J");
                jd = d[i];
            }else{
                break;
            }
        }

        if(hm.size() !=n){
            System.out.println("Case #"+testCase+": IMPOSSIBLE");
        }else{
            for(int i=0;i<n;i++){
                sb.append(hm.get(b[i]));
            }
            System.out.println("Case #"+testCase+": "+sb.toString());
        }

         testCase++;
         
     }

    }
}