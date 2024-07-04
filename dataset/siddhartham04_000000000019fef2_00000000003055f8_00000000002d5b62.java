import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();

        for(int test = 1; test<=t; test++){
            int x = scan.nextInt();
            int y = scan.nextInt();

            String xBin = Integer.toBinaryString(Math.abs(x));
            String yBin = Integer.toBinaryString(Math.abs(y));
            String aux ="";
            boolean xOry = false; //false = y

            for(int i = 0; i<Math.abs(xBin.length() - yBin.length()); i++){
                if(xBin.length() > yBin.length()){
                    yBin = "0" + yBin;
                }
                else {
                    xBin = "0"+ xBin;
                }
            }

           int check = check(xBin, yBin, aux);

            ArrayList<String> ans = new ArrayList<>();
            if(check == -1){
                System.out.println("Case #" + test+": IMPOSSIBLE");
            }

            else if(check == 1){
                 aux = Integer.toBinaryString((int)(Math.pow(2, xBin.length())));

                 String temp = Integer.toBinaryString(Integer.parseInt(aux, 2) - Integer.parseInt(xBin, 2));
                for(int i = 0; i<Math.abs(temp.length() - yBin.length()); i++){

                    temp = "0"+ temp;

                }
                 int c1 = check(temp, yBin, aux);

                 if(c1 == 0){
                     for(int i = yBin.length()- 1; i >=0; i--){
                         if(i < temp.length() && temp.charAt(i) == '1'){
                             if(x > 0) ans.add("W");
                             else ans.add("E");
                         }
                         else {
                             if(y > 0) ans.add("N");
                             else ans.add("S");
                         }
                     }
                     if(x>0) ans.add("E");
                     else ans.add("W");
                     System.out.print("Case #" +test+": " );
                     for(String a: ans){
                         System.out.print(a);
                     }
                     System.out.println();
                     continue;
                 }
                 temp = Integer.toBinaryString(Integer.parseInt(aux, 2) - Integer.parseInt(yBin, 2));
                for(int i = 0; i<Math.abs(temp.length() - xBin.length()); i++){

                    temp = "0"+ temp;

                }
                 int c2 = check(temp, xBin, aux);


                if(c2 == 0){
                    for(int i = xBin.length()- 1; i >=0; i--){
                        if(i < temp.length() && temp.charAt(i) == '1'){
                           if(y > 0) ans.add("S");
                           else ans.add("N");
                        }
                        else {
                            if(x > 0) ans.add("E");
                            else ans.add("W");
                        }
                    }
                    if(y > 0) ans.add("N");
                    else ans.add("S");
                    System.out.print("Case #" +test+": " );
                    for(String a: ans){
                        System.out.print(a);
                    }
                    System.out.println();
                    continue;
                }
                System.out.println("Case #" + test+": IMPOSSIBLE");
            }
            else{
                ArrayList<String> a = new ArrayList<>();
                for(int i = xBin.length() -1; i >= 0; i--){
                    if(xBin.charAt(i) == '1') {
                       if(x>0) a.add("E");
                       else a.add("W");
                    }
                    else {
                        if(y > 0) a.add("N");
                        else a.add("S");
                    }
                }
                System.out.print("Case #" + test+": ");
                for(String b: a){
                    System.out.print(b);
                }
                System.out.println();
                continue;
            }

        }


    }

    private static int check (String xBin, String yBin, String aux){
            for(int i = 0; i<xBin.length(); i++){
                char a = xBin.charAt(i);
                char b = yBin.charAt(i);
                if(a != b) continue;
                if(a == b && a == '0') {
                    return -1;
                }
                else {
                    return 1;
                }
            }
            return 0;
        }





}
