/**
 * Created by Yafael on 2/26/2017.
 */
public class Prog {
    public Decl_Seq decl_seq;
    public Stmt_Seq stmt_seq;

    /*
     * Creates Parse Tree structure of <prog>::= program <decl-seq> begin <stmt-seq> end
     */
    public void parseProg(){
        boolean check;
        check = HelperFunctions.compareStrings("program");

        /*
         * Generate dec-seq
         */
        decl_seq = new Decl_Seq();
        decl_seq.parseDeclSeq();

        check = HelperFunctions.compareStrings("begin");
        /*
         * Generate stmt-seq
         */
        stmt_seq = new Stmt_Seq();
        stmt_seq.parseStmtSeq();

        check = HelperFunctions.compareStrings("end");
        check = HelperFunctions.compareStrings("EOF");
        //System.out.println("End of parsing");
    }

    public Decl_Seq getDeclSeq() {
        return decl_seq;
    }
    public Stmt_Seq getStmtSeq() {
        return stmt_seq;
    }
}
