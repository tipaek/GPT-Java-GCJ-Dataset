import java.io.*;
import java.util.*;

class Solution{

    static long pow2[];

    public static boolean check(int num, ArrayList<Integer> list){

        // System.out.println(num);
        // for(int i=0;i<list.size();i++){
        //     System.out.print(list.get(i)+",");
        // }
        // System.out.println();
        
        if(num==0 && list.size()==1)return true;
        else if(num==0)return false;

        int res = 0;
        int m=1;
        for(int i=0;i<list.size();i++){
            int indx = list.get(i);
            int val = (int)pow2[indx];
            res = res + (m*val);
            m*=-1;
        }

        if(res==num)return true;
        else return false;

    }

    public static int[] getBin(long num){

        int a[] = new int[32];
        int k=0;
        while(num>0){
            a[k++]=(int)(num%2);
            num=num/2;
        }

        return a;

    }

    public static void main(String args[])throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        pow2 = new long[32];
        pow2[0]=1;
        for(int i=1;i<32;i++){
            pow2[i]=pow2[i-1]*2;
        }
        int t = Integer.parseInt(br.readLine());
        for(int test=1;test<=t;test++){
            String s[] = br.readLine().trim().split(" ");
            int x = Integer.parseInt(s[0]);
            int y = Integer.parseInt(s[1]);

            int xarr[] = getBin((int)Math.abs(x));
            int yarr[] = getBin((int)Math.abs(y));
            int flag=0;
            ArrayList<Integer> list1 = new ArrayList<Integer>();
            for(int i=31;i>=0;i--){
                if(xarr[i]==0 && flag==0)continue;
                else if(xarr[i]==0 && flag==1)list1.add(i);
                if(xarr[i]==1 && flag==0){list1.add(i+1);flag=1;}
            }

            boolean checkY = check((int)Math.abs(y), list1);

            int signX = x>0?1:-1;
            int signY = y>0?1:-1;
            char ans[] = new char[100];
            if(checkY){

                for(int i=0;i<=31;i++){
                    if(xarr[i]==1){
                        if(signX==1)
                            ans[i]='E';
                        else
                            ans[i]='W';
                    }
                }

                
                if(y!=0){
                    int m = 1;
                    for(int i=0;i<list1.size();i++){
                        int xx = list1.get(i);
                        int rSign = signY*m;
                        if(rSign==1)
                            ans[xx]='N';
                        else
                            ans[xx]='S';
                        m=(m*(-1));
                    }
                }

                String A = new String(ans);
                sb.append("Case #"+test+": "+A+"\n"); 
                continue;

            }


            flag=0;
            ArrayList<Integer> list2 = new ArrayList<Integer>();
            for(int i=31;i>=0;i--){
                if(yarr[i]==0 && flag==0)continue;
                else if(yarr[i]==0 && flag==1)list2.add(i);
                if(yarr[i]==1 && flag==0){list2.add(i+1);flag=1;}
            }
            boolean checkX = check((int)Math.abs(x), list2);

            if(checkX){

                for(int i=0;i<31;i++){
                    if(yarr[i]==1){
                        if(signY==1)
                            ans[i]='N';
                        else
                            ans[i]='S';
                    }
                }

                if(x!=0){
                    int m = 1;
                    for(int i=0;i<list2.size();i++){
                        int yy = list2.get(i);
                        int rSign = signX*m;
                        if(rSign==1)
                            ans[yy]='E';
                        else
                            ans[yy]='W';
                        m=(m*(-1));
                    }
                }

                String A = new String(ans);
                sb.append("Case #"+test+": "+A+"\n"); 
                continue;

            }

            String A = "IMPOSSIBLE";
            sb.append("Case #"+test+": "+A+"\n");
        }

        System.out.print(sb);
    }

}
