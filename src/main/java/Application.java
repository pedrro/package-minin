import java.io.File;
import java.io.FileNotFoundException;

import Business.Input;

public class Application {

    public static void main(String[] args) throws FileNotFoundException {
        File file1 = new File("src//test/resources//files//input1");
        File file2 = new File("src//test/resources//files//input2");
        File file3 = new File("src//test/resources//files//input3");

        Input input = new Input();
        input.readFile(file1);
    }
}
