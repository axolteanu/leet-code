class Solution {
  public String customSortString(String order, String s) {
    char[] output = new char[s.length()];
    short oIndex = -1;

    for(int i = 0; i < order.length(); i++){
      char c = order.charAt(i);
      while(true){
        int cIndex = s.indexOf(c);
        if(cIndex < 0)
          break;
        else{
          oIndex++;
          output[oIndex] = c;
          s = removeCharFromStringAtIndex(s, cIndex);
        }
      }
    }
    for(int i = 0; i < s.length(); i++){
      oIndex++;
      output[oIndex] = s.charAt(i);
    }

    return new String(output);
  }

  private String removeCharFromStringAtIndex(String s, int cIndex){
    if(s.length() == 0)
      return s;

    char[] cArr = new char[s.length() - 1];
    int cArrIndex = 0;
    for(int i = 0; i < s.length(); i++){
      if(i != cIndex){
        cArr[cArrIndex] = s.charAt(i);
        cArrIndex++;
      }
    }

    return new String(cArr);
  }
}