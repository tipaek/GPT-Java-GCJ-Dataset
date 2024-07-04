import java.util.*;
public class Solution{

    public static void main(String[] args)throws Exception{
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int k=t;
        while(t-->0){
            int x = sc.nextInt();
            int y =sc.nextInt();
            if((ifOdd(x) && ifOdd(y)) || (ifEven(x)&&ifEven(y))){
                System.out.println("Case #"+(k-t)+": "+"IMPOSSIBLE");
                continue;
            }
            boolean flag = true;
            StringBuilder sb = new StringBuilder();
            while(true){
                if(ifOdd(x)){
                    int x1 = (x+1)/2;
                    int x2 = (x-1)/2;
                    int yy = y/2;
                    if(yy==0 && x1 ==0){
                        sb.append('W');
                        break;
                    }
                    if(yy==0 && x2 == 0){
                        sb.append('E');
                        break;
                    }
                    if(ifOdd(yy)){
                        if(ifEven(x1)){
                            sb.append('W');
                            y = yy;
                            x = x1;
                        }else {
                            sb.append('E');
                            y = yy;
                            x = x2;
                        }
                    }else{
                        if(ifOdd(x1)){
                            sb.append('W');
                            y = yy;
                            x = x1;
                        }else {
                            sb.append('E');
                            y = yy;
                            x = x2;
                        }
                    }
                }else{
                    int y1 = (y+1)/2;
                    int y2 = (y-1)/2;
                    int xx = x/2;
                    if(xx==0 && y1 ==0){
                        sb.append('S');
                        break;
                    }
                    if(xx==0 && y2 == 0){
                        sb.append('N');
                        break;
                    }
                    if(ifOdd(xx)){
                        if(ifEven(y1)){
                            sb.append('S');
                            x = xx;
                            y = y1;
                        }else {
                            sb.append('N');
                            x = xx;
                            y = y2;
                        }
                    }else{
                        if(ifOdd(y1)){
                            sb.append('S');
                            x = xx;
                            y = y1;
                        }else {
                            sb.append('N');
                            x = xx;
                            y = y2;
                        }
                    }
                }
            }
            if(flag){
                System.out.println("Case #"+(k-t)+": "+sb.toString());
            }else {
                System.out.println("Case #"+(k-t)+": "+"IMPOSSIBLE");
            }

        }
    }
    private static boolean ifOdd(int x){
        return (x & 1) == 1;
    }
    private static boolean ifEven(int x){
        return (x & 1) == 0;
    }
}

