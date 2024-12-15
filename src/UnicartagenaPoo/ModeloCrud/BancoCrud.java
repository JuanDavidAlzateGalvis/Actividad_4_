/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UnicartagenaPoo.ModeloCrud;
import UnicartagenaPoo.ModeloEntidades.Banco;
import java.util.*;

/**
 *
 * @author juana
 */
public class BancoCrud {
    
    private List<Banco> bancos;

    public BancoCrud() {
        bancos = new ArrayList<>();
    }

    public void agregarBanco(Banco banco) {
        bancos.add(banco);  
    }

    public List<Banco> listarBancos() {
        return bancos;
    }

    public Banco buscarBanco(String nombre) {
        for (Banco banco : bancos) {
            if (banco.getNombre().equalsIgnoreCase(nombre)) {
                return banco;
            }
        }
        return null;
    }

    public boolean eliminarBanco(String nombre) {
        Banco banco = buscarBanco(nombre);
        if (banco != null) {
            bancos.remove(banco);  
            return true;
        }
        return false;
    }

    public void actualizarBanco(Banco banco) {

        for (int i = 0; i < bancos.size(); i++) {
            if (bancos.get(i).getNombre().equalsIgnoreCase(banco.getNombre())) {
                bancos.set(i, banco); 
                break;
            }
        }
    }
}
