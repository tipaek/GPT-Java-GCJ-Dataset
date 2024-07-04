import java.io.*;
import java.util.*;

public class blindbullseye {

    public static void main(String[] args) throws IOException {

        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int t = in.nextInt();
        boolean done = false;
        for (int x = 0; x < t; x++) {
            int lower = 0; int upper = 1000000000;
            int mid;
            while(upper>lower){
                mid = lower + (upper-lower)/2;
                if (upper-lower==1){
                    System.out.println(0+" "+upper+" ("+lower+", "+upper+")");
                    String s = in.next();
                    if(s.equals("CENTER")){
                        done = true;
                        continue;
                    } else if(s.equals("HIT")){
                        lower=upper;
                        break;
                    } else if(s.equals("MISS")){
                        upper=lower;
                        break;
                    } else if(s.equals("WRONG")){
                        break;
                    }
                }
                System.out.println(0+" "+mid+" ("+lower+", "+upper+")");
                String s = in.next();
                if(s.equals("CENTER")){
                    done=true;
                    continue;
                } else if(s.equals("HIT")){
                    lower = mid;
                } else if(s.equals("MISS")){
                    upper = mid;
                } else if(s.equals("WRONG")){
                    break;
                }
            }
            if(done) continue;
            int yUp = lower;

            lower = -1000000000; upper = 0;
            while(upper>lower){
                mid = lower + (upper-lower)/2;
                if (upper-lower==1){
                    System.out.println(0+" "+upper);
                    String s = in.next();
                    if(s.equals("CENTER")){
                        done = true;
                        continue;
                    } else if(s.equals("HIT")){
                        upper=lower;
                        break;
                    } else if(s.equals("MISS")){
                        lower=upper;
                        break;
                    } else if(s.equals("WRONG")){
                        break;
                    }
                }
                System.out.println(0+" "+mid);
                String s = in.next();
                if(s.equals("CENTER")){
                    done = true;
                    continue;
                } else if(s.equals("HIT")){
                    upper = mid;
                } else if(s.equals("MISS")){
                    lower = mid;
                } else if(s.equals("WRONG")){
                    break;
                }
            }
            if(done) continue;
            int yDown = lower;

            lower = 0; upper = 1000000000;
            while(upper>lower){
                mid = lower + (upper-lower)/2;
                if (upper-lower==1){
                    System.out.println(upper+" "+0);
                    String s = in.next();
                    if(s.equals("CENTER")){
                        done = true;
                        continue;
                    } else if(s.equals("HIT")){
                        lower=upper;
                        break;
                    } else if(s.equals("MISS")){
                        upper=lower;
                        break;
                    } else if(s.equals("WRONG")){
                        break;
                    }
                }
                System.out.println(mid+" "+0);
                String s = in.next();
                if(s.equals("CENTER")){
                    done = true;
                    continue;
                } else if(s.equals("HIT")){
                    lower = mid;
                } else if(s.equals("MISS")){
                    upper = mid;
                } else if(s.equals("WRONG")){
                    break;
                }
            }
            if(done) continue;
            int xUp = lower;

            lower = -1000000000; upper = 0;
            while(upper>lower){
                mid = lower + (upper-lower)/2;
                if (upper-lower==1){
                    System.out.println(upper+" "+0);
                    String s = in.next();
                    if(s.equals("CENTER")){
                        done = true;
                        continue;
                    } else if(s.equals("HIT")){
                        upper=lower;
                        break;
                    } else if(s.equals("MISS")){
                        lower=upper;
                        break;
                    } else if(s.equals("WRONG")){
                        break;
                    }
                }
                System.out.println(0+" "+mid);
                String s = in.next();
                if(s.equals("CENTER")){
                    done = true;
                    continue;
                } else if(s.equals("HIT")){
                    upper = mid;
                } else if(s.equals("MISS")){
                    lower = mid;
                } else if(s.equals("WRONG")){
                    break;
                }
            }
            if(done) continue;
            int yDown = lower;

            System.out.println((xDown+xUp)/2 + " " + (yUp+yDown)/2);
        }
    }
}

