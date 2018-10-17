import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.io.Serializable;
import java.util.Locale;
import java.text.*;
import java.util.ResourceBundle;


public abstract class Pupil implements Serializable  {

    public enum Type{STUDENT, SCHOOLBOY};

    private String name;
    private Type type;
    private String date;
    transient public ResourceBundle bundle=ResourceBundle.getBundle("resource");

    Pupil() {};
    Pupil(String name, Type type, Locale locale) {
        this.type=type;
        this.name=name;
        this.date= DateFormat.getTimeInstance(DateFormat.MEDIUM, locale).format(new Date());
    }

    public String getName() {return this.name;}
    public Type getType() {return this.type;}
    public void setType(Type t1) {this.type=t1;}


    public void showInformation() throws UnsupportedEncodingException {
        System.out.print(new String (bundle.getString("Name").getBytes("ISO-8859-1"), "Windows-1251")+ " ");
        System.out.print(new String (bundle.getString(this.name).getBytes("ISO-8859-1"), "Windows-1251") +", ");
        System.out.print(new String (bundle.getString("time_of_creation").getBytes("ISO-8859-1"), "Windows-1251") + " ");
        System.out.print(this.date);
    }
   }
