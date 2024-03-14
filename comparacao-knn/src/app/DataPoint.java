package app;

public class DataPoint{
    private double caloria;
    private double hora;
    private String estado;


    public double getCaloria() {
        return caloria;
    }

    public double getHora() {
        return hora;
    }

    public String getEstado() {
        return estado;
    }

    public DataPoint(double caloria, double hora, String estado){
        this.estado = estado;
        this.hora = hora;
        this.caloria = caloria;
    }

    public DataPoint(double caloria, double hora){
        this.caloria = caloria;
        this.hora = hora;
    }
}