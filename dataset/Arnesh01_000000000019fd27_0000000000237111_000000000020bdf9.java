import java.io.*;
import java.lang.*;
import java.util.*;
public class Solution{
    public static class Activity implements Comparable<Activity>{
        int start;
        int end;
        int pos;
        char p;
        public Activity(int a,int b,int pos){start=a;end=b;p='A';this.pos=pos;}
        public int compareTo(Activity ac){ return Integer.compare(this.start,ac.start);}
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int T=Integer.parseInt(br.readLine());
        StringBuffer sb=new StringBuffer();
        for(int t=1;t<=T;t++){
            int N=Integer.parseInt(br.readLine());
            Activity[] arr=new Activity[N];
            for(int i=0;i<N;i++){
                String str[]=br.readLine().split(" ");
                int a=Integer.parseInt(str[0]);
                int b=Integer.parseInt(str[1]);
                arr[i]=new Activity(a,b,i);
            }
            Arrays.sort(arr);
            boolean flag=true;
            for(int i=0;i<N;i++){
                int C=0;int J=0;
                for(int j=0;j<i;j++){
                    if(arr[j].end>arr[i].start){
                        if(arr[j].p=='C') C++;
                        else J++;
                    }
                }
                if(C!=0 && J!=0){
                    flag=false;
                    break;
                }
                else arr[i].p=(C==0)?'C':'J';
            }
            StringBuffer sbs=new StringBuffer(N);
            if(!flag) sbs.append("IMPOSSIBLE");
            else{
                for(int i=0;i<N;i++) sbs.append('A');
                for(int i=0;i<N;i++) sbs.setCharAt(arr[i].pos,arr[i].p);
            }
            sb.append("Case #"+t+": "+sbs+"\n");
        }
        System.out.print(sb);
    }
}