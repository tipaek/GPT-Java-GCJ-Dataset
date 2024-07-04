import java.util.*;
public class Solution {
    public static void main(String... args){
        
        Scanner sc = new Scanner(System.in);
        int testcase = sc.nextInt();
        sc.nextLine();
        for(int i = 1;i<=testcase;i++){
            int n = sc.nextInt();
            
        
            help arr[] =  new help[n];
            for (int j =0 ; j <n ; j++){
                arr[j] = new help(sc.nextInt(),sc.nextInt(),j);
            }
            Arrays.sort(arr);
            String r = "";
            boolean flag = true;
            int ce = 0 ,je =0;
            ce = arr[0].e;
            r += "C";
            
            
            for (int j =1 ; j <n ; j++){
                if(ce<=arr[j].s){
                    ce = arr[j].e;
                    r+="C";
                }else  if(je<=arr[j].s){
                    je = arr[j].e;
                    r+="J";
                }else {
                    flag = false; 
                    break;
                }
                
            }
            if(flag){
                char[] ans =new char[n];
                for (int j =0 ; j <n ; j++){
                    ans[arr[j].index] = r.charAt(j);
                } 
                
            System.out.println("Case #"+ i +": "+String.valueOf(ans));
            }
            else System.out.println("Case #"+ i +": "+"IMPOSSIBLE");
        }
    }
}

class help implements Comparable<help>{
    public int s , e , index;
    public int compareTo(help h ) 
    { 
        return this.s - h.s; 
    } 
    public help(int s,int e,int index){
        
        this.s = s;
        this.e = e;
        this.index = index;
    }
}