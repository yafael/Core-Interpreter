/**
 * Created by Yafael on 2/26/2017.
 */
public class Loop {

    public Cond cond;
    public Stmt_Seq stmt_seq;

    /*
     * Creates Parse Tree structure of <loop>::= while<cond> loop<stmt-seq> end;
     */
    public void parseLoop(){
        HelperFunctions.compareStrings("while");

        cond = new Cond();
        cond.parseCond();

        HelperFunctions.compareStrings("loop");

        stmt_seq = new Stmt_Seq();
        stmt_seq.parseStmtSeq();

        String tok = Tokenizer.currentToken();
        HelperFunctions.compareStrings("end");
        HelperFunctions.compareStrings(";");
    }

    public Cond getCond(){
        return cond;
    }
    public Stmt_Seq getStmt_seq(){
        return stmt_seq;
    }
}
