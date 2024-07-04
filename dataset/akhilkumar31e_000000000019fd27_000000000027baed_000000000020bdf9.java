import java.util.*;
import java.io.*;
class pair{
    int start;
    int end;
    int idx;
    pair(int s,int e,int i){
        start=s;
        end=e;
        idx=i;
    }
}
class Solution{
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int test=Integer.parseInt(br.readLine());
        for(int t=1;t<=test;t++){
            int n=Integer.parseInt(br.readLine());
            ArrayList<pair> arr=new ArrayList<pair>();
            for(int i=0;i<n;i++){
                String s2[]=br.readLine().split(" ");
                int st=Integer.parseInt(s2[0]);
                int e=Integer.parseInt(s2[1]);
                arr.add(new pair(st,e,i));
            }
            Collections.sort(arr,new Comparator<pair>(){
                public int compare(pair p1,pair p2){
                    if(p1.start>p2.start) return 1;
                    else return -1;
                }
            });
            int c=arr.get(0).end,j=0;
            char ans[]=new char[n];
            ans[arr.get(0).idx]='C';
            int i=1;
            for( i=1;i<n;i++){
               
                    if(c<=arr.get(i).start){
                        ans[arr.get(i).idx]='C';
                        c=arr.get(i).end;
                        
                    }
                    else if(j<=arr.get(i).start){
                        ans[arr.get(i).idx]='J';
                        j=arr.get(i).end;
                        
                    }
                    else{
                        System.out.println("Case #"+t+":"+" IMPOSSIBLE");
                        break;
                    }
                }
            
            if(i==n) System.out.println("Case #"+t+":"+" "+String.valueOf(ans));
        }
    }
}