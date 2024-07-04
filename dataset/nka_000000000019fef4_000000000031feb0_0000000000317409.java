import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            int x=sc.nextInt();
            int y=sc.nextInt();
            String path=sc.next();
            int yx=x+Math.abs(x);
            int yy=y+Math.abs(y);
//            if(x==0 || y==0){
//                yx=x+Math.abs(y);
//                yy=y+Math.abs(x);
//            }
            int len=path.length();
            int p=x;
            int q=y;
            int count=0;
            boolean flag=false;
            for(int i=0;i<len;i++){
                if(path.charAt(i)=='S'){
                    q++;
                }
                else if(path.charAt(i)=='N'){
                    q--;
                }
                else if(path.charAt(i)=='E'){
                    p--;
                }
                else{
                    p++;
                }
                count++;
                int dx=Math.abs(p-yx);
                int dy=Math.abs(q-yy);
                if((dx+dy)<=count && len>=((dx+dy))){
                    int output=(int)Math.abs(x-yx)+Math.abs(y-yy);
                    if(output%2==0){
                        output=output/2;
                    }
                    else{
                        output=output/2+1;
                    }
                    System.out.println("Case #" + t + ": "+output);
                    flag=true;
                    break;
                }

            }
            if(!flag) {
                System.out.println("Case #" + t + ": IMPOSSIBLE");
            }
        }
    }


}
