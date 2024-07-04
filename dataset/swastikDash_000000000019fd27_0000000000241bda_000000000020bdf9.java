import java.util.Scanner;

public class Solution{

    public static void main(String[] args){

        Scanner scanner=new Scanner(System.in);
        int cases = Integer.parseInt(scanner.nextLine());

        for (int test = 1; test <= cases; test++) {
            int N=Integer.parseInt(scanner.nextLine());
            int startTime[]=new int[N];
            int endTime[]=new int[N];
            int sequence[]=new int[N];
            for(int i=0;i<N;i++)
            {
                String a[]=scanner.nextLine().split("\\s");
                startTime[i]=Integer.parseInt(a[0]);
                endTime[i]=Integer.parseInt(a[1]);
                sequence[i]=i;
            }

            for (int i = 0; i < N; i++)
            {
                for (int j = i + 1; j < N; j++) {
                    if (startTime[i] > startTime[j])
                    {
                        int temp = startTime[i];
                        startTime[i] = startTime[j];
                        startTime[j] = temp;

                        temp=endTime[i];
                        endTime[i]=endTime[j];
                        endTime[j]=temp;

                        temp=sequence[i];
                        sequence[i]=sequence[j];
                        sequence[j]=temp;
                    }
                }
            }


            String order[]=new String[N];
            int J=0;
            int C=0;
            for(int i=0;i<N;i++)
            {
                if(i==1)
                {
                    if(startTime[i]>=endTime[C])
                    {
                        order[i]="C";
                        C=i;

                        continue;
                    }
                    else
                    {
                        order[i]="J";
                        J=i;
                    }

                }

               else if(i==0)
                {
                    order[i]="C";
                    C=i;
                    continue;
                }
                else
                {
                    if(startTime[i]>=endTime[C])
                    {
                        order[i]="C";
                        C=i;
                    }
                    else if(startTime[i]>=endTime[J])
                    {
                        order[i]="J";
                        J=i;
                    }
                    else
                    {
                        order[i]="-1";
                    }
                }
            }
            for (int i = 0; i < N; i++)
            {
                for (int j = i + 1; j < N; j++) {
                    if (sequence[i] > sequence[j])
                    {
                        int temp = sequence[i];
                        sequence[i] = sequence[j];
                        sequence[j] = temp;

                        String tem=order[i];
                        order[i]=order[j];
                        order[j]=tem;

                    }
                }
            }

            boolean flag=true;
            for(int i=0;i<N;i++)
            {
                if(order[i]=="-1")
                {
                    flag=false;
                }

            }
            String result="";
            if(flag)
            {
                for(int i=0;i<N;i++)
                {
                    result=result+order[i];

                }
            }
            if(flag)
            {
                System.out.println("Case #"+test+": "+result);
            }
            else
            {
                System.out.println("Case #"+test+": "+"IMPOSSIBLE");;
            }


        }
    }
}

    
