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
        String[] total;
        int totalCounter;
        boolean inC;
        boolean inJ;
        boolean impossible;
        String full = "";

        for(int i = 1; i <= T; i ++){
            totalCounter = 0;
            C = new ArrayList<>();
            J = new ArrayList<>();
            impossible = false;

            int N = Integer.parseInt(input.next());

            total = new String[N];

            C.add(new slot(Integer.parseInt(input.next()), Integer.parseInt(input.next())));
            total[totalCounter] = "C";
            totalCounter ++;

            for(int k = 1; k < N; k ++){
                inC = false;
                inJ = false;
                //check if in C or J
                slot temp = new slot(Integer.parseInt(input.next()), Integer.parseInt(input.next()));

                for(int c = 0; c < C.size(); c ++){
                    if(intersects(C.get(c), temp)) {
                        inC = true;
                        for(int j = 0; j < J.size(); j ++){
                            if(intersects(J.get(j), temp)) {
                                inJ = true;
                                j = J.size();
                            }
                        }
                        c = C.size();
                    }
                }

                if(inC == true && inJ == true){
                    impossible = true;
                    k = N;
                }

                else{
                    if(inC == false && inJ == true){
                        C.add(temp);
                        total[totalCounter] = "C";
                        totalCounter ++;
                    }
                    else if(inJ == false && inC == true){
                        J.add(temp);
                        total[totalCounter] = "J";
                        totalCounter ++;
                    }
                    else{
                        C.add(temp);
                        total[totalCounter] = "C";
                        totalCounter ++;
                    }

                }

            }

            if(impossible){
                System.out.println("Case #" + i + ": IMPOSSIBLE");
            }
            else{
                full = "";
                for(int iter = 0; iter < N; iter ++){
                    full = full + total[iter];
                }
                System.out.println("Case #" + i + ": " + full);
            }
        }
    }
}
