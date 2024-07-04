import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        int f = 0;
        while (f++ < t){
            String result = "";
            int n = scan.nextInt();
            String[] ar  = new String[n];
            for (int i = 0; i < n; i++) {
                ar[i] = scan.next();
            }

            Arrays.sort(ar, ((o1, o2) -> o2.length() - o1.length()));


            String re = ar[0];
            HashSet<String> visited = new HashSet<>();
            boolean isPossible = true;
            for (int i = 1; i < ar.length; i++) {
                if(visited.contains(ar[i])) continue;
                boolean sst = false;
                String v = ar[i];
                int l = re.length()-1;
                for (int j = v.length()-1; j >0 ; j--) {
                    if(v.charAt(j) != re.charAt(l--)){
                        sst = true;
                        break;
                    }
                }
                if(!sst){
                    isPossible = false;
                }
                visited.add(ar[i]);
            }

            System.out.println("Case #" + f + ": " + (isPossible ? "*":re.replaceAll("\\*","")));
        }
    }
}
