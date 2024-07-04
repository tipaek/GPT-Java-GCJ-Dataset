import java.util.Scanner;

public class Solution {

    static int N;
    static String[] s;

    static String findName() {

        String[] f = new String[N];
        String[] l = new String[N];

        // finding first and last parts

        //f[0] = s[0].substring(0,s[0].indexOf('*'));
        //l[0] = s[0].substring(s[0].lastIndexOf('*')+1);

        //int flen = f[0].length();
        //int llen = l[0].length();

        int flenmax = 0;
        int llenmax = 0;

        String firstMax = "";
        String lastMax = "";

        for(int i=0; i<N; i++) {

            f[i] = s[i].substring(0,s[i].indexOf('*'));
            l[i] = s[i].substring(s[i].lastIndexOf('*')+1);
            //System.out.println("f:"+f[i]);
            //System.out.println("l:"+l[i]);

            //if(f[i].length() != flen || l[i].length() != llen)
            //    return "*";

            if(f[i].length() > flenmax) {
                flenmax = f[i].length();
                firstMax = f[i];
            }

            if(l[i].length() > llenmax) {
                llenmax = l[i].length();
                lastMax = l[i];
            }
        }

        //System.out.println("firstMax: " + firstMax);
        //System.out.println("lastMax: " + lastMax);




        for(int i=0; i<N; i++) {

            //System.out.println("i=" + i);

            for(int idx=0; idx<flenmax; idx++) {



                if(f[i].length() > idx) {

                    char fichar = f[i].charAt(idx);
                    char firstMaxChar = firstMax.charAt(idx);

                    //System.out.println(fichar);
                    //System.out.println(firstMaxChar);

                    if(fichar != firstMaxChar) {
                        return "*";
                    }

                    //System.out.println();
                }
                else
                    break;
            }
        }


        for(int i=0; i<N; i++) {

            //System.out.println("i=" + i);

            for(int idx=0; idx<llenmax; idx++) {

                if(l[i].length() > idx) {

                    char lichar = l[i].charAt(l[i].length()-idx-1);
                    char lastMaxChar = lastMax.charAt(llenmax-idx-1);

                    //System.out.println(lichar);
                    //System.out.println(lastMaxChar);

                    if(lichar != lastMaxChar) {

                        return "*";
                    }

                    //System.out.println();
                }
                else
                    break;
            }
        }


        StringBuilder sb = new StringBuilder();
        sb.append(firstMax);

        for (int i=0; i<N; i++) {

            int fidx = s[i].indexOf('*')+1;
            int lidx = s[i].lastIndexOf('*');

            if(lidx > fidx) {
                String tru = s[i].substring(fidx, lidx);
                //System.out.println("tru: " + tru);

                String[] strings = tru.split("\\*");

                for(String ss : strings) {
                    //System.out.println("ss:" + ss);
                    sb.append(ss);
                }
            }
        }



        sb.append(lastMax);


        return String.valueOf(sb);
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int T = Integer.parseInt(scanner.nextLine());

        for(int caseNo=1; caseNo<= T; caseNo++) {  // each case

            N = Integer.parseInt(scanner.nextLine());

            s = new String[N];

            for(int n=0; n<N; n++) {    // read patterns

                s[n] = scanner.nextLine();
                //System.out.println("s:"+s[n]);
            }

            String result = findName();

            System.out.println("Case #" + caseNo + ": " + result);
        }
    }
}
