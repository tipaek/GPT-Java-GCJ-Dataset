import java.util.*;

class pair{
    int x;
    int y;
    pair(int a,int b){
        x = a;
        y = b;
    }
}
class Solution{
    public static void main(String []args){
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        int c = 0;
        while(c < t){
            int ca = -1;
            int ja = -1;

            TreeMap tm = new TreeMap();
            //HashMap index = new HashMap();
            int n = s.nextInt();
            ArrayList ans = new ArrayList(Collections.nCopies(n, 0));
            for(int i = 0;i<n;i++){
                int start = s.nextInt();
                int end = s.nextInt();
                tm.put(start, new pair(end,i));
            }
            Iterator it = tm.entrySet().iterator();
            boolean allok = true;

            while(it.hasNext()){

                Map.Entry me = (Map.Entry)it.next();
                int start = (int)me.getKey();
                pair p = (pair)me.getValue();
                int end = p.x;
                int index = p.y;
                // System.out.println(start);
                // System.out.println(end);
                // System.out.println(index);
                if(start >= ca){
                    ca = end;
                    ans.set(index, 'C');
                }else if(start >= ja){
                    ja = end;
                    ans.set(index, 'J');
                }else{
                    allok = false;
                    break;
                }

            }
            if(allok){
                System.out.print("Case #"+(c+1) + ": ");
                for(int k = 0;k<n;k++){
                    System.out.print(ans.get(k));
                }
                System.out.print("\n");
            }else{
                System.out.println("Case #"+(c+1) + ": " + "IMPOSSIBLE");
            }
            c++;
        }
    }

}