import java.util.*;
import java.io.*;
class Solution{  
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for(int t_=1;t_<=t;t_++){
            int n = Integer.parseInt(br.readLine());
            
            int a[][] = new int[n][2];
            for(int i=0;i<n;i++){
                String s[] = br.readLine().trim().split(" ");
                a[i][0] = Integer.parseInt(s[0]);
                a[i][1] = Integer.parseInt(s[1]);
            }
            HashMap<String, Integer> hm = new HashMap();
            HashMap<String, Integer> hm1 = new HashMap();
            
            for(int i=0;i<n;i++){
                String cur = a[i][0]+" "+a[i][1];
                    if(hm.containsKey(cur))
                        hm1.put(cur, i);
                    else
                        hm.put(cur, i);
            }
            
            Arrays.sort(a, new Comparator<int[]>(){
                @Override              
                public int compare(final int[] entry1, final int[] entry2){
                  if (entry1[0] > entry2[0]) 
                      return 1; 
                  else
                      return -1; 
                } 
            });
            
            char res[] = new char[n];
            
            boolean poss = true;
            int c = 0, j = 0;
            for(int i=0;i<n;i++){
                int start = a[i][0];
                int end = a[i][1];
                if(c <= start){
                    c = end;
                    String cur = start+" "+end;
                    int index = 0;
                    if(hm.containsKey(cur)){
                        index = hm.get(cur);
                        hm.remove(cur);
                    }
                    else{
                        index = hm1.get(cur);
                    }    
                    res[index] = 'C';
                }
                else if(j <= start){
                    j = end;
                    String cur = start+" "+end;
                    int index = 0;
                    if(hm.containsKey(cur)){
                        index = hm.get(cur);
                        hm.remove(cur);
                    }
                    else{
                        index = hm1.get(cur);
                    }    
                    res[index] = 'J';
                }
                else{
                    poss = false;break;
                }
            }
            if(poss){
                String s1 = new String(res);
                System.out.println("Case #"+t_+": "+s1);
            }
            else{
                System.out.println("Case #"+t_+": IMPOSSIBLE");
            }
        }
    } 
}