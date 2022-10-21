class Solution {
  public String customSortString(String order, String s) {
    char[] output = new char[s.length()];
    short oIndex = -1;

    for(int i = 0; i < order.length(); i++){
      char c = order.charAt(i);
      int cIndex = s.indexOf(c);
      while(cIndex >= 0){
        oIndex++;
        output[oIndex] = c;
        s = removeCharFromStringAtIndex(s, cIndex);
        cIndex = s.indexOf(c);
      }
    }

    for(int j = 0; j < s.length(); j++){
      oIndex++;
      output[oIndex] = s.charAt(j);
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