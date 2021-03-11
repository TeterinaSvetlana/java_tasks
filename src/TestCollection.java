public class TestCollection {
    private static TestCollection instance;
    private TestCollection() {
    }

    @BeforeSuite
    private static TestCollection beforeSuit() {
        System.out.println("this is beforeSuit");
        if (instance == null) return new TestCollection();
        else return instance;
    }

    @Test(priority = Priority.p10)
    private void test(boolean bool) {
        System.out.println("this is p10 and the bool is: " + bool);
    }

    @Test(priority = Priority.p4)
    private void test(int number) {
        System.out.println("this is p4 and the number is: " + number);
    }

    @Test
    private void test(String string) {
        System.out.println("this is p5 and the string is: " + string);
    }

    @Test(priority = Priority.p10)
    private void test() {
        System.out.println("this is p10 and the parameter is null");
    }

    @AfterSuite
    private static void afterSuit() {
        System.out.println("this is afterSuit");
        instance = null;
    }



}
