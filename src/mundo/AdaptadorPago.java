
package mundo;


public class AdaptadorPago implements SistemaPago{
    private ProcesadorPago procesador;

    public AdaptadorPago(ProcesadorPago procesador) {
        this.procesador = procesador;
    }

    @Override
    public void procesarPago(int monto) {
        procesador.realizarPago(monto);
    }
}
