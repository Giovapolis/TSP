package AG;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Seleccionar implements SeleccionInterface {

    private double frecuenciaEsperadaTotal = 0;
    private ArrayList<Individuo> poblacion;
    private double[] valoresEsperados;
    private double r;
    private java.util.Random random;
    private ArrayList<Integer> indicesElegidos = new ArrayList<>();

    /**
     * Constructor del objeto Seleccionar
     * @param aptitud Aptitudes ya creadas de los individuos
     * @param random Objeto que servira para obtener numeros pseudoaleatorios
     */
    public Seleccionar(ArrayList<Individuo> aptitud, Random random) {
        this.poblacion = aptitud;
        this.random = random;
        this.valoresEsperados = new double[this.poblacion.size()];
        //Obtener FrecuanciaEsperadaTotal
        for (int i = 0; i < this.poblacion.size(); i++) {
            frecuenciaEsperadaTotal += this.poblacion.get(i).getAptitud();
        }
        frecuenciaEsperadaTotal = frecuenciaEsperadaTotal / this.poblacion.size();
        //Obtener Valores Esperados
        for (int i = 0; i < this.poblacion.size(); i++) {
            this.valoresEsperados[i] = frecuenciaEsperadaTotal * this.poblacion.get(i).getAptitud();
        }
        //System.out.println("Valores Esperados: ");
        //System.out.println(Arrays.toString(valoresEsperados));
    }

    /**
     * Implementacion de la funcion de seleccion por ruleta
     * @param n Numero de cromosomas a seleccionar
     * @return Individuos seleccionados
     */
    @Override
    public ArrayList<Integer> seleccionRuleta(int n) {
        indicesElegidos.clear();
        double tmp = 0.0;
        for (int i = 0; i < n; i++) {
            r = (frecuenciaEsperadaTotal * random.nextDouble())*100;
            for (int j = 0; j < valoresEsperados.length; j++) {
                if (tmp >= r) {
                    indicesElegidos.add(j);
                    tmp = 0.0;
                    break;
                } else {
                    tmp += valoresEsperados[j];
                }
            }
        }
        while (indicesElegidos.size() < n) {
            int idx = random.nextInt(poblacion.size());
            indicesElegidos.add(idx);
        }
        return indicesElegidos;
    }

    /**
     * Implementacion de la funcion de seleccion sobrante Estocastico con remplazo
     * @param n Numero de cromosomas a seleccionar
     * @return Individuos seleccionados
     */
    @Override
    public ArrayList<Integer> seleccionEstocasticaSinRemplazo(int n) {
        indicesElegidos.clear();
        long[] pInt = new long[poblacion.size()];
        double[] pFrc = new double[poblacion.size()];
        for (int i = 0; i < poblacion.size(); i++) {
            pInt[i] = (long)poblacion.get(i).getAptitud();
            pFrc[i] = poblacion.get(i).getAptitud() - pInt[i];    
            if (pInt[i] >= 1 ){
                indicesElegidos.add(i);
            }
        }
        
        while (indicesElegidos.size() < n) {
            int idx = random.nextInt(poblacion.size());
            if (pFrc[idx] != 0.0) {
                indicesElegidos.add(idx);
            }
        }
        return indicesElegidos;
    }

    /**
     * Implementacion de la funcion de seleccion por sobrante estocastico sin remplazo
     * @param n Numero de cromosomas a seleccionar
     * @return Individuos seleccionados
     */
    @Override
    public ArrayList<Integer> seleccionEstocasticaConRemplazo(int n) {
        indicesElegidos.clear();
        double[] pFrc = new double[poblacion.size()];
        double[] probabilidad = new double[poblacion.size()];
        int sumAptitudes=0;
        for (int i = 0; i < poblacion.size(); i++) {
            sumAptitudes += poblacion.get(i).getAptitud();
        }
        for (int i = 0; i < poblacion.size(); i++) {
            pFrc[i] = poblacion.get(i).getAptitud() - (long)poblacion.get(i).getAptitud(); 
            probabilidad[i] = pFrc[i]/sumAptitudes;
        }
//        poblacion = probabilidad;
//        seleccionRuleta(n);
        return indicesElegidos;
    }

}
