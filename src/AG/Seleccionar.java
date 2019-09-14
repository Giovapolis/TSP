package AG;

import java.util.ArrayList;
import java.util.Random;

public class Seleccionar implements SeleccionInterface {

    private ArrayList<Individuo> poblacion;
    private ArrayList<Integer> indicesElegidos = new ArrayList<>();

    private double frecuenciaEsperadaTotal = 0;
    private double[] valoresEsperados;
    private double ruleta;
    private Random random;

    public Seleccionar(ArrayList<Individuo> poblacion, Random random) {
        this.poblacion = poblacion;
        this.random = random;
        this.valoresEsperados = new double[poblacion.size()];
        //Obtener FrecuanciaEsperadaTotal
        for (int i = 0; i < poblacion.size(); i++) {
            frecuenciaEsperadaTotal += poblacion.get(i).getAptitud();
        }
        frecuenciaEsperadaTotal = frecuenciaEsperadaTotal / poblacion.size();
        //Obtener Valores Esperados
        for (int i = 0; i < poblacion.size(); i++) {
            this.valoresEsperados[i] = frecuenciaEsperadaTotal * poblacion.get(i).getAptitud();
        }
    }

    @Override
    public ArrayList<Integer> seleccionRuleta(int n) {
        indicesElegidos.clear();
        double tmp = 0.0;
        for (int i = 0; i < n; i++) {
            ruleta = (frecuenciaEsperadaTotal * random.nextDouble())*10000;
            for (int j = 0; j < valoresEsperados.length; j++) {
                if (tmp >= ruleta) {
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

}
