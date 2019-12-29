package com.company;

import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.Stack;
import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

public class Main {
    /*
    Pseudo code:
    Assuming operators are single characters and binary, do:
    - Until the end of the expression if reached, evaluate each character and perform ane of the steps
    (a) through (f).
        (a) if it's an operand, push it to the Operand Stack.
        (b) if it's an operator and the Operator Stack is empty, push it to the Operator Stack.
        (c) if it's an operator and the Operator Stack is NOT empty, and the character's precedence
        is greater than the precedence of the Stack's top operator, then push the operator into the Stack.
        (d) if it's ' ( ' then push it to the Operator Stack.
        (e) if it's ' ) ', then, until ' ( ' is found, do the following:
            1) Pop Operand Stack once (value1)
            2) Pop Operator Stack once (operator)
            3) Pop Operand Stack again (value2)
            4) compute value1 operator value2
            5) push the value obtained in the operation to the Operand Stack.
            6) Pop Operator stack to ignore ' ( '
         When there are no more input characters, keep processing steps in (e) until the Operator Stack
         becomes empty. The value left in the Operand Stack is the final result.
         Test case:
         (5+3)*6
         =48
    */

    static Integer compute (Character operator, Integer operand1, Integer operand2){
        char charValue = operator.charValue();
        System.out.println("Char value: "+charValue);
        switch(charValue){
            case '+': {return operand1 + operand2;}
            case '-': {return operand1 - operand2;}
            case '*': {return operand1 * operand2;}
            case '/': {return operand1 / operand2;}
            case '%': {return operand1 % operand2;}
            default: {return 0;}
        }
    }


    public static void main(String[] args) {

        System.out.println("Enter expression: ");
        Scanner sc = new Scanner(System.in);
        String expression = sc.nextLine();
        System.out.println(expression);

        Stack<Character> operators = new Stack<>();
        Stack<Integer> operands = new Stack<>();

        Map<Character,Integer> operatorPrecedence = new HashMap<Character,Integer>();
        operatorPrecedence.put('*',2);
        operatorPrecedence.put('/',2);
        operatorPrecedence.put('%',2);
   //     operatorPrecedence.put('(',2);
   //    operatorPrecedence.put(')',2);
        operatorPrecedence.put('+',1);
        operatorPrecedence.put('-',1);

        for(int i = 0; i < expression.length(); i++){
            try{
                int operand = Integer.parseInt(new String(new char[]{expression.charAt(i)}));
                System.out.println("Operand: "+operand);
                operands.push(operand);
            }
            catch(Exception e){
                char operator = expression.charAt(i);
                System.out.println("Operator: "+operator);
                if(operator == '(')
                    operators.push(operator);

                else if(operator == ')'){
                    while(!operators.peek().equals(Character.valueOf('('))) {
                        Integer result = compute(operators.pop(), operands.pop(), operands.pop());
                        System.out.println("Result: " + result);
                        operands.push(result);
                    }
                    System.out.println("Top operator before pop: "+operators.peek());
                    operators.pop();
                    System.out.println("Top operand: "+operands.peek());
                    try{
                        System.out.println("Top operator: "+operators.peek());
                    }
                    catch(Exception e2){}
                }
                else if(operators.isEmpty()){
                    operators.push(operator);
                }
                else{
                    try{
                        if(operatorPrecedence.get(operator) > operatorPrecedence.get(operators.peek())){
                            operators.push(operator);
                            Integer result2 = compute(operators.pop(), operands.pop(), operands.pop());
                            System.out.println("Result: " + result2);
                            operands.push(result2);
                        }
                        else{
                            continue;}
                    }
                    catch(NullPointerException npe){
                        operators.push(operator);
                        System.out.println("No more operators");
                    }
                }
                continue;
            }
        }


        while(!operators.isEmpty()){
            Integer result = compute(operators.pop(), operands.pop(), operands.pop());
            System.out.println("Result: " + result);
            operands.push(result);
        }
        System.out.println("Final result: "+operands.peek());
    }
}
