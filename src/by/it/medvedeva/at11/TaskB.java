package by.it.medvedeva.at11;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB {

    private static String dir(Class<?> cl) {
        String path = System.getProperty("user.dir") + File.separator + "src" + File.separator;
        String clDir = cl.getName().replace(cl.getSimpleName(), "").replace(".", File.separator);
        return path + clDir;

    }

    public static void main(String[] args) {
        int words = 0;
        int points = 0;
        try {
            File file = new File(dir(TaskB.class) + "text.txt");
            Scanner sc = new Scanner(file);
            Pattern word = Pattern.compile("[A-Za-zА-Яа-яЁё]+");
            Pattern point = Pattern.compile("[,.!?;:]");
            while(sc.hasNextLine()){
                String line = sc.nextLine();
                Matcher m = word.matcher(line);
                while (m.find()) {
                    words++;
                }
                m = point.matcher(line);
                while (m.find()) {
                    points++;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            String out1 = "words="+ String.valueOf(words)+", punctuation marks="+ String.valueOf(points);
            PrintWriter out2 = new PrintWriter(new FileWriter(dir(TaskB.class) + "resultTaskB.txt"));
            System.out.println(out1);
            out2.println(out1);
            out2.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

