import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.Locale;

public class Student extends Pupil implements Serializable {
    private boolean  hasGrants;

    Student(String name, boolean hasGrants, Locale locale)
    {
        super(name, Type.STUDENT,locale);
        this.hasGrants=hasGrants;
    }

    public boolean hasGrants(){return this.hasGrants;}

    public void showInformation() throws UnsupportedEncodingException {
        super.showInformation();
        System.out.print(new String (bundle.getString("student").getBytes("ISO-8859-1"), "Windows-1251"));
        if(this.hasGrants) System.out.print(new String (bundle.getString("with_grants").getBytes("ISO-8859-1"), "Windows-1251"));
        else System.out.print(new String (bundle.getString("without_grants").getBytes("ISO-8859-1"), "Windows-1251"));
    }
}
