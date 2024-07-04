import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;


public class Solution {
    public static void main(String[] args) {


        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));
        try {
            int t = Integer.parseInt(reader.readLine());
            for (int i = 1; i <= t; i++) {
                String s = reader.readLine();
                //ArrayList<String> arrayList=new ArrayList<String>();
                String s1 = "";
                int count = 0;
                for (int j = 0; j < s.length(); j++) {
                    int a = Integer.parseInt("" + s.charAt(j));

                    switch (a) {
                        case 0:
                            while (count>0){
                                s1+=")";
                                count--;
                            }
                            s1 += "0";
                            break;
                        case 1:
                            if (count < 1) {
                                s1 = s1 + "(";
                                // arrayList.add("(");
                                count++;
                                //s1 += 1;
                            } else if (count > 1) {
                                while (count > 1) {
                                    s1 += ")";
                                    count--;
                                }
                                //s1 += "1";
                            }
                                s1+="1";

                            // arrayList.add("1");
                            break;
                        case 2:
                            if (count < 2) {
                                while (count < 2) {
                                    s1 += "(";
                                    count++;
                                    // arrayList.add("(");
                                }
                                //s1 += "2";

                            } else if (count > 2) {
                                while (count > 2) {
                                    s1 += ")";
                                    count--;
                                }
                                //s1 += "2";
                            }
                            s1+="2";

                            break;
                        case 3:
                            if (count < 3) {
                                while (count < 3) {
                                    s1 += "(";
                                    // arrayList.add("(");
                                    count++;
                                }
                            } else if (count > 3) {
                                while (count > 3) {
                                    s1 += ")";
                                    count--;
                                }
                                //s1+="1";
                            }

                            s1 += 3;
                            // arrayList.add("3");
                            break;
                        case 4:
                            if (count < 4) {
                                while (count < 4) {
                                    s1 += "(";
                                    //    arrayList.add("(");
                                    count++;
                                }
                            } else if (count > 4) {
                                while (count > 4) {
                                    s1 += ")";
                                    count--;
                                }
                                //s1+="1";
                            }
                            s1 += 4;
                            //  arrayList.add("4");
                            break;
                        case 5:
                            if (count < 5) {
                                while (count < 5) {
                                    s1 += "(";
                                    //   arrayList.add("(");
                                    count++;
                                }
                            } else if (count > 5) {
                                while (count > 5) {
                                    s1 += ")";
                                    count--;
                                }
                                //s1+="1";
                            }
                            s1 += 5;
                            //  arrayList.add("5");
                            break;

                        case 6:
                            if (count < 6) {
                                while (count < 6) {
                                    s1 += "(";
                                    //   arrayList.add("(");
                                    count++;
                                }
                            } else if (count > 6) {
                                while (count > 6) {
                                    s1 += ")";
                                    count--;
                                }
                                //s1+="1";
                            }
                            s1 += 6;
                            // arrayList.add("6");
                            break;
                        case 7:
                            if (count < 7) {
                                while (count < 7) {
                                    s1 += "(";
                                    count++;
                                    //    arrayList.add("(");
                                }
                            } else if (count > 7) {
                                while (count > 7) {
                                    s1 += ")";
                                    count--;
                                }
                                //s1+="1";
                            }
                            s1 += 7;
                            //  arrayList.add("7");
                            break;
                        case 8:
                            if (count < 8) {
                                while (count < 8) {
                                    s1 += "(";
                                    count++;
                                    // arrayList.add("(");
                                }
                            } else if (count > 8) {
                                while (count > 8) {
                                    s1 += ")";
                                    count--;
                                }
                                //s1+="1";
                            }
                            s1 += 8;
                            //  arrayList.add("8");
                            break;
                        case 9:
                            if (count < 9) {
                                while (count < 9) {
                                    s1 += "(";
                                    count++;
                                    //   arrayList.add("(");
                                }
                            }
                            s1 += 9;
                            //  arrayList.add("9");
                            break;
                    }
                    if (j == s.length() - 1) {
                        while (count > 0) {
                            s1 += ")";
                            count--;
                        }
                    }
                }
                System.out.println(s1);

            }
        }catch (Exception e){

        }
    }
}