package com.mxm.ujsojcodesandbox.unsafe;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class ReadFileError implements Cloneable{
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    private String string;


    public static void main(String[] args) throws IOException {
        String userDir = System.getProperty("user.dir");
        String filePath = userDir + File.separator + "src/main/resources/application.yml";
        List<String> list = Files.readAllLines(Paths.get(filePath));
        System.out.println(String.join("\n", list));
    }

    static class a {
        public void add() {

        }
    }

    class b {
        public void add() {

        }
    }
}

