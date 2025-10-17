
package runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/feature",       // path to your .feature files
        glue = "steps",                           // step definitions package
        plugin = {
                "pretty",                         // readable console output
                "html:target/cucumber-report.html", // generates HTML report
                "json:target/cucumber-report.json"  // generates JSON report
        },
        monochrome = true,                        // clean console output
        publish = true                            // optional: publish report link
)
public class TestRunner {
}


