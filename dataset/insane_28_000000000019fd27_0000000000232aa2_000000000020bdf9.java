import java.io.*;
import java.util.*;
import java.lang.*;

class Solution{
    static class Activities implements Comparable<Activities>{
        int start,end,index;
        public Activities(int start,int end,int i){
            this.index = i;
            this.start=start;
            this.end=end;
        }
        public int compareTo(Activities o){
            return this.start-o.start;
        }
    }
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = new Integer(br.readLine());
        StringBuffer sb = new StringBuffer();
        for(int z=1;z<=t;z++){
            sb.append("Case #").append(z).append(": ");
            int n = new Integer(br.readLine());
            Activities[] ac = new Activities[n];
            for(int i=0;i<n;i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                ac[i]=new Activities(new Integer(st.nextToken()),new Integer(st.nextToken()),i);
            }
            Arrays.sort(ac);
            char[] ans = new char[n];
            boolean J=false,C=false;
            int pJs=-1,pJe=-1,pCs=-1,pCe=-1,i=0;
            for(i=0;i<n;i++){
                int s = ac[i].start;
                int e = ac[i].end;
                if(pJs==-1&&pJe==-1){
                    J=true;
                    pJs=s;
                    pJe=e;
                    ans[ac[i].index]='J';
                    continue;
                }
                else if(pCs==-1&&pCe==-1){
                    if(e<pJe){
                        C=true;
                        pCs=s;
                        pCe=e;
                        ans[ac[i].index]='C';
                        continue;
                    }
                    else {
                        C=true;
                        pCs=s;
                        pCe=e;
                        ans[ac[i].index]='C';
                        continue;
                    }
                }
                if(s>=pJe){
                    J=false;
                }
                if(s>=pCe){
                    C=false;
                }
                if(J==false){
                    if(e>=pCe){
                        ans[ac[i].index]='J';
                        J=true;
                        pJs=s;
                        pJe=e;
                        continue;
                    }
                    else{
                        J=true;
                        ans[ac[i].index]='J';
                        pJs=s;
                        pJe=e;
                        continue;
                    }
                }
                if(C==false){
                    if(e>=pJe){
                        ans[ac[i].index]='C';
                        C=true;
                        pCs=s;
                        pCe=e;
                        continue;
                    }
                    else{
                        ans[ac[i].index]='C';
                        C=true;
                        pCs=s;
                        pCe=e;
                        continue;
                    }
                }
                if(J&&C){
                    sb.append("IMPOSSIBLE\n");
                    break;
                }
            }
            if(i==n){
                for(int k=0;k<n;k++){
                    sb.append(ans[k]);
                }
                sb.append("\n");
            }
        }
        br.close();
        System.out.println(sb);
    }
}