package com.mxm.ujsojcodesandbox.unsafe;

public class ReadFile {
    public static void main(String[] args) throws CloneNotSupportedException {
        new ReadFileError.a();
        ReadFileError readFileError = new ReadFileError();
        ReadFileError readFileError1 = (ReadFileError) readFileError.clone();
        System.out.println(readFileError1 == readFileError);
    }

}
