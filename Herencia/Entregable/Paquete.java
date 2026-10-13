public class Paquete {
    //Declaramos la variable como protected para que la clase hija pueda acceder a el
    protected String codigo;
    //Este sera el constructor
    public Paquete(String codigo) {
        this.codigo = codigo;
    }
    //Metodo
    public void mostrarRastreo() {
        System.out.println("Rastreando el paquete " + codigo);
    }
    //Metodo
    public int calcularTiempoEntrega() {
        //Definimos por defecto 5
        return 5;
    }
    //Aqui va a estar la sobrecarga mismo metodo, diferente parametro, usamos deparametro los kiloemtros
    public int calcularTiempoEntrega(double km) {
        //Por cada 100 kilometros va a ser uno extra
        int diasExtra = (int) (km / 100);
        //Retornamos los dias habiles mas los extra
        return 5 + diasExtra;
    }
}