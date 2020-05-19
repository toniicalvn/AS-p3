package junit.com;

import static java.lang.Math.min;

public class ProgressiveRateStrategy implements RateStrategy {
    @Override

    public int calculaTime(int insertedSoFar) {
        int time = 0;
        if(insertedSoFar > 350)
        {
            int monedas3ahora = (insertedSoFar-350);
            time += monedas3ahora / 5;
            insertedSoFar -= monedas3ahora;
        }
        if(insertedSoFar > 150)
        {
            int monedas2hora = (insertedSoFar-150);
            time += monedas2hora / 5 * 1.5;
            insertedSoFar -= monedas2hora;
        }
        time +=insertedSoFar/5*2;
        return time;
    }
}
