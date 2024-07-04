import java.util.*;
import java.io.*;
class Solution{
    
    
    public static void main(String[] args){
        
        
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        int kk=1;
        while(t-->0){
            int n=sc.nextInt();
            int[][] arr=new int[n][3];
            for(int i=0;i<n;i++){
                for(int j=0;j<2;j++){
                    arr[i][j]=sc.nextInt();
                }
                
            }
            int ll=0;
            for(int i=0;i<n;i++){
                arr[i][2]=ll++;
            }
              Arrays.sort(arr,new Comparator<int[]>(){
                public int compare(int[] a1,int[] a2){
                    if(a1[0]>a2[0]){
                        return 1;
                    }
                    else{
                        return -1;
                    }
                    
                }}
                );
                int code=0,jam=0;
                char[] carr=new char[n];
                for(int i=0;i<carr.length;i++){
                    carr[i]='P';
                }
                for(int i=0;i<n;i++){
                    if(arr[i][0]>=code){
                        carr[arr[i][2]]='C';
                        code=arr[i][1];
                    }
                    else if(arr[i][0]>=jam){
                        carr[arr[i][2]]='J';
                        jam=arr[i][1];
                    }
                    
                }
                int idx=Integer.MIN_VALUE;
                for(int i=0;i<n;i++){
                    if(carr[i]=='P'){
                        idx=i;
                        break;
                    }
                }
                String res=new String(carr);
                if(idx==Integer.MIN_VALUE){
             System.out.println("Case #"+kk+": "+res);

                }
                else{
                    System.out.println("Case #"+kk+": IMPOSSIBLE");
                }
            
           kk+=1;
    }
    
    
    
}
}