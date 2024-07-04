import java.io.FileNotFoundException;
import java.util.Scanner;

class Solution {//Rename to Solution
    static Scanner scan;
    public static void main(String[] args) throws FileNotFoundException {
        scan = new Scanner(System.in);
        int T = scan.nextInt();
        for(int t = 1; t <= T; t++){
            int a = scan.nextInt();
            int b = scan.nextInt();
            String s = "";
            boolean hit = false;
            boolean center = false;
            int s1 = 0; int s2 = 0;
            for(int i = -1000000000+a/2; i<=1000000000 && !hit && !center; i+=a){
                for(int j = -1000000000+a/2; j<=1000000000 && !hit && !center; j+=a) {
                    int q = query(i,j);
                    if(q == 1){
                        s1 = i; s2 = j; hit = true;
                    }
                    if(q==2)
                        center = true;
                }
            }
            int dist = Math.abs((s1+1000000000))/4;
            int x1 = (s1-1000000000)/2; int x2 = (s1+1000000000)/2;
            int y1 = (s2-1000000000)/2; int y2 = (s2+1000000000)/2;
            while(dist>0 && !center){
                int q = query(x1,s2);
                if (q == 0){
                    x1+=dist;
                }
                else if(q==1)x1-=dist;
                else center = true;
                dist>>=1;
            }
            dist = Math.abs((1000000000-s1))/4;
            while(dist>0 && !center){
                int q = query(x2,s2);
                if (q == 0){
                    x2-=dist;
                }
                else if(q==1)x2+=dist;
                else center = true;
                dist>>=1;
            }
            dist = Math.abs((s2+1000000000))/4;
            while(dist>0 && !center){
                int q = query(s1,y1);
                if (q == 0){
                    y1+=dist;
                }
                else if(q==1)y1-=dist;
                else center = true;
                dist>>=1;
            }
            dist = Math.abs((1000000000-s2))/4;
            while(dist>0 && !center){
                int q = query(s1,y2);
                if (q == 0){
                    y2-=dist;
                }
                else if(q==1)y2+=dist;
                else center = true;
                dist>>=1;
            }
            s1 = (x1+x2)/2;
            s2 = (y1+y2)/2;
            for(int i = -2; i <=2; i++){
                for(int j = -2; j <=2; j++){
                    if(!center){
                        int q = query(s1+i,s2+j);
                        if (q==2) center = true;
                    }
                }
            }
        }
        scan.close();
    }
    public static int query(int x,int y){
        System.out.print(x + " " + y);
        String s = scan.next();
        if(s.equals("MISS")) return 0;
        if(s.equals("HIT")) return 1;
        else return 2;
    }
}