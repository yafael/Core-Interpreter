/*
 * Created by Yashvardhan Gusani on 2/2/2017.
 * Principles of Programming Languages
 * Professor Jeremy Morris
 * Monday-Wednesday-Friday 3:00pm : Spring 2017
 */

import java.io.*;
import java.util.*;

public class Tokenizer {

    public static String WHITESPACE = " \n\t\r";
    public static String COMPARISON = "=<>!";
    public static String UNITOPERATORS = ";!=+-*/[]()";
    public static List<String> TOKENS = new LinkedList<String>();
    public static List<String> LINES = new LinkedList<String>();
    public static String currentToken;
    public static Map<String, Integer> tokenNumbers = new HashMap<String, Integer>();
    public static int currentTokenNumber = 0;


    public static void initializeTokenizer(){
        tokenNumbers.put("program", 1);
        tokenNumbers.put("begin", 2);
        tokenNumbers.put("end", 3);
        tokenNumbers.put("int", 4);
        tokenNumbers.put("if", 5);
        tokenNumbers.put("then", 6);
        tokenNumbers.put("else", 7);
        tokenNumbers.put("while", 8);
        tokenNumbers.put("loop", 9);
        tokenNumbers.put("read", 10);
        tokenNumbers.put("write", 11);
        tokenNumbers.put("and", 12);
        tokenNumbers.put("or", 13);
        tokenNumbers.put(";", 14);
        tokenNumbers.put(",", 15);
        tokenNumbers.put("=", 16);
        tokenNumbers.put("!", 17);
        tokenNumbers.put("[", 18);
        tokenNumbers.put("]", 19);
        tokenNumbers.put("(", 20);
        tokenNumbers.put(")", 21);
        tokenNumbers.put("+", 22);
        tokenNumbers.put("-", 23);
        tokenNumbers.put("*", 24);
        tokenNumbers.put("!=", 25);
        tokenNumbers.put("==", 26);
        tokenNumbers.put(">=", 27);
        tokenNumbers.put("<=", 28);
        tokenNumbers.put(">", 29);
        tokenNumbers.put("<", 30);
        tokenNumbers.put("EOF", 33);
    }

    /*
     * This method is used to check the validity of an identifier
     * The conditions are length is between 1 and 8 (inclusive)
     * Starting with uppercase letter followed by zero or more uppercase letter
     * Then zero or more digits
     */
    public static boolean checkID(String str){
        boolean retVal = true;

        if(str.length() > 8 || str.length() < 1){
            retVal = false;
        }else{
            char firstCharacter = str.charAt(0);
            if(Character.isUpperCase(firstCharacter) == false){
                retVal = false;
            }else{
                boolean upper = true;
                for(int i = 1; i < str.length(); i++){
                    if(upper == false){
                        if(Character.isDigit(str.charAt(i)) == false){
                            return false;
                        }
                    }else if(Character.isUpperCase(str.charAt(i)) == false){
                        upper = false;
                        if(Character.isDigit(str.charAt(i)) == false){
                            return false;
                        }
                    }
                }
            }
        }
        return retVal;
    }

    /*
     * Returns the current token as a String
     */
    public static String currentToken(){
        return (TOKENS.get(currentTokenNumber));
    }

    /*
     * Precondition: currentTokenNumber is not the EOF token
     */
    public static void nextToken(){
        currentTokenNumber++;
    }

    /*
     * Method to input a file and then store it in a list with each entry being a single line
     * After that, breakLines() is called
     */
    public static void startTokenizing(String fileName){
        int i,j,k;
        try {
            String line;
            BufferedReader obj = new BufferedReader(new FileReader(fileName));

            while((line = obj.readLine()) != null) {
                LINES.add(line);
            }

            /*
             * Close Buffered Reader.
             */
            obj.close();
            breakLines();
        }
        catch(Exception ex) {
            System.out.println(ex);
        }

    }

    /*
     * Takes one line at a time and then splits it into String array using split()
     * Passed the array to tokenize()
     */
    public static void breakLines(){
        for(String line : LINES){
            String[] tempTokens;
            tempTokens = line.split("\\s+");
            tokenize(tempTokens);
        }
        TOKENS.add("EOF");
    }

    /*
     * This is where tokens are created and stored
     * 1. For each value of array, check for digit
     * 2. If not, then check for comparison operators like <=, >=, != or ==
     * 3. If not, then check for unit operators like =,+,-,*,/ etc.
     * 4. If not, then see whether the value is reserved word or is correct identifier
     *    If not then report an error
     */

    public static void tokenize(String[] input){
        int i,j;
        char start;
        for(String word : input){
            i = 0;
            while(i < word.length()){
                start = word.charAt(i);
                j = i + 1;

                /*
                 * Check for digits
                 */
                if(Character.isDigit(start)){
                    while((j < word.length()) && Character.isDigit(word.charAt(j))){
                        j++;
                    }
                    TOKENS.add(word.substring(i,j));
                }
                /*
                 * Check for comparison operators
                 */
                else if(COMPARISON.contains(String.valueOf(start))){
                    if(((i + 1) < word.length()) && word.charAt(j) == '='){
                        j++;
                    }
                    TOKENS.add(word.substring(i,j));
                }
                /*
                 * Check for Unit operators
                 */
                else if(UNITOPERATORS.contains(String.valueOf(start))){
                    TOKENS.add(word.substring(i,j));
                }
                /*
                 * Check for reserved keywords or identifiers
                 */
                else{
                    while((j < word.length()) && (!COMPARISON.contains(String.valueOf(word.charAt(j))))
                        &&(!UNITOPERATORS.contains(String.valueOf(word.charAt(j))))){
                        j++;
                    }
                    if(tokenNumbers.containsKey(word.substring(i,j))){
                        TOKENS.add(word.substring(i,j));
                    }else if(checkID(word.substring(i,j))){
                        TOKENS.add(word.substring(i,j));
                    }else if (!checkID(word.substring(i,j))){
                        System.out.println("Error in Tokenizing: " + word.substring(i,j));
                    }

                }
                i = j;
            }
        }
    }

    /*
     * Function to print tokens
     */
    public static void printTokens(){
        String temp;
        for (int i = 0; i < TOKENS.size(); i++){
            temp = TOKENS.get(i);
            if(tokenNumbers.containsKey(temp)){
                System.out.println(tokenNumbers.get(temp) + " : " + temp);
            }
            else if(checkID(temp)){
                System.out.println("32 : " + temp);
            }
            else{
                try{
                    int num = Integer.parseInt(temp);
                    if(num >= 0){
                        System.out.println("31 : " + num);
                    }else{
                        System.out.println("Error tokenizing : " + temp);
                    }
                }catch(Exception e){
                    System.out.println(e);
                }
            }
        }
    }

    public static void main(String args[])throws IOException{
        /*
         * Checks for correct number of input arguments
         */
        if(args.length != 1){
            System.out.println("Enter correct argument");
        }else{
            /*
             * Initialize values for symbols and reserved keywords
             */
            initializeTokenizer();
            /*
             * Tokenize the Core program
             */
            startTokenizing(args[0]);
        }
        printTokens();
    }
}