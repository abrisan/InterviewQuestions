import static java.lang.System.out;

public class Stack{

  private int size = 0;
  private Node top;

  private class Node{
    int data;
    Node next;
  }

  void push(int data){
      Node n = new Node();
      n.data = data;
      n.next = top;
      top = n;
      ++size;
  }

  int pop() throws Exception{
    if(top == null) throw new Exception("Trying to pop an empty stack");
    int ret = top.data;
    --size;
    top = top.next;
    return ret;
  }

  int peek() throws Exception{
    if(top == null) throw new Exception("Tring to peek an empty stack");
    return top.data;
  }

  public static void main(String[] args) throws Exception{
    Stack s = new Stack();
    s.push(1);
    out.println(s.peek());
    s.push(2);
    out.println(s.peek());
    int top = s.pop();
    out.println(s.peek());
    out.println(top);
  }

}
