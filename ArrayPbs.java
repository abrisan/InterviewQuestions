// given an array of integers, find the first unique element
// ex : [1,1,1,2,3,2,2,4,5,3] -> 4

import static java.lang.System.out;

public class ArrayPbs{

  public static int findInt(int[] a){
    int c = 0;
    for(int i = 0 ; i < a.length; i++){
      for(int j = 0; j < a.length; j++){
        if(a[i]==a[j]){
          c++;
        }
      }
      if(c == 1){
        return a[i];
      }
      c = 0;
    }
    return -1;
  }


  public static int find(int[] a){
    int[] b = new int[256];
    for(int i = 0; i< a.length; i++){
      ++b[a[i]];
    }
    for(int j=0; j< a.length; j++){
      if(b[a[j]]==1){
        return a[j];
      }
    }
    return -1;
  }

  public static int firstUniqueInt(int[] arg){
    int[] freqs = new int[256];
    for(int i : arg) ++freqs[i];
    for(int i : arg) if(freqs[i] == 1) return i;
    return -1;
  }

  public static int getLongestContSubArray(int[] arg){
    int length = 1;
    int maxLength = 0;
    int[] arrayLengths = new int[arg.length];
    for(int i = 0; i < arg.length-1; i++){
      if(arg[i+1]==arg[i]+1){
        length++;
      }
      else{
      if(length > maxLength){
        maxLength = length;
      }
      length = 1;
    }
    }
    if(length > maxLength){
      maxLength = length;
    }
    return maxLength;


  }

  public static void main(String[] args){
    int[] input = {1,1,2,3,4,5};
    int[] example = {1,2,3,4,7,9,10,11,12,13,14,15,16};
    out.println(findInt(input));
    out.println(getLongestContSubArray(example));
  }

}
