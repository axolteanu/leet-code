 // 8. String to Integer (atoi)
 // https://leetcode.com/problems/string-to-integer-atoi/

var myAtoi = function(s){
  if(s.length > 200)
    return 0;
  
  let n = 0;
  let sign = 1;
  let startIndex = -1;
  for(let i = 0; i < s.length ; i++){
    if(s[i] == ' ')
      continue
    else if(s[i] == '-'){
      sign = -1;
      startIndex = i + 1;
      break;
    }else if(s[i] == '+'){
      startIndex = i + 1;
      break;
    }else if(isDigit(s[i])){
      n = s[i]
      startIndex = i + 1;
      break;
    }else
      break;
  }

  if(startIndex < 0)
    return 0;
  
  for(i = startIndex; i < s.length && isDigit(s[i]); i++)
    n += s[i];
  n = n * sign;
  let negLimit = -1 * Math.pow(2,31);
  let posLimit = Math.pow(2,31) - 1;
  
  if(n < negLimit)
    n = negLimit;
  else if(n > posLimit)
    n = posLimit;
  
    return n;
};

var isDigit = function(s){
  return s >= '0' && s <= '9';
}