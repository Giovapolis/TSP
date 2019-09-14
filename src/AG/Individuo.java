package AG;

import java.util.ArrayList;
import java.util.Random;

public class Individuo {

    private ArrayList<Ciudad> ruta;
    private double aptitud;

    public Individuo(ArrayList<Ciudad> ruta, double aptitud) {
        this.ruta = ruta;
        this.aptitud = aptitud;
    }

    public double getAptitud() {
        return aptitud;
    }

    public void setAptitud(double aptitud) {
        this.aptitud = aptitud;
    }

    public ArrayList<Ciudad> getRuta() {
        return ruta;
    }

    public void setRuta(ArrayList<Ciudad> ruta) {
        this.ruta = ruta;
    }

    @Override
    public String toString() {
        return "Ruta: " + ruta + " Aptitud: " + aptitud;
    }

    public ArrayList<Individuo> cruza(Individuo m) {
        ArrayList<Individuo> hijos = new ArrayList<>();
        hijos.add(this);
        hijos.add(m);

        for (int i = 0; i < new Random().nextInt(ruta.size()/2); i++) {
            int idx = new Random().nextInt(ruta.size());
            Ciudad remplazarDeA = hijos.get(0).ruta.get(idx);
            Ciudad remplazarDeB = hijos.get(1).ruta.get(idx);
            hijos.get(0).ruta.set(this.ruta.indexOf(remplazarDeB), remplazarDeA);
            hijos.get(0).ruta.set(idx, remplazarDeB);
            hijos.get(1).ruta.set(m.ruta.indexOf(remplazarDeA), remplazarDeB);
            hijos.get(1).ruta.set(idx, remplazarDeA);
        }

        return hijos;
    }

    public void muta() {
        for (int i = 0; i < new Random().nextInt(ruta.size()/2); i++) {
            int idx1 = new Random().nextInt(ruta.size());
            int idx2 = new Random().nextInt(ruta.size());

            Ciudad ciudadA = ruta.get(idx1);
            Ciudad ciudadB = ruta.get(idx2);

            ruta.set(idx1, ciudadB);
            ruta.set(idx2, ciudadA);
        }
    }

}
