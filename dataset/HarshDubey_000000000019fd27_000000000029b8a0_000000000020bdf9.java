import java.util.*;
class pair implements Comparable<pair>{
    int x;
    int y;
    public int compareTo(pair o){
        return this.x-o.x;
    }
}

public class Solution{

     public static void main(String []args){
        Scanner s=new Scanner(System.in);
        int t=s.nextInt();
        int k=1;
        while(t-->0){
            int n=s.nextInt();
            pair[] arr=new pair[n];
            for(int i=0;i<n;i++){
                pair temp=new pair();
                temp.x=s.nextInt();
                temp.y=s.nextInt();
                arr[i]=temp;
            }
            
            Arrays.sort(arr);
            int temp=arr[0].y;
            arr[0].x=-1;
            for(int i=1;i<arr.length;i++){
                
                if(arr[i].x>=temp){
                    arr[i].x=-1;
                    temp=arr[i].y;
                }
                
            }
            
            int temp1=-1;
            for(int i=0;i<arr.length;i++){
                
                if(arr[i].x==-1){
                    continue;
                }else{
                    if(temp1==-1){
                        temp1=arr[i].y;
                        arr[i].x=-2;
                    }else{
                        if(arr[i].x>=temp1){
                            arr[i].x=-2;
                            temp1=arr[i].y;
                        }
                    }
                }
            }
            
            String str="";
            for(int i=0;i<arr.length;i++){
                if(arr[i].x>=0){
                    str="IMPOSSIBLE";
                    break;
                }else if(arr[i].x==-1){
                    str+="C";
                }else{
                    str+="J";
                }
            }
            
            System.out.println("Case #"+k+": "+str);
            k++;
        }
     }
}