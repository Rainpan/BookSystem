package com.tpanda.util;

import java.io.File;

class dir1{
    public int print(){
        return 1;
    }

    public void test(){
        System.out.println(print());
    }
}

class dir2 extends dir1{
    public int print(){
        return 2;
    }
}

class dous{

    int n =2;
    int m = set();


    private int set(){
        System.out.println(n);
        return n;
    }

    public static void main(String[] args) {
        dous d = new dous();
        System.out.println(d.m);
    }
}


public class TEST {
    public synchronized static void main(String[] args) {

        Thread t = new Thread(new Runnable() {
            public void run() {

            }
        });
        t.setPriority(10);
        t.start();

        System.out.println("hello");

        /*int i_start = Integer.MAX_VALUE;
        for (int i = i_start;i<i_start+10;i++){
            System.out.println(i);
        }



        int i = 2000000000;
        for (float f=i;f<i+10;i++){
            System.out.println(f);
        }
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MAX_VALUE+1);
        System.out.println(Integer.MIN_VALUE);
        float f = i+10;
        float f2 = i;
        System.out.println(f==f2);
        System.out.println(f);*/

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
