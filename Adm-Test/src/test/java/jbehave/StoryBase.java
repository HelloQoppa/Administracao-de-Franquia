package jbehave;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.Keywords;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.i18n.LocalizedKeywords;
import org.jbehave.core.io.CodeLocations;
import org.jbehave.core.io.StoryFinder;
import org.jbehave.core.junit.JUnitStory;
import org.jbehave.core.parsers.RegexStoryParser;
import org.jbehave.core.reporters.Format;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.InstanceStepsFactory;

public abstract class StoryBase extends JUnitStory {

	/*
	 * public Configuration configuration() {
	 * 
	 * Keywords keywords = new LocalizedKeywords(new Locale("pt"));
	 * 
	 * return new MostUsefulConfiguration().useKeywords(keywords).useStoryParser(new
	 * RegexStoryParser(keywords)) .useStoryLoader(new
	 * LoadFromClasspath(this.getClass())).useStoryReporterBuilder( new
	 * StoryReporterBuilder().withDefaultFormats().withFormats(Format.CONSOLE,
	 * Format.HTML)); }
	 * 
	 * public InjectableStepsFactory stepsFactory() { return new
	 * InstanceStepsFactory(configuration(), new Jbhave()); }
	 * 
	 * protected List<String> storyPaths() { return
	 * Arrays.asList("src/test/java/jbehave/login.story"); }
	 */

	@Override
	public Configuration configuration() {
		Keywords keywords = new LocalizedKeywords(new Locale("pt"));
		return new MostUsefulConfiguration().useKeywords(keywords).useStoryParser(new RegexStoryParser(keywords))
				.useStoryReporterBuilder(new StoryReporterBuilder().withDefaultFormats().withFormats(Format.CONSOLE,
						Format.TXT, Format.HTML));
	}

	protected List<String> storyPaths() {
		return new StoryFinder().findPaths(CodeLocations.codeLocationFromClass(this.getClass()),
				Arrays.asList("**/*.story"), Arrays.asList(""));
	}

	@Override
	public InjectableStepsFactory stepsFactory() {
		return new InstanceStepsFactory(configuration(), new Jbhave());
	}
}
