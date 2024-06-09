import java.util.Arrays;
import java.util.BitSet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        symbols();
        System.out.println("enter your well formed formula, leave spaces between symbols");
        String wff = sc.nextLine();
        String[] wffArr = wff.split(" ");
        System.out.println("enter the letters used, leave spaces between letters");
        String letters = sc.nextLine();
        String[] lettersArr = letters.split(" ");

        Boolean[] lettersValues= new Boolean[lettersArr.length];
        Arrays.fill(lettersValues, false);

        Integer values =150;
        BitSet lettersValuesBitSet = new BitSet(lettersArr.length);
        System.out.println(lettersValuesBitSet.toString()+lettersArr.length);
        lettersValuesBitSet.flip(1);
        System.out.println(lettersValuesBitSet.toString()+lettersArr.length);
        for (int i = 0; i < (int)Math.pow(lettersArr.length, 2); i++) {
            if(i==0){
                lettersValues[lettersValues.length-1] = true;
                continue;
            }
            for (int j = 0; j < lettersValues.length; j++) {
                if (lettersValues[lettersValues.length - j - 1]) {
                    lettersValues[lettersValues.length - j - 1]=false;

                }
            }
        }


    }
    public static void symbols() {
        System.out.println("! not");
        System.out.println("&& and");
        System.out.println("|| or");
        System.out.println("( ) parenthesis");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
    }
    public static boolean and(String[] left, String[] right, String[] lettersArr, Boolean[] lettersValues) {
        if(isALetter(left, lettersArr) && isALetter(right, lettersArr)) {
            return true;
        }
        return true;
    }
    public static boolean isALetter(String[] wffs, String[] lettersArr) {
        if(wffs.length == 1){
            for (String s : lettersArr) {
                if (s.equals(wffs[0])) {
                    return true;
                }
            }
        }
        return false;
    }
    public static boolean calculate(String[] wffs, String[] lettersArr, Boolean[] lettersValues) {
        for (int i = 0; i < wffs.length; i++) {
            if (wffs[i].equals("&&")) {
                String[] left= new String[i];
                left=wffs;
                String[] right = new String[wffs.length-i];
                right =wffs;
                return and(left, right, lettersArr, lettersValues);
            }
        }
        return false;
    }



    }