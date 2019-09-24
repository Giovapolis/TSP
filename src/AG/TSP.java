package AG;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class TSP extends Thread {

    private ArrayList<Individuo> poblacion = new ArrayList<>();
    private ArrayList<Individuo> hijos = new ArrayList<>();
    private ArrayList<Ciudad> ciudades;
    private int generaciones;
    private double mutacion;
    private int tamPoblacion;

    @Override
    public void run() {
        inicializarPoblacion();
        evaluarPoblacion(poblacion);
        //System.out.println("Hilo: " + this.getName() + " " + poblacion);
        //System.out.println("Hilo: " + this.getName() + " " + poblacion.get(obtenerMejor(poblacion)));
        for (int i = 0; i < generaciones; i++) {
            ArrayList<Individuo> nP = new ArrayList<>();
            
            //Cruza
            cruzaPoblacion();
            //Unir
            unirPoblacion();
            evaluarPoblacion(poblacion);
            
            //Elitismo
            nP.add(poblacion.get(obtenerMejor(poblacion)));
            
            //Muta
            mutarPoblacion(poblacion, mutacion);
            
            //Creo nuevos Indices
            Seleccionar seleccionador = new Seleccionar(poblacion, new Random());
            ArrayList<Integer> indices = seleccionador.seleccionEstocasticaSinRemplazo(poblacion.size());
            while (nP.size() < tamPoblacion) {
                nP.add(poblacion.get(new Random().nextInt(indices.size())));
            }
            poblacion = nP;
        }
    }

    public TSP(ArrayList<Ciudad> ciudades, int itereaciones, double mutacion, int tamPoblacion) {
        this.ciudades = ciudades;
        this.generaciones = itereaciones;
        this.mutacion = mutacion;
        this.tamPoblacion = tamPoblacion;
    }

    public ArrayList<Individuo> getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(ArrayList<Individuo> poblacion) {
        this.poblacion = poblacion;
    }

    public ArrayList<Ciudad> getCiudades() {
        return ciudades;
    }

    public void setCiudades(ArrayList<Ciudad> ciudades) {
        this.ciudades = ciudades;
    }

    public int getItereaciones() {
        return generaciones;
    }

    public void setItereaciones(int itereaciones) {
        this.generaciones = itereaciones;
    }

    public double getMutacion() {
        return mutacion;
    }

    public void setMutacion(double mutacion) {
        this.mutacion = mutacion;
    }

    public int getTamPoblacion() {
        return tamPoblacion;
    }

    public void setTamPoblacion(int tamPoblacion) {
        this.tamPoblacion = tamPoblacion;
    }

    public ArrayList<Individuo> getHijos() {
        return hijos;
    }

    public void setHijos(ArrayList<Individuo> hijos) {
        this.hijos = hijos;
    }

    /////////////////////////////////////////////////////////////////////
    private Fitnes evaluador = new Fitnes();

    private void inicializarPoblacion() {
        for (int i = 0; i < tamPoblacion; i++) {
            ArrayList<Ciudad> tmp = new ArrayList<>(ciudades);
            revolverlista(tmp);
            poblacion.add(new Individuo(tmp, -1));
        }
    }

    private void revolverlista(ArrayList<Ciudad> tmp) {
        final long seed = System.nanoTime();
        Collections.shuffle(tmp, new Random(seed));
    }

    /////////////////////////////////////////////////////////////////////
    private void evaluarPoblacion(ArrayList<Individuo> poblacionAevaluar) {
        for (Individuo individuo : poblacionAevaluar) {
            evaluador.evaluar(individuo);
        }
    }

    public int obtenerMejor(ArrayList<Individuo> poblacion) {
        int idx = 0;
        double mejorAptitud = poblacion.get(0).getAptitud();
        for (int i = 1; i < poblacion.size() - 1; i++) {
            if (poblacion.get(i).getAptitud() < mejorAptitud) {
                idx = i;
                mejorAptitud = poblacion.get(i).getAptitud();
            }
        }
        return idx;
    }

    private void cruzaPoblacion() {
        hijos.clear();
        Seleccionar seleccionador = new Seleccionar(poblacion, new Random());
        ArrayList<Integer> indices = seleccionador.seleccionRuleta(poblacion.size());

        for (int i = 0; i < poblacion.size(); i++) {
            int p = new Random().nextInt(indices.size());
            int m = new Random().nextInt(indices.size());
            ArrayList<Individuo> tmps = poblacion.get(p).cruza(poblacion.get(m));
            for (Individuo tmp : tmps) {
                hijos.add(tmp);
            }
        }
    }

    private void unirPoblacion() {
        for (Individuo hijo : hijos) {
            poblacion.add(hijo);
        }
    }

    private void mutarPoblacion(ArrayList<Individuo> poblacionAmutar, double porcentaje) {
        int vecesAmutar = (int) (porcentaje * poblacionAmutar.size());
        for (int i = 0; i < vecesAmutar; i++) {
            poblacionAmutar.get(new Random().nextInt(poblacionAmutar.size())).muta();
        }
    }

}
