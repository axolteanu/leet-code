class Solution {
  public int myAtoi(String s) {
    if (s.length() == 0 || s.length() > 200)
      return 0;

    short sign = 0;
    int startIndex = -1;
    int nDigits = 0;
    boolean hasTrailingZero = false;

    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if(c >= '0' && c <= '9') {
        if(c == '0' && sign == 0 && nDigits == 0)
          hasTrailingZero = true;
        if(nDigits > 0 || (nDigits == 0 && c != '0'))
          nDigits++;
        if(startIndex == -1 && nDigits > 0) {
          startIndex = i;
          if(sign == 0)
            sign = 1;
        }
      }
      else if((c == ' ' || c == '+' || c == '-') && sign == 0) {
        if (hasTrailingZero)
          break;
        if(c == '+')
          sign = 1;
        else if(c == '-')
          sign = -1;
      }else
        break;
    }

    if (startIndex < 0)
      return 0;

    String numberStr = s.substring(startIndex, startIndex + nDigits);
    int[] numLimitArr = new int[]{2, 1, 4, 7, 4, 8, 3, 6, 4, sign == 1 ? 7 : 8};
    boolean outOfBounds = false;

    if(numberStr.length() > numLimitArr.length)
      outOfBounds = true;
    else if(numberStr.length() == numLimitArr.length){
      for(int i = 0; i < numLimitArr.length; i++) {
        int n = numberStr.charAt(i) - '0';
        if(numLimitArr[i] > n)
          break;
        else if(numLimitArr[i] < n) {
          outOfBounds = true;
          break;
        }
      }
    }

    if(outOfBounds)
      return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
    else
      return Integer.parseInt(sign == 1 ? numberStr : '-' + numberStr);
  }
}
