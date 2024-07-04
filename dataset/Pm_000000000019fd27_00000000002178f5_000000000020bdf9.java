import java.util.*;
public class Solution {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
     int t = sc.nextInt();
     int testCase = 1;
     while(t-->0){
         int n = sc.nextInt();
         int[] a = new int[n];
         int[] d = new int[n];
         for(int i=0;i<n;i++){
             a[i] = sc.nextInt();
             d[i] = sc.nextInt();
         }
        Arrays.sort(a);
        Arrays.sort(d);   
        int i=0,j=0;
        StringBuilder sb = new StringBuilder();
        int cd = 0;
        int jd = 0;
   while(i<n && j<n){
    if(a[i]<=d[j]){
        if(a[i]>=cd){
            sb.append("C");
            cd = d[i];
        }else if(a[i]>=jd){
            sb.append("J");
            jd = d[i];
        }else{
            break;
        }
    i++;
    }else{
        j++;
    }
}
        if(sb.toString().length()!=n){
            System.out.println("Case #"+testCase+": IMPOSSIBLE");
        }else{
            System.out.println("Case #"+testCase+": "+sb.toString());
        }

         testCase++;
         
     }

    }
}