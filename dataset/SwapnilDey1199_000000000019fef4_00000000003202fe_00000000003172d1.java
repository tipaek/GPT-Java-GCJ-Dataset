import java.io.*;
import java.util.*;
import java.lang.*;
public class Solution{
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        StringBuffer sb=new StringBuffer();
        for(int z=1;z<=t;z++){
            int n = sc.nextInt();
            int d = sc.nextInt();
            Map<Long,Integer> map=new HashMap<>();
            long[] arr=new long[n];
            long lar=0;
            for(int i=0;i<n;i++){
                long a = sc.nextLong();
                arr[i]=a;
                if(a>lar) lar=a;
                if(map.containsKey(a)){
                    int f=map.get(a);
                    map.put(a,f+1);
                }
                else map.put(a,1);
            }
            if(d==2){
                int cut=1;
                for(int i=0;i<n;i++){
                    long a=arr[i];
                    if(map.get(a)>=2){
                        cut=0;
                        break;
                    }
                }
                sb.append("Case #"+z+": "+cut+"\n");
            }
            if(d==3){
                int cut=2;
                for(int i=0;i<n;i++){
                    long a=arr[i];
                    if(map.get(a)>=3){
                        if(cut>0) cut=0;
                    }
                    if(map.containsKey(2*a)){
                        if(cut>1) cut=1;
                    }
                    if(map.get(a)==2 && a!=lar){
                        if(cut>1) cut=1;
                    }
                }
                sb.append("Case #"+z+": "+cut+"\n");
            }
        }
        System.out.print(sb);
    }
}