package com.dzeru.artnowtest.runners;

import lombok.NoArgsConstructor;
import org.testng.TestListenerAdapter;
import org.testng.TestNG;

@NoArgsConstructor
public class ClassTestRunner implements TestRunner {

    private Class[] testClasses;

    public ClassTestRunner(Class[] testClasses) {
        this.testClasses = testClasses;
    }

    @Override
    public void runTests() {
        TestListenerAdapter testListenerAdapter = new TestListenerAdapter();
        TestNG testng = new TestNG();
        testng.setTestClasses(testClasses);
        testng.addListener(testListenerAdapter);
        testng.run();
    }
}
