import java.util.*;

class Solution {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    
    for(int i=0;i<t;i++){
        int n = sc.nextInt();
        int time[]=new int[14410];
        HashMap<Integer,HashSet<Integer>> hash = 
            new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();
        for(int tl=0;tl<14410;tl++){
            HashSet<Integer> list1 = new HashSet<>();
            hash.put(tl,list1);
        }
        for(int p=0;p<n;p++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            
            HashSet<Integer> temp = hash.get(a);
            temp.add(p+1);
            list.add(a);
            hash.put(a,temp);
            
            temp = hash.get(b);
            temp.add(p+1);
            hash.put(b,temp);
            
        }
        int c=0,j=0;
        boolean clocked=false, jlocked=false;
        String out = "";
        HashMap<Integer,String> mm = new HashMap<>();
        
        for(int p=0;p<14410;p++){
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
                    mm.put(p,"C");
                }
                else if(j == 0){
                    j = in;
                    jlocked = true;
                    out+="J";
                    mm.put(p,"J");
                }
                else{
                    out = "IMPOSSIBLE";
                    break;
                }
            }
            if(out.equals("IMPOSSIBLE"))break;

        }
        String tem = "";
        if(!out.equals("IMPOSSIBLE")){
        
        for(Integer inn:list){
            if(mm.get(inn)!=null)
            tem+=mm.get(inn);
        }
        }
        else{
            tem = out;
        }
        // System.out.println("Case #"+(i+1)+": "+out);
        System.out.println("Case #"+(i+1)+": "+tem);
    }
  }
}