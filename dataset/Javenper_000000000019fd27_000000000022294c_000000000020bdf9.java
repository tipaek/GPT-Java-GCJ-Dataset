import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        for(int i = 0; i < t; i++){
            int n = sc.nextInt();
            String plan ="";
            String J = "";
            String C = "";
            //int[][] h = new int[n][2];
            int start, end;
            for(int j = 0; j < n; j++){
                start = sc.nextInt();
                end = sc.nextInt();
                if(job(C,start,end)){
                    C += Integer.toString(start)+" ";
                    C += Integer.toString(end)+" ";
                    plan +="C";
                } else if (job(J,start,end)){
                    J += Integer.toString(start)+" ";
                    J += Integer.toString(end)+" ";
                    plan += "J";
                }else{
                    System.out.println("Case #"+(i + 1)+": IMPOSSIBLE");
                    plan = "";
                    break;
                }
            }
            if(plan.length() > 0)
                System.out.println("Case #"+(i + 1)+": "+plan);
        }
    }
    
    private static boolean job(String j, int s, int e){
        String[] h = j.split(" ");
        if(h.length < 2)
            return true;
        for(int i = 0; i < h.length; ){
            
            int a = Integer.parseInt(h[i]);
            int b = Integer.parseInt(h[++i]);
            if((s < a) && (e <= a)){
                return true;
            } else if(s >= b){
                return true;
            } else
                return false;
        }
        return false;
    }
}
