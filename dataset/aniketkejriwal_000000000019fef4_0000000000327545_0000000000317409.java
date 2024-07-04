import java.util.*;

class Solution
{
    public static void main(String[] args)
    {
        Scanner in=new Scanner(System.in);
        int T= in.nextInt();
        in.nextLine();
        int i=0;
        while(i<T)
        {
            i++;
            int X=in.nextInt();
            int Y=in.nextInt();
            String M=in.nextLine();
            ArrayList<ArrayList<Integer>> L=new ArrayList<ArrayList<Integer>>();
            ArrayList<Integer> A=new ArrayList<Integer>();
            L.add(A);
            L.get(0).add(X);
            L.get(0).add(Y);
            for(int j=1;j<=M.length()-1;j++)
            {
                ArrayList<Integer> B=new ArrayList<Integer>();
                L.add(B);
                X=L.get(j-1).get(0);
                Y=L.get(j-1).get(1);
                if(M.charAt(j)=='N')
                {
                    L.get(j).add(X);
                    L.get(j).add(Y+1);
                }
                else if(M.charAt(j)=='S')
                {
                    L.get(j).add(X);
                    L.get(j).add(Y-1);
                }
                else if(M.charAt(j)=='E')
                {
                    L.get(j).add(X+1);
                    L.get(j).add(Y);
                }
                else
                {
                    L.get(j).add(X-1);
                    L.get(j).add(Y);
                }
            }
            int min=0;
            ArrayList<ArrayList<ArrayList<Integer>>> L1=new ArrayList<ArrayList<ArrayList<Integer>>>();
            ArrayList<ArrayList<Integer>> L2=new ArrayList<ArrayList<Integer>>();
            L1.add(L2);
            int j=0;
            int x=0;
            int y=0;
            L1.get(j).add(new ArrayList<Integer>());
            L1.get(j).get(L1.get(j).size()-1).add(x);
            L1.get(j).get(L1.get(j).size()-1).add(y);
            for(j=1;j<=M.length()-1;j++)
            {
                ArrayList<ArrayList<Integer>> L3=new ArrayList<ArrayList<Integer>>();
                L1.add(L3);
                for(int k=0;k<L1.get(j-1).size();k++)
                {
                        x=L1.get(j-1).get(k).get(0);
                        y=L1.get(j-1).get(k).get(1);
                        if(x==L.get(j).get(0) && y==L.get(j).get(1))
                        {
                            min=j;
                            j=M.length();
                            break;
                        }
                        L1.get(j).add(new ArrayList<Integer>());
                        L1.get(j).get(L1.get(j).size()-1).add(x);
                        L1.get(j).get(L1.get(j).size()-1).add(y);
                        if(x+1==L.get(j).get(0) && y==L.get(j).get(1))
                        {
                            min=j;
                            j=M.length();
                            break;
                        }
                        L1.get(j).add(new ArrayList<Integer>());
                        L1.get(j).get(L1.get(j).size()-1).add(x+1);
                        L1.get(j).get(L1.get(j).size()-1).add(y);
                        if(x-1==L.get(j).get(0) && y==L.get(j).get(1))
                        {
                            min=j;
                            j=M.length();
                            break;
                        }
                        L1.get(j).add(new ArrayList<Integer>());
                        L1.get(j).get(L1.get(j).size()-1).add(x-1);
                        L1.get(j).get(L1.get(j).size()-1).add(y);
                        if(x==L.get(j).get(0) && y-1==L.get(j).get(1))
                        {
                            min=j;
                            j=M.length();
                            break;
                        }
                        L1.get(j).add(new ArrayList<Integer>());
                        L1.get(j).get(L1.get(j).size()-1).add(x);
                        L1.get(j).get(L1.get(j).size()-1).add(y-1);
                        if(x==L.get(j).get(0) && y+1==L.get(j).get(1))
                        {
                            min=j;
                            j=M.length();
                            break;
                        }
                        L1.get(j).add(new ArrayList<Integer>());
                        L1.get(j).get(L1.get(j).size()-1).add(x);
                        L1.get(j).get(L1.get(j).size()-1).add(y+1);
                        
                }
                L1.get(L1.size()-2).clear();
            }
            if(min!=0)
                System.out.println("Case #"+i+": "+min);
            else
            {
                System.out.println("Case #"+i+": "+"IMPOSSIBLE");
            }
        }
    }
}
        
            