package AG;

import java.util.ArrayList;

public interface SeleccionInterface {
    public ArrayList<Integer> seleccionRuleta(int n);
    
    public ArrayList<Integer> seleccionEstocasticaConRemplazo(int n);
    
    public ArrayList<Integer> seleccionEstocasticaSinRemplazo(int n);
}
