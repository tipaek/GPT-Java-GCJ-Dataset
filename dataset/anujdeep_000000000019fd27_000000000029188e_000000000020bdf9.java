import java.util.*;
import java.io.*;
public class Solution{
    static class interval{
        int s,e,index;
        interval(int st,int ed,int ind){
            s=st;
            e=ed;
            index=ind;
        }
    }
    static class ans{
        char c;
        int i;
        ans(char ch,int ind){
            c=ch;
            i=ind;
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
                arr[i]=new interval(st,ed,i);
            }
            Arrays.sort(arr,new Comparator<interval>(){
                    public int compare(interval a,interval b){
                        return a.s-b.s;
                    }
            });
            int status=0;
            
            ans arr1[]=new ans[n];
            arr1[0]=new ans('C',arr[0].index);
            int je=-1,ce=arr[0].e;
            
            for(int i=0;i<n-1;i++){
                //System.out.println(ce+" "+je+" "+arr[i+1].s);
                if((ce<=arr[i+1].s)){
                  // System.out.println(ce+" "+arr[i+1].s);
                    arr1[i+1]=new ans('C',arr[i+1].index);
                    
                    ce=arr[i+1].e;
                }
                else if((je<=arr[i+1].s )){
                   // System.out.println(je+" "+arr[i+1].s);
                    arr1[i+1]=new ans('J',arr[i+1].index);
                    
                    je=arr[i+1].e;
                }
                else{
                    //System.out.println(ce+" "+je+" "+arr[i+1].s);
                    status=1;
                    break;
                }
            }
            if(status==1)
            System.out.println("Case #"+k+": "+"IMPOSSIBLE");
            else{
                Arrays.sort(arr1,new Comparator<ans>(){
                    public int compare(ans x,ans y){
                        return x.i-y.i;
                    }
                });
                System.out.print("Case #"+k+": ");
                for(int i=0;i<n;i++)
                System.out.print(arr1[i].c);
                System.out.println();
            }
        }
    }
}
