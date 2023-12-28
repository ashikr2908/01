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
        
        Ccwc testClass = new Ccwc();
        CommandLine cmd = new CommandLine(testClass);
        cmd.execute(args);
        Results result = cmd.getExecutionResult();
        
		assertEquals(342190, result.byteCountGetter());
        
    }
	
	
	@Test
    public void CountLineTest() throws URISyntaxException {
		URL resource = AppTest.class.getResource("resources/test.txt");
        File file = Paths.get(resource.toURI()).toFile();
        String path = file.getAbsolutePath();
        String[] args = { "-l", path };
        
        Ccwc testClass = new Ccwc();
        CommandLine cmd = new CommandLine(testClass);
        cmd.execute(args);
        Results result = cmd.getExecutionResult();
        
		assertEquals(7145, result.byteLineGetter());
        
    }
	
	
	
	@Test
    public void CountWordTest() throws URISyntaxException {
		URL resource = AppTest.class.getResource("resources/test.txt");
        File file = Paths.get(resource.toURI()).toFile();
        String path = file.getAbsolutePath();
        String[] args = { "-w", path };
        
        Ccwc testClass = new Ccwc();
        CommandLine cmd = new CommandLine(testClass);
        cmd.execute(args);
        Results result = cmd.getExecutionResult();
        
		assertEquals(58164, result.byteWordGetter());
        
    }
	
	@Test
    public void allTest() throws URISyntaxException {
		URL resource = AppTest.class.getResource("resources/test.txt");
        File file = Paths.get(resource.toURI()).toFile();
        String path = file.getAbsolutePath();
        String[] args = { path };
        
        Ccwc testClass = new Ccwc();
        CommandLine cmd = new CommandLine(testClass);
        cmd.execute(args);
        Results result = cmd.getExecutionResult();
        
        assertEquals(7145, result.byteLineGetter());
        assertEquals(58164, result.byteWordGetter());
		assertEquals(7145, result.byteLineGetter());
        
    }
}
