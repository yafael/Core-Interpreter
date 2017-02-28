/**
 * Created by Yafael on 2/26/2017.
 */
public class Decl_Seq {
    /*
     * choice is for the option selected <decl> | <decl> <decl-seq>
     * decl is for <decl>
     * decl_seq is for <decl-seq>
     */
    public int choice = 1;
    public Decl decl;
    public Decl_Seq decl_seq;

    /*
     * Creates Parse Tree structure of <decl-seq>::= <decl> | <decl> <decl-seq>
     */
    public void parseDeclSeq() {
        decl = new Decl();
        decl.parseDecl();

        /*
         * If no begin token then we know it is the second option, so we then parse that
         */
        if (!Tokenizer.currentToken().equals("begin")) {
            choice = 2;
            decl_seq = new Decl_Seq();
            decl_seq.parseDeclSeq();
        }
    }

    public int getChoice(){
        return choice;
    }
    public Decl getDecl(){
        return decl;
    }
    public Decl_Seq getDecl_seq(){
        return decl_seq;
    }
}
