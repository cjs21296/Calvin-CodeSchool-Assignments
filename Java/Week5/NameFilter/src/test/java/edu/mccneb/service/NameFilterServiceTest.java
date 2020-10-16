//package edu.mccneb.service;
//
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//
//import java.util.List;
//import java.util.stream.Stream;
//
//public class NameFilterServiceTest {
//
//    private final List<String> names = List.of("Noah","Oliver","William","Elijah","James","Lucas","Mason","Ethan","Alexander","Henry","Benjamin","Jacob","Michael","Daniel","Logan","Jackson","Sebastian","Jack","Aiden","Owen","Samuel","Matthew","Joseph","Levi","Mateo","David","John","Wyatt","Carter","Julian","Luke","Grayson","Isaac","Jayden","Theodore","Gabriel","Anthony","Dylan","Leo","Lincoln","Jaxon","Asher","Christopher","Josiah","Andrew","Thomas","Joshua","Ezra","Hudson","Charles","Caleb","Isaiah","Ryan","Nathan","Adrian","Christian","Maverick","Colton","Elias","Aaron","Eli","Landon","Jonathan","Nolan","Hunter","Cameron","Connor","Santiago","Jeremiah","Ezekiel","Angel","Roman","Easton","Miles","Robert","Jameson","Nicholas","Greyson","Cooper","Ian","Carson","Axel","Jaxson","Dominic","Leonardo","Luca");
//    private List<String> ExpectedNames,ActualNames;
//    private NameFilterService test = new NameFilterService();
//    @Test
//    void NameFilterService_NamesaboveX()
//    {
//        ActualNames=test.NamesOverX(names,9);
//        ExpectedNames = this.names;
//        for(String s:ExpectedNames)
//            if(s.length()>9)
//                ExpectedNames.remove(s);
//        System.out.println(ExpectedNames);
//        Assertions.assertIterableEquals(ActualNames,ActualNames);
//    }
//}
