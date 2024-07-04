import java.io.*;
import java.util.Arrays;
import java.util.Comparator;

public class Solution {

    private static final Boolean FROM_FILE = Boolean.FALSE;

    private static class Activity implements Comparable<Activity>{
        int x,y;    //24x60 = 1440
        int i;      //1000
        int color;  //0,1

        public Activity(int x, int y, int index){
            this.x = x; this.y = y; this.i = index;
        }

        public void setColor(int c){
            this.color = c;
        }

        public int getX(){
            return this.x;
        }
        public int getY(){
            return this.y;
        }

        public int getColor(){
            return this.color;
        }
        public int getIndex(){
            return this.i;
        }

        @Override
        public int compareTo(Activity a){
            if(a.x > x) return -1;
            if(a.x < x) return 1;
            return Integer.compare(y,a.y);
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br;
        BufferedWriter bw;

        if(FROM_FILE){
            br = new BufferedReader(new FileReader("QR20203.in"));
        } else {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String NO = "IMPOSSIBLE";

        try {
            if(FROM_FILE) {
                File file = new File("QR20203.out");
                if (!file.exists()) {
                    file.createNewFile();
                }
                bw = new BufferedWriter(new FileWriter(file.getAbsoluteFile()));
            } else {
                bw = new BufferedWriter(new OutputStreamWriter(System.out));
            }

            String line = br.readLine();
            String[] p;

            int tests = Integer.parseInt(line);//100
            int n;//max 1000

            //24*60
            for(int i = 0; i < tests; i++){
                line = br.readLine();
                n = Integer.parseInt(line);

                Activity[] a = new Activity[n];
                boolean solution = true;

                for(int j = 0;j < n;j++) {
                    line = br.readLine();
                    p = line.split("\\s+");

                    a[j] = new Activity(Integer.parseInt(p[0]), Integer.parseInt(p[1]), j);
                }
                //Step #1: sort by start then by end
                Arrays.sort(a);//compareTo

                //Step #2: process LTR and color. throw false on solution if unable to color
                int[] finishes = new int[2];
                Arrays.fill(finishes,-1);

                int color = 1;
                a[0].setColor(color);
                finishes[color] = a[0].y;

                for(int j = 1;j < n && solution;j++) {
                    if(finishes[color] <= a[j].getX()){
                        //no overlap, continue color, set next finish
                       a[j].setColor(color);
                       finishes[color] = a[j].getY();
                    } else {
                        //some overlap prevents same color
                        // try to switch color
                        if(finishes[1-color] <= a[j].getX()){
                            color = 1-color;//flip current color
                            a[j].setColor(color);
                            finishes[color] = a[j].getY();
                        } else {
                            //neither of them is available, need a 3rd color
                            solution = false;
                        }
                    }
                }

                //Step #3: sort back by index and extract answer
                String answer;
                if(solution) {
                    //sort by index
                    Arrays.sort(a, new Comparator<Activity>() {
                        @Override
                        public int compare(Activity o1, Activity o2) {
                            return Integer.compare(o1.getIndex(),o2.getIndex());
                        }
                    });

                    StringBuilder s = new StringBuilder(n);
                    for(int j = 0;j < n;j++){
                        if(a[j].getColor() == 1) {
                            s.append("C");
                        } else {
                            s.append("J");
                        }
                    }
                    answer = s.toString();
                } else {
                    answer = NO;
                }

                //output
                bw.write("Case #"+(i+1)+": "+answer+"\n");
                bw.flush();
            }

            if(FROM_FILE) {
                bw.close();
            }
        } finally {
            if(FROM_FILE) {
                br.close();
            }
        }
    }
}
