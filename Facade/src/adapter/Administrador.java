package adapter;


public class Administrador {

    public void create() {
        System.out.println("Se ha creado administrador");
    }

    public void brief() {
        System.out.println("Se ha consultado administrador");
    }

    public void update() {
        System.out.println("Se ha actualizado administrador");
    }

    public void delete() {
        System.out.println("Se ha eliminado administrador");
    }

    @Override
    public String toString() {
        return "Administrador"; //To change body of generated methods, choose Tools | Templates.
    }

}
