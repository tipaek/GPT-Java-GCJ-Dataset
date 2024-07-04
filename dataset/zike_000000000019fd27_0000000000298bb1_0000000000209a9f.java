import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int T = Integer.parseInt(in.nextLine());
        int count = 1;
        int current = 0;
        int old = 0;
        int res = 0;
        char par;

        for(int i = 0; i<T;i++){
            String str = in.nextLine();
            System.out.print("Case #"+count+": ");
            count++;
            for(int j = 0; j<str.length();j++){
                old = current;
                current = Integer.parseInt(String.valueOf(str.charAt(j)));
                res = old - current;
                if(res < 0){
                    par = '(';
                }else{
                    par = ')';
                }

                for(int a = 0; a< Math.abs(res); a++){
                        System.out.print(par);
                }
                System.out.print(current);


            }
            par = ')';
            for(int a = 0; a< current; a++){
                System.out.print(par);
            }
            System.out.println();
            current = 0;
        }

    }
}
