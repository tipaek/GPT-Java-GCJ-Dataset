import java.io.*;
import java.util.*;
import java.lang.*;
public class Solution{
    public static void main(String[] args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int T=Integer.parseInt(br.readLine());
        StringBuffer sb=new StringBuffer();
        for(int mm=1;mm<=T;mm++){
            String str[] =br.readLine().split(" ");
            int N=(int)Long.parseLong(str[0]);
            int D=(int)Long.parseLong(str[1]);
            HashMap<Long,Integer> map=new HashMap<Long,Integer>();
            long[] arr=new long[N];
            long largest=0;
            StringTokenizer st=new StringTokenizer(br.readLine()," ");
            for(int i=0;i<N;i++){
                Long a=Long.parseLong(st.nextToken());
                arr[i]=a;
                if(a>largest) largest=a;
                if(map.containsKey(a)){
                    int f=map.get(a);
                    map.remove(a);
                    map.put(a,f+1);
                }
                else map.put(a,1);
            }
            if(D==2){
                int cut=1;
                for(int i=0;i<N;i++){
                    long a=arr[i];
                    if(map.get(a)>=2){
                        cut=0;
                        break;
                    }
                }
                sb.append("Case #"+mm+": "+cut+"\n");
            }
            if(D==3){
                int cut=2;
                for(int i=0;i<N;i++){
                    long a=arr[i];
                    if(map.get(a)>=3){
                        if(cut>0) cut=0;
                    }
                    if(map.containsKey(2*a)){
                        if(cut>1) cut=1;
                    }
                    if(map.get(a)==2 && a!=largest){
                        if(cut>1) cut=1;
                    }
                }
                sb.append("Case #"+mm+": "+cut+"\n");
            }
        }
        System.out.print(sb);
    }
}
            