import java.util.Scanner;

public class Vestigium{
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        int cno = 1;
        int t = scanner.nextInt();
        while(t-- > 0){
            String s = scanner.next();
            int op = 0;
            StringBuilder sb = new StringBuilder();
            for(char c : s.toCharArray()){
                int number = (int)(c-'0');
                //check for zero
                if(number == 0){
                    while(op!=0){
                        sb.append(")");
                        op--;
                    }
                }
                //check for non zero
                else{
                    int nop = number - op;
                    //check if we have to open come paranthesis
                    if(nop > 0){
                        while(nop-- != 0){
                            sb.append("(");
                            op++;
                        }
                    }
                    //check if we have to close all paranthesis
                    else if(nop < 0) {
                        while(nop++ != 0){
                            sb.append(")");
                            op--;
                        }
                    }
                }
                sb.append(number);
            }
            while(op-- > 0) {
            sb.append(")");
            }
            System.out.println("Case #" + cno +": "+sb.toString());
            cno++;
        }
        scanner.close();
       
    }
   
}