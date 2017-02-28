/**
 * Created by Yafael on 2/26/2017.
 */
public class Out {
    public Id_List id_list;

    /*
     * Creates parse tree for <out> ::= write<id-list>;
     */
    public void parseOut(){
        HelperFunctions.compareStrings("write");
        id_list = new Id_List();
        id_list.parseIdList();
        HelperFunctions.compareStrings(";");
    }

    public Id_List getId_list(){
        return id_list;
    }
}
