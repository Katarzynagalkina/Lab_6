import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.io.Serializable;
import java.util.Locale;
import java.text.*;
import java.util.ResourceBundle;


public class Pupil implements Serializable  {

    public enum Type{STUDENT, SCHOOLBOY};

    private String name;
    private Type type;
    private String date;

    Pupil() {};
    Pupil(String name, Type type, Locale locale) {
        this.type=type;
        this.name=name;
        this.date= DateFormat.getTimeInstance(DateFormat.MEDIUM, locale).format(new Date());
    }

    public String getName() {return this.name;}
    public Type getType() {return this.type;}
    public void setType(Type t1) {this.type=t1;}
    public void showInformation(Locale locale) throws UnsupportedEncodingException {

       // ResourceBundle bundle=ResourceBundle.getBundle("resource", locale);
        //System.out.println(new String (bundle.getString("Name").getBytes("ISO-8859-1"), "Windows-1251")+ " ");
      //  System.out.println(new String (bundle.getString(this.name).getBytes("ISO-8859-1"), "Windows-1251") +", ");
       // System.out.println(new String (bundle.getString("time_of_creation").getBytes("ISO-8859-1"), "Windows-1251") + " ");
      //  System.out.println(new String (bundle.getString(this.date).getBytes("ISO-8859-1"), "Windows-1251"));
        System.out.print("Name " + this.name + ", time of creation " + this.date);
    }
   }
