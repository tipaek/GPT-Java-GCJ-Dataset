import java.util.*;
public class Solution{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int tests=sc.nextInt();
        for(int t=1;t<=tests;t++){
            int n=sc.nextInt();
            int start[]=new int[n];
            int starto[]=new int[n];
            int end[]=new int[n];
            int endo[]=new int[n];
            for(int i=0;i<n;i++){
                start[i]=sc.nextInt();
                starto[i]=start[i];
                end[i]=sc.nextInt();
                endo[i]=end[i];
            }
            Arrays.sort(starto);
            Arrays.sort(endo);
            int x=0,y=0;
            int m=starto.length,no=endo.length;
            int max=0,cur=0;
            while(x<m&&y<no){
                if(starto[x]<endo[y]){
                    cur++;
                    max=Math.max(max,cur);
                    x++;
                }else{
                    cur--;
                    y++;
                }
            }
            if(max>2){
                System.out.println("Case #"+t+": IMPOSSIBLE");
            }else{
                String ans="";
                if(max==1){
                    for(int i=0;i<n;i++)
                    ans+="C";
                    
                    System.out.println("Case #"+t+": "+ans);
                }else{
                 for(int i=0;i<n;i++){
                     int flag=0;
                     int j;
                     for(j=i-1;j>=0;j--){
                         if((start[j]<=start[i]&&start[i]<end[j])||(start[j]<end[i]&&end[i]<=end[j])||(start[i]<=start[j]&&start[j]<end[i])||(start[i]<end[j]&&end[j]<=end[i])){
                             flag=1;
                             break;
                         }
                     }
                     if(flag==1)
                     {
                         if(ans.charAt(j)=='C')
                         ans+="J";
                         else
                         ans+="C";
                     }
                     else
                     ans+="C";
                     
                     flag=0;
                 }
                 System.out.println("Case #"+t+": "+ans);
                }
            }
        }
    }
}