import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int size = scan.nextInt();
        scan.nextLine();
        for (int i = 0; i < size; i++) {
            String string = "";
            String in = scan.nextLine();
            for (int k = 0; k < in.length();k++){
                for (int l = 0; l < Integer.parseInt(in.charAt(k)+"");l++){
                    string += "(";
                }
                string += in.charAt(k);
                while (k+1 < in.length() &&in.charAt(k) == in.charAt(k+1)){
                    string += in.charAt(k);
                    k++;
                }
                if (k+1 == in.length() || in.charAt(k) != in.charAt(k+1)){
                    for (int l = 0; l < Integer.parseInt(in.charAt(k)+"");l++){
                        string += ")";
                    }
                }
            }
            System.out.println("Case #"+(i+1)+": "+string);
        }
    }
}