package com.tpanda.util;

import java.io.File;

public class TEST {
    public static void main(String[] args) {
        new TEST().dir(new File("E:\\picture"));
        System.out.println((int)3.8);
    }

    public void dir(File fileDir){
        if (fileDir.isDirectory()){
            File[] files = fileDir.listFiles();
            for (File f:files){
                dir(f);
            }
        }else {
            if (fileDir.getName().equals("vssver2.scc")){
                fileDir.delete();
            }
        }
    }

    public class Person{
        private String name, son;
        public Person(String name, String son){
            this.name = name;
            this.son = son;
        }
    }


}
