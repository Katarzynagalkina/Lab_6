import java.io.*;
import java.util.Scanner;
import java.util.Locale;
import java.util.ResourceBundle;

public class Test {

//   private static void print(Locale locale, String key) throws UnsupportedEncodingException
//    {
//        ResourceBundle bundleEng=ResourceBundle.getBundle("resource", locale);
//        System.out.println(new String (bundleEng.getString("key").getBytes("ISO-8859-1"), "Windows-1251"));
//    }


    public static void main(String[] args) throws IOException {

        System.out.println("Enter your region(RU, BY, GB)");
        Scanner in = new Scanner(System.in);
        String st = in.nextLine();
        Locale locale = Locale.getDefault();

        switch (st) {
            case "BY": {
                locale = new Locale("be", "BY");
                break;
            }
            case "RU": {
                locale = new Locale("ru", "RU");
                break;
            }
            case "GB": {
                locale = Locale.ENGLISH;
                break;
            }
            default: {
                System.out.println("Incorrect inpit");
                break;
            }
        }
        Locale.setDefault(locale);
        ResourceBundle bundle = ResourceBundle.getBundle("resource", locale);
        Pupil[] mas = new Pupil[5];
        mas[0] = new Student("Ivan", true, locale);
        mas[1] = new SchoolBoy("Denis", 10, locale);
        mas[2] = new SchoolBoy("Vladislav", 6, locale);
        mas[3] = new Student("Olga", false, locale);
        mas[4] = new SchoolBoy("Fedor", 7, locale);

        System.out.println(new String(bundle.getString("Students_list").getBytes("ISO-8859-1"), "Windows-1251"));
        for (Pupil i : mas) {
            if (i instanceof Student)
                System.out.print(new String(bundle.getString(i.getName()).getBytes("ISO-8859-1"), "Windows-1251") + " ");
        }

        System.out.println();
        System.out.println(new String(bundle.getString("Schoolboys_list").getBytes("ISO-8859-1"), "Windows-1251"));
        for (Pupil i : mas) {
            if (i instanceof SchoolBoy)
                System.out.print(new String(bundle.getString(i.getName()).getBytes("ISO-8859-1"), "Windows-1251") + " ");
        }
        System.out.println();

        System.out.println();
        System.out.println(new String(bundle.getString("Information_about_an_oblect").getBytes("ISO-8859-1"), "Windows-1251"));
        mas[0].showInformation();

        try {

            Connector con = new Connector("info.dat");
            Pupil[] savedMas = new Pupil[5];
            con.write(mas);
            savedMas = con.read();
            System.out.println();
            System.out.println(new String(bundle.getString("Massive_after_deserialization").getBytes("ISO-8859-1"), "Windows-1251"));
            for (Pupil i : savedMas)
                System.out.print(new String(bundle.getString(i.getName()).getBytes("ISO-8859-1"), "Windows-1251") + " ");
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}
