import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    public static long endRange=100;
    public static long startRange=-100;
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int T=sc.nextInt();
        for(int t=1;t<=T;t++){
            long x=sc.nextLong();
            long y=sc.nextLong();
            Queue<Point> pointQueue=new LinkedList<Point>();
            pointQueue.add(new Point(0,0,"",0));
            Set<String> pointSet=new HashSet<String>();
            pointSet.add("0,0");
            System.out.println("Case #" + t + ": " + getDirections(pointQueue,pointSet,x,y));
        }
    }

    public static String getDirections(Queue<Point> pointQueue,Set<String> pointSet, long xx,long yy){

        while(!pointQueue.isEmpty()){
            Point point=pointQueue.poll();
            //System.out.println(point.x+" "+point.y);
            if(point.x==xx && point.y==yy){
                return point.ways.toString();
            }
            if((point.x>=startRange && point.x<=endRange) && (point.y>=startRange && point.y<=endRange)){
                long jump= (long)Math.pow(2,point.jump);
                long lx=point.x-jump;
                long rx=point.x+jump;
                long dy=point.y-jump;
                long uy=point.y+jump;
                long njump=point.jump+1;
                //System.out.println(jump);
                if(!pointSet.contains(lx+","+point.y)){
                    pointQueue.add(new Point(lx,point.y,point.ways+"W",njump));
                    pointSet.add(lx+","+point.y);
                }
                if(!pointSet.contains(rx+","+point.y)){
                    pointQueue.add(new Point(rx,point.y,point.ways+"E",njump));
                    pointSet.add(rx+","+point.y);
                }
                if(!pointSet.contains(point.x+","+dy)){
                    pointQueue.add(new Point(point.x,dy,point.ways+"S",njump));
                    pointSet.add(point.x+","+dy);
                }
                if(!pointSet.contains(point.x+","+uy)){
                    pointQueue.add(new Point(point.x,uy,point.ways+"N",njump));
                    pointSet.add(point.x+","+uy);
                }

            }

        }

        return "IMPOSSIBLE";
    }

    static class Point{
        long x;
        long y;
        long jump;
        String ways;
        public Point(long x,long y,String ways,long jump){
            this.x=x;
            this.y=y;
            this.jump=jump;
            this.ways=ways;
        }
    }
}