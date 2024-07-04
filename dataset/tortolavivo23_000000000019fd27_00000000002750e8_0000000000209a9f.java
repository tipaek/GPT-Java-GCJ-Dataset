import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Nesting {
    public static void main(String[]Args){
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for(int s=1; s<=t; s++){
            String k = in.next();
            String sol = "";
            int pA=0;
            for(int i=0; i<k.length(); i++){
                int n = Integer.parseInt(String.valueOf(k.charAt(i)));
                if(n>pA){
                    while(n>pA){
                        sol+="(";
                        pA++;
                    }
                }
                else{
                    while(n<pA){
                        sol+=")";
                        pA--;
                    }
                }
                sol+=n;
            }
            while(pA>0){
                sol+=")";
                pA--;
            }
            System.out.println("Case #"+s+": "+sol);
        }
    }
}
