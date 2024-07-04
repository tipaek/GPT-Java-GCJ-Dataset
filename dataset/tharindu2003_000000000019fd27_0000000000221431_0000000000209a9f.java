import java.util.*;
import java.io.*;
public class Solution {

    public String solve(String input){
        String filled = "";
        String retval = "";
        String openPar;
        String closePar;
        for (int i =0; i<input.length(); i++){
            openPar = "";
            closePar = "";
            int num = Integer.parseInt(input.charAt(i)+"");
            for(int j=0; j< num; j++){
                openPar+="(";
                closePar+=")";
            }
            filled +=openPar + input.charAt(i) + closePar;
        }
        if(input.length()<=1) return filled;
        int i = 0;
        char cur;
        char next;
        int change=1;
        while(change >0){
            change = 0;
            i=0;
            while(i<filled.length()-1){
                cur = filled.charAt(i);
                next = filled.charAt(i+1);
                if(!(cur == ')' && next =='(')){
                    retval+=filled.charAt(i);
                }else{
                    change++;
                    i++;
                }i++;
            }
            char last = filled.charAt(filled.length()-1);
            if(change>0){
                filled = retval+last;
                retval = "";
            }
        }
        return retval + filled.charAt(filled.length()-1);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        Solution app = new Solution();
        int i =1;
        String joke = in.nextLine();
        while(in.hasNext()){
            String n = in.nextLine();
            String solved = app.solve(n);
            System.out.println("Case #" + i + ": " + solved);
            i++;
        }
    }
}
