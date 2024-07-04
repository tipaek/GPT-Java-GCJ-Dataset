import java.lang.*;
import java.util.*;
public class Solution{
    
    public static Map<Integer,Integer> c= new HashMap<>();
    public static Map<Integer,Integer> j=new HashMap<>();
    public static Map<Integer,Integer> se=new HashMap<>();
    public static Map<Integer,Integer> index=new HashMap<>();
    public static void main(String args[]){
        Scanner sc= new Scanner(System.in);
        int testcase=sc.nextInt();
        for(int test=0;test<testcase;test++){
            int n= sc.nextInt();
            se=new HashMap<>();
            index=new HashMap<>();
            int[]start=new int[n];
            for(int i=0;i<n;i++){
                start[i]=sc.nextInt();
                se.put(start[i],sc.nextInt());
                index.put(start[i],i);
            }
            Arrays.sort(start);
            System.out.print("Case #"+Integer.toString(test+1)+": ");
            boolean[] ans=fn(start);
            String sol="";
            if(ans[ans.length-1]==true){
                System.out.println("IMPOSSIBLE");
            }else{
                for(int x=0;x<ans.length-1;x++){
                    if(ans[x]==false){
                        sol=sol+"C";
                    }else{
                        sol=sol+"J";
                    }
                }
                System.out.println(sol);
            }
                
        }
    }
    public static boolean[] fn(int[]start){
        boolean[] ans= new boolean[start.length+1];
        for(int i=0;i<start.length;i++){
            if(checkc(start[i],se.get(start[i]))){
                ans[index.get(start[i])]=false;
            }else if(checkj(start[i],se.get(start[i]))){
                ans[index.get(start[i])]=true;
            }else{
                c=new HashMap<>();
                j=new HashMap<>();
                ans[ans.length-1]=true;
                return ans;
            }
        }
        
                c=new HashMap<>();
                j=new HashMap<>();
        return ans;
    }
    public static boolean checkc(int curs,int cure){
        int cc=0;
        for(int key:c.keySet()){
            if((curs<key&&cure>key)){
                cc=1;
            } else if((curs>=key&&curs<c.get(key))){
                cc=1;
            }
        }
        if(cc==0){
            c.put(curs,cure);
            return true;
        }else{
            return false;
        }
    }
    public static boolean checkj(int curs,int cure){
        int cc=0;
        for(int key:j.keySet()){
            if((curs<key&&cure>key)){
                cc=1;
            } else if((curs>=key&&curs<j.get(key))){
                cc=1;
            }
        }
        if(cc==0){
            j.put(curs,cure);
            return true;
        }
        return false;
    }
}