import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = in.nextInt();

        char J='J', C='C';

        for (int t = 1; t <= T; ++t) {
            int N = in.nextInt();
            Map<Integer,Activity> aM = new HashMap<>();
            List<Activity> aL = new ArrayList<>(N);
            Activity activity;
            for(int n=0;n<N;n++) {
                activity = new Activity(in.nextInt(),in.nextInt(),n);
                aL.add(activity);
                aM.put(n,activity);
            }

            aL.sort(new Comparator<Activity>() {
                @Override
                public int compare(Activity o1, Activity o2) {
                    return o1.S-o2.S;
                }
            });

            boolean solved = false;
            /*for(int i = 0;i<=24*60;i++) {
                int m=0;
                br: for(Activity a:aM.values()) {
                    if(a.S<i && a.E>i) {
                        m++;
                        if(m==3) {
                            System.out.println("Case #" + t + ": " + "IMPOSSIBLE");
                            solved = true;
                            i = 24*60+1;
                            break br;
                        }
                    }
                }
            }*/

            for(int i=0;i<N;i++) {
                Activity a = aL.get(i);
                for(int j=i+1;j<N;j++) {
                    Activity b = aL.get(j);
                    if(b.S<a.E) {
                        Activity ab = new Activity(b.S,a.E<b.E?a.E:b.E,-1);
                        for (int k = j + 1; k < N; k++) {
                            Activity c = aL.get(k);
                            if(c.S<ab.E) {
                                System.out.println("Case #" + t + ": " + "IMPOSSIBLE");
                                solved = true;
                                k=N;
                                j=N;
                                i=N;
                            }
                        }
                    }
                }
            }

            if(!solved) {

                aL.get(0).P=true;
                for(int i = 0;i<aL.size()-1;i++) {
                    Activity a = aL.get(i);
                    Activity b = aL.get(i+1);
                    if(b.S<a.E) {
                        b.P=!a.P;
                    } else {
                        b.P=a.P;
                    }
                }

                System.out.print("Case #" + t + ": ");
                for(int i=0;i<aM.size();i++) {
                    System.out.print(aM.get(i).P?C:J);
                }
                System.out.println();
            }
        }
    }

    static class Activity {
        int S, E, ID; public boolean P;
        public Activity(int S, int E, int ID) {
            this.S = S;
            this.E = E;
            this.ID = ID;
        }
    }
}
