import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] strings) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = scanner.nextInt();
        int inputs = (int)Math.pow(10,4);

        for (int i = 0; i < T; i++) {
            int U = scanner.nextInt();
            ArrayList<Coppia> list = new ArrayList<>();
            MyChar[] array = new MyChar[26];

            for (int j = 0; j < 26; j++) {
                array[j] = new MyChar();
            }

            for (int j = 0; j < inputs; j++) {
                int input = scanner.nextInt();
                String output = scanner.nextLine().trim();
                list.add(new Coppia(input, output));
            }
            Collections.sort(list);

            for (Coppia coppia : list) {
                String curr = coppia.output;
                array[takePos(curr.charAt(0))].updateMin(1);
                if (curr.length() == U){
                    array[takePos(curr.charAt(0))].updateMax(U-1);
                }
                String input = String.valueOf(coppia.input);
                if (input.length() == curr.length()){
                    array[takePos(curr.charAt(0))].updateMax(Character.digit(input.charAt(0),10));
                    for (int j = 0; j < curr.length()-1; j++) {
                        if (array[takePos(curr.charAt(j))].found
                         && array[takePos(curr.charAt(j))].min == Character.digit(input.charAt(j),10)){
                            array[takePos(curr.charAt(j+1))].updateMax(Character.digit(input.charAt(j+1),10));
                        }
                        else break;
                    }
                }
            }
            char[] answer = new char[10];
            for (int j = 0; j < 26; j++) {
                if (array[j].found) {
                    answer[array[j].min] = (char)('A'+j);
                }
            }
            System.out.println("Case #"+(i+1) +": " + String.valueOf(answer));
        }

    }

    static int takePos(char c){
        return c - 'A';
    }
}

class MyChar{
    int min = 0;
    int max = 9;
    boolean found = false;

    void updateMin(int n){
        if (min < n)
            min = n;
        if (min == max)
            found = true;
    }

    void updateMax(int n){
        if (max > n)
            max = n;
        if (min == max)
            found = true;
    }
}

class Coppia implements Comparable<Coppia>{
    int input;
    String output;

    public Coppia(int input, String output) {
        this.input = input;
        this.output = output;
    }

    @Override
    public int compareTo(Coppia coppia) {
        return this.input - coppia.input;
    }
}