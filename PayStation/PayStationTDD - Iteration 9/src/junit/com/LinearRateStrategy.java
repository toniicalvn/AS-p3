package junit.com;

public class LinearRateStrategy implements RateStrategy {


    public int calculaTime(int insertedSoFar) {
        return insertedSoFar/5 * 2;
    }
}
