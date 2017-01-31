import java.util.Stack;


public class Bloomberg{
    
    static void findSum(int[] arr, int k){
	boolean[] b = new boolean[256];
	for(int i = 0 ; i < arr.length ; ++i){
	    if(b[k-arr[i]]){
		System.out.printf("%d %d\n", k-arr[i], arr[i]);
		b[k-arr[i]] = false;
	    }else{
		b[arr[i]] = true;
	    }
	}
    }

    static String convert(String input) throws Exception{
	String[] chars = input.split("\\s+");
	Stack<String> st = new Stack<>();
	for(String s : chars){
	    if(!is_symbol(s)) st.push(s);
	    else{
		if(st.size() < 2) throw new Exception("IllegalStateException");
		String s1 = st.pop();
		String s2 = st.pop();
		st.push("("+s2+s+s1+")");
	    }
	}
	if(st.size()!=1) throw new Exception("IllegalStateException");
	return st.pop();
    }

    static void balanced(String input){
	Stack<Character> st = new Stack<>();
	char fst = input.charAt(0);
	if(fst == ']' || fst == ')' || fst == '}'){
	    System.out.println("NOT BALANCED");
	    return;
	}
	st.push(fst);
	for(int i = 1 ; i < input.length(); ++i){
	    char a = input.charAt(i);
	    char b;
	    if(!st.isEmpty()) b = st.peek();
	    else{
		if(a == '{' || a == '[' || a == '('){
		    st.push(a);
		}
		continue;
	    }
	    if(isPair(b,a)){
		st.pop();
	    }else{
		if(a == '{' || a == '[' || a == '('){
		    st.push(a);
		}else{
		    System.out.println("NOT BALANCED");
		    return;
		}
	    }
	}
	if(st.isEmpty()) System.out.println("BALANCED");
	else System.out.println("NOT BALANCED");
    }
    
    static boolean isPair(char a, char b){
	if(a=='(' && b == ')') return true;
	else if(a=='[' && b == ']') return true;
	else if(a=='{' && b == '}') return true;
	return false;
    }


    static boolean is_symbol(String s){
	return s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/");
    }

    public static void main(String[] args){
	int[] test = {1,2,1,2,1};
	findSum(test,3);
	try{
	    System.out.println(convert("a b + c * d e + / "));	    
	}catch(Exception e){
	    e.printStackTrace();
	}
	String shouldWork = "(((()))){((()))}[[[[]]]]()";
	String shouldNotWork = "((((())){{{{}}}[[[]]]";
	balanced(shouldWork);
	balanced(shouldNotWork);

    }


}
