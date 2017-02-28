/**
 * Created by Yafael on 2/26/2017.
 */
public class Decl {
    Id_List id_list;

    /*
     * Creates Parse Tree structure of <decl>::= int<id-list>;
     */
    public void parseDecl(){
        HelperFunctions.compareStrings("int");

        id_list = new Id_List();
        id_list.parseIdList();

        HelperFunctions.compareStrings(";");

    }

    public Id_List getId_list(){
        return id_list;
    }
}
