package karate.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.intuit.karate.Results;
import com.intuit.karate.Runner;
import com.intuit.karate.junit5.Karate;

/**
 * ### MUST ###
 * 1. Before executing the method of DemoRunner.class,
 *    Run `KarateDemoProjectApplication` Server
 *
 * 2. Leave only 1 of the 2 active
 *    When both are activated, two requests are made.
 */
class DemoRunner {

    @Karate.Test
    Karate testAutoAll() {
        // It executes features that exist `only` in the package area.
        // ex) karate/deom/*.feature
        return Karate.run().relativeTo(getClass());
    }

    @Test
    void testManuallyAll() {
        // Explicitly informs the package of features to be executed.
        Results results = Runner.path("classpath:karate/demo")
                                .tags("~@CreateValue")
                                .parallel(5);
        assertEquals(0, results.getFailCount(), results.getErrorMessages());
    }

}