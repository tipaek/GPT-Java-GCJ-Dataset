import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

class Solution {
    private static class Triangle{
        int rows = 0;
        List<List<Integer>> values=new LinkedList<>();
        void createUntilRow(int row){
            for(int i=rows;i<row+1;i++){
                values.add(new LinkedList<>());
                if(i==0){
                    values.get(i).add(1);
                }else{
                    values.get(i).add(1);
                    for(int j=1;j<i;j++){
                        values.get(i).add(values.get(i-1).get(j-1)+values.get(i-1).get(j));
                    }
                    values.get(i).add(1);
                }
            }
            rows = row+1;
        }
        Integer get(int c, int r){
            if(r>= rows){
                createUntilRow(r);
            }
            return  values.get(r).get(c);
        }
    }



    public static Integer getIntFromLine(){
        BufferedReader obj = new BufferedReader(new InputStreamReader(System.in));
        String line="";
        try {
            line = obj.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        line = line.replaceAll("\\s","");
        return Integer.valueOf(line);
    }
    public static String getStringFromLine(){
        BufferedReader obj = new BufferedReader(new InputStreamReader(System.in));
        String line="";
        try {
            line = obj.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return line;
    }

    public static void main(String[] args){
        int testCases=getIntFromLine();
        for(int i=0;i<testCases;i++){
            int n = getIntFromLine();
            Triangle triangle = new Triangle();
            LinkedList<Point> path = new LinkedList<>();
            LinkedList<Point> result = getPath(new Point(0,0),n,triangle,path);
            System.out.println("Case #"+(i+1)+":");
            if(result == null){

            }else{
                for(int j=0;j<result.size();j++){
                    System.out.println((result.get(j).y+1)+" "+(result.get(j).x+1));
                }
            }
        }
        try {
            System.in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static LinkedList<Point> getPath(Point newPoint, int rest, Triangle triangle, LinkedList<Point> path){
        if(rest == 0){
            return path;
        }
        if(rest-triangle.get(newPoint.x,newPoint.y)>=0){
            if(path.contains(newPoint)){
                return null;
            }
            path.addLast(newPoint);
            LinkedList<Point> candidates = new LinkedList<>();
            candidates.add(new Point(newPoint.x,newPoint.y+1));
            candidates.add(new Point(newPoint.x+1,newPoint.y+1));
            if(newPoint.x<newPoint.y){
                candidates.add(new Point(newPoint.x+1,newPoint.y));
                candidates.add(new Point(newPoint.x,newPoint.y-1));
            }
            if(newPoint.x >0){
                candidates.add(new Point(newPoint.x-1,newPoint.y));
                candidates.add(new Point(newPoint.x-1,newPoint.y-1));
            }
            while(candidates.size()>0){
                Point maxPoint = null;
                int max = 0;
                for(int i=0;i<candidates.size();i++){
                    if(max < triangle.get(candidates.get(i).x,candidates.get(i).y)){
                        maxPoint = candidates.get(i);
                        max = triangle.get(maxPoint.x,maxPoint.y);
                    }
                }
                LinkedList<Point> p = getPath(maxPoint,rest-triangle.get(newPoint.x,newPoint.y),triangle,path);
                if(p != null){
                    return p;
                }
                candidates.remove(maxPoint);
            }
        }else{
            return null;
        }
        path.removeLast();
        return null;
    }

}
