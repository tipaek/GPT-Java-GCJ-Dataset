import java.util.*;
public class Solution {
    private static int N;
    public static String makeMatrix(int a, int b, int c, int d, int e)
    {
        int[] temp = new int[N*N];
        if(N==2)
        {
            temp[0] = a;
            temp[1] = b;
            temp[2] = b;
            temp[3] = a;
        }
        else if(N==3)
        {
            temp[0] = b;
            temp[1] = c;
            temp[2] = a;
            temp[3] = a;
            temp[4] = b;
            temp[5] = c;
            temp[6] = c;
            temp[7] = a;
            temp[8] = b;
        }
        else if(N==4)
        {
            temp[0] = c;
            temp[1] = b;
            temp[2] = a;
            temp[3] = d;
            temp[4] = a;
            temp[5] = c;
            temp[6] = d;
            temp[7] = b;
            temp[8] = b;
            temp[9] = d;
            temp[10] = c;
            temp[11] = a;
            temp[12] = d;
            temp[13] = a;
            temp[14] = b;
            temp[15] = c;
        }
        else if(N==5)
        {
            temp[0] = e;
            temp[1] = d;
            temp[2] = c;
            temp[3] = a;
            temp[4] = b;
            temp[5] = d;
            temp[6] = c;
            temp[7] = e;
            temp[8] = b;
            temp[9] = a;
            temp[10] = b;
            temp[11] = e;
            temp[12] = a;
            temp[13] = d;
            temp[14] = c;
            temp[15] = c;
            temp[16] = a;
            temp[17] = b;
            temp[18] = e;
            temp[19] = d;
            temp[20] = a;
            temp[21] = b;
            temp[22] = d;
            temp[23] = c;
            temp[24] = e;
        }
        return (Arrays.toString(temp)).replace(",", "").replace(" ", "").replace("[", "").replace("]", "");
    }

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        ArrayList<String>[] test = new ArrayList[T];
        int[][] answer = new int[T][2];
        //1 = possible
        //0 = impossible
        for(int i=0;i<T;i++)
        {
            test[i] = new ArrayList<>();
            N = scanner.nextInt();
            int K = scanner.nextInt();
            int[] possibilities = new int[N];
            for(int j=0;j<N;j++)
                possibilities[j] = j+1;
            boolean foundanswer = false;
            if(N==2)
            {
                for(int a=0;a<N;a++) {
                    int choiceA = possibilities[a];
                    for(int b=0;b<N;b++)
                    {
                        if(a==b)
                            continue;
                        int choiceB = possibilities[b];
                        if(choiceA + choiceA == K)
                        {
                            String ok = makeMatrix(choiceA, choiceB, 0, 0, 0);
                            test[i].add(ok);
                            foundanswer = true;
                            break;
                        }
                        else if(choiceB + choiceB == K) {
                            test[i].add(makeMatrix(choiceA, choiceB, 0, 0, 0));
                            foundanswer = true;
                            break;
                        }
                    }
                    if(foundanswer)
                        break;
                }
                if(!foundanswer)
                {
                    String ok = "0";
                    test[i].add(ok);
                }
            }
            else if(N==3)
            {
                for(int a=0;a<N;a++)
                {
                    int choiceA = possibilities[a];
                    for(int b=0;b<N;b++)
                    {
                        if(a==b)
                            continue;
                        int choiceB = possibilities[b];
                        for(int c=0;c<N;c++)
                        {
                            if(c==a||c==b)
                                continue;
                            int choiceC = possibilities[c];
                            if(choiceA + choiceB + choiceC == K)
                            {
                                test[i].add(makeMatrix(choiceA, choiceB, choiceC, 0, 0));
                                foundanswer = true;
                                break;
                            }
                            else if(choiceA + choiceA + choiceA == K)
                            {
                                test[i].add(makeMatrix(choiceA, choiceB, choiceC, 0, 0));
                                foundanswer = true;
                                break;
                            }
                        }
                        if(foundanswer)
                            break;
                    }
                    if(foundanswer)
                        break;
                }
                if(!foundanswer)
                    test[i].add("0");
            }
            else if(N==4)
            {
                for(int a=0;a<N;a++)
                {
                    int choiceA = possibilities[a];
                    for(int b=0;b<N;b++)
                    {
                        if(a==b)
                            continue;
                        int choiceB = possibilities[b];
                        for(int c=0;c<N;c++)
                        {
                            if(c==b||a==c)
                                continue;
                            int choiceC = possibilities[c];
                            for(int d=0;d<N;d++)
                            {
                                if(d==a||d==b||d==c)
                                    continue;
                                int choiceD = possibilities[d];
                                if(choiceB*4 == K)
                                {
                                    test[i].add(makeMatrix(choiceA, choiceB, choiceC, choiceD, 0));
                                    foundanswer = true;
                                    break;
                                }
                                else if(choiceC * 2 + choiceD * 2 == K)
                                {
                                    test[i].add(makeMatrix(choiceA, choiceB, choiceC, choiceD, 0));
                                    foundanswer = true;
                                    break;
                                }
                            }
                            if(foundanswer)
                                break;
                        }
                        if(foundanswer)
                            break;
                    }
                    if(foundanswer)
                        break;
                }
                if(!foundanswer)
                    test[i].add("0");
            }
            else if(N==5)
            {
                for(int a=0;a<N;a++)
                {
                    int choiceA = possibilities[a];
                    for(int b=0;b<N;b++)
                    {
                        if(a==b)
                            continue;
                        int choiceB = possibilities[b];
                        for(int c=0;c<N;c++)
                        {
                            if(c==a||c==b)
                                continue;
                            int choiceC = possibilities[c];
                            for(int d=0;d<N;d++)
                            {
                                if(d==a||d==b||d==c)
                                    continue;
                                int choiceD = possibilities[d];
                                for(int e=0;e<N;e++)
                                {
                                    if(e==a||e==d||e==b||e==c)
                                        continue;
                                    int choiceE = possibilities[e];
                                    if(choiceA*2 + choiceC*2 + choiceE == K)
                                    {
                                        test[i].add(makeMatrix(choiceA, choiceB, choiceC, choiceD, choiceE));
                                        foundanswer = true;
                                        break;
                                    }
                                    else if(choiceC + choiceE + choiceA + 2*choiceB == K)
                                    {
                                        test[i].add(makeMatrix(choiceA, choiceB, choiceC, choiceD, choiceE));
                                        foundanswer = true;
                                        break;
                                    }
                                }
                                if(foundanswer)
                                    break;
                            }
                            if(foundanswer)
                                break;
                        }
                        if(foundanswer)
                            break;
                    }
                    if(foundanswer)
                        break;
                }
                if(!foundanswer)
                    test[i].add("0");
            }
            else
                System.exit(0);
        }
        for(int i=0;i<T;i++)
        {
            //System.out.println(test[i].get(0));
            if(test[i].get(0).equals("0"))
                System.out.println("Case #" + (i+1) + ": " + "IMPOSSIBLE");
            else
            {
                System.out.println("Case #" + (i+1) + ": " + "POSSIBLE");
                if(test[i].get(0).length() == 4)
                {
                    for(int j=0;j<4;j+=2)
                        System.out.println(test[i].get(0).substring(j,j+1) + " " + test[i].get(0).substring(j+1,j+2));
                }
                else if(test[i].get(0).length() == 9)
                {
                    for(int j=0;j<9;j+=3)
                        System.out.println(test[i].get(0).substring(j,j+1) + " " + test[i].get(0).substring(j+1,j+2) + " " + test[i].get(0).substring(j+2,j+3));
                }
                else if(test[i].get(0).length() == 16)
                {
                    for(int j=0;j<16;j+=4)
                        System.out.println(test[i].get(0).substring(j,j+1) + " " + test[i].get(0).substring(j+1,j+2) + " " + test[i].get(0).substring(j+2,j+3) + " " + test[i].get(0).substring(j+3,j+4));
                }
                else
                {
                    for(int j=0;j<25;j+=5)
                        System.out.println(test[i].get(0).substring(j,j+1) + " " + test[i].get(0).substring(j+1,j+2) + test[i].get(0).substring(j+2,j+3) + " " + test[i].get(0).substring(j+3,j+4) + test[i].get(0).substring(j+4,j+5));
                }
            }
        }
    }
}
