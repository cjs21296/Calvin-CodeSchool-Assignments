package edu.mccneb.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<String> test12 = new ArrayList<>();
        test12.add("hello");
        test12.add("SuperTest");

        String temp1,temp2;
        for(int size=0;size<test12.size();size++)
        {
            String s = test12.get(size);
            s = s.toUpperCase();
            for(int i=1;i<s.length();i++)
            {
                if(i%2==0)
                {
                    temp1=s.substring(0,i);
                    temp2=s.substring(i,s.length());
                    temp2=temp2.toUpperCase();
                    s=temp1+temp2;
                }
                else
                {
                    temp1=s.substring(0,i);
                    temp2=s.substring(i,s.length());
                    temp2=temp2.toLowerCase();
                    s=temp1+temp2;
                }
                test12.set(size,s);
            }
        }
        System.out.println("------------------");
        System.out.println(test12);
        System.out.println("------------------");
    }
    public static List<String> dostuff(List<String> test12, int i)
    {
        return test12.stream().filter(len->len.length()>i).collect(Collectors.toList());
    }
}
