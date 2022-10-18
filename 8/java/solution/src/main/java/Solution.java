class Solution {
  public int myAtoi(String s) {
    short sign = 0;
    int startIndex = -1;
    int nDigits = 0;

    if (s.length() == 0 || s.length() > 200)
      return 0;

    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if(c >= '0' && c <= '9') {
        nDigits++;
        if(startIndex == -1) {
          startIndex = i;
          if(sign == 0)
            sign = 1;
        }
      }
      else if(c == ' ' && sign == 0)
        continue;
      else if(c == '+' && sign == 0)
        sign = 1;
      else if(c == '-' && sign == 0)
        sign = -1;
      else
        break;
    }

    if (startIndex < 0)
      return 0;

    String numberStr = s.substring(startIndex, startIndex + nDigits);
    numberStr = s.substring(startIndex, startIndex + nDigits);

    return (int) (Double.parseDouble(numberStr) * sign);
  }
}
