import java.util.HashMap;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();

        for(int n=0; n<t;n++){
            int u = scanner.nextInt();
            HashMap<Character,int[]> map = new HashMap<>();
            for(int i=0; i<10000; i++){
                int q = scanner.nextInt();
                String m = ""+q;
                String r = scanner.nextLine();
                r = r.trim();
                for(int j=m.length(); j>=0;j--){
                    if(j>=r.length()) continue;
                    char c = r.charAt((j));
                    if(map.containsKey(c)){
                        int[] entry = map.get(c);
                        int start = Integer.parseInt(m.charAt(j)+"");
                        for(int k = start; k<10; k++){
                            entry[k]++;
                        }
                    }else {
                        map.put(c,new int[10]);
                    }
                }
            }
            /*char[] base = new char[10];
            for(char c : map.keySet()){
                int weight = 0;
                int predDigit = 0;
                for(int i=0; i<10;i++){
                    if(map.get(c)[i]>weight){
                        weight = map.get(c)[i];
                        predDigit = i;
                    }
                }

                for(int)
                base[predDigit] = c;
            }
            */
            char[] base = new char[10];
            int max = 0;
            for(int i=0; i<10; i++){
                max=0;
                for(char c : map.keySet()){
                    if(map.get(c)[i]>max){
                        max = map.get(c)[i];
                        base[i] = c;
                    }
                }
                map.remove(base[i]);
            }

            String out ="";
            for(char c :base){
                out+=c;
            }
            System.out.println("Case #"+(n+1)+": "+out);
        }
    }
}
