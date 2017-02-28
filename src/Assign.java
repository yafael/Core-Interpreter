import com.sun.javafx.fxml.expression.Expression;

/**
 * Created by Yafael on 2/26/2017.
 */
public class Assign {

    public Id id;
    public Exp exp;

    /*
     * Creates Parse Tree structure of <assign> ::=<id> =<exp>;
     */
    public void parseAssign(){
        id = new Id();
        id.parseId();

        Tokenizer.nextToken();
        HelperFunctions.compareStrings("=");

        exp = new Exp();
        exp.parseExp();

        HelperFunctions.compareStrings(";");
    }

    public Exp getExp() {
        return exp;
    }
    public Id getId() {
        return id;
    }
}
