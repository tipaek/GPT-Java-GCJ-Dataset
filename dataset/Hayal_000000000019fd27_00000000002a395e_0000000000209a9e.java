
import java.awt.*;
import java.util.LinkedList;
import java.util.Scanner;

public class Solution {

    static byte [] reverse(byte[] a) {
        byte[] b = new byte[a.length];
        int j = a.length;
        for (byte value : a) {
            b[j - 1] = value;
            j = j - 1;
        }
        return b;
    }
    static byte [] complement(byte[] ans) {
        for (int k = 0; k < ans.length ; k++) {
            if(ans[k]==0)
                ans[k]=1;
            else
                ans[k]=0;
        }
        return ans;
    }

        public static void main(String[] args) {
            final int qmax = 150;
        Scanner scan = new Scanner(System.in);
        int tt = scan.nextInt();
        int b = scan.nextInt();
        byte[] ans = new byte[b];
        int q = 0;
        for (int t = 0; t < tt; t++) {
            boolean eflag = false;
            boolean dflag = false;
            boolean fin = false;
            LinkedList<Point> equal= new LinkedList<>();
            LinkedList<Point> diff= new LinkedList<>();
            Point fequal = null;
            Point fdiff = null;
            int i=0;
            while (i<b/2) {
                // i is not always four
                int start = i;
                for (; i < Math.min(start + 4, b / 2); i++) {
                    if (q + 1 != 1 && (q + 1) % 10 == 1)
                        break;
                    System.out.println(1 + i);
                    q++;
                    byte num1 = scan.nextByte();
                    ans[i] = num1;
                    System.out.flush();
                    System.out.println(b - i);
                    q++;
                    byte num2 = scan.nextByte();
                    ans[b - i - 1] = num2;
                    System.out.flush();
                    if (!fin) {
                        if (num1 == num2) {
                            equal.add(new Point(num1, i + 1));
                            eflag = true;
                        } else {
                            diff.add(new Point(num1, i + 1));
                            dflag = true;
                        }//revise
                        if (dflag && eflag) {
                            fin = true;
                            fequal = equal.getLast();
                            fdiff = diff.getLast();
                        }
                    }
                }
                System.out.flush();
                if ((q + 1) % 10 == 1 && fin) {
                    System.out.println(fequal.y);
                    q++;
                    byte eq = scan.nextByte();
                    System.out.flush();
                    System.out.println(fdiff.y);
                    q++;
                    byte dif = scan.nextByte();
                    if (eq != fequal.x && dif != fdiff.x) {
                        complement(ans);
                    } else if (eq != fequal.x) {
                        ans = reverse(complement(ans));
                    } else if (dif != fdiff.x) {
                        ans = reverse(ans);
                    }
                }
                else if(!fin&&(q+1)%10==1){
                    System.out.flush();
                    System.out.println(1);
                    q++;
                     scan.nextByte();
                }
            }
            //problem is values are changed (swapped )
            while(q<=qmax){//=150
                if((q+1)%10==1) {
                    if (!fin&&q==qmax) {
                        if(!dflag) {
                            System.out.flush();
                            System.out.println(equal.getLast().y);
                            q++;
                            if (scan.nextByte() != equal.getLast().x) {
                                while(!equal.isEmpty()) {
                                        int val = equal.pop().y;
                                    if (ans[val-1] == 0)
                                        ans[val-1] = 1;
                                    else
                                        ans[val-1] = 0;
                                }
                            }
                            }
                        else if(!eflag) {
                            System.out.flush();
                            System.out.println(diff.getLast().y);
                            q++;
                            if (scan.nextByte() != diff.getLast().x) {
                                while(!equal.isEmpty()) {
                                    int val = diff.pop().y;
                                    if (ans[val-1] == 0)
                                        ans[val-1] = 1;
                                    else
                                        ans[val-1] = 0;
                                }
                            }
                        }
                        }
                    else if(fin) {
                        System.out.flush();
                        System.out.println(fequal.y);
                        q++;
                        byte eq = scan.nextByte();
                        System.out.flush();
                        System.out.println(fdiff.y);
                        q++;
                        byte dif = scan.nextByte();
                        if (eq != fequal.x && dif != fdiff.x) {
                            complement(ans);
                        } else if (eq != fequal.x) {
                            ans = reverse(complement(ans));
                        } else if (dif != fdiff.x) {
                            ans = reverse(ans);
                        }
                    }
                }
                else {
                    System.out.flush();
                    System.out.println(1);
                    scan.nextByte();
                    q++;
                }
            }
            System.out.flush();
            System.out.print("Case #" + (t + 1) + ": ");
            for (byte an : ans) {
                System.out.print(an);
            }
            System.out.println();
        }
    }
}
