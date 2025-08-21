package com.mc.algorithm.d_datastructure.stack;

public class StackQuiz {

	public static boolean isPair(String str) {
		_Stack<Character> stack = new _Stack<>();

		for (char c : str.toCharArray()) {
			if (c == '(' || c == '{' || c == '[') {
				stack.push(c);
			}

			else if (c == ')' || c == '}' || c == ']') {
				if (stack.isEmpty())
					return false;
				
			
				char top = stack.pop();
				if (!matches(top,c)) return false;
				
			}
		}
		return stack.isEmpty();
	}

	private static boolean matches(char o, char c) {
		return (o == '(' && c == ')') || (o == '{' && c == '}') || (o == '[' && c == ']');
	}

    public static void main(String[] args) {
        System.out.println(isPair("({[]})"));  
       
    }
	
}
