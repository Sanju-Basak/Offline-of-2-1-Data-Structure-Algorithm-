package Stack;

import java.util.Scanner;

public class Main {

    public int precedence(char ch)
    {
        if(ch== '(')
            return 0;
        if(ch== '+' || ch== '-')
            return 1;
        else
            return 2;
    }

    public double operation(double a1, double a2, char ch)
    {
        if(ch== '+')
            return a1+ a2;
        else if(ch== '-')
            return a1- a2;
        else if(ch== '*')
            return a1* a2;
        else
            return a1/a2;
    }


    public static void main(String[] args) {
        Stack_of_chars stack_of_chars= new Stack_of_chars();
        Stack_of_doubles stack_of_doubles= new Stack_of_doubles();
        Main main= new Main();
        Scanner scn= new Scanner(System.in);
        String str= scn.nextLine();
        int i= 0,c =1, valid= 1, open=0, close=0;
        double d1, d2;
        char ch;

        //validity check
        while (i< str.length())
        {
            if(str.charAt(i)== '(')
                open++;
            else if(str.charAt(i)== ')')
                close++;
            i++;
        }
        if(open !=close)
            valid= 0;
        i=0;
        if(valid==1)
        {
            while (i< str.length())
            {
                if((i==0 || i== str.length()-1) && (str.charAt(i)== '+' || str.charAt(i)== '-' || str.charAt(i)== '*' || str.charAt(i)== '/'))
                {
                    valid=0;
                    break;
                }
                else if(str.charAt(i)== '(' && str.charAt(i+1)== '-')
                {
                    i= i+2;
                    while ((str.charAt(i)>= '0' && str.charAt(i)<= '9') || str.charAt(i)== '.')
                        i++;
                    if(str.charAt(i) != ')')
                    {
                        valid= 0;
                        break;
                    }
                }
                else if((str.charAt(i)== '+' || str.charAt(i)== '-' || str.charAt(i)== '*' || str.charAt(i)== '/') && (str.charAt(i+1)== '+' || str.charAt(i+1)== '-' || str.charAt(i+1)== '*' || str.charAt(i+1)== '/'))
                {
                    valid =0;
                    break;
                }
                i++;
            }
        }
        i=0;

        //expression check
        if(valid== 1)
        {
            while(i < str.length())
            {
                if((str.charAt(i)>= '0' && str.charAt(i)<= '9'))
                {
                    StringBuffer str1= new StringBuffer();
                    str1.append(str.charAt(i));
                    i++;
                    while( i< str.length() && ((str.charAt(i)>= '0' && str.charAt(i)<= '9') || str.charAt(i)== '.') )
                    {
                        str1.append(str.charAt(i));
                        i++;
                    }
                    double ld= Double.parseDouble(String.valueOf(str1));
                    if(c==0)
                        ld= -ld;
                    stack_of_doubles.push(ld);
                }
                else if(str.charAt(i)== '(')
                {
                    if(str.charAt(i+1)== '-')
                    {
                        c=0;
                        i= i+2;
                    }
                    else
                    {
                        stack_of_chars.push('(');
                        i++;
                    }

                }
                else if(str.charAt(i)== ')')
                {
                    if(c==0)
                    {
                        c=1;
                        i++;
                        continue;
                    }
                    while (stack_of_chars.display()!= '(')
                    {
                        d2= stack_of_doubles.pop();
                        d1= stack_of_doubles.pop();
                        ch= stack_of_chars.pop();
                        d1= main.operation(d1, d2, ch);
                        stack_of_doubles.push(d1);
                    }
                    stack_of_chars.remove();
                    i++;
                }
                else
                {
                    if(!stack_of_chars.isEmpty())
                    {

                        if(main.precedence(stack_of_chars.display())> main.precedence(str.charAt(i)))
                        {
                            ch= stack_of_chars.pop();
                            d2= stack_of_doubles.pop();
                            d1= stack_of_doubles.pop();
                            d1= main.operation(d1, d2, ch);
                            stack_of_doubles.push(d1);
                        }
                        else if(stack_of_chars.display()== '/' && str.charAt(i)== '*')
                        {
                            ch= stack_of_chars.pop();
                            d2= stack_of_doubles.pop();
                            d1= stack_of_doubles.pop();
                            d1= main.operation(d1, d2, ch);
                            stack_of_doubles.push(d1);
                        }
                        stack_of_chars.push(str.charAt(i));

                    }
                    else
                        stack_of_chars.push(str.charAt(i));
                    i++;
                }


            }
            while (!stack_of_chars.isEmpty())
            {
                if(stack_of_chars.display()== '(')
                    stack_of_chars.remove();
                if(!stack_of_chars.isEmpty())
                {
                    ch= stack_of_chars.pop();
                    d2= stack_of_doubles.pop();
                    d1= stack_of_doubles.pop();
                    d1= main.operation(d1, d2, ch);
                    stack_of_doubles.push(d1);
                }
            }
        }

        if(valid==1)
            System.out.println("Valid expression, Computed value: " + stack_of_doubles.display());
        else
            System.out.println("Not valid");

    }
}
