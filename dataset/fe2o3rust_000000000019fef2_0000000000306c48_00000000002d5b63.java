import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
/*
r- the lower bound of the radius
scan1. sweep across the wall throwing a dart every 2r, rows every 2r
scan2. sweep again throwing a dart every r (skipping the ones we already tested)

hasAlreadyHit

 */

public  class Solution {
    static BufferedReader reader;
    public static void main(String[] arg)throws IOException{

        reader =
                new BufferedReader(new InputStreamReader(System.in));

        String line=reader.readLine();
        String split[]=line.split(" ");
        int numCases= Integer.parseInt(split[0]);
        int A= Integer.parseInt(split[1]);
        int B= Integer.parseInt(split[2]);

        for(int i =0;i<numCases;i++){

            processCase(A,B);
        }
    }

    private static boolean processCase(int A,int B)throws IOException{


        State state=new State();
        state.B=B;
        state.A=A;

        for(int i=0;i<300;i++){

            makeQuery(state);
            sendQuery(state);
            //processResponse(response,state);
            if(isComplete(state)){
                break;
            }

        }
        return true;

    }
    private static boolean isComplete(State state){
        return "CENTER".equals(state.queries.get(state.queries.size()-1).getResponse());
    }


    private static void makeQuery(State state){
        Query q=new Query();


        if(!state.hasAnyHits()) {
            //scanning till we get a hit
            if(state.queries.size()>=state.numTriesInScan()){
                q.setX(1);
                q.setY(1);
            }else{
                int x=state.getXForScan(state.queries.size()+1);
                int y=state.getYForScan(state.queries.size()+1);
                q.setX(x);
                q.setY(y);
            }
        }else{

          //  if (state.innerBox==null){
                state.makeInitialInnerBox();
         //   }
         //   if(state.outerBox==null) {
                state.makeInitialOuterBox();
          //  }
            if(state.boxesSame()){
                q.setX(state.innerBox.getCenterX());
                q.setY(state.innerBox.getCenterY());
            }else{
                int topDiff=-1;
                int botDiff=-1;
                int leftDiff=-1;
                int rightDiff=-1;

                topDiff=state.outerBox.getMaxy()-state.innerBox.getMaxy();
                botDiff=state.innerBox.getMiny()-state.outerBox.getMiny();

                leftDiff=state.innerBox.getMinx()-state.outerBox.getMinx();
                rightDiff=state.outerBox.getMaxx()-state.innerBox.getMaxx();

                if(topDiff>=botDiff && topDiff>=leftDiff && topDiff>=rightDiff){
                    q.setX(state.outerBox.getCenterX());
                    q.setY(topDiff+state.innerBox.getMaxy());
                }else if(botDiff>=topDiff && botDiff>=leftDiff && botDiff>=rightDiff){
                    q.setX(state.outerBox.getCenterX());
                    q.setY(state.innerBox.getMiny()-botDiff);
                }else if(leftDiff>=topDiff && leftDiff>=botDiff && leftDiff>=rightDiff){
                    q.setX(state.innerBox.getMinx());
                    q.setY(state.outerBox.getCenterY());
                }else{
                    q.setX(state.innerBox.getMaxx()+rightDiff);
                    q.setY(state.outerBox.getCenterY());
                }
            }
        }

        state.queries.add(q);
    }

    private static void sendQuery(State state)throws IOException{

        Query q=state.queries.get(state.queries.size()-1);

        StringBuffer sb=new StringBuffer();
        sb.append(q.getX());
        sb.append(" ");
        sb.append(q.getY());
        System.out.println(sb.toString());

        String resp=reader.readLine();
        q.setResponse(resp);


    }

    public static class Query{

        private int x;
        private int y;
        private String response;

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }

        public String getResponse() {
            return response;
        }

