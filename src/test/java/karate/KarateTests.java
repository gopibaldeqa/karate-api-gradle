package karate;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.intuit.karate.Results;
import com.intuit.karate.Runner;

class KarateTests {

    /**
     * ## Parallel Execution
     * Karate can run tests in parallel, and dramatically cut down execution time.
     * This is a 'core' feature and does not depend on JUnit, Maven or Gradle.
     * ref : https://github.com/intuit/karate#parallel-execution
     */

    /**
     * ## TAGS()
     * - any *.feature file tagged as @ignore will be skipped
     *   the ~ prefix means a "NOT" operation.
     * ex) Runner.path("classpath:animals").tags("~@ignore").parallel(5);
     *
     * - The tags() method also takes multiple arguments
     * "AND" operation: tags("@customer", "@smoke")
     * "OR" operation: tags("@customer,@smoke")
     */

    /**
     * ## PARALLEL()
     * parallel() has to be the last method called,
     * and you pass the number of parallel threads needed.
     *
     * It returns a Results object
     * that has all the information you need
     * such as the number of passed or failed tests.
     */
    @Test
    void testScenarioAll() {
        Results results = Runner.path("classpath:karate/scenario")
                                .tags("@RegressionTest")
                                .parallel(5);
        assertEquals(0, results.getFailCount(), results.getErrorMessages());
    }
}