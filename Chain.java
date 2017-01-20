
public class Chain{

  public static int longest_chain(int[] arr){
    int maxLength = 0;
    int curLength = 0;
    for(int i = 1 ; i < arr.length ; ++i){
      if(arr[i] == arr[i-1]+1) ++curLength;
      else if(curLength > maxLength) { maxLength = curLength + 1; curLength = 1;}
      else curLength = 0;
    }
    if(curLength > maxLength) maxLength = curLength + 1;
    return maxLength;
  }

  public static void main(String[] args){
    int[] example = {1,2,3,4,7,9,10,11,12,13,14,15,16};
    int res = longest_chain(example);
    System.out.println(res);
  }

}
