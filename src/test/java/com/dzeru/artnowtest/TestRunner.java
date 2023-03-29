package com.dzeru.artnowtest;

import com.dzeru.artnowtest.runners.ClassTestRunner;
import com.dzeru.artnowtest.tests.*;

public class TestRunner {

    public static void main(String[] args) {
        ClassTestRunner classTestRunner = new ClassTestRunner(new Class[] { FirstTest.class, SecondTest.class, ThirdTest.class, FourthTest.class, FifthTest.class });
        classTestRunner.runTests();
    }
}
