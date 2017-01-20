// 1.) import static
// import static Strings.i;
import static java.lang.System.out;
import static java.lang.System.in;
// System.out.println() -> out.println();
// 2.) import
import java.util.ArrayList;
import java.util.HashMap;
// rule = never, ever use wildcard imports
// wildcard import :
import java.util.*;

public class Strings{

  // static method = does not depend on the state
  // of the object in which it is located

  static int i ;

  // constructor
  public Strings(int i){
    this.i = i;
  }

  // instance method
  public static void do_something(){
    System.out.println("Hello, World!");
  }

  // MAIN HEADER MUST ALWAYS BE THIS ONE, BY CONVENTION
  public static void main(String[] args){
    // IO
    Scanner stdin = new Scanner(in);
    // read an integer
    int n = stdin.nextInt();
    // some useful methods
    // stdin.next() -> String
    // stdin.nextLine() -> String
    // stdin.hasNext() -> Boolean
    stdin.close();
    do_something();
  }
}
