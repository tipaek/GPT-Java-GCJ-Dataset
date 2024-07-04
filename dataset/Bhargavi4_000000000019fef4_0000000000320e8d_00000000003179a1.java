import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String test = br.readLine();
        if(test == null)return;
        int t = Integer.parseInt(test);
        int k=1;
        while(t-- > 0){
            String bound = br.readLine();
            int u = Integer.parseInt(bound);

            int[] ch = new int[26];

            long[] v = new long[10000];
            Map<Long, List<String>> map = new HashMap();
            int j = 10000;
            while(j-- > 0){

                String s = br.readLine();
                String[] s1 = s.split(" ");
                long m = Long.parseLong(s1[0]);
                v[j]= m;
                String r = s1[1];

                if(map.containsKey(Long.valueOf(m))){
                    List<String> va = map.get(Long.valueOf(m));
                    va.add(r);
                    map.put(Long.valueOf(m),va);
                }else{
                    List<String> va = new ArrayList<>();
                    va.add(r);
                    map.put(Long.valueOf(m),va);
                }

                for(int i=0;i<r.length();i++){
                    ch[r.charAt(i)-'A']++;
                }

            }

            Arrays.parallelSort(v);

            String result = "";
            for(int i=0;i<26;i++){

                if(ch[i] !=0){
                    int x = i+'A';
                    result=result+(char)x;
                }

            }

            System.out.println("Case #"+k+": "+result);
        }



    }

    private  static int pow(int x){
        if(x==0)return 1;
        return 10 * pow(x-1);
    }
}
