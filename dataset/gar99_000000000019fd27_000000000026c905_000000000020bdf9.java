import java.util.ArrayList;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Collections;
class Solution{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        /*HashMap<Character,ArrayList<time>> map=new HashMap<>();
        for(int k=1;k<=t;k++){
            int n=sc.nextInt();
            String ans="";
            //HashMap<Character,ArrayList<time>> map=new HashMap<>();
            map.put('C',new ArrayList<time>());
            map.put('J',new ArrayList<time>());
            for(int i=0;i<n;i++){
                int a=sc.nextInt();
                int b=sc.nextInt();
                if(feasible(map.get('C'),a,b)){
                    ans+='C';
                    map.get('C').add(new time(a,b));
                }
                else{
                    if(feasible(map.get('J'),a,b)){
                        ans+='J';
                        map.get('J').add(new time(a,b));
                    }
                    else{
                        ans="IMPOSSIBLE";
                        break;
                    }
                }
            }
            System.out.println("Case #"+k+":"+" "+ans);
            map.clear();
            System.gc();
        }*/
        for(int k=1;k<=t;k++){
            int n=sc.nextInt();
            ArrayList<time> arr=new ArrayList<>();
            for(int i=0;i<n;i++){
                int a=sc.nextInt();
                int b=sc.nextInt();
                arr.add(new time(a,b));
            }
            Collections.sort(arr,(t1,t2)->t1.s-t2.s);
            time prevC=new time(0,0);
            time prevJ=new time(0,0);
            String ans="";
            for(int j=0;j<arr.size();j++){
                if(prevC.s==0 && prevC.e==0){
                    ans+='C';
                    prevC=new time(arr.get(j).s,arr.get(j).e);
                }
                else if(arr.get(j).s>=prevC.e || arr.get(j).e<=prevC.s){
                    ans+='C';
                    prevC=new time(arr.get(j).s,arr.get(j).e);
                }
                else{
                    if(prevJ.s==0 && prevJ.e==0){
                        ans+='J';
                        prevJ=new time(arr.get(j).s,arr.get(j).e);
                    }
                    else if(arr.get(j).s>=prevJ.e || arr.get(j).e<=prevJ.s){
                        ans+='J';
                        prevJ=new time(arr.get(j).s,arr.get(j).e);
                    }
                    else{
                        ans="IMPOSSIBLE";
                        break;
                    }
                }
            }
           System.out.println("Case #"+k+":"+" "+ans);
        }
    }
    /*static boolean feasible(ArrayList<time> arr,int a,int b){
        for(int i=0;i<arr.size();i++){
            if(a>=arr.get(i).e || b<=arr.get(i).s) continue;
            else return false;
        }
        return true;
    }*/
}
class time{
    int s;
    int e;
    time(int s,int e){
        this.s=s;
        this.e=e;
    }
}