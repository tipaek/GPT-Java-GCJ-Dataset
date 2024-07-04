import java.util.Scanner;

public class Solution {
    private static String PATTEN = "Case #%d: %s";
    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        for (int p = 1; p <= t; p++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            if ((x ==0 ) && (y==0)){
                System.out.println(String.format(PATTEN, p, ""));
                continue;
            }
            int zhengX = x;
            if (zhengX<0){
                zhengX = -zhengX;
            }
            int zhengY = y;
            if (zhengY<0){
                zhengY = -zhengY;
            }
            if ((zhengX+zhengY) % 2 ==0){
                System.out.println(String.format(PATTEN, p, "IMPOSSIBLE"));
                continue;
            }
            long value =1;
            boolean flag = false;
            StringBuilder sb = new StringBuilder();
            for (int i =0;i<=32;i++){
                long k = value-zhengX -zhengY;
                if (k<0){
                    value = value*2;
                    continue;
                }
                k = k/2;
                for (int b=0;b<=k;b++){
                    long d = k-b;
                    long a = zhengX+b;
                    long c = zhengY+d;
                    if ( ((a&b)==0) && ((a&c)==0) && ((a&d)==0) && ((b&c)==0) && ((b&d)==0)  && ((c&d)==0) ){
                        long vv = 1;
                        for (int q = 0;q<=i;q++){
                            if ((a&vv)!=0){
                                if (zhengX == x){
                                    sb.append('E');
                                } else {
                                    sb.append('W');
                                }
                            }
                            if ((b&vv)!=0){
                                if (zhengX == x){
                                    sb.append('W');
                                } else {
                                    sb.append('E');
                                }
                            }
                            if ((c&vv)!=0){
                                if (zhengY == y){
                                    sb.append('N');
                                } else {
                                    sb.append('S');
                                }
                            }
                            if ((d&vv)!=0){
                                if (zhengY == y){
                                    sb.append('S');
                                } else {
                                    sb.append('N');
                                }
                            }
                            vv = vv*2;
                        }
                        flag = true;
                        System.out.println(String.format(PATTEN, p, sb.toString()));
                        break;
                    }
                }
                if (sb.length()>0){
                    break;
                }
                value = value*2;
            }
            if (!flag){
                System.out.println(String.format(PATTEN, p, "IMPOSSIBLE"));
            }
        }
    }
}