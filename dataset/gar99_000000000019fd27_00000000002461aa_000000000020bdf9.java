import java.util.ArrayList;
import java.util.Scanner;
import java.util.HashMap;
class Solution{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        HashMap<Character,ArrayList<time>> map=new HashMap<>();
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
        }
    }
    static boolean feasible(ArrayList<time> arr,int a,int b){
        for(int i=0;i<arr.size();i++){
            if(a>=arr.get(i).e || b<=arr.get(i).s) continue;
            else return false;
        }
        return true;
    }
}
class time{
    int s;
    int e;
    time(int s,int e){
        this.s=s;
        this.e=e;
    }
}