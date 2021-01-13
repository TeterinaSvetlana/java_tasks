public enum DayOfWeek {
    Monday, Tuesday, Wednesday, Thursday, Friday, Saturday, Sunday;
    public static int getWorkingHours(DayOfWeek day){
        switch (day){
            case Monday: return 40;
            case Tuesday: return 32;
            case Wednesday: return 24;
            case Thursday: return 16;
            case Friday: return 8;
            case Saturday:{
                System.out.println("Сегодня выходной");
                return 0;
            }
            case Sunday: {
                System.out.println("Сегодня выходной");
                return 0;
            }
            default: {
                System.out.println("Ошибка");
                return 0;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(getWorkingHours(DayOfWeek.Monday));
    }
}
