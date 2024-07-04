import java.util.*;

class Solution{
    static class Pair{
        int x, y;
        Pair(int x, int y){
            x = x;
            y = y;
        }
    }
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int testCase = sc.nextInt();
        for(int k=1;k<=testCase;k++){
           
            int x = sc.nextInt();
            int y = sc.nextInt();
            String path = sc.next();

             ArrayList<Pair> pathTrack = new ArrayList<>();
            ArrayList<Integer> a = new ArrayList<>();
            ArrayList<Integer> b = new ArrayList<>();
            for(int i=0;i<path.length();i++){
                if(a.size()==0){
                    if(path.charAt(i)=='N'){
                        a.add(x); b.add(y+1);
                    }
                        
                        // pathTrack.add(new Pair(x, y+1));
                    else if (path.charAt(i)=='S'){
                        a.add(x); b.add(y-1);
                    }
                        // pathTrack.add(new Pair(x, y-1));
                    else if (path.charAt(i)=='E'){
                        a.add(x+1); b.add(y);
                    }
                        // pathTrack.add(new Pair(x+1, y));
                    else if (path.charAt(i)=='W'){
                        a.add(x-1); b.add(y);
                    }
                        // pathTrack.add(new Pair(x-1, y));
                }else{
                    // Pair lastPoint = pathTrack.get(pathTrack.size()-1);
                    int lastX = a.get(a.size()-1);
                    int lastY = b.get(b.size()-1);
                    if(path.charAt(i)=='N'){
                        a.add(lastX); b.add(lastY+1);
                    }
                        // pathTrack.add(new Pair(lastPoint.x, (lastPoint.y)+1));
                    else if (path.charAt(i)=='S'){
                        a.add(lastX); b.add(lastY-1);
                    }
                        // pathTrack.add(new Pair(lastPoint.x, (lastPoint.y)-1));
                    else if (path.charAt(i)=='E'){
                        a.add(lastX+1); b.add(lastY);
                    }
                        // pathTrack.add(new Pair((lastPoint.x)+1, lastPoint.y));
                    else if (path.charAt(i)=='W'){
                        a.add(lastX-1); b.add(lastY);
                    }
                        // pathTrack.add(new Pair((lastPoint.x)-1, lastPoint.y));
                }
            }

            // for(int i=0;i<a.size();i++){
            //     System.out.println(" x "+ p.x + " p.y : "+p.y);
            // }

            Integer ans = Integer.MAX_VALUE;
            int currDist = 0;
            for(int i=0;i<a.size();i++){
                int  currX = a.get(i);
                int currY = b.get(i);
                currDist = Math.abs(currX) + Math.abs(currY);
                if(currDist <= i+1){
                    ans = i+1;
                    break;
                }     
            }

            if(ans==Integer.MAX_VALUE)
                System.out.println("Case #"+k+": IMPOSSIBLE");
            else
                System.out.println("Case #"+k+": "+ans);  
        }
        
    }
}