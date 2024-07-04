import java.lang.*;
import java.util.*;
public class Solution{
    
    public static Map<Integer,Integer> c= new HashMap<>();
    public static Map<Integer,Integer> j=new HashMap<>();
    public static Map<Integer,Integer> se=new HashMap<>();
    public static void main(String args[]){
        Scanner sc= new Scanner(System.in);
        int testcase=sc.nextInt();
        for(int test=0;test<testcase;test++){
            int n= sc.nextInt();
            se=new HashMap<>();
            int[]start=new int[n];
            for(int i=0;i<n;i++){
                start[i]=sc.nextInt();
                se.put(start[i],sc.nextInt());
            }
            Arrays.sort(start);
            System.out.print("Case #"+Integer.toString(test+1)+": ");
            System.out.println(fn(start));
        }
    }
    public static String fn(int[]start){
        String ans="";
        for(int i=0;i<start.length;i++){
            if(checkc(start[i],se.get(start[i]))){
                ans=ans+"C";
            }else if(checkj(start[i],se.get(start[i]))){
                ans=ans+"J";
            }else{
                c=new HashMap<>();
                j=new HashMap<>();
                return "IMPOSSIBLE";
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
        }
        return false;
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