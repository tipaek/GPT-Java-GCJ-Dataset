import java.util.Scanner;
import java.util.*;
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt(); 
        for (int i = 0; i<num; i++) {
            String orig = sc.next();
            String new1 = "";
            for (char ch: orig.toCharArray()) {
                int val = Character.getNumericValue(ch);
                for (int a = 0; a<val; a++) {
                    new1+="(";
                }
                new1+=ch;
                for (int a = 0; a<val; a++) {
                    new1+=")";
                }
            }
            String new2=new1;
            while (true) {
                new2 = new1;
                new1 = new1.replaceAll("\\)\\(", "");
                if (new1.equals(new2)) {
                    System.out.println("Case #"+(i+1)+": "+new1);
                    break;
                }
            }
        }
    }
}