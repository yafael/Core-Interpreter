/**
 * Created by Yafael on 2/26/2017.
 */
public class Comp_Op {

    public String operator;

    /*
     * Creates Parse Tree structure of <comp>::= ( <fac> <comp-op> <fac> )
     */
    public void parseCompOp(){
        operator = Tokenizer.currentToken();
        if(operator.equals("!=") || operator.equals("==") || operator.equals("<") || operator.equals(">") || operator.equals("<=") ||operator.equals(">=")){
            Tokenizer.nextToken();
        }else{
            System.out.println("Error parsing CompOp: " + operator);
            System.exit(2);
        }
    }

    public String getCompOp(){
        if(operator.equals("!=") || operator.equals("==") || operator.equals("<") || operator.equals(">") || operator.equals("<=") ||operator.equals(">=")){
            return operator;
        }else{
            System.out.println("Comparator operator not valid: Found - " + operator);
            System.exit(2);
            return "";
        }
    }
}
