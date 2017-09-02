package megha.restful_api;

/**
 * Created by Megha Chauhan on 01-Sep-17.
 */

public class data {
    String title ,body;
    int uid,id;
    public data(String t,String b,int uid,int id)
    {
        this.title=t;
        this.body=b;
        this.id=id;
        this.uid=uid;
    }
    public String getTitle(){
        return title;
    }
    public String getBody(){
        return body;
    }
    public int getUid(){
        return uid;
    }
    public int getId(){
        return id;
    }
}
