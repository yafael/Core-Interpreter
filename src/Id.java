/**
 * Created by Yafael on 2/26/2017.
 */
public class Id {
    public String id;

    /*
     * Creates proper ID
     */
    public void parseId(){
        id = Tokenizer.currentToken();
        //System.out.println("In ID: " + id);

    }

    public String getId(){
        return(id);
    }
}
