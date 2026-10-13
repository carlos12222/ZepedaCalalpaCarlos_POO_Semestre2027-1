//Aqui esta la herencia simple usando extends
public class paqueteExpress extends Paquete{
    private double precio;
    //Aqui usamos la herencia con super, mandamos a llamar al constructor padre
    public paqueteExpress(String codigo){
        //Le enviamos el codigo a la clase padre
        super(codigo);
        //Guardamos el precio propio que asigna el hijo
        this.precio = 150.00;
    }
    //Aqui implementamos la herencia pero usando override
    @Override
    public void mostrarRastreo(){
        //Usamos el metodo pero del padre
        super.mostrarRastreo();
        System.out.println("Costo de envio express " + precio);
    }
}
