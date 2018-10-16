import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.Locale;

public class SchoolBoy extends Pupil implements Serializable {

    private int averageMark;

    SchoolBoy(String name,int averageMark, Locale locale)
    {
        super(name, Type.SCHOOLBOY,locale);
        this.averageMark=averageMark;
    }

    private int getAverageMark(){return this.averageMark;}

    public void showInformation(Locale locale)throws UnsupportedEncodingException {
        super.showInformation(locale);
        System.out. println(", schoolboy with average Mark " + this.averageMark);
    }
}
