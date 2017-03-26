package ru.iac.test.symbolcounter;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Artem Bulich on 26.03.2017.
 */
public class SymbolCounter {
    private static Map <Character, Integer> map = new HashMap <>();


    public static void main(String[] args) {

        String encoding = "UTF-8";
        File file = new File("MyText.txt");
        try {
            handleFile(file, encoding);
            for (Map.Entry entry : map.entrySet()) {
                System.out.println("Key: " + entry.getKey() + " Value: "
                        + entry.getValue());
            }
        }
        catch(IOException e) {
            System.out.println("error");
        }
    }

    private static void handleFile(File file, String encoding) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(file), encoding));
        handleCharacters(in);
    }

    private static void handleCharacters(Reader reader) throws IOException {
        int r;
        while ((r = reader.read()) != -1) {
            char ch = (char) r;
            if(map.containsKey(ch))
            {
                int i = map.get(ch);
                map.put(ch,i+1);
            }
            else{
                map.put(ch,1);
            }
        }
    }
}
