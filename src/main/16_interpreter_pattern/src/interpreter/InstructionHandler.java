package interpreter;

import java.util.Stack;

public class InstructionHandler {
    private String instruction;
    private AbstractNode node;

    public void handle(String instruction) {
        AbstractNode left = null, right = null;
        AbstractNode direction = null, action = null, distance = null;
        Stack stack = new Stack(); //声明一个栈对象用于存储抽象语法树
        String[] words = instruction.split(" "); //以空格分隔指令字符串
        for (int i = 0; i < words.length; i++) {
//本实例采用栈的方式来处理指令，如果遇到“and”，则将其后的三个单词作为三个终结符表达式连成一个left = (AbstractNode)stack.pop(); //弹出栈顶表达式作为左表达式

            if ("and".equals(words[i])) {
                String word1 = words[++i];
                direction = new DirectionNode(word1);
                String word2 = words[++i];
                action = new ActionNode(word2);
                String word3 = words[++i];
                distance = new DistanceNode(word3);
                right = new SentenceNode(direction, action, distance); //右表达式
                left = new AndNode(left, right);
                stack.push(left); //将新表达式压入栈中
            }
//如果是从头开始进行解释，则将前三个单词组成一个简单句子SentenceNode并将该句
            else {
                String word1 = words[i];
                direction = new DirectionNode(word1);
                String word2 = words[++i];
                action = new ActionNode(word2);
                String word3 = words[++i];
                distance = new DistanceNode(word3);
                left = new SentenceNode(direction, action, distance);
                stack.push(left); //将新表达式压入栈中
            }
        }
        this.node = (AbstractNode) stack.pop(); //将全部表达式从栈中弹出
    }

    public String output() {
        String result = node.interpret(); //解释表达式
        return result;
    }


    public static void main(String args[]) {
        String instruction = "up move 5 and down run 10 and left move 5";
        InstructionHandler handler = new InstructionHandler();
        handler.handle(instruction);
        String outString;
        outString = handler.output();
        System.out.println(outString);
    }
}
