/**
 * Created by Yafael on 2/26/2017.
 */
public class Exp {

    public int choice = 1;
    public Term term;
    public Exp exp;

    /*
     * Creates Parse Tree structure of exp>::= <term> | <term> + <exp> | <term> -<exp>
     */
    public void parseExp(){
        term = new Term();
        term.parseTerm();

        String tok = Tokenizer.currentToken();
        if(tok.equals("+")){
            choice = 2;
            Tokenizer.nextToken();
            exp = new Exp();
            exp.parseExp();
        }else if(tok.equals("-")){
            choice = 3;
            Tokenizer.nextToken();
            exp = new Exp();
            exp.parseExp();
        }
    }

    public int getChoice(){
        return choice;
    }
    public Term getTerm(){
        return term;
    }
    public Exp getExp(){
        return exp;
    }

}
