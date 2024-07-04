import java.util.HashMap;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int tt = t;
        while(t-->0){
            int U = sc.nextInt();
            HashMap<String,String> hm = new HashMap<>();
            for(int i=0;i<10000;i++){
                String q = sc.next();
                String r = sc.next();
                hm.put(q,r);
            }
            String ans = "";
            for(int i=0;i<=9;i++){
                if(hm.containsKey(Integer.toString(i))){
                    ans+=hm.get(Integer.toString(i));
                }
            }
            System.out.println("Case #"+(tt-t)+": "+ans);
        }
    }
}
