import java.io.IOException;
import java.io.*;
import java.util.ArrayList;

public class Connector {

    private String filename;

    Connector(String filename) throws IOException {
        this.filename=filename;
    }



    public void write(Pupil[] obj)  throws IOException // трабл с файлами
    {
        FileOutputStream out = new FileOutputStream(filename);
        try (ObjectOutputStream oos = new ObjectOutputStream(out)) {

            oos.writeObject(obj);
            oos.flush();

        } catch (Exception ex) {

            System.out.println(ex.getMessage());
        }
    }


    public  Pupil [] read() throws IOException {
            FileInputStream in = new FileInputStream(filename);
            try (ObjectInputStream oin = new ObjectInputStream(in)) {
                Pupil[] res = new Pupil[5];
                res = (Pupil[]) oin.readObject();
                return res;
            }
            catch (Exception ex) {

                System.out.println(ex.getMessage());
            }
            return null;
    }
}