        public void setResponse(String response) {
            this.response = response;
        }
    }

    public static class Box{
        //these are boundaries around the HIT that we know are not on the board, or else are the walls
        private int minx;
        private int miny;
        private int maxx;
        private int maxy;

        public int getMinx() {
            return minx;
        }

        public void setMinx(int minx) {
            this.minx = minx;
        }

        public int getMiny() {
            return miny;
        }

        public void setMiny(int miny) {
            this.miny = miny;
        }

        public int getMaxx() {
            return maxx;
        }

        public void setMaxx(int maxx) {
            this.maxx = maxx;
        }

        public int getMaxy() {
            return maxy;
        }

        public void setMaxy(int maxy) {
            this.maxy = maxy;
        }

        public int getCenterX(){
            return minx+(maxx-minx)/2;
        }
        public int getCenterY(){
            return miny+(maxy-miny)/2;
        }

    }
    public static class State {

        public int B;
        public int A;

        public List<Query> queries=new ArrayList<>();


        //box of misses
        public Box outerBox=null;

        //box of hits
        public Box innerBox=null;

        public boolean boxesSame(){
            return innerBox.getMinx()==outerBox.getMinx() &&innerBox.getMiny()==outerBox.getMiny() && innerBox.getMaxx()==outerBox.getMaxx() && innerBox.getMaxy() == outerBox.getMaxy();
        }

        public void makeInitialOuterBox(){
            //min x is either the left wall or the rightmost trial to the left of the hit
            List<Query> hits=queries.stream().filter(q->"HIT".equals(q.getResponse())).collect(Collectors.toList());
            List<Query> hitsByX=new ArrayList<>(hits);
            List<Query> hitsByY=new ArrayList<>(hits);
            hitsByX.sort(Comparator.comparing(Query::getX));
            hitsByY.sort(Comparator.comparing(Query::getY));

            List<Query> misses=queries.stream().filter(q->!"HIT".equals(q.getResponse())).collect(Collectors.toList());
            List<Query> missesByX=new ArrayList<>(misses);
            List<Query> missesByY=new ArrayList<>(misses);
            missesByX.sort(Comparator.comparing(Query::getX));
            missesByY.sort(Comparator.comparing(Query::getY));

            List<Query> missesBelowX=misses.stream().filter(q->q.getX()<hitsByX.get(0).getX()).collect(Collectors.toList());
            missesBelowX.sort(Comparator.comparing(Query::getX));

            List<Query> missesAboveX=misses.stream().filter(q->q.getX()>hitsByX.get(hitsByX.size()-1).getX()).collect(Collectors.toList());
            missesAboveX.sort(Comparator.comparing(Query::getX));

            List<Query> missesBelowY=misses.stream().filter(q->q.getY()<hitsByY.get(0).getY()).collect(Collectors.toList());
            missesBelowY.sort(Comparator.comparing(Query::getY));

            List<Query> missesAboveY=misses.stream().filter(q->q.getY()>hitsByY.get(hitsByY.size()-1).getY()).collect(Collectors.toList());
            missesAboveY.sort(Comparator.comparing(Query::getY));


            Box b=new Box();
            b.setMinx(missesBelowX.isEmpty()?-1000000000:missesBelowX.get(missesBelowX.size()-1).getX());
            b.setMiny(missesBelowY.isEmpty()?-1000000000:missesBelowY.get(missesBelowY.size()-1).getY());
            b.setMaxx(missesAboveX.isEmpty()?1000000000:missesAboveX.get(0).getX());
            b.setMaxy(missesAboveY.isEmpty()?1000000000:missesAboveY.get(0).getY());

            outerBox=b;
        }

        public void makeInitialInnerBox(){

            List<Query> hits=queries.stream().filter(q->"HIT".equals(q.getResponse())).collect(Collectors.toList());
            List<Query> hitsByX=new ArrayList<>(hits);
            List<Query> hitsByY=new ArrayList<>(hits);
            hitsByX.sort(Comparator.comparing(Query::getX));
            hitsByY.sort(Comparator.comparing(Query::getY));


            Box b=new Box();
            b.setMinx(hitsByX.get(0).getX());
            b.setMiny(hitsByY.get(0).getY());
            b.setMaxx(hitsByX.get(hitsByX.size()-1).getX());
            b.setMaxy(hitsByY.get(hitsByY.size()-1).getY());

            innerBox=b;
        }




        public int numTriesInScan(){
            /*
            -10^9 + r, 10^9 - r
            -10^9 +2r, 10^9 - r
            ...
            -10^9 +nr, 10^9 - r  (n is floor(2*10^9 / r)
            ...
             */
            int numRadii=Math.floorDiv(2000000000,A);
            return numRadii*numRadii;
        }
        public int getXForScan(int trialNum){
            //trialnum is 1 based
            int numRadii=Math.floorDiv(2000000000,A);
            int row=(trialNum-1)/numRadii;
            int remainder=(trialNum)-(row*numRadii);
            int x = -1000000000+(A*remainder);
            return x;
        }
        public int getYForScan(int trialNum){
            int numRadii=Math.floorDiv(2000000000,A);
            int row=(trialNum-1)/numRadii;
            row++;
            int y = 1000000000-(A*row);
            return y;
        }

        private boolean hitYet=false;

        public boolean hasAnyHits(){
            if(hitYet==false){
                for(Query q:queries){
                    if("HIT".equals(q.getResponse())){
                        hitYet=true;
                        break;
                    }
                }
            }
            return hitYet;
        }

    }

}
