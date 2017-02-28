/**
 * Created by Yafael on 2/27/2017.
 */
public class HelperFunctions {

    public static boolean compareStrings(String str){
        String token = Tokenizer.currentToken();
        boolean check = token.equals(str);
        if(check && !token.equals("EOF")){
            //System.out.println("helper function: " + Tokenizer.currentToken());
            Tokenizer.nextToken();
            //System.out.println("New current token: " + Tokenizer.currentToken());
        }else if(check && token.equals("EOF")){
            return check;
        }else{
            System.out.println("Error parsing: " + token + " found instead of " + str);
            System.exit(1);
        }
        return check;
    }
}
