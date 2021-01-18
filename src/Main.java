public class Main {
    public static void main(String[] args) {
        String [][] arr = {{"'","2","3","4"},
                            {"1","2","3","4"},
                            {"1","2","3","4"},
                           {"1","2","3","4"}};

        try {
            System.out.println(getArrAndSum(arr));

        } catch (MyArraySizeException e) {
            e.printStackTrace();
        } catch (MyArrayDataException e) {
            e.printStackTrace();
        }
    }

    public static int getArrAndSum(String [][] arr) throws MyArraySizeException, MyArrayDataException {
        int sum = 0;

        try {
            if (arr.length != 4)
                throw new MyArraySizeException();
            for (int i = 0; i < arr.length; i++) {
                if (arr[i].length != 4)
                    throw new MyArraySizeException();
            }
        }
        catch(MyArraySizeException e)
        {
            System.out.println("Exception: "+e.toString());
        }

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {

                try {
                    sum += Integer.parseInt(arr[i][j]);
                }
                catch(NumberFormatException e)
                {
                    throw new MyArrayDataException("Data error on " + i + " " + j, i, j);
                }
            };
        }
        return sum;
    }
}
