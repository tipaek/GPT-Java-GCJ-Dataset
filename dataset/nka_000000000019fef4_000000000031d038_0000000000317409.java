import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            int x=sc.nextInt();
            int y=sc.nextInt();
            String path=sc.next();
            int yx=x+Math.abs(y);
            int yy=y+Math.abs(x);
            int len=path.length();
            int p=x;
            int q=y;
            for(int i=0;i<len;i++){
                if(path.charAt(i)=='S'){
                    p++;
                }
                else if(path.charAt(i)=='N'){
                    p--;
                }
                else if(path.charAt(i)=='E'){
                    q--;
                }
                else{
                    q++;
                }
            }
            //System.out.println(p+" "+q);
            //System.out.println(yx+" "+yy);
            int dx=Math.abs(p-yx);
            int dy=Math.abs(q-yy);
            //System.out.println(dx+" "+dy);
            if(len>=(dx+dy)){

                int output=(int)Math.abs(x-yx)+Math.abs(y-yy);
                if(output%2==0){
                    output=output/2;
                }
                else{
                    output=output/2+1;
                }
                System.out.println("Case #" + t + ": "+output);
            }else {
                System.out.println("Case #" + t + ": IMPOSSIBLE");
            }
        }
    }


}
