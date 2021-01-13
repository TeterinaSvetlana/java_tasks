public class Main {
    public static void main(String[] args) {
        Cat cat1 = new Cat(20,5);
        Human human1 = new Human(10,3);
        Robot robot1 = new Robot(200,10);

        Contestant[] contestants = {cat1,human1, robot1};

        Wall w1 = new Wall(1);
        Wall w2 = new Wall(2);
        Wall w3 = new Wall(5);

        RunningTrack rt1 = new RunningTrack(5);
        RunningTrack rt2 = new RunningTrack(12);
        RunningTrack rt3 = new RunningTrack(50);

        Barrier[] barriers = {w1, rt1, w2, rt2, w3, rt3};

        for (Contestant contestant:contestants) {
            for (Barrier barrier:barriers) {
                try {
                    Wall b = (Wall)barrier;
                    contestant.jump();
                    if (!b.isSuccessful(contestant.getMaxJump())){
                        break;
                    }
                } catch (Exception e) {
                    RunningTrack b = (RunningTrack)barrier;
                    contestant.run();
                    if (!b.isSuccessful(contestant.getMaxRun())){
                        break;
                    }
                }

            }
        }
    }
}
