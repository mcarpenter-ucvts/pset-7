import java.nio.charset.StandardCharsets;

public class ProblemSet7 {
    public static void main(String[] args) {
    }

    /*
     * Exercise 1.
     */
    public String surroundMe(String in, String out) {
        if (in == null || out == null || out.length() != 4) {
            return in;
        }
        else {
            String firstHalf = out.substring(0,2);
            String secondHalf = out.substring(2,4);
            return firstHalf + in + secondHalf;
        }
    }

    /*
     * Exercise 2.
     */
    public String endsMeet(String text, int n) {

        if (text == null || (text.length() > 10 || text.length() < 1) || (n<1 || n>text.length())) {
            return text;
        }
        else {
            String firstHalf = text.substring(0,n);
            String secondHalf = text.substring(text.length()-n, text.length());
            String newString = firstHalf + secondHalf;
            return newString;
        }

    }

    /*
     * Exercise 3.
     */
    public String middleMan(String text) {

        if (text == null || text.length() % 2 != 1 || text.length() < 3) {
            return text;
        }
        else {
            String newString = text.substring((text.length()/2)-1, text.length()/2+2);
            return newString;
        }

    }

    /*
     * Exercise 4.
     */
    public boolean isCentered(String text, String target) {

        if (text == null || text.length() % 2 != 1 || text.length() < 3 || target == null || target.length() != 3) {
            return false;
        }
        else {
            String middleString = text.substring((text.length()/2)-1, text.length()/2+2);
            return middleString.equals(target);
        }

    }

    /*
     * Exercise 5.
     */
    public int countMe(String text, char suffix) {
        int count = -1;

        if ((int)suffix < 65 || ((int)suffix < 97 && (int)suffix > 90) || (int)suffix > 122 || text == null) {
            return -1;
        }
        else {
            count = 0;
            String lastLetters = " ";
            for (int k = 1; k < text.length(); k++) {
                if (text.charAt(k) == ' ') {
                    lastLetters += text.charAt(k - 1);
                }
            }
            lastLetters += text.charAt(text.length()-1);
            for (int m = 0; m < lastLetters.length(); m++ ) {
                if (lastLetters.charAt(m) == suffix) {
                    count += 1;
                }
            }
            return count;
        }
    }

    /*
     * Exercise 6.
     */
    public int triplets(String text) {
        int count = -1;

        if (text == null) {
            return -1;
        }
        else {
            count = 0;
            for (int k = 1; k < text.length()-1; k++) {
                if (text.charAt(k) == (text.charAt(k-1)) && text.charAt(k) == text.charAt(k+1)) {
                    count +=1;
                }
            }
            return count;
        }
    }

    /*
     * Exercise 7.
     */
    public long addMe(String text) {

        long sum = -1;
        if (text == null) {
            return -1;
        }
        else {
            sum = 0;
            for (int k = 0; k < text.length(); k ++) {
                if (Character.isDigit(text.charAt(k))) {
                    sum += Integer.parseInt(text.valueOf(text.charAt(k)));
                }
            }
            return sum;
        }

    }

    /*
     * Exercise 8.
     */
    public long sequence(String text) {

        long count = -1;
        long temp = 1;

        if (text == null) {
            return -1;
        }
        else if (text.isBlank()) {
            return 0;
        }
        else {
            count = 1;
            for (int k = 0; k < text.length()-1; k++) {
                if (text.charAt(k) == text.charAt(k+1)) {
                    temp +=1;
                }
                else {
                    temp = 1;
                }
                if (temp > count) {
                    count = temp;
                }
            }
            return count;
        }
    }

    /*
     * Exercise 9.
     */
    public String intertwine(String a, String b) {

        if (a == null || b == null) {
            return null;
        }
        String complete = "";

        if (a.length() > b.length()) {
            for (int k = 0; k < b.length(); k++) {
                complete += a.charAt(k);
                complete += b.charAt(k);
            }
            int leftover = a.length() - b.length();
            for (int m = a.length() - leftover; m < a.length(); m++ ) {
                complete += a.charAt(m);
            }
        }
        else if (a.length() == b.length()) {
            for (int k = 0; k < b.length(); k++) {
                complete += a.charAt(k);
                complete += b.charAt(k);
            }
        }
        else {

            for (int k = 0; k < a.length(); k++) {
                complete += a.charAt(k);
                complete += b.charAt(k);
            }
            int leftover = b.length() - a.length();
            for (int m = b.length() - leftover; m < b.length(); m++ ) {
                complete += b.charAt(m);
            }
        }
        return complete;
    }

    /*
     * Exercise 10.
     */
    public boolean isPalindrome(String text) {

        String firstHalf = "";
        String secondHalf = "";
        if (text == null) {
            return false;
        }
        else {
            if (text.length() % 2 == 0) {
                firstHalf = text.substring(0,text.length()/2);
            }
            else {
                firstHalf = text.substring(0,text.length()/2+1);
            }
            secondHalf = text.substring(text.length()/2, text.length());
            byte[] array = secondHalf.getBytes();
            byte[] reversed = new byte[array.length];
            for (int k = 0; k < reversed.length; k++) {
                reversed[k] = array[array.length - k -1];
            }
            String complete = new String(reversed, StandardCharsets.UTF_8);
            return firstHalf.equals(complete);
        }
    }
}
