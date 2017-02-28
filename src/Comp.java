import com.sun.javafx.fxml.expression.Expression;

/**
 * Created by Yafael on 2/26/2017.
 */
public class Comp {

    public Fac fac1;
    public Comp_Op comp_op;
    public Fac fac2;

    /*
     * Creates Parse Tree structure of <comp>::= ( <fac> <comp-op> <fac> )
     */
    public void parseComp(){
        HelperFunctions.compareStrings("(");

        fac1 = new Fac();
        fac1.parseFac();

        Tokenizer.nextToken();
        comp_op = new Comp_Op();
        comp_op.parseCompOp();

        fac2 = new Fac();
        fac2.parseFac();

        Tokenizer.nextToken();
        HelperFunctions.compareStrings(")");
    }

    public Fac getFac1(){
        return fac1;
    }
    public Fac getFac2(){
        return fac2;
    }
    public Comp_Op getCompOp(){
        return comp_op;
    }
}
