package AG;

import java.util.ArrayList;

public class Fitnes {

    public void evaluar(Individuo ind) {
        double aptitud = 0;

        ArrayList<Ciudad> miRuta = ind.getRuta();
        for (int i = 0; i < miRuta.size() - 1; i++) {
            aptitud += sacarDistancia(miRuta.get(i), miRuta.get(i + 1));
        }

        ind.setAptitud(aptitud);
    }

    private double sacarDistancia(Ciudad a, Ciudad b) {
        return Math.sqrt(Math.pow(a.getX() - b.getX(), 2.0) + Math.pow(a.getY() - b.getY(), 2.0));
    }

}
