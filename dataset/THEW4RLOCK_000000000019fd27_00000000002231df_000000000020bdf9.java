

    import java.util.Scanner;

    public class Solution {
        static String ppr(int ar[][], int n){
            int cs, ce, js=0, je=0, ns, ne;
            cs = ar[0][0];
            ce = ar[0][1];
            String str = "C";
            for(int i=1;i<n;i++){
                ns = ar[i][0];
                ne = ar[i][1];
                if((ns<ce && ns>=je )){

                    str=str.concat("J");
                    js=ns;
                    je=ne;
                }
                else if(ns >= ce){
                    str=str.concat("C");
                    cs=ns;
                    ce=ne;
                }
                else if(ns < je && ns>=ce){
                    str=str.concat("C");
                    cs=ns;
                    ce=ne;
                }
                else if(ns >= je){
                    str=str.concat("J");
                    js=ns;
                    je=ne;
                }
                else if(ns <cs && ne >ns){
                    str=str.concat("C");
                    cs=ns;
                    ce=ne;
                }
                else if(ns <js && ne >js){
                    str=str.concat("J");
                    js=ns;
                    je=ne;
                }
                else {
                    str = new String("IMPOSSIBLE");
                    break;
                }
            }
            return str;
        }

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            for(int q=0;q<t;q++){
                int n = sc.nextInt();
                int ar[][] = new int[n][2];
                for(int i=0;i<n;i++)
                    for(int j=0;j<2;j++)
                        ar[i][j]=sc.nextInt();
                System.out.println(ppr(ar, n));
            }
        }
    }
