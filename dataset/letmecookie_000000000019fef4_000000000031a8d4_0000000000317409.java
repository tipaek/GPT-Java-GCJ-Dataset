import java.util.Scanner;



public class Solution {



    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int i = 0; i<t;i++){
            int x = in.nextInt();
            int y = in.nextInt();
            if(x == 0 && y==0){
                System.out.println("Case #" + (i+1) + ": " + 0);
                continue;
            }

            String s = in.next();

            char[] arr = s.toCharArray();
            boolean ok = false;
            for(int k = 0; k<arr.length;k++){

                if(arr[k] == 'N') y++;
                else if(arr[k] == 'S') y--;
                else if(arr[k] == 'W') x--;
                else x++;
                int p = Math.abs(x) + Math.abs(y);
                if(p<=(k+1)){
                    ok = true;
                    System.out.println("Case #" + (i+1) + ": " + (k+1));
                    break;
                }
            }

            if(!ok) System.out.println("Case #" + (i+1) + ": IMPOSSIBLE");





        }
    }

}
