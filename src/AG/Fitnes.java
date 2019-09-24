package AG;

import java.util.ArrayList;

public class Fitnes {

    public void evaluar(Individuo ind) {
        double aptitud = 0;

        ArrayList<Ciudad> miRuta = ind.getRuta();
        for (int i = 0; i < miRuta.size() - 1; i++) {
            aptitud += sacarDistancia(miRuta.get(i), miRuta.get(i + 1),3);
        }

        ind.setAptitud(aptitud);
    }

    private double sacarDistancia(Ciudad a, Ciudad b,int tipo) {
        double aptitud;
        if(tipo == 1){
            aptitud = Math.sqrt(Math.pow(b.getX() - a.getX(), 2.0) + Math.pow(b.getY() - a.getY(), 2.0));
        }else if(tipo == 2){
            aptitud = Math.abs(Math.pow(b.getX() - a.getX(), 2.0) + Math.pow(b.getY() - a.getY(), 2.0));
        }else if (tipo == 3){
            aptitud = distanciaChebyshov(a,b);
        }else{
            aptitud = Double.POSITIVE_INFINITY;
        }        
        return aptitud;
    }
    
        private double distanciaChebyshov(Ciudad a,Ciudad b) {
        double d = 0;

        ArrayList<Integer> restas = new ArrayList<Integer>();
        
        restas.add( Math.abs( a.getX() - b.getX() ) );
        restas.add( Math.abs( a.getY() - b.getY() ) );

        d = restas.stream().mapToDouble(i -> i).max().getAsDouble();
        return d;
    }

}
