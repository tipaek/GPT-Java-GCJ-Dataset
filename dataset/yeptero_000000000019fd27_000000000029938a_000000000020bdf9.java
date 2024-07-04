import java.util.ArrayList;
import java.util.Scanner;

class slot{
    int place;
    int start;
    int end;

    slot(int Start, int End, int Place){
        start = Start;
        end = End;
        place = Place;
    }
}

public class Solution {

    public static boolean intersects(slot a, slot b){
        if(b.end <= a.start || b.start >= a.end){
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int T = input.nextInt();
        ArrayList<slot> C;
        ArrayList<slot> J;
        ArrayList<slot> E;
        String[] total;
        int totalCounter;
        boolean inC;
        boolean inJ;
        boolean impossible;
        int N;

        for(int i = 1; i <= T; i ++){
            totalCounter = 0;
            C = new ArrayList<>();
            J = new ArrayList<>();
            E = new ArrayList<>();
            impossible = false;

            N = input.nextInt();

            for(int j = 0; j < N; j ++){
                E.add(new slot(input.nextInt(), input.nextInt(), j));
            }

            C.add(E.remove(0));

            while(E.size() > 0) {

                for (int k = 0; k < E.size(); k++) {
                    inC = false;
                    inJ = false;
                    //check if in C or J
                    slot temp = E.get(k);

                    for (int c = 0; c < C.size(); c++) {
                        if (intersects(C.get(c), temp)) {
                            inC = true;
                            c = C.size();
                        }
                    }
                    for (int j = 0; j < J.size(); j++) {
                        if (intersects(J.get(j), temp)) {
                            inJ = true;
                            j = J.size();
                        }
                    }

                    if(E.size() == 1 && inC == false && inJ == false){
                        C.add(E.remove(k));
                    }

                    if (inC == true && inJ == true) {
                        impossible = true;
                        E.clear();
                    } else {
                        if (inC == false && inJ == true) {
                            C.add(E.remove(k));
                            k --;
                        } else if (inJ == false && inC == true) {
                            J.add(E.remove(k));
                            k --;
                        }

                    }

                }
            }

            if(impossible){
                System.out.println("Case #" + i + ": IMPOSSIBLE");
            }
            else{
                StringBuilder a = new StringBuilder("Case #");
                a.append(i);
                a.append(": ");

                boolean foundC;

                for(int it = 0; it < N ; it ++) {
                    foundC = false;
                    for (int iterC = 0; iterC < C.size(); iterC++) {
                        if(C.get(iterC).place == it) {
                            a.append("C");
                            iterC = C.size();
                            foundC = true;
                        }
                    }
                    if(foundC == false) {
                        for (int iterJ = 0; iterJ < J.size(); iterJ++) {
                            if (J.get(iterJ).place == it) {
                                a.append("J");
                                iterJ = J.size();
                            }
                        }
                    }
                }
                System.out.println(a);
            }
        }
    }
}
