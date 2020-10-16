

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class PigLatin_Test {

    private  List<String> testList = List.of("Hello","SuperTest","Calvin","Rob","Building");
    private List<String> testResult,expectedResult;
    private  PigLatinDriver test = new PigLatinDriver();
    @Test
    void pigLatin_ReturnPigLating()
    {
        testResult = new ArrayList<>();
        testResult.add(test.getPigLatin(testList.get(0)));
        testResult.add(test.getPigLatin(testList.get(1)));
        testResult.add(test.getPigLatin(testList.get(2)));
        testResult.add(test.getPigLatin(testList.get(3)));
        testResult.add(test.getPigLatin(testList.get(4)));
        expectedResult = List.of("Elloay","UperTestay","Alvinay","Obay","Uildingay");
        Assertions.assertIterableEquals(expectedResult,testResult);
    }
}
