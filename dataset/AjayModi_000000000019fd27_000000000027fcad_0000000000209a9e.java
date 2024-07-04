
/**
 * Write a description of class Solution3 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.*;
public class Solution
{
    public static void main(String[] args)
    {
        Scanner ob=new Scanner(System.in);
        int t=ob.nextInt();
        int b=ob.nextInt();
        test:
        for(int it=1;it<=t;it++)
        {
            int arr1[],arr2[],arr3[],arr4[];
            arr1=arr2=arr3=arr4=new int[b];
            Arrays.fill(arr1,-1);
            Arrays.fill(arr2,-1);
            Arrays.fill(arr3,-1);
            Arrays.fill(arr4,-1);
            chances:
            for(int ch=1;ch<=150;ch+=5)
            {
                int temp[]=new int[5];
                for(int inp=0;inp<5;inp++)// taking 5 input
                {
                    //System.out.println("pehla 5 input se:"+(inp+1));
                    temp[inp]=ob.nextInt();
                }
                chearray:
                for(int chearr=1;chearr<=4;chearr++)//check all array
                {
                    if(chearr==1)
                    {
                        int ind=filled(arr1);
                        if(ind==0)
                        {
                           // System.out.println("Arr1 starting input");
                            for(int inp=0;inp<5;inp++)// taking 5 input
                            {
                                arr1[inp]=temp[inp];
                            }
                            for(int inp=5;inp<10;inp++)// taking 5 input
                            {
                               // System.out.println(inp+1);
                                arr1[inp]=ob.nextInt();
                            }
                            ch+=5;
                           // System.out.println("filled check");
                            if(filled(arr1)==b-1)
                            {
                                 for(int otp=0;otp<b;otp++)// printing output
                                 {
                                     System.out.print(arr1[otp]);
                                    }
                                    System.out.println();
                                 if(ob.next().equals("N"))
                                 {
                                        break test;
                                    }
                                    else
                                    break chances;
                            }
                            break chearray;
                        }
                        else if(ind==b-1)
                        {
                            for(int otp=0;otp<b;otp++)// printing output
                            {
                                System.out.print(arr1[otp]);
                            }
                            System.out.println();
                            if(ob.next().equals("N"))
                            {
                                break test;
                            }
                            else
                            break chances;
                        }
                        else
                        {
                            int m=match(arr1,temp);
                            if(m==1)
                            {
                               
                                int fillin=filled(arr1);
                                // System.out.println("Arr1 input from"+fillin);
                               for(int inp=fillin;inp<fillin+5;inp++)
                               {
                                   //System.out.println(inp+1);
                                   arr1[inp]=ob.nextInt();
                                }
                                ch+=5;
                                break chearray;
                            }
                        }
                    }
                    else if(chearr==2)
                    {
                        int ind=filled(arr2);
                        if(ind==0)
                        {
                            //System.out.println("Arr2 starting input");
                            for(int inp=0;inp<5;inp++)// taking 5 input
                            {
                                arr2[inp]=temp[inp];
                            }
                            for(int inp=5;inp<10;inp++)// taking 5 input
                            {
                               // System.out.println(inp+1);
                                arr2[inp]=ob.nextInt();
                            }
                            ch+=5;
                            if(filled(arr2)==b-1)
                            {
                            for(int otp=0;otp<b;otp++)// printing output
                            {
                                System.out.print(arr2[otp]);
                            }
                            System.out.println();
                            if(ob.next().equals("N"))
                            {
                                break test;
                            }
                            else
                            break chances;
                            }
                            break chearray;
                        }
                        else if(ind==b-1)
                        {
                            for(int otp=0;otp<b;otp++)// printing output
                            {
                                System.out.print(arr2[otp]);
                            }
                            System.out.println();
                            if(ob.next().equals("N"))
                            {
                                break test;
                            }
                            else
                            break chances;
                        }
                        else
                        {
                            int m=match(arr2,temp);
                            if(m==1)
                            {
                               
                                int fillin=filled(arr2);
                                // System.out.println("Arr2 input from"+fillin);
                               for(int inp=fillin;inp<fillin+5;inp++)
                               {
                                  // System.out.println(inp+1);
                                   arr2[inp]=ob.nextInt();
                                }
                                ch+=5;
                                break chearray;
                            }
                        }
                    }
                    else if(chearr==3)
                    {
                        int ind=filled(arr3);
                        if(ind==0)
                        {
                            //System.out.println("Arr3 starting input");
                            for(int inp=0;inp<5;inp++)// taking 5 input
                            {
                                arr3[inp]=temp[inp];
                            }
                            for(int inp=5;inp<10;inp++)// taking 5 input
                            {
                                //System.out.println(inp+1);
                                arr3[inp]=ob.nextInt();
                            }
                            ch+=5;
                            if(filled(arr3)==b-1)
                            {
                            for(int otp=0;otp<b;otp++)// printing output
                            {
                                System.out.print(arr3[otp]);
                            }
                            System.out.println();
                            if(ob.next().equals("N"))
                            {
                                break test;
                            }
                            else
                            break chances;
                            }
                            break chearray;
                        }
                        else if(ind==b-1)
                        {
                            for(int otp=0;otp<b;otp++)// printing output
                            {
                                System.out.print(arr3[otp]);
                            }
                            System.out.println();
                            if(ob.next().equals("N"))
                            {
                                break test;
                            }
                            else
                            break chances;
                        }
                        else
                        {
                            int m=match(arr3,temp);
                            if(m==1)
                            {
                               
                                int fillin=filled(arr3);
                                // System.out.println("Arr3 input from"+fillin);
                               for(int inp=fillin;inp<fillin+5;inp++)
                               {
                                   //System.out.println(inp+1);
                                   arr3[inp]=ob.nextInt();
                                }
                                ch+=5;
                                break chearray;
                            }
                        }
                    }
                    else if(chearr==4)
                    {
                        int ind=filled(arr4);
                        if(ind==0)
                        {
                            //System.out.println("Arr4 starting input");
                            for(int inp=0;inp<5;inp++)// taking 5 input
                            {
                                arr4[inp]=temp[inp];
                            }
                            for(int inp=5;inp<10;inp++)// taking 5 input
                            {
                                //System.out.println(inp+1);
                                arr4[inp]=ob.nextInt();
                            }
                            ch+=5;
                            if(filled(arr4)==b-1)
                            {
                            for(int otp=0;otp<b;otp++)// printing output
                            {
                                System.out.print(arr4[otp]);
                            }
                            System.out.println();
                            if(ob.next().equals("N"))
                            {
                                break test;
                            }
                            else
                            break chances;
                            }
                            break chearray;
                        }
                        else if(ind==b-1)
                        {
                            for(int otp=0;otp<b;otp++)// printing output
                            {
                                System.out.print(arr4[otp]);
                            }
                            System.out.println();
                            if(ob.next().equals("N"))
                            {
                                break test;
                            }
                            else
                            break chances;
                        }
                        else
                        {
                            int m=match(arr4,temp);
                            if(m==1)
                            {
                               
                                int fillin=filled(arr4);
                                 //System.out.println("Arr4 input from"+fillin);
                               for(int inp=fillin;inp<fillin+5;inp++)
                               {
                                   System.out.println(inp+1);
                                   arr4[inp]=ob.nextInt();
                                }
                                ch+=5;
                                break chearray;
                            }
                        }
                    }
                }
            }
        }
    }
    public static  int match(int arr[],int temp[])
    {
        for(int i=0;i<5;i++)
        {
            if(arr[i]!=temp[i])
            return 0;//not matched
        }
        return 1;//matched
    }
    public static int filled(int arr[])
    {
       /* for(int i=0;i<arr.length;i++)
        {
            System.out.print(arr[i]+" ");
        }*/
        System.out.println();
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]<0)
            {
                //System.out.println("filled:"+i);
                return i;
            }
        }
        //System.out.println("filled:"+(arr.length-1));
        return arr.length-1;
    }
}
