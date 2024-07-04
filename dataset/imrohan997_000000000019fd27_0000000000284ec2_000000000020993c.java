import java.util.*;
class Solution{
    public static void main(String args[]){
        Scanner scn=new Scanner(System.in);
        int t=scn.nextInt();
        int count=1;
        while(t-->0){
            int n=scn.nextInt();
            int arr[][]=new int[n][n];
            for(int i=0;i<n;++i){
                for(int j=0;j<n;++j){
                    arr[i][j]=scn.nextInt();
                }
            }
            vestigium(arr,n,count++);
            
            
        }
        
    }
    private static void vestigium(int arr[][],int n,int count){
        
        int t=0;
        int rr=0;
        int rc=0;
        for(int i=0;i<n;++i){
            for(int j=0;j<n;++j){
                if(i==j){
                    t+=arr[i][j];
                }
            }
        }
        for(int i=0;i<n;++i){
            HashSet<Integer> map=new HashSet<>();
            for(int j=0;j<n;++j){
                if(map.contains(arr[i][j])){
                    rr++;
                    break;
                }else{
                    map.add(arr[i][j]);
                }
            }
        }
       // System.out.println(rr);
        
        for(int j=0;j<n;++j){
            HashSet<Integer> set=new HashSet<>();
            for(int i=0;i<n;++i){
                if(set.contains(arr[i][j])){
                    rc++;
                    break;
                }else{
                    set.add(arr[i][j]);
                }
            }
        }
        System.out.println("Case #"+count+": "+t+" "+rr+" "+rc);
    }
}