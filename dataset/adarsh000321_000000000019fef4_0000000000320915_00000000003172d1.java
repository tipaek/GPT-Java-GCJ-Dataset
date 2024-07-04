
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
public class Solution
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        StringBuilder sb=new StringBuilder();
        for (int tt = 1; tt <= t; tt++) {
            sb.append("Case #"+tt+": ");
            int n=sc.nextInt(),d=sc.nextInt();
            Long a[]=new Long[n];
            HashSet<Long> set=new HashSet<>();
            for (int i=0;i<n;i++){
                a[i]=sc.nextLong();
                set.add(a[i]);
            }
            if (d==2){
                Arrays.sort(a);
                boolean f=false;
                for (int i=0;i<n-1;i++){
                    if (a[i].equals(a[i+1])){
                        f=true;
                        break;
                    }
                }
                if (f){
                    sb.append(0);
                }else {
                    sb.append(1);
                }
            }else if(d==3){
                Arrays.sort(a);
                boolean three=false,two=false;
                for (int i=0;i<n;i++){
                    if (i+2<n && a[i].equals(a[i+1])){
                        two=true;
                    }
                    if (i+2<n && a[i].equals(a[i+1]) && a[i].equals(a[i+2])){
                        three=true;
                    }
                }
                if (three){
                    sb.append(0);
                }else if (two){
                    sb.append(1);
                }else {
                    boolean one=false;
                    for(int i=0;i<n;i++){
                        if (set.contains(2*a[i])){
                            one=true;
                            break;
                        }
                    }
                    if (one){
                        sb.append(1);
                    }else sb.append(2);
                }
            }
            if (tt!=t) {
                sb.append("\n");
            }
        }
        System.out.print(sb);
    }
    static int dis(int a,int b,int x,int y){
        return Math.abs(a-x)+Math.abs(b-y);
    }
}