/**
 * Created by Yafael on 2/26/2017.
 */
public class Fac {
    public int choice = 1;
    public int num;
    public Id id;
    public Exp exp;

    /*
     * Creates Parse Tree structure of <fac>::= <int> | <id> | ( <exp> )
     */
    public void parseFac(){
        String tok = Tokenizer.currentToken();
        if(tok.equals("(")){
            choice = 3;
            Tokenizer.nextToken();
            exp = new Exp();
            exp.parseExp();
            tok = Tokenizer.currentToken();
            if(!tok.equals(")")){
                System.out.println("Parsing Error: Expected - ) but found -  " + tok);
                System.exit(2);
            }
        }else if(Character.isDigit(tok.charAt(0))){
            choice = 1;
            num = Integer.parseInt(tok);
        }else if(Character.isUpperCase(tok.charAt(0))){
            choice = 2;
            id = new Id();
            id.parseId();
        }
    }

    public int getChoice(){
        return choice;
    }
    public Id getId(){
        return id;
    }
    public Exp getExp(){
        return exp;
    }
    public int getInt(){
        return num;
    }
}
