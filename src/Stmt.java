/**
 * Created by Yafael on 2/26/2017.
 */
public class Stmt {

    /*
     * choice is for the option selected <assign> | <if> | <loop> | <in> | <out>
     */

    public int choice = 1;
    public Assign assign;
    public If iff;
    public Loop loopp;
    public In in;
    public Out out;

    /*
     * Creates Parse Tree structure of <stmt> ::= <assign> | <if> | <loop> | <in> | <out>
     */
    public void parseStmt(){
        String tok = Tokenizer.currentToken();
        if(Tokenizer.checkID(tok)){
            choice = 1;
            assign = new Assign();
            assign.parseAssign();
        }else if(tok.equals("if")){
            choice = 2;
            iff = new If();
            iff.parseIf();
        }else if(tok.equals("while")){
            choice = 3;
            loopp = new Loop();
            loopp.parseLoop();
        }else if(tok.equals("read")){
            choice = 4;
            in = new In();
            in.parseIn();
        }else if(tok.equals("write")){
            choice = 5;
            out = new Out();
            out.parseOut();
        }else{
            System.out.println("Error in parsing: " + tok);
            System.exit(2);
        }
    }

    public int getChoice(){
        return choice;
    }
    public Assign getAssign(){
        return assign;
    }
    public If getIf(){
        return iff;
    }
    public Loop getLoop(){
        return loopp;
    }
    public In getIn(){
        return in;
    }
    public Out getOut(){
        return out;
    }

}
