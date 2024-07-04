
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.io.*;

public class Solution {


    public static void main(String[] args) {

        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        int b = in.nextInt();
        for (int i = 1; i <= t; ++i) {
          List<Char> answer = new ArrayList<>();
//            String answer = "";
            // interact
            for (int j = 0, f=b-1; j <=b/2; j++,f--) {
                System.out.println(j);
                answer.add(new Char(j,in.next().charAt(0)));
                if(f>b/2) {
                    System.out.println(f);

                    answer.add(new Char(f, in.next().charAt(0)));
                }
                //check fluctuation
                if(j % 10 == 1) {
                    //fluctuation may have happened
                    //correct previous read values
                    StringBuilder queriedLastPiece = new StringBuilder();
                    for (int k = Math.max(b-6, f+1); k<b; k++) {
                        System.out.println(k);
                        queriedLastPiece.append(in.next().charAt(0));
                    }
                    String oldLastPiece = getPiece(answer,Math.max(b-6, f+1), b-1);
                    String oldFirstPiece = getPiece(answer, 0, Math.min(4, j));


                    if(!queriedLastPiece.toString().equals(oldLastPiece)){
                        // changed
                        if(queriedLastPiece.toString().equals(reverse(oldFirstPiece))){
                            reverse(answer);
                        } else if(queriedLastPiece.toString().equals(complement(oldLastPiece))) {
                            complement(answer);
                        } else if(queriedLastPiece.toString().equals(complement(reverse(oldFirstPiece)))) {
                            reverse(answer);
                            complement(answer);
                        }
                    }

                }

            }
            System.out.println( answer.stream().sorted(Comparator.comparingInt(c->c.index)).map(c->Character.toString(c.c)).collect(Collectors.joining()));

        }

    }

    public static String getPiece(List<Char> answer, int from, int to) {
        answer.sort(Comparator.comparingInt(a->a.index));
        StringBuilder res = new StringBuilder();
        for (int i = from; i <to; i++) {
            res.append(answer.get(i));
        }
        return res.toString();
    }


    public static String reverse(String binary) {
        return new StringBuilder(binary).reverse().toString();
    }

    public static List<Char> reverse(List<Char> answer) {
        answer.sort(Comparator.comparingInt(Char::getIndex).reversed());
        for (int i = 0; i < answer.size()/2; i++) {
            final int idx = i;
            Char otherSideChar = answer.stream().filter(c->c.index==idx).findAny().get();
            otherSideChar.index = answer.get(i).getIndex();
        }
        return answer;
    }


    public static List<Char> complement(List<Char> answer) {
        for (int i = 0; i < answer.size(); i++) {
            char curChar = answer.get(i).c;
            answer.get(i).c = curChar == '0' ? '1' : '0';
        }
        return answer;
    }

    public static String complement(String binary) {
        if(binary.length() == 0)
            return "";
        char compChar = binary.charAt(0) == '0' ? '1' : '0';
        return  compChar + complement(binary.substring(1));
    }
}
class Char {
    int index;
    char c;
    Char(int i, char c) {
        this.index = i;
        this.c = c;
    }

    public int getIndex() {
        return index;
    }
}