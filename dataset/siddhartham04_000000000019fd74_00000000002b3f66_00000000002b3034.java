import java.util.*;
public class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();

        for(int test = 1; test<=t; test++){
            int n = scan.nextInt();
            String[] list = new String[n];
            for(int i = 0; i<n; i++){
                list[i] = scan.next();
            }

            Arrays.sort(list, new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    return -1*((Integer)o1.length()).compareTo(o2.length());
                }
            });

            boolean check = false;
            for(int i = 1; i<list.length; i++){
                String a = list[0].substring(1);
                String b = list[i].substring(1);

                if(a.indexOf(b) != -1) continue;
                else {
                    check = true;
                    break;
                }
            }

            if(check) System.out.println("Case #" + test +": *");
            else System.out.println("Case #" + test+": "+ list[0].substring(1));
        }
    }
}
