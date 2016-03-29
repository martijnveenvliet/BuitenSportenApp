package v3tomd.buitensportenapp.GridView;

/**
 * Created by Julien on 29-3-2016.
 */
public class ItemObject {
    private String MyName;
    private int  MyPhoto;



    private Class MyClass;


    public ItemObject(String name, int photo, Class theClass) {
        MyName = name;
        MyPhoto = photo;
        MyClass = theClass;
    }

    public String getName() {
        return MyName;
    }

    public void setName(String name) {
        this.MyName = name;
    }

    public int getPhoto() {
        return MyPhoto;
    }

    public void setPhoto(int photo) {
        this.MyPhoto = photo;
    }

    public Class getMyClass() {
        return MyClass;
    }

    public void setMyClass(Class myClass) {
        MyClass = myClass;
    }
}
