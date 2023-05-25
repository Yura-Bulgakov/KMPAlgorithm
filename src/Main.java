public class Main {
    public static void main(String[] args) {
        String s = "aeofghtprbulbuldstfiug";
        String pattern = "bulbul";
        int[] pi = prefix(pattern);
        System.out.println(findPattern(s,pattern,pi));
    }

    public static  int[] prefix(String s){
        int size = s.length();
        int[] pi = new int[size];
        pi[0] = 0;
        int j = 0;
        int i = 1;
        for (; i < size; i++)
        {
            if (s.charAt(i) == s.charAt(j)){
                pi[i] = j + 1;
                j++;
            }
            else if (j == 0){
                pi[i] = 0;
            }
            else {
                j = pi[j - 1];
            }
        }
        return pi;
    }

    public static boolean findPattern(String s, String pattern, int[] prefix){
        int sizeString = s.length();
        int sizePattern = pattern.length();
        boolean result = false;
        int k = 0;
        int l = 0;
        for (;k < sizeString; k++){
           if (l == sizePattern)
           {
               result = true;
               break;
           }
           if (s.charAt(k) == pattern.charAt(l)) l++;
           else if (l == 0) continue;
           else l = prefix[l - 1];
        }
        return result;
    }
}