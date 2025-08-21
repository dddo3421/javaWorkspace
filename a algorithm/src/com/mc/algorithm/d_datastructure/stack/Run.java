package com.mc.algorithm.d_datastructure.stack;

public class Run {

    public static void main(String[] args) {
        System.out.println(isPair("{(멀)티[캠]퍼{스}}"));
        System.out.println(isPair("{(멀)티[캠]퍼{스}})))))"));
        System.out.println(isPair("((((((({(멀)티[캠]퍼{스}}"));

        System.out.println('(' + ')');
        System.out.println('{' + '}');
        System.out.println('[' + ']');
    }

    private static boolean isPair(String text) {

        _Stack<Character> stack = new _Stack<Character>();

        for (char ch : text.toCharArray()) {

            if ("({[".contains(String.valueOf(ch))) {  // 괄호 수정
                stack.push(ch);
                continue;
            }

            if (!")}]".contains(String.valueOf(ch))) continue;

            if (stack.isEmpty()) return false;

            char k = stack.pop();  // int → char로 수정
            if (ch + k != 81 && ch + k != 184 && ch + k != 248) return false;

        }

        return stack.isEmpty();
    }

}
