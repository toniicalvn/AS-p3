package junit.com;

public class One2OneStrategy implements RateStrategy {
    @Override
    public int calculaTime(int insertedSoFar) {
        return insertedSoFar;
    }
}
