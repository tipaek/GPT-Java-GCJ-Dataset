import java.io.*;
import java.util.Arrays;

class Solution implements Comparable{
    int start;
    int end;
    int ind;
    char c;
    public Solution(int start, int end, int ind){
        this.start = start;
        this.end = end;
        this.ind = ind;
    }

    @Override
    public int compareTo(Object o) {
        Solution a = (Solution) o;
        if(this.start < a.start) return -1;
        if(this.start > a.start) return 1;
        return 0;
    }

    public static void main(String[] args) {

//        Reader inputString = new StringReader("4\n" +
//                "3\n" +
//                "360 480\n" +
//                "420 540\n" +
//                "600 660\n" +
//                "3\n" +
//                "0 1440\n" +
//                "1 3\n" +
//                "2 4\n" +
//                "5\n" +
//                "99 150\n" +
//                "1 100\n" +
//                "100 301\n" +
//                "2 5\n" +
//                "150 250\n" +
//                "2\n" +
//                "0 720\n" +
//                "720 1440");
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader in = new BufferedReader(inputString);
        String line = "";
        try {
            while ((line = in.readLine())!=null){
                int numc = Integer.parseInt(line);
                for(int c=0;c<numc;c++){
                    String sol = "";
                    int lol = Integer.parseInt(in.readLine());
                    Solution[] activities = new Solution[lol];
                    for(int act=0;act<lol;act++){
                        String[] linez = in.readLine().split(" ");
                        activities[act] = new Solution(Integer.parseInt(linez[0]),Integer.parseInt(linez[1]),act);
                    }
                    Arrays.sort(activities);
                    int[] done = new int[activities.length];
                    boolean j = true;
                    boolean C = true;
                    int start = 0;
                    for(int i=0;i<activities.length;i++){
                        for(int x = start;x<activities.length;x++){
                            if(done[x] != 0 && activities[i].start>=activities[x].end){
                                if(done[x]==1) C = true;
                                if(done[x]==2) j = true;
                                done[x] = 0;
                            }
                            if(done[x] != 0 && activities[i].start>=activities[x].end){
                                if(done[x]==1) C = true;
                                if(done[x]==2) j = true;
                                done[x] = 0;
                            }
                        }
                        if(!j & !C){
                            sol = "IMPOSSIBLE";
                            break;
                        }
                        if(C){
                            activities[i].c = 'C';
                            done[i] = 1;
                            C = !C;
                        }
                        else if(j) {
                            activities[i].c = 'J';
                            done[i] = 2;
                            j = !j;
                        }
                    }
//                    System.out.println(Arrays.toString(activities));
//                    System.out.println("Case #"+(c+1)+":"+" " + trace + " " +rowc + " " + colc + " ");
                    if(sol.equals("")){
                        char[] newOne = new char[activities.length];
                        for(Solution a : activities){
                            newOne[a.ind] = a.c;
                        }
                        sol = new String(newOne);
                    }
                    System.out.println("Case #"+(c+1)+":"+" " + sol);
                }

            }
        }
        catch (IOException e){}

    }
}


