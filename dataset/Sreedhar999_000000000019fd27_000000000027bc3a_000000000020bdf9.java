import java.io.*;
import java.util.*;

public class Solution {
    static class pair{
        int start;
        Double end;
        public pair(int start,int end,int idx){
            this.start=start;
            this.end=new Double(end);
        }
    }
    public static void main(String[] args) throws IOException{
            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        for(int w=0;w<t;w++){
            int n=Integer.parseInt(br.readLine());
            int[] st=new int[n];
            int[] en=new int[n];
            for(int i=0;i<n;i++){
                String[] str1=br.readLine().split(" ");
                st[i]=Integer.parseInt(str1[0]);
                en[i]=Integer.parseInt(str1[1]);
            }
            pair[] p=new pair[n];
            for(int i=0;i<n;i++){
                p[i]=new pair(st[i],en[i],i+1);
            }
            Arrays.sort(p, new Comparator<pair>()  
            { 
            @Override
            public int compare(pair o1, pair o2)  
            {   
                
                return o1.end.compareTo(o2.end) ; 
            } 
            });
            double jend=p[0].end;
            String str="";
            str+="J";
            double cend=0;
            for(int i=1;i<n;i++){
                if(p[i].start>=jend && p[i].start>=cend){
                    str+=String.valueOf(str.charAt(str.length()-1));
                }
                else if(p[i].start>=cend){
                    str+="C";
                    cend=p[i].end;
                }
                else if(p[i].start>=jend){
                    str+="J";
                    jend=p[i].end;
                }
                
                else if(p[i].start<jend && p[i].start<cend){
                    str="IMPOSSIBLE";
                    break;
                }
            }
            System.out.println("Case #"+(w+1)+": "+str);
        }
    }
}