import java.util.Scanner;
class Esab{
    static int COUNT=1;
    static Scanner sc=new Scanner(System.in);

    public static int print(int s){
        System.err.println("("+COUNT+") :"+s);
        COUNT+=1;
        System.out.println(s);
        System.out.flush();
        String a=sc.nextLine();
        System.err.println("Read : "+a);
        try{
            return Integer.parseInt(a);
        }
        catch(Exception e){
            System.err.println("Faulty input");
            return -500;
        }

        // return 0;
    }

    public static void print(int[] s){
        for(int ss : s)System.out.print(ss);
        System.out.println();
        System.out.flush();
        System.err.println("Finished printing ans");
        sc.nextLine();
    }

    
    public static void main(String[] args){
        
        int T=sc.nextInt();
        int B=sc.nextInt();
        sc.nextLine();
        for(int t=1;t<=T;t++){
            print(1);
            System.err.println("HI!"+T+" "+B);

            int[] ans=new int[B];
            int[] ansNew=new int[B];


            int l0,r0,l1,r1;

            int eq=-1,neq=-1,eqIdx=-1,neqIdx=-1;

            int left=-1;

            boolean cont=true;
            while(cont){

                left+=1;
                l1=print(left+1);
                r1=print(B - (4*left) );

                for(int i=1;i<4;i++){
                    if(!cont)break;
                    l0=l1;
                    r0=r1;

                    l1=print(left+1 + i);
                    r1=print(B - (4*left) - i );
                    
                    if( ((l0==r0)&(l1!=r1)) || ((l0!=r0)&(l1==r1))  ){
                        if(((l0==r0)&(l1!=r1))){
                            System.err.println("DEBUG: A");
                            eq=l0;
                            eqIdx=left+i-1;
                            neq=l1;
                            neqIdx=left+i;


                        }
                        else{
                            System.err.println("DEBUG: B");
                            neq=l0;
                            neqIdx=left+i-1;
                            eq=l1;
                            eqIdx=left+i;
                        }
                        cont=false;
                        for(int j=i+1;j<4;j++){
                            print(1);
                            print(1);
                        }
                    }
                }
                print(1);
                print(1);

            }

            System.err.println("eq " +eq);
            System.err.println("eqIdx " +eqIdx);
            System.err.println("neq " +neq);
            System.err.println("neqIdx " +neqIdx);


            int ii=0;


            while(ii<B){
            
                int eqNew=print(eqIdx+1);
                int neqNew=print(neqIdx+1);

                if(eqNew==eq & neqNew!=neq){
                    //swap
                    System.err.println("Swapped");
                    for(int i=0;i<B;i++){
                        ansNew[i]=ans[B-1-i];
                    }
                }
                else if(eqNew!=eq & neqNew!=neq){
                    //complement
                    System.err.println("Complement");
                    for(int i=0;i<B;i++){
                        ansNew[i]=1-ans[i];
                    }
                }
                else if(eqNew!=eq & neqNew==neq){
                    //swap+complement
                    System.err.println("Swap+Comp");
                    for(int i=0;i<B;i++){
                        ansNew[i]=1-ans[B-1-i];
                    }
                }
                else{
                    System.err.println("Nothing done");
                }
                ans=ansNew;
                // for(int i=0;i<B;i++)System.out.print(ans[i]);
                // System.out.println("");

                eq=eqNew;
                neq=neqNew;

                for(int i=0;i<7;i++){
                    System.err.println("Asking for "+(ii+1));
                    ans[ii]=print(ii+1);
                    ii++;
                    if(ii>=B)break;
                }

                System.err.println("Current ans");
                for(int i=0;i<B;i++)System.err.print(ans[i]);
                System.err.println("");


                if(ii==B){
                    print(ans);
                    return;
                }

                print(1);


            }



            // System.out.println("TESTCASE OVER");
            COUNT=1;

        }
    }

}