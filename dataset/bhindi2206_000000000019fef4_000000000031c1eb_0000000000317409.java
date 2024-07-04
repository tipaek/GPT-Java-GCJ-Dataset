import java.util.*;
import java.lang.*;

public class Solution{
    
    public static class Point{
        public  int x;
        public  int y;
        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
        public void printPoint(){
            System.out.println(this.x +","+this.y);
        }
    }
    
    public static ArrayList<Point> getPathArray(String str){
        ArrayList<Point> paths = new ArrayList<>();
        for(char ch: str.toCharArray()){
            if(ch == 'N')
                paths.add(new Point(0,1));
            else if(ch == 'S')
                paths.add(new Point(0,-1));
            else if(ch == 'E')
                paths.add(new Point(1,0));
            else if(ch == 'W')
                paths.add(new Point(-1,0));   
        }
        return paths;
    }
    public static ArrayList<Point> getCumulativePath(ArrayList<Point> pathPepurr, int Px, int Py){
        ArrayList<Point> finalPath = new ArrayList<>();
        Point currPoint = new Point(Px,Py);
        for(Point p:pathPepurr){
            int x = currPoint.x + p.x;
            int y = currPoint.y + p.y;
            finalPath.add(new Point(x,y));
            currPoint = new Point(x,y);
        }
        return finalPath;
    }
     public static void main(String []args){
         Scanner sc = new Scanner(System.in);
         int tt=0;
         int t = sc.nextInt();
         while(tt++<t){
             int Px = sc.nextInt();
             int Py = sc.nextInt();
             String str = sc.nextLine();
            // System.out.println(Px +"*************"+Py);
             ArrayList<Point> pathPepurr = getPathArray(str); 
            //System.out.println(str.trim());
             ArrayList<Point> finalPath = getCumulativePath(pathPepurr,Px,Py); 
            
            //for(Point p:finalPath)
               // p.printPoint();
             int timeLimit = pathPepurr.size();
             boolean flag = false;
             int stepsReqd = timeLimit + 1;
             
             for(int i=1;i<=timeLimit;i++){
                 //finalPath.get(i-1).printPoint();
                 stepsReqd = Math.abs(finalPath.get(i-1).x)+Math.abs(finalPath.get(i-1).y);
                 if(stepsReqd<=i){
                     stepsReqd = i;
                     flag = true;
                     break;
                 }
             }
             if(flag)
                System.out.println("Case #"+tt+": "+stepsReqd);
            else 
                System.out.println("Case #"+tt+": IMPOSSIBLE");
             //for(int i = timeLimit;i>0;i++){
                 
            // }
         }
         
     }
}