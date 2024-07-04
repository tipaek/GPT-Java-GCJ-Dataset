import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    public static boolean ranked(ArrayList<Integer> find, int rank){
        int rankPlace = 1;
        for(int i = 0; i < find.size(); i ++){
            if(rankPlace > rank){
                rankPlace = 1;
            }
            if(find.get(i) != rankPlace){
                return false;
            }
            rankPlace ++;
        }
        return true;
    }
    public static int findLast(int num, ArrayList<Integer> find){
        int lastPlace = -1;
        for(int i = 0; i < find.size(); i ++){
            if(find.get(i) == num){
                lastPlace = i;
            }
        }
        return lastPlace;
    }

    public static int findFirst(int num, ArrayList<Integer> find){
        int firstPlace = -1;
        for(int i = 0; i < find.size(); i ++){
            if(find.get(i) == num){
                firstPlace = i;
                i = find.size();
            }
        }
        return firstPlace;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int T = input.nextInt();

        for(int t = 1; t <= T; t ++){
            StringBuilder a = new StringBuilder("Case #");
            a.append(t);
            a.append(": ");

            int swaps = 0;

            int Rank = input.nextInt();
            int Suit = input.nextInt();

            ArrayList<Integer> R = new ArrayList<>();

            ArrayList<Integer> tempA = new ArrayList<>();
            ArrayList<Integer> tempB = new ArrayList<>();
            ArrayList<Integer> tempC = new ArrayList<>();

            ArrayList<Integer> A = new ArrayList<>();
            ArrayList<Integer> B = new ArrayList<>();

            int rankPlace = 1;
            for(int r = 0; r < Rank * Suit; r ++){
                if(rankPlace > Rank){
                    rankPlace = 1;
                }
                R.add(rankPlace);

                rankPlace ++;

            }

            for(int k = Rank; k >= 2; k --) {
                for (int j = 1; j < Suit; j++) {


                    int aPlace = findFirst(k, R);
                    int bPlace = findLast(k-1, R);

                    int aSize = aPlace + 1;
                    int bSize = bPlace - aPlace;

                    A.add(aSize);
                    B.add(bSize);

                    for(int ha = 0; ha <= aPlace; ha ++){
                        tempA.add(R.get(ha));
                    }
                    for(int he = aPlace + 1; he <= bPlace; he ++){
                        tempB.add(R.get(he));
                    }
                    for(int he = bPlace + 1; he < Suit*Rank; he ++){
                        tempC.add(R.get(he));
                    }
                    swaps ++;

                    R.clear();

                    R.addAll(tempB);
                    R.addAll(tempA);
                    R.addAll(tempC);

                    tempA.clear();
                    tempB.clear();
                    tempC.clear();

                }
            }

            a.append(swaps);
            System.out.println(a);

            for(int e = 0; e < A.size(); e ++){
                System.out.println(A.get(e) + " " + B.get(e));
            }


        }
    }
}
