import java.util.*;
public class Solution{
public static class pair implements Comparable<pair>{
    int st;
    int en;
    int idx;
    public pair(int st,int en,int idx){
        this.st=st;
        this.en=en;
        this.idx=idx;
    }
    public int compareTo(pair o){
        
     return this.st-o.st;   
    }
    
}    
    
    public static void main(String[] args){
    
    int tc=0;
    int l=1;
    Scanner s=new Scanner(System.in);
    if(s.hasNext())
    tc=s.nextInt();
        while(tc-->0){
        int n=s.nextInt();
        pair[] arr=new pair[n];
        for(int i=0;i<n;i++){
            int st=s.nextInt();
            int en=s.nextInt();
            arr[i]=new pair(st,en,i);
        }
        Arrays.sort(arr);
        
        int ce=0;
        int je=0;
        String ans="";
        pair curr=arr[0];
        char[] a1=new char[n];
        for(int i=0;i<n;i++){
            pair np=arr[i];
            if(ce<=np.st){
                ans+="C";
                a1[np.idx]='C';
                ce=np.en;
            }else if(je<=np.st){
                ans+="J";
                a1[np.idx]='J';
                je=np.en;
            }
            else{
                ans="IMPOSSIBLE";
                break;
            }
        }
        if(!ans.equals("IMPOSSIBLE")){
            ans="";
            for(int i=0;i<n;i++)
            ans+=a1[i]+"";
        }
        System.out.println("Case #"+l+": "+ans);
        l++;
        }
    
 }   
    
    
    
}