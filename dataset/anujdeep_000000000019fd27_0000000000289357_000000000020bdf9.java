import java.util.*;
import java.io.*;
public class Solution{
    static class interval{
        int s,e;
        interval(int st,int ed){
            s=st;
            e=ed;
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        for(int k=1;k<=t;k++){
            int n=sc.nextInt();
            interval arr[]=new interval[n];
            for(int i=0;i<n;i++){
                int st=sc.nextInt();
                int ed=sc.nextInt();
                arr[i]=new interval(st,ed);
            }
            Arrays.sort(arr,new Comparator<interval>(){
                    public int compare(interval a,interval b){
                        return a.s-b.s;
                    }
            });
            int status=0;
            StringBuffer sb=new StringBuffer();
            sb.append("C");
            int je=-1,ce=arr[0].e;
            for(int i=0;i<n-1;i++){
                if(ce<=arr[i+1].s){
                   
                    sb.append("C");
                    ce=arr[i+1].e;
                }
                else if(je<=arr[i+1].s ){
                    sb.append("J");
                    je=arr[i+1].e;
                }
                else{
                    status=1;
                    break;
                }
            }
            if(status==1)
            System.out.println("Case #"+k+": "+"IMPOSSIBLE");
            else
            System.out.println("Case #"+k+": "+sb);
        }
    }
}