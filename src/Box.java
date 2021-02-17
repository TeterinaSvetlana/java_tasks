import java.util.ArrayList;

public class Box <T extends  Fruit>{
    private ArrayList<T> box = new ArrayList<>();

    public ArrayList<T> getBox() {
        return box;
    }

    public void addFruitInBox(T fruit) {
        if (this.box.size() == 0){
            this.box.add(fruit);
        } else {
            if (this.box.get(0).getClass() == fruit.getClass()) {
                this.box.add(fruit);
            } else {
                System.out.println("noo you can't");
            }
        }
    }

    public float getWeight() {
        float oneFruitWeight = this.box.get(0).getWeight();
        return this.box.size() * oneFruitWeight;
    }

    public boolean compare (Box boxToCompare) {
        return (getWeight() == boxToCompare.getWeight());
    }

    public void moveToAnotheBox (Box boxToMoveIn) {
        if (this.box.size() == 0){
            System.out.println("This box is empty");
        } else {
            if (boxToMoveIn.getBox().size() == 0) {
                for (T fruit: box ) {
                    boxToMoveIn.addFruitInBox(fruit);
                }
                System.out.println("Fruits are moved");
            } else {
                if (this.box.get(0).getClass() == boxToMoveIn.getBox().get(0).getClass()) {
                    for (T fruit: box ) {
                        boxToMoveIn.addFruitInBox(fruit);
                    }
                    System.out.println("Fruits are moved");
                } else {
                    System.out.println("noo you can't");
                }
            }
        }
    }
}
