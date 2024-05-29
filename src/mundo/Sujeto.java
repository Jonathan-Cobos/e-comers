
package mundo;

import java.util.ArrayList;
import java.util.List;

interface Sujeto {
    void agregarObservador(Observador o);
    void eliminarObservador(Observador o);
    void notificarObservadores(String mensaje);
}
