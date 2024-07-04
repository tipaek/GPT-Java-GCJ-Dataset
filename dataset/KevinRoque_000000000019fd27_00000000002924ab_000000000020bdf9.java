import java.util.ArrayList;
import java.util.Scanner;
public class Solution {
    public static void main(String[] args) {
        Scanner SC = new Scanner(System.in);
        int T=SC.nextInt(),N;
        ArrayList<ArrayList<Integer>> AL1;
        for (int i = 0; i < T; i++) {
            AL1 = new ArrayList<>();
            AL1.add(new ArrayList<>());
            AL1.add(new ArrayList<>());
            N=SC.nextInt();
            for (int j = 0; j < N; j++) {
                AL1.get(0).add(SC.nextInt());
                AL1.get(1).add(SC.nextInt());
            }
            System.out.println("Case #"+(i+1)+": "+Parenting(AL1));
        }
        
    } 
    static String Parenting(ArrayList<ArrayList<Integer>> AL){      
        boolean B1,B2;
        String S="J";
        int it;
        ArrayList<ArrayList<Integer>> AL1 = new ArrayList<>();
        ArrayList<ArrayList<Integer>> AL2 = new ArrayList<>();
        AL1.add(new ArrayList<>());
        AL1.add(new ArrayList<>());
        AL2.add(new ArrayList<>());
        AL2.add(new ArrayList<>());
        AL1.get(0).add(AL.get(0).get(0));
        AL1.get(1).add(AL.get(1).get(0));
        for (int i = 1; i < AL.get(0).size(); i++) {
            B1= false;
            B2= false;
            it=-1;
            for (int j = 0; j < AL1.get(0).size(); j++) {
                if (AL.get(0).get(i)<AL1.get(1).get(j) && AL.get(1).get(i)>AL1.get(0).get(j) ) {
                    B1=true;
                }
                else if (AL2.get(0).isEmpty()) {
                    AL2.get(0).add(AL.get(0).get(i));
                    AL2.get(1).add(AL.get(1).get(i));
                    it=i;
                }
            }
            if ((!(AL2.get(0).isEmpty()))&&it!=i) {
                it=-1;
                for (int j = 0; j < AL2.get(0).size(); j++) {
                    if(AL.get(0).get(i)<AL2.get(1).get(j) && AL.get(1).get(i)>AL2.get(0).get(j)){
                        B2=true;
                    }
                }
            }
            if (B1==true && B2==false) {
                AL2.get(0).add(AL.get(0).get(i));
                AL2.get(1).add(AL.get(1).get(i));
                S+="C";
            }
            else if(B2==true || (B1==false&&B1==B2 )){
                AL1.get(0).add(AL.get(0).get(i));
                AL1.get(1).add(AL.get(1).get(i));
                S+="J";
            }       
            if(B1==true && B1==B2){
                return "Imposible";
            }        
        }
        return S;
    } 
}