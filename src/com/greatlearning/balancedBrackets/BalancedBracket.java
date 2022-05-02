package com.greatlearning.balancedBrackets;

import java.util.Scanner;
import java.util.Stack;

public class BalancedBracket {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the String of Bracket");

        String input = scanner.nextLine();
        BalancedBracket balancedBracket = new BalancedBracket();
        if (input == "")
            System.out.println("no bracket string entered");
        else {
            if (balancedBracket.CheckBalancedBrackets(input)) {
                System.out.println("The entered String has Balanced Brackets");
            } else  {
                System.out.println("The entered Strings do not contain Balanced Brackets");
            }
        }
        scanner.close();
    }

    public boolean CheckBalancedBrackets(String st) {

        //converting the bracket string to char array.
        char[] bracketString = st.toCharArray();
        Stack<Character> bracketStack = new Stack<>();
        for ( char x: bracketString) {
            if (x == '(' || x == '[' || x == '{'){
                bracketStack.push(x);
                continue;
            }

            // The stack cannot be empty.
            if (bracketStack.isEmpty())
                return false;

            char a;
            switch (x) {
                case ')':
                    a=bracketStack.pop();
                    if (a=='[' || a=='{')
                        return false;
                    break;

                case '}':
                    a=bracketStack.pop();
                    if (a=='[' || a=='(')
                        return false;
                    break;

                case ']':
                    a=bracketStack.pop();
                    if (a=='(' || a=='{')
                        return false;
                    break;
            }

        }

        //check if stack is empty.
        return (bracketStack.isEmpty());
    }
}
