package com.farid.ahadli.T5Stack;

public class Q150EvaluateReversePolishNotation {

    private static int [] evalRPN(String[] tokens,int index){
        String currentElement = tokens[index];
        if("+-*/".contains(currentElement)){
            int [] left = evalRPN(tokens, --index);
            int [] right  = evalRPN(tokens, --left[1]);
            int res;
            if(currentElement.equals("*")){
                res = right[0]*left[0];
            } else if (currentElement.equals("/")) {
                res = right[0]/left[0];
            } else if (currentElement.equals("+")){
                res = right[0]+left[0];
            } else {
                res = right[0]-left[0];
            }
            return new int[]{ res, right[1] };
        }else{
            return new int[]{Integer.parseInt(tokens[index]),index} ;
        }
    }

    public static int evalRPN(String[] tokens) {
        return evalRPN(tokens, tokens.length-1)[0];
    }

    public static void main(String[] args) {

        System.out.println( evalRPN(new String[]{"4","13","5","/","+"}));
    }
}
