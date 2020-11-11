package kukulam.module.advancedtesting.task1;

import org.junit.jupiter.api.extension.AfterAllCallback;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

class LoggingTestExtension implements BeforeAllCallback, AfterAllCallback {

    @Override
    public void beforeAll(ExtensionContext context) {
        System.out.println("Starting tests for " + NumberCalculatorTest2.class.toString());
    }

    @Override
    public void afterAll(ExtensionContext context) {
        System.out.println("Ending tests for " + NumberCalculatorTest2.class.toString());
    }
}
