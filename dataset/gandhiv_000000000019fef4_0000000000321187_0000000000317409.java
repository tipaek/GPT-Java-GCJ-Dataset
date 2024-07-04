import java.util.*;
class Point{
    private int x;
    private int y;
    private int t;
    Point(int x,int y, int t){
        this.x = x;
        this.y = y;
        this.t = t;
    }
    public int getX(){
        return this.x;
    }
    public int getY(){
        return this.y;
    }
    public int getT(){
        return this.t;
    }
    public void setX(int x){
        this.x = x;
    }
    public void setY(int y){
        this.y = y;
    }
    public void setT(int t){
        this.t = t;
    }
    @Override
    public String toString(){
        return "Point:[x:"+this.x+", y:"+this.y+", t:"+this.t+"]";
    }
    @Override
    public boolean equals(Object p1){
        Point p = (Point)p1;
        return (x==p.x)&&(y==p.y)&&(t==p.t);
    }
}
public class Solution
{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int i1=1;i1<=t;i1++){
		    int x = sc.nextInt();
		    int y = sc.nextInt();
		    String m = sc.next();
		    Point p = new Point(x,y,-1);
		    List<Point> li = new ArrayList<>();
		    li.add(p);
		    int i;
		    for(i=0;i<m.length();i++){
		        if(m.charAt(i)=='S' || m.charAt(i)=='N'){
		            y = (m.charAt(i)=='N')?y+1:y-1;
		        }
		        else {
		            x = (m.charAt(i)=='E')?x+1:x-1;
		        }
		        Point tmp = new Point(x,y,i+1);
		        li.add(tmp);
		    }
		    x = li.get(0).getX();
		    y = li.get(0).getY();
		    li.remove(0);
		    int x1=0,y1=0;
		    List<Point> li1 = new ArrayList<>();
		    boolean flag = (y>=x)?true:false;
		    for(i=0;i<li.size();i++){
		        if(flag==true){
		            if(x1==x)
		                flag = !flag;
		            else    x1++;
		        }
		        else{
		            if(y1==y)
		                flag = !flag;
		            else    y1++;
		        }
		        li1.add(new Point(x1,y1,i+1));
		    }
		    li.retainAll(li1);
		    System.out.print("Case #"+i1+": ");
		    if(li.size()==0)
		        System.out.println("IMPOSSIBLE");
		    else{
		        int min = 10000;
		        for(Point p1:li){
		            if(p1.getT()<min)
		                min = p1.getT();
		        }
		        System.out.println(min);
		    }
		}
	}
}