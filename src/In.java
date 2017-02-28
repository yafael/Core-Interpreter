/**
 * Created by Yafael on 2/26/2017.
 */
public class In {

    public Id_List id_list;

    /*
     * Creates parse tree for <in> ::= read<id-list>;
     */
    public void parseIn(){
        HelperFunctions.compareStrings("read");
        id_list = new Id_List();
        id_list.parseIdList();
        HelperFunctions.compareStrings(";");
    }

    public Id_List getId_list(){
        return id_list;
    }
}
