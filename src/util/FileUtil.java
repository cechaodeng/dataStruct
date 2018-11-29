package util;

import com.sun.deploy.util.ArrayUtil;

import java.io.*;
import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created by kent on 18-1-30.
 */
public class FileUtil {
    public static String[] getFileWord2Array(String path) throws IOException {
        File file = new File(path);
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String[] words = new String[0];
        String line = null;
        while ((line = br.readLine()) != null) {
            //还有数据
            String[] lineWords = line.toLowerCase().replaceAll(" +", " ").replaceAll("[^0-9a-zA-Z ]", "").split(" ");
            words = Arrays.copyOf(words, words.length + lineWords.length);
            System.arraycopy(lineWords, 0, words, words.length - lineWords.length, lineWords.length);
        }
        return words;
    }

    public static void main(String[] args) throws IOException {
        String path = "/home/kent/IdeaProjects/sort/src/search/resource/bible.txt";
        String[] words = getFileWord2Array(path);
        System.out.println(1);
        /*String[] aa = {"11","22","33"};
        String[] bb = {"44","55","66"};
        aa = Arrays.copyOf(aa, aa.length + bb.length);
        System.arraycopy(bb, 0, aa, aa.length - bb.length, bb.length);
        System.out.println(aa);
        System.out.println(bb);*/
    }
}
