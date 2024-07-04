import java.util.*;

public class Solution{
    public static void main(String ard[]){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        for(int tt=1;tt<=t;tt++){
            int n=sc.nextInt(),time[][]=new int [n][3];
            for(int i=0;i<n;i++){time[i][0]=sc.nextInt();time[i][1]=sc.nextInt();time[i][2]=i;}
            
            int arr[][]=new int [n*2][2];
            for(int i=0;i<2*n;i+=2){
                arr[i][0]=time[i/2][0];arr[i][1]=0;
                arr[i+1][0]=time[i/2][1];arr[i+1][1]=1;
            }
            Arrays.sort(arr,(a,b)->a[0]-b[0]==0?b[1]-a[1]:a[0]-b[0]);
            String res="";
            int count=0;
            for(int i=0;i<2*n;i++){
                if(arr[i][1]==0)
                    count++;
                else
                    count--;
                if(count==3){
                    res="IMPOSSIBLE";break;
                }
            }
            if(res.equals("IMPOSSIBLE"))
                System.out.println("Case #"+tt+": "+res);
            else{
                res+="J";
                Arrays.sort(time,(a,b)->a[0]-b[0]==0?a[1]-b[1]:a[0]-b[0]);
                for(int i=1;i<n;i++){
                    if(time[i-1][1]<=time[i][0])
                        if(res.charAt(res.length()-1)=='J')
                            res+="J";
                        else
                            res+="C";
                    else
                        if(res.charAt(res.length()-1)=='J')
                            res+="C";
                        else
                            res+="J";
                }
                char ans[]=new char[n];
                for(int i=0;i<n;i++)
                ans[time[i][2]]=res.charAt(i);
                String s="";
                for(int i=0;i<n;i++)
                    s=s+ans[i];
                System.out.print("Case #"+tt+": "+s);
                System.out.println();
            }
        }
    }
}