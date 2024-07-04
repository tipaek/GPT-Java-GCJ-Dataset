import java.io.*;
import java.util.*;
import java.lang.*;

class Solution{
    static class Activities implements Comparable<Activities>{
        int start,end;
        public Activities(int start,int end){
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
                ac[i]=new Activities(new Integer(st.nextToken()),new Integer(st.nextToken()));
            }
            Arrays.sort(ac);
            String ans = "";
            boolean J=false,C=false;
            int pJs=-1,pJe=-1,pCs=-1,pCe=-1,i=0;
            for(i=0;i<n;i++){
                int s = ac[i].start;
                int e = ac[i].end;
                if(pJs==-1&&pJe==-1){
                    J=true;
                    pJs=s;
                    pJe=e;
                    ans+='J';
                    continue;
                }
                else if(pCs==-1&&pCe==-1){
                    if(e<pJe){
                        C=true;
                        pCs=s;
                        pCe=e;
                        ans+='C';
                        continue;
                    }
                    else {
                        J=false;
                        C=true;
                        pCs=s;
                        pCe=e;
                        ans+='C';
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
                        C=false;
                        ans+='J';
                        J=true;
                        pJs=s;
                        pJe=e;
                        continue;
                    }
                    else{
                        J=true;
                        ans+='J';
                        pJs=s;
                        pJe=e;
                        continue;
                    }
                }
                if(C==false){
                    if(e>=pJe){
                        J=false;
                        ans+='C';
                        C=true;
                        pCs=s;
                        pCe=e;
                        continue;
                    }
                    else{
                        ans+='C';
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
                sb.append(ans).append("\n");
            }
        }
        br.close();
        System.out.println(sb);
    }
}
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            