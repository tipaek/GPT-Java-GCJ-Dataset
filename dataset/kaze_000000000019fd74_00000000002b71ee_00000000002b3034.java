import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int T = input.nextInt();
        for (int turn = 0; turn < T; turn++) {
            int n = input.nextInt();
            input.nextLine();
            String[] strings = new String[n];
            for (int index = 0; index < n; index++) {
                strings[index] = input.nextLine().trim();
            }
            String result = "";
            ArrayList<String> jutou = new ArrayList<String>();
            ArrayList<String> juwei = new ArrayList<String>();
            ArrayList<String> juzhong = new ArrayList<String>();

            for (int i = 0; i < n; i++) {
                char curr = strings[i].charAt(0);
                int index = 0;
                while (curr != '*') {
                    index++;
                    curr = strings[i].charAt(index);
                }
                if (index > 0) {
                    jutou.add(strings[i].substring(0, index));
                }

                curr = strings[i].charAt(strings[i].length()-1);
                int index2 = strings[i].length()-1;
                while (curr != '*') {
                    index2--;
                    curr = strings[i].charAt(index2);
                }
                if (index2 <strings[i].length()-1) {
                    juwei.add(strings[i].substring(index2+1, strings[i].length()));
                }
                if (index+1 < index2) {
                    juzhong.add(strings[i].substring(index + 1, index2));
                }
            }
            int maxlength = 0;
            int maxIndex = -1;
            for (int i = 0; i < jutou.size(); i++) {
                String str = jutou.get(i);
                if (maxlength < str.length()) {
                    maxIndex = i;
                    maxlength = str.length();
                }
            }
            String maxjutou = "";
            if (maxIndex != -1) {
                maxjutou = jutou.get(maxIndex);
            }
            maxIndex = -1;
            maxlength = 0;
            for (int i = 0; i < juwei.size(); i++) {
                String str = juwei.get(i);
                if (maxlength < str.length()) {
                    maxIndex = i;
                    maxlength = str.length();
                }
            }
            String maxjuwei = "";
            if (maxIndex != -1) {
                maxjuwei = juwei.get(maxIndex);
            }
            boolean boom = false;
            for (int i = 0; i < jutou.size(); i++) {
                for (int j = 0; j < jutou.get(i).length(); j++) {
                    if (jutou.get(i).charAt(j) != maxjutou.charAt(j)) {
                        boom = true;
                    }
                }
            }
            for (int i = 0; i < juwei.size(); i++) {
                for (int j = 1; j <= juwei.get(i).length(); j++) {
                    if (juwei.get(i).charAt(juwei.get(i).length()-j) != maxjuwei.charAt(maxjuwei.length()-j)) {
                        boom = true;
                    }
                }
            }
            if (boom) {
                System.out.println("Case #" + (turn+1) + ": " + "*");
            }else {
                result+=maxjutou;
                for (int i = 0; i < juzhong.size(); i++) {
                    result+=juzhong.get(i).replace("*","");

                }
                result+=maxjuwei;
                System.out.println("Case #" + (turn+1) + ": " + result);
            }
        }
    }
}
