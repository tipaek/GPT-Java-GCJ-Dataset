import java.util.*;
public class Solution{

    private static class Pair{
        char charac;
        int freq;
        Pair (char c, int f){
            charac =c;
            freq =f;
        }
    }

    public static void main(String[] args)throws Exception{
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int k=t;
        while(t-->0){

            int u = sc.nextInt();
            HashSet<Character> hs = new HashSet<>();
            String res[] = new String[10000];
            for(int i=0;i<10000;i++){
                sc.nextLong();
                res[i] = sc.nextLine();
                res[i] = res[i].substring(1);
            }
            boolean flag =false;
            for(int i=0;i<10000 && !flag;i++){
                for(int j=0;j<res[i].length();j++){
                    hs.add(res[i].charAt(j));
                    if(hs.size()==10){
                        flag = true;
                        break;
                    }
                }
            }
            HashSet<Character> zero = new HashSet<>(hs);
            for(int i=0;i<10000;i++){
                if(zero.size() == 1){
                    break;
                }
                if(!zero.contains(res[i].charAt(0))) continue;
                //System.out.println(res[i].charAt(0));
                zero.remove(res[i].charAt(0));
            }
            char zer = ' ';
            for(char z: zero){
                zer = z;
                //System.out.println(z);
            }
            //System.out.println(zer);
            StringBuilder sb = new StringBuilder();
            sb.append(zer);
            HashMap<Character, Integer> hm = new HashMap<>();
            for(int i=0;i<10000;i++){
                for(int j=0;j<res[i].length();j++){
                    if(res[i].charAt(j) == zer) continue;
                    hm.put(res[i].charAt(j),hm.getOrDefault(res[i].charAt(j),0)+1);
                }
            }
            PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<Pair>() {
                @Override
                public int compare(Pair pair, Pair t1) {
                    return t1.freq - pair.freq;
                }
            });
            for(Map.Entry<Character, Integer> map: hm.entrySet()){
                pq.add(new Pair(map.getKey(), map.getValue()));
            }
            while(!pq.isEmpty()){
                Pair p = pq.remove();
                sb.append(p.charac);
            }

            System.out.println("Case #"+(k-t)+": "+sb.toString());
        }
    }

}
