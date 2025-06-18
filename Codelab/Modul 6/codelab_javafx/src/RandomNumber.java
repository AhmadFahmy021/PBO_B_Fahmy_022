public class RandomNumber {
    int random ;
    public RandomNumber(){
        random = (int)(Math.random() * 101);
    }

    public void setRandom() {
        random = (int)(Math.random() * 101);
    }

    public int getRandom() {
        return random;
    }
}
