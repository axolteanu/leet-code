class Solution {
    public int myAtoi(String s) {
        int nIndex = -1;
        int sign = 0;
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
                    if (Character.isDigit(c))
                        nIndex = i;
                    break;
                }
            }else if(sign != 0)
                break;
        }

        if(nIndex < 0)
            return 0;

        if(sign == 0)
            sign = 1;

        String numberStr = "";
        numberStr += s.charAt(nIndex);

        for(int i = nIndex + 1; i < s.length(); i++){
            if(Character.isDigit(s.charAt(i)))
                numberStr += s.charAt(i);
            else
                break;
        }

        return (int) (Double.parseDouble(numberStr) * sign);
    }
}
