import java.util.*;
class Solution
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int T=sc.nextInt();
        boolean visited=false;
        for(int k=1;k<=T;k++)
        {
            int n=sc.nextInt();
            int arr[][]=new int[n][2];
            ArrayList<Integer> C=new ArrayList<Integer>();
            ArrayList<Integer> J=new ArrayList<Integer>();
            ArrayList<Character> ar=new ArrayList<Character>();
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<2;j++)
                {
                    arr[i][j]=sc.nextInt();
                }
            }
            C.add(0);
            ar.add('C');
            
            for(int i=1;i<n;i++)
            {
                int siz=C.size();
                int j;
                if(i==1){
                for(j=0;j<siz;j++)
                {
                   
                        if(arr[i][0]>arr[C.get(j)][0]&&arr[i][0]<arr[C.get(j)][1])
                        {
                        J.add(i);
                        ar.add('J');
                        break;
                        }
                        if(arr[i][1]>arr[C.get(j)][0]&&arr[i][1]<arr[C.get(j)][1])
                        {
                        J.add(i);
                        ar.add('J');
                        break;
                        }
                    
                }
                if(j==siz)
                {
                    C.add(C.size()+J.size());
                    ar.add('C');
                      
                }
            }
            else
            {
                for(j=0;j<C.size();j++)
                {
                   
                        if(arr[i][0]>arr[C.get(j)][0]&&arr[i][0]<arr[C.get(j)][1])
                        {
                            int z;
                        for(z=0;z<J.size();z++)
                        {
                             if(arr[i][0]>arr[J.get(z)][0]&&arr[i][0]<arr[J.get(z)][1])
                        {
                        //impossible
                         if(visited!=true){
                        System.out.println("Case #"+k+": IMPOSSIBLE");
                        visited=true;
                        }}
                        if(arr[i][1]>arr[J.get(z)][0]&&arr[i][1]<arr[J.get(z)][1])
                        {
                        //impossible
                        if(visited!=true){
                        System.out.println("Case #"+k+": IMPOSSIBLE");
                        visited=true;
                        //i=n;
                        }}
                            
                            
                            
                            
                        }
                        if(z==J.size())
                        {
                            J.add(C.size()+J.size());
                            ar.add('J');
                        }
                        }
                        if(arr[i][1]>arr[C.get(j)][0]&&arr[i][1]<arr[C.get(j)][1])
                        {
                        
                             int z;
                        for(z=0;z<J.size();z++)
                        {
                             if(arr[i][0]>arr[J.get(z)][0]&&arr[i][0]<arr[J.get(z)][1])
                        {
                        //impossible
                        if(visited!=true){
                        System.out.println("Case #"+k+": IMPOSSIBLE");
                        visited=true;
                        //i=n;
                    }
                        }
                        if(arr[i][1]>arr[J.get(z)][0]&&arr[i][1]<arr[J.get(z)][1])
                        {
                            if(visited!=true){
                        System.out.println("Case #"+k+": IMPOSSIBLE");
                        visited=true;
                        //i=n;
                        }}
                            
                            
                            
                            
                        }
                        if(z==J.size())
                        {
                            J.add(C.size()+J.size());
                            ar.add('J');
                        }
                            
                        }
                    
                }
                if(j==C.size()&&ar.size()<n)
                {
                    //System.out.println(C.size()+J.size());
                    C.add(C.size()+J.size());
                    ar.add('C');
                }
            }//else
            }
            String ne="";
            for(int i=0;i<ar.size();i++)
            ne=ne+ar.get(i);
            /**System.out.println(C);
            System.out.println(J);*/
            if(visited==false)
            System.out.println("Case #"+k+": "+ne);
        }//T
    }
}