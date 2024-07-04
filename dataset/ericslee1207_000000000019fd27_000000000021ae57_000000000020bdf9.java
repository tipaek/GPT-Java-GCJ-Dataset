import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

class chores {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int t=scanner.nextInt();
        for (int i = 0; i < t; i++) {
            ArrayList<Chore> chores=new ArrayList<>();
            int n = scanner.nextInt();
            for (int j = 0; j < n; j++) {
                int start= scanner.nextInt();
                int end=scanner.nextInt();
                Chore chore=new Chore(start,end);
                chores.add(chore);
            }
            ArrayList<Chore> chores1=new ArrayList<>(chores);
            chores1.sort((a,b)->a.s-b.s);
            int c=0;
            int j=0;
            String answer="";
            HashMap<Chore, Character> hello=new HashMap<>();
            for (Chore chore : chores1) {
                if (chore.s>=c){
                    c=chore.e;
                    hello.put(chore,'C');
                }
                else if (chore.s>=j){
                    j=chore.e;
                    hello.put(chore,'J');
                }
                else{
                    answer="IMPOSSIBLE";
                    break;
                }
            }
            if (answer.equals("IMPOSSIBLE")){
                System.out.println("IMPOSSIBLE");
            }
            else{
                StringBuilder sb=new StringBuilder();
                for (int k = 0; k < chores.size(); k++) {
                    sb.append(hello.get(chores.get(k)));
                }
                System.out.println(sb.toString());
            }
        }

    }

    private static class Chore {
        int s;
        int e;

        public Chore(int s, int e) {
            this.s = s;
            this.e = e;
        }
    }
}
