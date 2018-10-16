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

    public void showInformation(Locale locale) throws UnsupportedEncodingException {
        super.showInformation(locale);
        System.out. print(", student");
        if(this.hasGrants) System.out. println(" with grants");
        else System.out. println(" without grants");
    }
}
