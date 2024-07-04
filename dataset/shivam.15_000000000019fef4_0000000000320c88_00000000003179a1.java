import java.util.*;
import java.io.*;
class Solution{
    static int a[][];
    static boolean visited[][];
    static boolean bf[];
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        
        for(int t_=1;t_<=t;t_++){
            int u = Integer.parseInt(br.readLine());
            HashMap<Character, boolean[]> hm = new HashMap();
            HashMap<Character, Integer> all = new HashMap();
            
            for(int i=0;i<10000;i++){
                String s[] = br.readLine().trim().split(" ");
                long x = Long.parseLong(s[0]);
                char dc[] = s[1].trim().toCharArray();
                if(x == -1) continue;
                
                for(int j=0;j<dc.length;j++){
                    if(!all.containsKey(dc[j])) 
                        all.put(dc[j], 1);
                }
                
                if(s[0].length() == dc.length){
                    char j = dc[0];
                    while(x>9) x /= 10;
                    if(hm.containsKey(j)){
                        boolean temp[] = hm.get(j);
                        for(int k=(int)x+1;k<10;k++)
                            temp[k] = true;
                        hm.put(j, temp);
                    }
                    else{
                        boolean temp[] = new boolean[10];
                        for(int k=(int)x+1;k<10;k++)
                            temp[k] = true;
                        hm.put(j, temp);
                    }
                }
            }
            char res[] = new char[10];
                
            int count = 0;
            for(int i=9;i>=0;i--){
                int c = 0;
                char cur = 'c';
                for(char w : hm.keySet()){
                    boolean temp[] = hm.get(w);
                    if(!temp[i]){
                        cur = w;c++;
                    }
                }
                if(c == 1){
                    hm.remove(cur);
                    res[i] = cur;
                    all.remove(cur);
                }
            }
            String result = new String(res);
            for(char w:all.keySet())
                result = w+result;
            
            System.out.println("Case #"+t_+": "+result);
        }
    } 
} 



