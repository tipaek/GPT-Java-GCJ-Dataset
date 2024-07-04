

import java.util.Scanner;

public class Solution{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        in.nextLine();
        nextTest:for(int i=1;i<=t;i++){
            String inp = in.nextLine();
            String arr[]=inp.split(" ");
            int x = Integer.parseInt(arr[0]);
            int y = Integer.parseInt(arr[1]);
            String path = arr[2];
            if(path.length()<x){
                System.out.println("Case #"+i+": IMPOSSIBLE");
            }else{
                int cost = x;
                int hx=x;
                int hy=0;
                //after x H step
                int ccy=y;
                for(int j=0;j<x;j++){
                    if('N'==path.charAt(j)){
                        ccy++;
                    }else{
                        ccy--;
                    }
                }
                if(hx==x&&hy==ccy){
                    System.out.println("Case #"+i+": "+cost);
                    continue nextTest;
                }else{
                    //find away char
                    char away='N';
                    if(ccy<hy){
                        away='S';
                    }
                    for(int j=x;j<path.length();j++){
                        if(hy==ccy){
                            System.out.println("Case #"+i+": "+cost);
                            continue nextTest;
                        }
                        if('N'==path.charAt(j)){
                            ccy++;
                        }else{
                            ccy--;
                        }
                        if(away=='N') {
                            if(ccy-hy>1)
                            hy++;
                        }
                        else {
                            if(hy-ccy>1)
                            hy--;
                        }
                        cost++;
                    }
                    if(hy==ccy){
                        System.out.println("Case #"+i+": "+cost);
                        continue nextTest;
                    }else
                    System.out.println("Case #"+i+": IMPOSSIBLE");
                }
            }
        }
    }

    //System.out.println("Case #"+i+": ");
}
