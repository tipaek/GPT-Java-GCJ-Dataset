import java.util.*;
import java.io.*;  

public class Solution{
    public static class pair{
        int x;
        int y;
        int z;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        int u=1;
        while(t-->0){
            int n=Integer.parseInt(br.readLine());
            ArrayList<pair> list=new ArrayList<>();
            for(int i=0;i<n;i++){
                String line=br.readLine();
                String[] strs=line.trim().split(" ");
                pair p=new pair();
                p.x=Integer.parseInt(strs[0]);
                p.y=Integer.parseInt(strs[1]);
                p.z=i;
                list.add(p);
            }
            Collections.sort(list,new Comp());
            int c=list.get(0).y;
            int j=0;
            StringBuffer sb=new StringBuffer();
            sb.append("C");
            int s=0;
            for(int i=1;i<n;i++){
                char ch=sb.charAt(sb.length()-1);
                if(ch=='C'){
                    if(c<=list.get(i).x){
                        sb.append("C");
                        c=list.get(i).y;
                    }else if(j<=list.get(i).x){
                        sb.append("J");
                        j=list.get(i).y;
                    }else{
                        s=1;
                        break;
                    }
                }else{
                    if(j<=list.get(i).x){
                        sb.append("J");
                        j=list.get(i).y;
                    }else if(c<=list.get(i).x){
                        sb.append("C");
                        c=list.get(i).y;
                    }else{
                        s=1;
                        break;
                    }
                }
            }
            // System.out.println(sb);
            
            if(s==1){
                System.out.println("Case #"+u+": IMPOSSIBLE");
            }else{
                char[] ar=new char[n];
                StringBuffer sh=new StringBuffer();
                for(int i=0;i<n;i++){
                    char ch=sb.charAt(i);
                    int index=list.get(i).z;
                    ar[index]=ch;
                }
                for(int i=0;i<n;i++){
                    sh.append(ar[i]+"");
                }
                System.out.println("Case #"+u+": "+sh);
            }
            u++;
        }
    }
    public static class Comp implements Comparator<pair>{
        @Override
        public int compare(pair a,pair b){
            if(a.x!=b.x){
                return a.x-b.x;
            }else{
                return a.y-b.y;
            }
        }
    }
}
