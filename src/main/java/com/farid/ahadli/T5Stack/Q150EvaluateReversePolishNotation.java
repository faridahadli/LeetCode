package com.farid.ahadli.T5Stack;

public class Q150EvaluateReversePolishNotation {

    private static int [] evalRPN(String[] tokens,int index){
        String currentElement = tokens[index];
        if("+-*/".contains(currentElement)){
            int [] right = evalRPN(tokens, index - 1);
            int [] left  = evalRPN(tokens, right[1] - 1);
            int res;
            if(currentElement.equals("*")){
                res = left[0]*right[0];
            } else if (currentElement.equals("/")) {
                res = left[0]/right[0];
            } else if (currentElement.equals("+")){
                res = left[0]+right[0];
            } else {
                res = left[0]-right[0];
            }
            return new int[]{ res, left[1] };
        }else{
            return new int[]{Integer.parseInt(tokens[index]),index} ;
        }
    }

    public static int evalRPN(String[] tokens) {
        return evalRPN(tokens, tokens.length-1)[0];
    }

    public static void main(String[] args) {

        System.out.println( evalRPN(new String[]{"10","6","9","3","+","-11","*","/","*","17","+","5","+"}));
    }

    /*
    public int evalRPN(String[] tokens) {
    Deque<Integer> stack = new ArrayDeque<>();
    for (String t : tokens) {
        switch (t) {
            case "+" -> { int b = stack.pop(), a = stack.pop(); stack.push(a + b); }
            case "-" -> { int b = stack.pop(), a = stack.pop(); stack.push(a - b); }
            case "*" -> { int b = stack.pop(), a = stack.pop(); stack.push(a * b); }
            case "/" -> { int b = stack.pop(), a = stack.pop(); stack.push(a / b); }
            default  -> stack.push(Integer.parseInt(t));
        }
    }
    return stack.pop();
}
     */
}
