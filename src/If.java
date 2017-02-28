/**
 * Created by Yafael on 2/26/2017.
 */
public class If {

    public int choice = 1;
    public Cond cond;
    public Stmt_Seq stmt_seq1;
    public Stmt_Seq stmt_seq2;

    /*
     * Creates Parse Tree structure of <if> ::= if <cond> then <stmt-seq> end; |
     *                                          if <cond> then<stmt-seq> else<stmt-seq> end;
     */
    public void parseIf(){
        HelperFunctions.compareStrings("if");
        cond = new Cond();
        cond.parseCond();

        HelperFunctions.compareStrings("then");
        stmt_seq1 = new Stmt_Seq();
        stmt_seq1.parseStmtSeq();

        String tok = Tokenizer.currentToken();
        if(tok.equals("else")){
            choice = 2;
            Tokenizer.nextToken();
            stmt_seq2 = new Stmt_Seq();
            stmt_seq2.parseStmtSeq();
        }
        HelperFunctions.compareStrings("end");
        HelperFunctions.compareStrings(";");
    }

    public int getChoice(){
        return choice;
    }
    public Cond getCond(){
        return cond;
    }
    public Stmt_Seq getStmt_seq1(){
        return stmt_seq1;
    }
    public Stmt_Seq getStmt_seq2(){
        return stmt_seq2;
    }
}
