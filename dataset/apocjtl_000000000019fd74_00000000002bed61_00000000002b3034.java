import java.util.*;
public class Solution {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        for(int i = 0; i < t; i++) {
            int n = input.nextInt();
            input.nextLine();
            ArrayList<Character> beginning = new ArrayList<>();
            ArrayList<Character> end = new ArrayList<>();
            ArrayList<Character> any = new ArrayList<>();
            String[] store = new String[n];
            boolean works = true;
            for(int k = 0; k < n; k++) {
                String temp = input.nextLine();
                store[k] = temp;
                int num = 0;
                for(int h = 0; h < temp.length(); h++) {
                    if(temp.charAt(h) == '*') {
                        num++;
                    }
                }
                if(temp.charAt(0) != '*') {
                    String begintest = "";
                    for(int h = 0; h < temp.length(); h++) {
                        if(temp.charAt(h) == '*') {
                            break;
                        }
                        begintest += temp.charAt(h);
                    }
                    int counter1 = 0;
                    int counter2 = 0;
                    for(; counter1 < beginning.size() && counter2 < begintest.length(); counter1++, counter2++) {
                        if (beginning.get(counter1) != begintest.charAt(counter2)) {
                            works = false;
                            break;
                        }
                    }
                    if(counter2 < begintest.length()) {
                        beginning.clear();
                        for(int h = 0; h < begintest.length(); h++) {
                            beginning.add(h, begintest.charAt(h));
                        }
                    }
                }
                if(temp.charAt(temp.length() - 1) != '*') {
                    String endtest = "";
                    int h = temp.length() - 1;
                    while(temp.charAt(h) != '*' && h >= 0) {
                        endtest = temp.charAt(h) + endtest;
                        h--;
                    }
                    int counter1 = end.size() - 1;
                    int counter2 = endtest.length() - 1;
                    for(; counter1 >= 0 && counter2 >= 0; counter1--, counter2--) {
                        if(end.get(counter1) != endtest.charAt(counter2)) {
                            works = false;
                            break;
                        }
                    }
                    if(counter2 >= 0) {
                        end.clear();
                        for(h = 0; h < endtest.length(); h++) {
                            end.add(h, endtest.charAt(h));
                        }
                    }
                }
                if(!works) {
                    System.out.println("Case #" + (i + 1) + ": *");
                    break;
                }
                int firstpos = 0;
                int lastpos = 0;
                if(num >= 2) {
                    for(int h = 0; h < temp.length(); h++) {
                        if(temp.charAt(h) == '*') {
                            firstpos = h;
                            break;
                        }
                    }
                    for(int h = temp.length() - 1; h >= 0; h--) {
                        if(temp.charAt(h) == '*') {
                            lastpos = h;
                            break;
                        }
                    }
                    for(int h = firstpos + 1; h < lastpos; h++) {
                        if(temp.charAt(h) != '*') {
                            any.add(temp.charAt(h));
                        }
                    }
                }
            }
            if(works) {
                String result = "";
                for(int k = 0; k < beginning.size(); k++) {
                    result += beginning.get(k);
                }
                for(int k = 0; k < any.size(); k++) {
                    result += any.get(k);
                }
                for(int k = 0; k < end.size(); k++) {
                    result += end.get(k);
                }
                System.out.println("Case #" + (i + 1) + ": " + result);
            }
        }
    }
}
