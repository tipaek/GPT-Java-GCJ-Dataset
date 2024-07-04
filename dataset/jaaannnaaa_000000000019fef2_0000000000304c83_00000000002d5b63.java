import java.util.*;


import java.io.*;
public class Solution {

    // python interactive_runner.py python local_testing_tool.py 0 -- java Solution
    static int M = 1000000000;
    static String HIT = "HIT";
    static String MISS = "MISS";
    static String CENTER = "CENTER";
    static String WRONG = "WRONG";
    static boolean wasCenter;
    static boolean wasWrong;
    static int counter;

    public static void main(String[] args) throws FileNotFoundException {
        // //////////////////////////////
        // try {
        //     FileWriter myWriter = new FileWriter("filename.txt");
        //     myWriter.write("Files in Java might be tricky, but it is fun enough!");
        //     myWriter.close();
        //     // System.out.println("Successfully wrote to the file.");
        // //////////////////////////////
        
        
        
        Scanner in;
        int FROM_SYSTEM = 1;    // 1 on Submission !!!

        if (FROM_SYSTEM == 1) { // 1 on Submission !!!
            in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        } else {
            File myObj = new File("test.txt");
            in = new Scanner(myObj);
        }



        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        int a = in.nextInt();
        int b = in.nextInt();
        boolean wasWrong = false;

        for (int tt = 1; tt <= t; ++tt) {
            wasCenter = false;
            counter = 0;
            if (wasWrong) return;

            // find HIT
            boolean wasHit = false;
            
            
            int hitX = 0;
            int hitY = 0;
            for (int x = -M+M/4; !wasHit && x < M; x += M/4) {
                for (int y = -M+M/4; !wasHit && y < M; y += M/4) {
                    print(x,y);
                    String judge = in.next();
                    if (judge.equals(HIT)) {
                        wasHit = true;
                        hitX = x;
                        hitY = y;
                        // myWriter.write("hit x y: " + x + " " + y);
                    } else if (judge.equals(CENTER)) {
                        wasCenter = true;
                    } else if (judge.equals(WRONG)) {
                        wasWrong = true;
                        return;
                    }
                }
            }

            if (wasCenter) continue;

            // HIT is x, y
            // System.out.println("HIT" + hitX + "a" + hitY + " 0");
            
            // find x leftmost hit (with fix y)
            int xLeft = binSearchXLeft(-M, hitX, hitY, in);
            if (wasWrong) return;
            if (wasCenter) continue;
            
            int xRight = binSearchXRight(hitX, M, hitY, in);
            if (wasWrong) return;
            if (wasCenter) continue;
            // System.out.println("xLeft" + xLeft + "a" + xRight + " 0");
            int xCenter = (xLeft + xRight) / 2;
            int yUp = binSearchYUp(hitY, M, xCenter, in);
            if (wasWrong) return;
            if (wasCenter) continue;
            int yDown = binSearchYDown(-M, hitY, xCenter, in);
            if (wasWrong) return;
            if (wasCenter) continue;
            int yCenter = (yUp + yDown) / 2;
            // System.out.println("yUD" + yUp + "a" + yDown + " 0");
            
            // myWriter.write("center x y: " + xCenter + " " + yCenter);
            
            print(xCenter, yCenter);
            // System.out.println("Center" + xCenter + "a" + yCenter + " 0");
            String judge = in.next();
            if (judge.equals(CENTER)) {
                wasCenter = true;
            } else {
                return;
            }
        }

        in.close();


        //////////////////////////////
    //     myWriter.close();
    // } catch (IOException e) {
    //     System.out.println("An error occurred.");
    //     e.printStackTrace();
    // }
    ////////////////////////////
 
    }

    static int binSearchXLeft(int lo, int hi, int y, Scanner in) {
        while (lo < hi) {
            int mid = lo + (hi-lo)/2;
            print(mid, y);
            String judge = in.next();
            if (judge.equals(HIT)) {
                // wasHit = true;
                hi = mid;
            } else if (judge.equals(CENTER)) {
                wasCenter = true;
                return hi;
            } else if (judge.equals(WRONG)) {
                wasWrong = true;
                return hi;
            } else {
                lo = mid+1;
            }
            if (wasWrong) return hi;
        }

        return hi;
    }

    static int binSearchYUp(int lo, int hi, int x, Scanner in) {
        while (lo + 1 < hi) {
            int mid = lo + (hi-lo)/2;
            print(x, mid);
            String judge = in.next();
            if (judge.equals(HIT)) {
                // wasHit = true;
                lo = mid;
            } else if (judge.equals(CENTER)) {
                wasCenter = true;
                return hi;
            } else if (judge.equals(WRONG)) {
                wasWrong = true;
                return hi;
            } else {
                hi = mid-1;
            }
            if (wasWrong) return hi;
        }

        print(x, hi);
        String judge = in.next();
        if (judge.equals(HIT)) {
            // wasHit = true;
            return hi;
        } else if (judge.equals(CENTER)) {
            wasCenter = true;
            return hi;
        } else if (judge.equals(WRONG)) {
            wasWrong = true;
            return hi;
        } else {
            return lo;
        }
    }

    static int binSearchXRight(int lo, int hi, int y, Scanner in) {
        while (lo +1 < hi) {
            int mid = lo + (hi-lo)/2;
            print(mid, y);
            String judge = in.next();
            if (judge.equals(HIT)) {
                // wasHit = true;
                lo = mid;
            } else if (judge.equals(CENTER)) {
                wasCenter = true;
                return hi;
            } else if (judge.equals(WRONG)) {
                wasWrong = true;
                return hi;
            } else {
                hi = mid-1;
            }
            if (wasWrong) return hi;
        }

        print(hi, y);
        String judge = in.next();
        if (judge.equals(HIT)) {
            // wasHit = true;
            return hi;
        } else if (judge.equals(CENTER)) {
            wasCenter = true;
            return hi;
        } else if (judge.equals(WRONG)) {
            wasWrong = true;
            return hi;
        } else {
            return lo;
        }
    }

    static int binSearchYDown(int lo, int hi, int x, Scanner in) {
        while (lo < hi) {
            int mid = lo + (hi-lo)/2;
            print(x, mid);
            String judge = in.next();
            if (judge.equals(HIT)) {
                // wasHit = true;
                hi = mid;
            } else if (judge.equals(CENTER)) {
                wasCenter = true;
                return hi;
            } else if (judge.equals(WRONG)) {
                wasWrong = true;
                return hi;
            } else {
                lo = mid+1;
            }
            if (wasWrong) return hi;
        }

        return hi;
    }

    static void print(int x, int y) {
        System.out.println(x + " " + y);
        counter++;
        if (counter >= 298) {wasWrong = true;}
    }
}