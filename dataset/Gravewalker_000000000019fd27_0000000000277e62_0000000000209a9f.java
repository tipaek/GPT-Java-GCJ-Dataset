import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    static String formatStr(String s){
        String[] sArr = s.split("");
        for (int i = 0; i<sArr.length; i++){
            if (sArr[i].equals("1")){
                sArr[i] = "(1)";
            }else if (sArr[i].equals("2")){
                sArr[i] = "((2))";
            }else if (sArr[i].equals("3")){
                sArr[i] = "(((3)))";
            }else if (sArr[i].equals("4")){
                sArr[i] = "((((4))))";
            }else if (sArr[i].equals("5")){
                sArr[i] = "(((((5)))))";
            }else if (sArr[i].equals("6")){
                sArr[i] = "((((((6))))))";
            }else if (sArr[i].equals("7")){
                sArr[i] = "(((((((7)))))))";
            }else if (sArr[i].equals("8")){
                sArr[i] = "((((((((8))))))))";
            }else if (sArr[i].equals("9")){
                sArr[i] = "(((((((((9)))))))))";
            }
        }

        String sFormated = String.join("", sArr);
        while (sFormated.contains(")(")){
            String[] temp = sFormated.split("(\\)\\()");
            sFormated = String.join("", temp);
        }

        return  sFormated;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<String> strArr = new ArrayList<>();

        int t = Integer.parseInt(sc.nextLine());
        for(int i = 0; i < t; i++){
            String s = sc.nextLine();
            strArr.add(s);
        }

        for (String s: strArr) {
            System.out.println(formatStr(s));
        }
    }
}
