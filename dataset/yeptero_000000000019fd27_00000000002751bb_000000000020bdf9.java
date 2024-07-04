import java.util.ArrayList;
import java.util.Scanner;

class slot{
    int start;
    int end;

    slot(int Start, int End){
        start = Start;
        end = End;
    }
}

public class Solution {

    public static boolean intersects(slot a, slot b){
        if(((a.start >= b.start && a.start < b.end) || (a.end > b.start && a.end < b.end)) || ((b.start >= a.start && b.start < a.end) || (b.end > a.start && b.end < a.end))){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int T = Integer.parseInt(input.next());
        ArrayList<slot> C;
        ArrayList<slot> J;
        ArrayList<String> total;
        boolean inC;
        boolean inJ;
        boolean impossible;
        String full = "";

        for(int i = 1; i <= T; i ++){
            C = new ArrayList<>();
            J = new ArrayList<>();
            total = new ArrayList<>();
            impossible = false;

            int N = Integer.parseInt(input.next());

            C.add(new slot(Integer.parseInt(input.next()), Integer.parseInt(input.next())));
            total.add("C");

            for(int k = 1; k < N; k ++){
                inC = false;
                inJ = false;
                //check if in C or J
                slot temp = new slot(Integer.parseInt(input.next()), Integer.parseInt(input.next()));

                for(int c = 0; c < C.size(); c ++){
                    if(intersects(C.get(c), temp)) {
                        inC = true;
                        c = C.size();
                    }
                }
                for(int j = 0; j < J.size(); j ++){
                    if(intersects(J.get(j), temp)) {
                        inJ = true;
                        j = J.size();
                    }
                }


                if(inC == true && inJ == true){
                    impossible = true;
                    k = N;
                }

                else{
                    if((inC == false && inJ == true) || (inC == false && inJ == false)){
                        C.add(temp);
                        total.add("C");
                    }
                    if(inJ == false && inC == true){
                        J.add(temp);
                        total.add("J");
                    }

                }

            }

            if(impossible){
                System.out.println("Case #" + i + ": IMPOSSIBLE");
            }
            else{
                full = "";
                for(int iter = 0; iter < total.size(); iter ++){
                    full = full + total.get(iter);
                }
                System.out.println("Case #" + i + ": " + full);
            }
        }
    }
}
