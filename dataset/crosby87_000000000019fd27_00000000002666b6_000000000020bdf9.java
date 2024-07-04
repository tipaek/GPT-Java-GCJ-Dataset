import java.util.*;

public class Solution {
    public static class Event{
        int start;
        int end;

        public Event (int a, int b){
            this.start = a;
            this.end = b;
        }
    }

    public static ArrayList<String> binary(int n){
        ArrayList<String>  a = new ArrayList<>();
        ArrayList<String>  temp = new ArrayList<>();
        a.add("");
        for (int i = 0; i < n; i++){
            for (int j = 0; j < a.size(); j++){
                temp.add(a.get(j) + "0");
                temp.add(a.get(j) + "1");
            }
            a = temp;
            temp = new ArrayList<>();
        }
        return a;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int a = 1; a <= T; a++){
            int N = sc.nextInt();
            System.out.print("Case #" + a + ": ");
            Event[] e = new Event[N];

            for (int i = 0; i < N; i++){
                int start = sc.nextInt();
                int end = sc.nextInt();
                Event e1 = new Event(start, end);
                e[i] = e1;
            }
            ArrayList<String> s = binary(N);

            boolean works = false;

            for (int i = 0; i < s.size(); i++){
                String s1 = s.get(i);
                ArrayList<Integer> jamie = new ArrayList<>();
                boolean jw = true;
                boolean cw = true;
                ArrayList<Integer> cameron = new ArrayList<>();

                for (int j = 0; j < s1.length(); j++){
                    if (s1.charAt(j) == '0') jamie.add(j);
                    else{
                        cameron.add(j);
                    }
                }

                for (int j = 0; j < jamie.size(); j++){
                    for (int k = j + 1; k < jamie.size(); k++){
                        int a1 = e[jamie.get(j)].start;
                        int a2 = e[jamie.get(j)].end;
                        int b1 = e[jamie.get(k)].start;
                        int b2 = e[jamie.get(k)].end;
                        if (((b1 > a1) && (b1 < a2)) || ((b2 > a1) && (b2 < a2))){
                            cw = false;
                        }

                        if (((a1 > b1) && (a1 < b2)) || ((a2 > b1) && (a2 < b2))){
                            cw = false;
                        }
                    }
                }

                for (int j = 0; j < cameron.size(); j++){
                    for (int k = j + 1; k < cameron.size(); k++){
                        int a1 = e[cameron.get(j)].start;
                        int a2 = e[cameron.get(j)].end;
                        int b1 = e[cameron.get(k)].start;
                        int b2 = e[cameron.get(k)].end;
                        if (((b1 > a1) && (b1 < a2)) || ((b2 > a1) && (b2 < a2))){
                            cw = false;
                        }

                        if (((a1 > b1) && (a1 < b2)) || ((a2 > b1) && (a2 < b2))){
                            cw = false;
                        }
                    }
                }

                if (jw && cw){
                    for (int k = 0; k < s1.length(); k++){
                        if (s1.charAt(k) == '0'){
                            System.out.print('J');
                        }
                        else{
                            System.out.print('C');
                        }
                    }
                    System.out.println();
                    works = true;
                    break;
                }
            }
            if (!works){
                System.out.println("IMPOSSIBLE");
            }
        }

    }
}
