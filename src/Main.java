/**
 * Created by Yafael on 2/26/2017.
 */
import java.io.*;

public class Main {
    public static void main(String args[])throws IOException{
        /*
         * Create instance of the class
         */
        Tokenizer tok = new Tokenizer();

        /*
         * Checks for correct number of input arguments
         */
        if(args.length != 1){
            System.out.println("Enter correct argument");
        }else{
            /*
             * Initialize values for symbols and reserved keywords
             */
            tok.initializeTokenizer();
            /*
             * Tokenize the Core program
             */
            tok.startTokenizing(args[0]);
        }
        //tok.printTokens();

        Prog parseTree = Parser.generateParseTree();
        PrettyPrinter.print(parseTree);
    }
}
