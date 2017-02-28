import com.sun.javafx.fxml.expression.Expression;

/**
 * Created by Yafael on 2/26/2017.
 */
public class Cond {

    public int choice = 1;
    public Comp comp;
    public Cond cond1;
    public Cond cond2;

    /*
     * Creates Parse Tree structure of <cond>::=<comp> | !<cond> | [ <cond> and<cond> ]|[ <cond> or<cond> ]
     */
    public void parseCond(){
        String tok = Tokenizer.currentToken();
        if(tok.equals("(")){
            comp = new Comp();
            comp.parseComp();
        }else if(tok.equals("!")){
            choice = 2;
            Tokenizer.nextToken();
            cond1 = new Cond();
            cond1.parseCond();
        }else if(tok.equals("[")){
            Tokenizer.nextToken();
            cond1 = new Cond();
            cond1.parseCond();

            tok = Tokenizer.currentToken();
            if(tok.equals("and")){
                choice = 3;
                Tokenizer.nextToken();
            }else if(tok.equals("or")){
                choice = 4;
                Tokenizer.nextToken();
            }else{
                System.out.println("Comparison operator not found. Instead we found: " + tok);
            }
            cond2 = new Cond();
            cond2.parseCond();
            HelperFunctions.compareStrings("]");
        }
    }

    public int getChoice(){
        return choice;
    }
    public Comp getComp(){
        return comp;
    }
    public Cond getCond1(){
        return cond1;
    }
    public Cond getCond2(){
        return cond2;
    }
}
