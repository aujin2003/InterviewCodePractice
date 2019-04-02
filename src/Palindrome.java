public class Palindrome {
  public Palindrome(){
    System.out.println("A man, a plan, a canal: Panama. : " + isPalindrome("A man, a plan, a canal: Panama."));
    System.out.println("A man, a plan, a ccanal: Panama. : " + isPalindrome("A man, a plan, a ccanal: Panama."));
    System.out.println("A man, a plan, a cCcanal: Panama. : " + isPalindrome("A man, a plan, a cCcanal: Panama."));
    System.out.println("Aa man, a plan, a cCcanal: Panama. : " + isPalindrome("Aa man, a plan, a cCcanal: Panama."));
  }

  public boolean isPalindrome(String sentence){

    int left = 0;
    int right = sentence.length() - 1;
    boolean result = true;

    while(left <= right){

      char leftChar = sentence.charAt(left);
      char rightChar = sentence.charAt(right);

      boolean compare = true;

      if(!Character.isLetter(leftChar)){
        left++;
        compare = false;
      }

      if(!Character.isLetter(rightChar)){
        right--;
        compare = false;
      }

      if(compare){
        System.out.println("compare "+ leftChar + " : " + rightChar);
        if(Character.toLowerCase(leftChar) != Character.toLowerCase(rightChar))
          result = false;

        left++;
        right--;
      }
    }

    return result;
  }
}
