import java.util.Stack;

public class Main{
    public static String convert(char[] args) throws Exception{
      Stack<String> st = new Stack<>();
      for(char c : args){
        if(isSymbol(c)){
          st.push(String.valueOf(c));
        }else{
          String s1 = st.pop();
          String s2 = st.pop();
          st.push("(" + s2 + String.valueOf(c) + s1 + ")");
        }
      }
      if(st.size() != 1) throw new Exception("IllegalStateException");
      return st.pop();
    }
    public static boolean isSymbol(char a){
      return a != '+' && a != '-' && a != '*' && a != '/';
    }
    public static void main(String[] args){
      char[] arg = {'a','b','-','c','*','d','a','+','/'};
      try{
        System.out.println(convert(arg));
      }catch(Exception e){
        e.printStackTrace();
      }
    }
}
