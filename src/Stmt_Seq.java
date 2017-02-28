/**
 * Created by Yafael on 2/26/2017.
 */
public class Stmt_Seq {
    /*
     * choice is for the option selected <stmt> | <stmt> <stmt-seq>
     * stmt is for <stmt>
     * stmt_seq is for <stmt-seq>
     */
    public int choice = 1;
    public Stmt stmt;
    public Stmt_Seq stmt_seq;

    /*
     * Creates Parse Tree structure of <stmt-seq>::= <stmt> | <stmt> <stmt-seq>
     */
    public void parseStmtSeq() {

        stmt = new Stmt();
        stmt.parseStmt();
        /*
         * Check for the second option
         */
        String tok = Tokenizer.currentToken();
        if(tok.equals("if") || tok.equals("while") || tok.equals("read") || tok.equals("write") || Tokenizer.checkID(tok)){
            choice = 2;
            stmt_seq = new Stmt_Seq();
            stmt_seq.parseStmtSeq();
        }
    }

    public int getChoice(){
        return choice;

    }
    public Stmt getStmt(){
        return stmt;
    }
    public Stmt_Seq getStmt_seq(){
        return stmt_seq;
    }
}
