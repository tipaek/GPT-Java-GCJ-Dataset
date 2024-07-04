import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Scanner;

public class Solution {
    static class Operation{
        int a, b;
        Operation(int a, int b){
            this.a = a;
            this.b = b;
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for(int tt = 1; tt<= t; tt++){
            int r = in.nextInt();
            int s = in.nextInt();
            LinkedList<Integer> cards = new LinkedList<>();
            for(int i = 0; i<s; i++) {
                for (int j = 0; j < r; j++) {
                    cards.add(j);
                }
            }
            LinkedList<Operation> ops = new LinkedList<>();
            int op = 0;
            cards = new LinkedList<>(cards.subList(0, cards.size()-1));
            for(int i = r-1; i>0; i--){
                int moved = 1;
                while(moved!=s){
                    for(int j = cards.size()-1; j>0; j--){
                        if(cards.get(j) == i){
                            op++;
                            moved++;
                            ops.add(new Operation(j+1, cards.size()-1-j));
                            LinkedList<Integer>subB = new LinkedList<Integer>(cards.subList(j+1, cards.size()));
                            LinkedList<Integer>subA = new LinkedList<Integer>(cards.subList(0, j));
                            subB.addAll(subA);
                            cards = subB;
                            break;
                        }
                    }
                }
                cards = new LinkedList<>(cards.subList(0, cards.size()-1));
            }
            System.out.println("Case #" + tt + ": " + op);
            for(Operation o : ops){
                System.out.println(o.a + " " + o.b);
            }
        }
    }

}
