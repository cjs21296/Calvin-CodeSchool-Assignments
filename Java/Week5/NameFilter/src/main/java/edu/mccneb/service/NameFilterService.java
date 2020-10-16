package edu.mccneb.service;

import jdk.dynalink.Operation;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class NameFilterService {
    public List<String> NamesOverX(List<String> names, int x)
    {
        return names.stream().filter(len->len.length()>x).collect(Collectors.toList());

    }

    public List<String> Namesstarting(List<String> names, char x)
    {
        int i = names.stream().map(String::length).min(Integer::compare).get();
        return names.stream().filter(name->name.length()==i).collect(Collectors.toList());
    }
    public List<String> testss(List<String> names, char x)
    {
        return names.stream().distinct().collect(Collectors.toList());
    }
    public List<String> strff(List<String> names, int start, int end)
    {
        return names.stream().filter(name-> {
        if(names.indexOf(name)>=start && names.indexOf(name)<=end)
            return true;
        return false;
    }).collect(Collectors.toList());

    }
}
