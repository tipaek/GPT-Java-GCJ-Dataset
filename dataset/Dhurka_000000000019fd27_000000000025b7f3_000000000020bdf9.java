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
           int j[]=new int[2];
           int c[]=new int[2];
           String res="";
            for(int i=0;i<n;i++){
                if(arr[i]>=j[1]){
                    j[1]=dep[i];
                    res+="J";
                    j[0]=arr[i];
                }
                else if(arr[i]>=c[1]){
                    c[1]=dep[i];
                    res+="C";
                    c[0]=arr[i];
                }
                else if(dep[i]<=j[0]){
                    res+="J";
                    j[0]=arr[i];
                    j[1]=dep[i];
                }
                else if(dep[i]<=c[0]){
                    res+="C";
                    c[0]=arr[i];
                    c[1]=dep[i];
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