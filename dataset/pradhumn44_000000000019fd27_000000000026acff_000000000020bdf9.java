import java.util.*;
public class Solution {
    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        for(int i = 1; i <= t ; i++){
            int n = s.nextInt();
            ArrayList<Time> a = new ArrayList<>();
            for(int j = 0 ; j < n ; j++){
                int x = s.nextInt();
                int y = s.nextInt();
                Time ob = new Time(x,y);
                a.add(ob);
            }
            Collections.sort(a);
            int flag = 0;
            String ans = "J";
            int swap = 0,J = a.get(0).getE(),C = -1;
            
            String lo[] = {"J","C"};
            
            for(int j = 1 ; j < n ; j++){
                if(a.get(j).getS() >= a.get(j-1).getE()){
                    ans += lo[swap];
                    if(swap == 0)
                    J = a.get(j).getE();
                    else
                    C = a.get(j).getE();
                }else if(a.get(j).getS() < a.get(j-1).getE()){
                    if(swap == 1){
                        if(J <= a.get(j).getS()){
                            swap = 0;
                            J = a.get(j).getE();
                            ans += "J";
                        }else{
                            flag = 1;
                            break;
                        }
                    }else{
                        if(C <= a.get(j).getS()){
                            swap = 1;
                            C = a.get(j).getE();
                            ans += "C";
                        }else{
                            flag = 1;
                            break;
                        }
                    }
                }
            }
            
            System.out.print("Case #"+i+": ");
            
            if(flag == 1)
            System.out.println("IMPOSSIBLE");
            else
            System.out.println(ans);
        }
    }
}
class Time implements Comparable<Time>{
    int s;
    int e;

    Time(int x, int y){
        this.s = x;
        this.e = y;
    }

    public int compareTo(Time t){
        if(this.s == t.s)
        return this.e - t.e;

        return this.s - t.s;
    }

    public int getS(){return this.s;}
    public int getE(){return this.e;}
}