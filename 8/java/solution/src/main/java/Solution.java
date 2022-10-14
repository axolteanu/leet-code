import org.apache.commons.lang3.time.StopWatch;

class Solution {
    public int myAtoi(String s) {
        int nIndex = -1;
        int sign = 0;
        int nSize = 0;
        int startIndex = 0;

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
                    if (c >= '0' && c <= '9') {
                        nSize++;
                        startIndex = i;
                        nIndex = i + 1;
                    }
                    break;
                }
            }else if(sign != 0)
                break;
        }

        if(nIndex < 0)
            return 0;

        if(sign == 0)
            sign = 1;

        for(int i = nIndex; i < s.length(); i++){
            char c = s.charAt(i);
            if(c >= '0' && c <= '9')
                nSize++;
            else
                break;
        }

        String numberStr = s.substring(startIndex, startIndex + nSize);

        return (int) (Double.parseDouble(numberStr) * sign);
    }
}
