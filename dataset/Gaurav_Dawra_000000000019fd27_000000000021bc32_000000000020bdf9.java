import java.util.*;
public class Solution{
    static class s{
        public int num, id, type;
        s(int n, int i, int t){
            num=n;
            id=i;
            type=t;
        }
    }
    static class comp implements Comparator<s>{
        @Override
        public int compare(s a, s b){
            if(a.num==b.num){
                if(a.type==0 && b.type==1) return 1;
                else if(a.type==1 && b.type==0) return -1;
                else return -1;
            }
            return (a.num<b.num)?-1:1;
        }
    }
    public static void main(String []args){
        Scanner in=new Scanner(System.in);
        int t=in.nextInt();
        for(int T=1;T<=t;T++){
        int n=in.nextInt();
        ArrayList<s> a = new ArrayList<>();
        for(int i=0;i<n;i++){
            int u=in.nextInt();
            int v=in.nextInt();
            
            a.add(new s(u, i, 0));
            a.add(new s(v, i, 1));
        }
        
        Collections.sort(a, new comp());
        // for(int i=0;i<a.size();i++) System.out.println(a.get(i).num);
        boolean C=false, J=false;
        boolean possible=true;
        boolean []who = new boolean[n];
        for(int i=0;i<n;i++) who[i] = false;
        for(int i=0;i<a.size();i++){
            if(a.get(i).type==0){
                if(!C){
                    C=true;
                    who[a.get(i).id] = false;
                }
                else if(!J){
                    J=true;
                    who[a.get(i).id] = true;
                }
                else{
                    possible=false;
                    break;
                }
            }
            else{
                if(who[a.get(i).id] == true){
                    J=false;
                }
                else{
                    C=false;
                }
            }
        }
        System.out.print("Case #");
        System.out.print(T);
        System.out.print(": ");
        if(!possible) System.out.println("IMPOSSIBLE");
        else{
            for(int i=0;i<n;i++){
                if(who[i]==true) System.out.print('J');
                else System.out.print('C');
            }
            System.out.println();
        }
        }
        in.close();
    }
}