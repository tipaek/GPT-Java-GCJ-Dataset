import java.util.*;

public class Solution {
    

    public static void main(String [] args ) {

        Scanner scanner = new Scanner(System.in);
        
        int t = scanner.nextInt();
        int u = scanner.nextInt();

        for(int tt=0;tt<t;tt++) {

            String [] q = new String[100100];
            String [] r = new String[100100];
            
            char [] freq = new char[30];
            Map<Character, List<Pair>> map = new HashMap<>();
            map.clear();

            for(int i=1;i<=10000;i++) {
                q[i] = scanner.next();
                r[i] = scanner.next();
                int szq = q[i].length();
                int szr = r[i].length();

                if(szq == szr) {
                    for(int j=0;j<szq;j++) {
                        if(j>=szr) {
                           // continue;
                        }
                        List<Pair> p = map.get(q[i].charAt(j));
                        if(p==null) {
                            p = new ArrayList<>();
                        }
                        int lsize = p.size();
                        boolean ok = false;
                        for(int k=0;k<lsize;k++ ) {
                            if(p.get(k).first == r[i].charAt(j)) {
                                p.set(k,new Pair(p.get(k).first,p.get(k).count+1));
                                ok = true;
                                //break;
                            }
                        }
                        if(!ok) {
                            p.add(new Pair(r[i].charAt(j),1));
                        }
                        map.put(q[i].charAt(j),p);
                    }
                }
            } 

            Map<Character, Character> ansMap = new HashMap<>();
            ansMap.clear();
            int [] max = new int[250];
            int [] used = new int[250];
            for(char i='0';i<='9';i++) {
                List<Pair> p = map.get(i);
                Collections.sort(p, new Comparator<Pair>() {

                    @Override
                    public int compare(Pair p1, Pair p2) {
                        if(p1.count < p2.count ) return 1;
                        else if(p1.count > p2.count ) return -1;
                        else return 0;
                    }
                });
               
                for(int j=0;j<=9;j++) {
                    //System.out.println(p.get(j).first + " => " + p.get(j).count);
                    if(max[i] < p.get(j).count && used[p.get(j).first]==0) {
                        max[i] = p.get(j).count;
                        ansMap.put(i,p.get(j).first);
                        used[p.get(j).first] = 1;
                    }
                }

               // System.out.println("-----------------");
            }

            String ans = "";
            for(char i='0';i<='9';i++) {
                ans+=ansMap.get(i);
            }
            //System.out.println(ansMap);
            

			System.out.println("CASE #"+(tt+1) + ": "+ ans);
        }

    }
}

class Pair {

    public Character first;
    public Integer count;

    public Pair(Character first, Integer count) {
        this.first = first;
        this.count = count;
    }
}