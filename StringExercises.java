import java.util.HashMap;


public class StringExercises{

  public static boolean isPalindrome(String a){
    // new StringBuilder(a).reverse().toString() -> String = rev(a)
    return new StringBuilder(a).reverse().toString().equals(a);
  }

  // decide if two strings are anagrams

  // "aa" "ab"

  public static boolean areAnagrams(String s1, String s2){
    HashMap<Character, Integer> count = new HashMap<>();
    if(s1 == null || s2 == null) return false;
    if(s1.length() != s2.length()) return false;
    for(int i = 0; i < s1.length(); ++i){
      Character c = s1.charAt(i);
      Integer j = count.get(c);
      if(j==null) count.put(c,1);
      else count.put(c, j+1);
    }
    for(int i = 0 ; i < s2.length() ; ++i){
      Character c = s2.charAt(i);
      Integer j = count.get(c);
      if(j==null) return false;
      else if(j==1) count.remove(c);
      else count.put(c, j-1);
    }
    return count.isEmpty();
  }

}

/*
  NOTES

String is immutable

String a = "abc";
a = "def";
a = a + "abc";

!!! OBJECT CREATION IN JAVA IS VERY VERY EXPENSIVE !!!

String.compareTo = compares two Strings O(n) n - length of string
a = s1;
b = s2

a.compareTo(b) a > b = 1
               a == b = 0
               a < b = -1

String.contains ? O(n)
String.split = on whitespace a.split("\\s+"); String[]

String.toCharArray -> char[] O(n)

12 is Alex's number

String.format("%d is %s's number", 12, "Alex");

String.format("%s", compute(1),String.valueOf(true));



*/
