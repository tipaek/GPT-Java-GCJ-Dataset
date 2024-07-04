import java.util.ArrayList;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Collections;
class Solution{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        for(int k=1;k<=t;k++){
            int n=sc.nextInt();
            ArrayList<time> arr=new ArrayList<>();
            for(int i=0;i<n;i++){
                int a=sc.nextInt();
                int b=sc.nextInt();
                arr.add(new time(a,b,i));
            }
            Collections.sort(arr,(t1,t2)->t1.s-t2.s);
            time prevC=new time(0,0,0);
            time prevJ=new time(0,0,0);
            char ans[]=new char[n];
            for(int j=0;j<arr.size();j++){
                if(prevC.s==0 && prevC.e==0){
                    ans[arr.get(j).pos]='C';
                    prevC=new time(arr.get(j).s,arr.get(j).e,arr.get(j).pos);
                }
                else if(arr.get(j).s>=prevC.e || arr.get(j).e<=prevC.s){
                    ans[arr.get(j).pos]='C';
                    prevC=new time(arr.get(j).s,arr.get(j).e,arr.get(j).pos);
                }
                else{
                    if(prevJ.s==0 && prevJ.e==0){
                        ans[arr.get(j).pos]='J';
                        prevJ=new time(arr.get(j).s,arr.get(j).e,arr.get(j).pos);
                    }
                    else if(arr.get(j).s>=prevJ.e || arr.get(j).e<=prevJ.s){
                        ans[arr.get(j).pos]='J';
                        prevJ=new time(arr.get(j).s,arr.get(j).e,arr.get(j).pos);
                    }
                    else{
                        ans="IMPOSSIBLE".toCharArray();
                        break;
                    }
                }
            }
           System.out.println("Case #"+k+":"+" "+(new String(ans)));
        }
    }
}
class time{
    int s;
    int e;
    int pos;
    time(int s,int e,int pos){
        this.s=s;
        this.e=e;
        this.pos=pos;
    }
}