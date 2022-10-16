import org.apache.commons.lang3.time.StopWatch;

class Solution {
    public int myAtoi(String s) {
        int sign = 0;
        int startIndex = -1;
        int nSize = 0;

        if(s.length() == 0 || s.length() > 200)
            return 0;

        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c != ' ') {
                if (c == '-') {
                    if (sign == 0)
                        sign = -1;
                    else
                        break;
                }else if(c == '+') {
                    if (sign == 0)
                        sign = 1;
                    else
                        break;
                }else {
                    if (charIsDigit(c)) {
                        nSize++;
                        startIndex = i;
                    }
                    break;
                }
            }else if(sign != 0)
                break;
        }

        if(startIndex < 0)
            return 0;

        if(sign == 0)
            sign = 1;

        for(int i = startIndex + 1; i < s.length(); i++){
            char c = s.charAt(i);
            if(charIsDigit(c))
                nSize++;
            else
                break;
        }

        String numberStr = s.substring(startIndex, startIndex + nSize);

        return (int) (Double.parseDouble(numberStr) * sign);
    }

    private boolean charIsDigit(char c){
        return c >= '0' && c <= '9';
    }
}
