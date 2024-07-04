import java.util.*;

class Solution {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt(); 
    // System.out.println(t);
    
    for(int i=0;i<t;i++){
        HashMap<String,HashSet<Integer>> hash = 
            new HashMap<>();
        HashSet<Integer> row = new HashSet<>();
        HashSet<Integer> col = new HashSet<>();
        int m = sc.nextInt();
        int trace = 0;
        for(int p=0;p<m;p++){
            for(int q=0;q<m;q++){
                int in = sc.nextInt();
                if(p==q)trace+=in;
                // System.out.println("p:"+p+" q:"+q+" in:"+in);
                // if(!row.contains(p))
                if(hash.get("r"+p)!=null){
                    // System.out.println("if r"+p);
                    HashSet<Integer> temp = hash.get("r"+p);
                    if(temp.contains(in))row.add(p);
                    else {
                        temp.add(in);
                        hash.put("r"+p,temp);
                    }
                }else{
                    // System.out.println("else r"+p);
                    HashSet<Integer> temp = new HashSet<>();
                    temp.add(in);
                    hash.put("r"+p,temp);
                }
                // if(!col.contains(q))
                if(hash.get("c"+q)!=null){
                    // System.out.println("if c"+q);
                    HashSet<Integer> temp = hash.get("c"+q);
                    if(temp.contains(in))col.add(q);
                    else {
                        temp.add(in);
                        hash.put("c"+q,temp);
                    }
                }else{
                    // System.out.println("else c"+q);
                    HashSet<Integer> temp = new HashSet<>();
                    temp.add(in);
                    hash.put("c"+q,temp);
                }
            }
        }
        System.out.println("Case #"+(i+1)+": "+trace+" "+row.size()+" "+col.size());
    }
  }
}