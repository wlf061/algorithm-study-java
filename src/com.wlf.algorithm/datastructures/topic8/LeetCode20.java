package com.wlf.algorithm.datastructures.topic8;

import java.util.Stack;

/**
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 *
 * @author nancy.wang
 * @Time 2019/1/21
 */
public class LeetCode20 {
    public static  boolean isValid(String s) {
        if (null == s) {
            return false;
        }
        Stack<Character> cStack = new Stack<Character>();
        for(char c : s.toCharArray()){
            if(c == '{' || c == '(' || c == '['){
                cStack.add(c);
            } else{
                if( c == '}'){
                    if (!cStack.isEmpty() && cStack.peek()=='{'){
                        cStack.pop();
                    }else{
                        return false;
                    }
                } else if( c == ']'){
                    if (!cStack.isEmpty() && cStack.peek()=='['){
                        cStack.pop();
                    }else{
                        return false;
                    }
                }else if( c == ')'){
                    if (!cStack.isEmpty() && cStack.peek()=='('){
                        cStack.pop();
                    }else{
                        return false;
                    }
                }
            }
        }
        return cStack.isEmpty();
    }

    private static boolean matchChar(Character stackPeek, Character stringScan) {
        if ((stringScan.equals('}') && stackPeek.equals('{'))
                || (stringScan.equals(']') && stackPeek.equals('['))
                || (stringScan.equals(')') && stackPeek.equals('('))) {
            return true;
        }
        return false;
    }

    public static void main(String[] str){
        String test="(])";
        System.out.println(LeetCode20.isValid(test));
    }
}
