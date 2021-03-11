
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TestManager {
    private static Method beforeMethod = null;
    private static List<Method> testMethodsOrdered = new LinkedList<>();
    private static Method afterMethod = null;

    public static void main(String[] args) {
        start(TestCollection.class);
        clearFields();
    }

    private static void start(Class testedClass) {
        try {
            sortMethods(testedClass);
        } catch (RuntimeException re) {
            System.out.println("only one AfterSuit and one BeforeSuit allowed");
            return;
        }
        invokeMethods();
    }

    private static void start(String className) {
        Class testedClass = null;
        try {
            testedClass = Class.forName(className);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        start(testedClass);
    }

    private static void sortMethods(Class testedClass) {
        Method[] methods = testedClass.getDeclaredMethods();
        List<Method> beforeSuiteMethods = new ArrayList<>();
        List<Method> testMethods = new ArrayList<>();
        List<Method> afterSuiteMethods = new ArrayList<>();
        for (Method method : methods) {
            if (method.getAnnotation(BeforeSuite.class) != null) beforeSuiteMethods.add(method);
            if (method.getAnnotation(Test.class) != null) testMethods.add(method);
            if (method.getAnnotation(AfterSuite.class) != null) afterSuiteMethods.add(method);
        }
        extracted(beforeSuiteMethods, afterSuiteMethods);
        beforeMethod = beforeSuiteMethods.get(0);
        beforeMethod.setAccessible(true);
        afterMethod = afterSuiteMethods.get(0);
        afterMethod.setAccessible(true);
        int priority = Priority.p10;
        do {
            for (Method method : testMethods) {
                if (method.getAnnotation(Test.class).priority() == priority) {
                    method.setAccessible(true);
                    testMethodsOrdered.add(method);
                }
            }
            priority--;
        } while (priority >= Priority.p1);
    }

    private static void extracted(List<Method> beforeSuiteMethods, List<Method> afterSuiteMethods) {
        if (beforeSuiteMethods.size() != 1 || afterSuiteMethods.size() != 1)
            throw new RuntimeException();
    }

    private static void invokeMethods() {
        String str1 = "this is string";
        int number = 123;
        boolean bool = true;
        try {
            TestCollection testCollection = (TestCollection) beforeMethod.invoke(null);
            testMethodsOrdered.forEach((method) -> {
                Class[] type = method.getParameterTypes();
                System.out.printf("Priority: %d. Action: ", method.getAnnotation(Test.class).priority());
                if (type.length == 0) try {
                    method.invoke(testCollection);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                } else try {
                    Class currentType = type[0];
                    if (currentType == boolean.class) method.invoke(testCollection, bool);
                    else if (currentType == String.class) method.invoke(testCollection, str1);
                    else if (currentType == int.class) method.invoke(testCollection, number);
                } catch (IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
            });
            afterMethod.invoke(null);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    private static void clearFields() {
        beforeMethod = null;
        testMethodsOrdered = new LinkedList<>();
        afterMethod = null;
    }
}
