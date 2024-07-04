import java.util.*;

class Solution {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    
    for(int i=0;i<t;i++){
        int n = sc.nextInt();
        int time[]=new int[1441];
        HashMap<Integer,HashSet<Integer>> hash = 
            new HashMap<>();
        for(int tl=0;tl<1441;tl++){
            HashSet<Integer> list = new HashSet<>();
            hash.put(tl,list);
        }
        for(int p=0;p<n;p++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            
            HashSet<Integer> temp = hash.get(a);
            temp.add(p+1);
            hash.put(a,temp);
            
            temp = hash.get(b);
            temp.add(p+1);
            hash.put(b,temp);
            
        }
        int c=0,j=0;
        boolean clocked=false, jlocked=false;
        String out = "";
        
        for(int p=0;p<1441;p++){
            HashSet<Integer> set = hash.get(p);
            if(set.size()==0)continue;
            if(set.contains(c)){
                set.remove(c);
                c=0;
                clocked = false;
            }
            if(set.contains(j)){
                set.remove(j);
                j=0;
                jlocked = false;
            }
            
            for(Integer in: set){
                if(c == in){
                    c=0;
                    clocked = false;
                }
                else if(j == in){
                    j=0;
                    jlocked = false;
                }
                else if(c == 0){
                    c = in;
                    clocked = true;
                    out+="C";
                }
                else if(j == 0){
                    j = in;
                    jlocked = true;
                    out+="J";
                }
                else{
                    out = "IMPOSSIBLE";
                    break;
                }
            }
            if(out.equals("IMPOSSIBLE"))break;

        }
        System.out.println("Case #"+(i+1)+": "+out);
    }
  }
}