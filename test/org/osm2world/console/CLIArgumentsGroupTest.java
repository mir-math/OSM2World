package org.osm2world.console;

import static org.junit.Assert.*;

import org.junit.Test;

import uk.co.flamingpenguin.jewel.cli.ArgumentValidationException;
import uk.co.flamingpenguin.jewel.cli.CliFactory;


public class CLIArgumentsGroupTest {
	
	@Test
	public void testIsCompatible() throws ArgumentValidationException {
		
		CLIArguments cliArgs1 = CliFactory.parseArguments(CLIArguments.class,
				"-i", "testFile.osm", "-o", "foobar.png");
		CLIArguments cliArgs2 = CliFactory.parseArguments(CLIArguments.class,
				"-i", "testFile.osm", "-o", "bazbar.pov");
		
		assertTrue(CLIArgumentsGroup.isCompatible(cliArgs1, cliArgs2));
		
		CLIArguments cliArgs3 = CliFactory.parseArguments(CLIArguments.class,
				"-i", "testFile2.osm", "-o", "foobar.png");

		assertFalse(CLIArgumentsGroup.isCompatible(cliArgs1, cliArgs3));
		
	}
	
}
