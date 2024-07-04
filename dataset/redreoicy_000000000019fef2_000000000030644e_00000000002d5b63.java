import java.util.*;


public class Solution {
    
    static String response = "START";
    static Scanner stdin = new Scanner(System.in);
    
    static int leftmost(int l, int r, int h){
        while(l<r && !response.equals("CENTER")){
            int lrmid = (l+r-1)/2;
            System.out.println(lrmid + " " + h);
            response = stdin.next();
            if(response.equals("HIT")){
                r = lrmid;
            }
            if(response.equals("MISS")){
                l = lrmid+1;
            }
        }
            return r;
    }
    
    static int rightmost(int l, int r, int h){
        while(l<r && !response.equals("CENTER")){
            int lrmid = (l+r-1)/2;
            System.out.println(lrmid + " " + h);
            response = stdin.next();
            if(response.equals("HIT")){
                l = lrmid+1;
            }
            if(response.equals("MISS")){
                r = lrmid;
            }
        }
        return r;

    }

    public static void main(String[] args) {
        int t = stdin.nextInt();
        int a = stdin.nextInt();
        int b = stdin.nextInt();
        for (int k = 0; k < t; k++) {
            response = "start";
            int u = 500000001;
            int d = -500000001;
            int udmid=0;
            while(d<u && !response.equals("CENTER")){
                udmid = (d+u-1)/2;
                int cLeft = leftmost(-1000000000, -999999940, udmid);
                System.out.println(cLeft + " " + (udmid+1));
                response = stdin.next();
                if(response.equals("HIT")){//circle opens upwards
                    d = udmid;
                }else{
                    System.out.println(cLeft + " " + (udmid-1));
                    response = stdin.next();
                    if(response.equals("HIT")){
                        u = udmid;
                    }else{
                        break; //udmid is the widest point of circle
                    }
                }
            }
            int rightPoint = rightmost(999999940, 1000000000, udmid);
            int leftPoint = leftmost(-1000000000, -999999940, udmid);
            int center = (rightPoint+leftPoint)/2;
            System.out.println(center + " " + udmid);
            
        }

    }
    
}
