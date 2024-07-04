import java.util.*;
class Solution{
    public static void main(String args[]){
        Scanner s=new Scanner(System.in);
        int t=s.nextInt();
        int m=1;
        while(t-->0){
            int n=s.nextInt();
            int arr[]=new int[n];
            int dep[]=new int[n];
            for(int i=0;i<n;i++){
                arr[i]=s.nextInt();
                dep[i]=s.nextInt();
            }
           int j1=0;
           int j2=0;
           int c1=0;
           int c2=0;
           String res="";
            for(int i=0;i<n;i++){
                if(arr[i]>=j2){
                    j2=dep[i];
                    res+="J";
                    j1=arr[i];
                }
                else if(arr[i]>=c2){
                    c2=dep[i];
                    res+="C";
                    c1=arr[i];
                }
                else if(dep[i]<=j1){
                    res+="J";
                    j1=arr[i];
                    j2=dep[i];
                }
                else if(dep[i]<=c1){
                    res+="C";
                    c1=arr[i];
                    c2=dep[i];
                }
                else{
                    res="IMPOSSIBLE";
                    break;
                }
                
            }
            System.out.println("Case #"+m+": "+res);
            m++;
        }
    }
}