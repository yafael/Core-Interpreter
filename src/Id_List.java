/**
 * Created by Yafael on 2/26/2017.
 */
public class Id_List {

    public int choice = 1;
    public Id id;
    public Id_List id_list;

    /*
     * Creates Parse Tree structure of <id-list> ::=<id> | <id>,<id-list>
     */
    public void parseIdList(){
        id = new Id();
        id.parseId();
        Tokenizer.nextToken();
        String tok = Tokenizer.currentToken();
        if(tok.equals(",")){
            choice = 2;
            Tokenizer.nextToken();
            id_list = new Id_List();
            id_list.parseIdList();
        }
    }

    public int getChoice(){
        return choice;
    }
    public Id getId(){
        return id;

    }
    public Id_List getId_list(){
        return id_list;
    }
}
