import com.sun.javafx.fxml.expression.Expression;

/**
 * Created by Yafael on 2/26/2017.
 */
public class Term {
    public int choice = 1;
    public Fac fac;
    public Term term;

    /*
     * Creates Parse Tree structure of <term> ::= <fac> | <fac> *<term>
     */
    public void parseTerm(){
        fac = new Fac();
        fac.parseFac();

        Tokenizer.nextToken();
        String tok = Tokenizer.currentToken();
        if(tok.equals("*")){
            choice = 2;
            Tokenizer.nextToken();
            term = new Term();
            term.parseTerm();
        }
    }

    public int getChoice(){
        return choice;
    }
    public Fac getFac(){
        return fac;
    }
    public Term getTerm(){
        return term;
    }
}
