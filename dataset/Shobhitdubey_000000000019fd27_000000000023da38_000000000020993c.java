import java.util.*;


 class HelloWorldSwing {
     public static void main(String[] args) {
                  Scanner s =new Scanner(System.in);
                  int T=s.nextInt();
                for(int p=1;p<=T;p++)
                {
                    int n=s.nextInt();
                    int a[][]=new int[n][n];
                       boolean flag=true;
                    int rowcount=0,colcount=0,k=0;
                    
                    for(int i=0;i<n;i++)
                    {
                        ArrayList<Integer>m=new ArrayList<Integer>();                   
                        for(int j=0;j<n;j++)
                        {
                            a[i][j]=s.nextInt();    
                                if(m.contains(a[i][j])&&flag)
                                {
                                    rowcount++;
                                flag=false;
                                }              
                                else                  
                                m.add(a[i][j]);
                        }
                        flag=true;
                    }


                    for(int i=0;i<n;i++)
                    {
                        ArrayList<Integer>m=new ArrayList<Integer>();                   
                        for(int j=0;j<n;j++)
                        {
                            // a[j][i]=s.nextInt();    
                                if(m.contains(a[j][i])&&flag)
                                {
                                    colcount++;
                                flag=false;
                                }              
                                else                  
                                m.add(a[j][i]);
                            if(i==j)
                                k+=a[i][j];

                        }
                        // System.out.println(m.toString());
                        flag=true;
                    }
                                System.out.println("Case #"+p+": "+k+" "+(rowcount)+" "+(colcount)+"");


                }         
          }
}