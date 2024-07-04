

import java.util.*;
import java.io.*;

class point {
    int x;
    int y;
    boolean visited;
    char direction;
    point parent;

    public point(int a, int b,char direction, point parent){
        this.x=a;
        this.y=b;
        this.direction=direction;
        this.parent=parent;

    }


    public boolean equals(point o) {
        if(o.x==this.x&&o.y==this.y)
            return true;
        return false;
    }
    public boolean isValid(point target){
        int maxVal=(int)Math.pow(10,3);
        int x=2*Math.abs(target.x);
        int y=2*Math.abs(target.y);
        if((this.x>x||this.x<-1*x)&&(this.y>y||this.y<-1*y))
            return false;

        return true;

    }
    public String path(){
        point p=this;
        StringBuilder sb=new StringBuilder();
        while(p!=null){
            sb.append(p.direction);
            p=p.parent;
        }
        return sb.reverse().toString().substring(1);
    }
}
public class Solution {
    public static void main(String[] args) throws Exception{

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int t = Integer.parseInt(br.readLine());
            for (int k = 1; k <= t; ++k) {
                String [] cord=br.readLine().split(" ");
                int x=Integer.parseInt(cord[0]);
                int y=Integer.parseInt(cord[1]);
                point target=new point(x,y,'T',null);
                ArrayList<point> curr_level= new ArrayList<point>();
                curr_level.add(new point(0,0,'O',null));
                ArrayList<point> next_level= new ArrayList<point>();
                int i=1;
                point result=null;
                while(true){
                    if(curr_level.isEmpty()){
                        curr_level=next_level;
                        i++;
                        next_level=new ArrayList<point>();
                    }
                    point curr_point=curr_level.remove(curr_level.size()-1);
                    //Moving N
                    point pt=new point(curr_point.x,curr_point.y+(int)Math.pow(2,i-1),'N',curr_point);
                    if(pt.equals(target)||!pt.isValid(target)){
                        result=pt;

                        break;
                    }
                    next_level.add(pt);

                    //Moving S
                    pt=new point(curr_point.x,curr_point.y-(int)Math.pow(2,i-1),'S',curr_point);
                    if(pt.equals(target)||!pt.isValid(target)){
                        result=pt;

                        break;
                    }
                    next_level.add(pt);

                    //Moving W
                    pt=new point(curr_point.x-(int)Math.pow(2,i-1),curr_point.y,'W',curr_point);
                    if(pt.equals(target)||!pt.isValid(target)){
                        result=pt;
                        break;
                    }
                    next_level.add(pt);

                    //Moving E
                    pt=new point(curr_point.x+(int)Math.pow(2,i-1),curr_point.y,'E',curr_point);
                    if(pt.equals(target)||!pt.isValid(target)){
                        result=pt;
                        break;
                    }
                    next_level.add(pt);
                    System.gc();
                }
                if(!result.isValid(target))
                    System.out.println("Case #" + k + ": IMPOSSIBLE");
                else
                    System.out.println("Case #" + k + ": "+result.path());
            }


    }
}