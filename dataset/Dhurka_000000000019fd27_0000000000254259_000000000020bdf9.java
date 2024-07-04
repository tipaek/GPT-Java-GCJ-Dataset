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
            String res="";
            int min=0;
            int flag=0;
            for(int i=0;i<n;i++){
                min=arr[i];
                flag=i;
                for(int j=i;j<n;j++){
                    if(arr[j]<min){
                        min=arr[j];
                        flag=j;
                    }
                }
                int temp=arr[i];
                arr[i]=min;
                arr[flag]=temp;
                temp=dep[i];
                dep[i]=dep[flag];
                dep[flag]=temp;
            }
            int jc[]=new int[2];
            
            for(int i=0;i<n;i++){
                if(arr[i]>=jc[0]){
                    jc[0]=dep[i];
                    res+="J";
                }
                else{
                    if(arr[i]>=jc[1]){
                    jc[1]=dep[i];
                    res+="C";
                }
                else{
                    res="IMPOSSIBLE";
                    
                    break;
                }
                }
                
            }
            System.out.println("Case #"+m+": "+res);
            m++;
        }
    }
}