package arraylist;

public class Partido {
    private String equipoLocal;
    private String equipoVisitante;
    private int golesLocal;
    private int golesVisitante;

    public Partido(String equipoLocal, String equipoVisitante, int golesLocal, int golesVisitante) {
        this.equipoLocal = equipoLocal;
        this.equipoVisitante = equipoVisitante;
        this.golesLocal = golesLocal;
        this.golesVisitante = golesVisitante;
    }

    public String getEquipoLocal() { return equipoLocal; }
    public String getEquipoVisitante() { return equipoVisitante; }
    public int getGolesLocal() { return golesLocal; }
    public int getGolesVisitante() { return golesVisitante; }

    public boolean esEmpate() {
        return golesLocal == golesVisitante;
    }

    public boolean ganoVisitante() {
        return golesVisitante > golesLocal;
    }

    public boolean ganoLocal() {
        return golesLocal > golesVisitante;
    }

    @Override
    public String toString() {
        return equipoLocal + " " + golesLocal + " - " + golesVisitante + " " + equipoVisitante;
    }
}
