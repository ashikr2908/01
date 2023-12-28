package com.codingchallenges.ccwc;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.concurrent.Callable;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

@Command(
		  name = "ccwc",mixinStandardHelpOptions = true,
		  description = "count number of lines, words, characters and so on"
		)
class Ccwc implements Callable<Results>
{
	@Option(names = {"-c"}, description = "calculates number of bytes")
    private boolean flagByteCount;
	
    @Option(names = {"-l"}, description = "-l for counting lines")
    private boolean flagLines;
    
    @Option(names = {"-w"}, description = "-l for counting words")
    private boolean flagWords; 
    
	
  @Parameters(index = "0", description = "The file to calculate for.")
  private File file;
  
	
	public void ccwcMethod(Ccwc ccwc, String args[])
	{
		CommandLine cmd = new CommandLine(ccwc);
		int exitCode = cmd.execute(args);
		System.exit(exitCode);
	}

	@Override
	public Results call() {
	
		Results result = new Results();
		StringBuilder resultStr = new StringBuilder();
		
		byte[] bytes = null;
		try {
			bytes = Files.readAllBytes(Path.of(file.toURI()));
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		if(flagByteCount == false && flagLines==false && flagWords == false)
		{
			flagByteCount = true;
		    flagLines = true;
			flagWords = true;
		}
		
		
		if(flagByteCount)
		{
			result.byteCountSetter(bytes.length);
			resultStr.append(" ").append(result.byteCountGetter());
		}
		
		
		if(flagLines)
		{
			String text = new String(bytes, StandardCharsets.UTF_8);
			String[] lines = text.split("\n");
			int lineCount = lines.length;
			result.byteLineSetter(lineCount);
			resultStr.append(" ").append(result.byteLineGetter());
		}
		
		
		if(flagWords)
		{
			String text = new String(bytes, StandardCharsets.UTF_8);
			String[] words = text.split("\\s+");
			int wordCount = words.length;
			result.byteWordSetter(wordCount);
			resultStr.append(" ").append(result.byteWordGetter());
		}
		
		resultStr.append(" ").append(file.getName());
		System.out.println(resultStr.toString());
		
		return result;
		
		
	}
}
