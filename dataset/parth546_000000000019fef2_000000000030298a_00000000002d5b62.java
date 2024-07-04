import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
    static Scanner sc=new Scanner(System.in);
    public static void main(String args[])
    {
       int t=sc.nextInt();
       for(int i=1;i<=t;i++)
           eachCase(i);
    }
    static void eachCase(int testCase)
    {
        long x=sc.nextLong();
        long y=sc.nextLong();
        System.out.print("Case #"+testCase+": ");
        if((x+y)%2!=0)
        bfs(x,y);
        else
        System.out.println("IMPOSSIBLE");
    }
    static void bfs(long x,long y)
    {
        LinkedList<CustomClass> frontier= new LinkedList<>();
        frontier.addLast(new CustomClass(0,0,"",0));
        while(!frontier.isEmpty()) {
            CustomClass state = frontier.removeFirst();
            if (state.x == x && state.y == y) {
                print(state);
                break;
            }
            CustomClass[] children = state.getChildren();
            for (int i = 0; i < 4; i++) {
                frontier.addLast(children[i]);
            }
            //System.out.println(""+state.depth+" "+state.x+","+state.y);
            
        }
    }
    static void print(CustomClass obj)
    {
        System.out.println(obj.moves);
    }
}
class CustomClass{
    public long x,y;
    String moves;
    byte depth;
    CustomClass(long x,long y, String moves, long depth){
        this.x=x;
        this.y=y;
        this.moves=moves;
        this.depth=depth;
    }
    CustomClass[] getChildren(){
       CustomClass[] ans= new CustomClass[4];
       ans[0]= new CustomClass(this.x+(int)Math.pow(2,this.depth),this.y,this.moves+"E",this.depth+1);
       ans[1]= new CustomClass(this.x-(int)Math.pow(2,this.depth),this.y,this.moves+"W",this.depth+1);
       ans[2]= new CustomClass(this.x,this.y+(int)Math.pow(2,this.depth),this.moves+"N",this.depth+1);
       ans[3]= new CustomClass(this.x,this.y-(int)Math.pow(2,this.depth),this.moves+"S",this.depth+1);
       return ans;
    }
}
