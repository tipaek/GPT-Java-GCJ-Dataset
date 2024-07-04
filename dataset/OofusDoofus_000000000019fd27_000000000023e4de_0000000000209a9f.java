import java.io.*;
import java.util.*;

public class Q2020Depth {

    public static void main(String[] args){

        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int T = in.nextInt();
        in.nextLine();

        for(int a = 0; a < T; a++){
            String str = in.nextLine();
            int current = 0;

            System.out.print("Case #" + a + ": ");
            for(int i = 0; i < str.length(); i++){
                if(Integer.parseInt(str.substring(i,i+1)) > current){
                    for(int j = 0; j < Integer.parseInt(str.substring(i,i+1)) - current; j++){
                        System.out.print('(');

                    }

                }
                else {
                    for (int j = 0; j < current - Integer.parseInt(str.substring(i, i + 1)); j++) {
                        System.out.print(')');

                    }

                }
                System.out.print(str.substring(i,i+1));
                current = Integer.parseInt(str.substring(i, i + 1));


            }
            for (int j = 0; j < Integer.parseInt(str.substring(str.length()-1)); j++) {
                System.out.print(')');

            }
            System.out.println();


        }

    }

}
