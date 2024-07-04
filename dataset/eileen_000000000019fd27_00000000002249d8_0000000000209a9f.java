import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();

        for (int i = 0; i < T; i++) {
            Boolean flag = false; 
            System.out.print("Case #" + (i+1) + ": ");
            String S = scan.next();
            for (int j = 0; j < S.length(); j++) {
                if(S.substring(j, j+1).equals("0")){
                    if(flag){
                        System.out.print(")0");
                        flag = false;
                    }
                    else{
                        System.out.print("0");
                    }
                }
                else if(S.substring(j, j+1).equals("1")){
                    flag = true;
                    if(j != 0 && j != S.length() - 1){
                        if(S.substring(j-1, j).equals("0")){
                            System.out.print("(1");
                        }
                        else{
                            System.out.print("1");
                        }
                        
                    }
                    else if(j == 0){
                        System.out.print("(1");
                    }
                    else if(j == S.length() - 1){
                        if(S.substring(j - 1, j).equals("0")){
                            System.out.print("(1)");
                        }
                        else{
                            System.out.print("1)");
                        }
                        

                    }
                }
            }
            System.out.println();
        }

    }
}