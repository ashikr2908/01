package com.codingchallenges.ccwc;


import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.nio.file.Paths;
import java.net.URISyntaxException;
import java.net.URL;

import org.junit.jupiter.api.Test;
import picocli.CommandLine;


public class AppTest 
{
	@Test
    public void CountCharsTest() throws URISyntaxException {
		URL resource = AppTest.class.getResource("resources/test.txt");
        File file = Paths.get(resource.toURI()).toFile();
        String path = file.getAbsolutePath();
        String[] args = { "-c", path };
        
        Ccwc classUnderTest = new Ccwc();
        CommandLine cmd = new CommandLine(classUnderTest);
        cmd.execute(args);
        
        //Results result = new Results();
		//assertEquals(0, result.byteCountGetter(), "line count is 0");
        //assertEquals(0, result.byteLineGetter(), "word count is 0");
        //assertEquals(341836, result.byteWordGetter(), "byte count is 341836");
    }
}
