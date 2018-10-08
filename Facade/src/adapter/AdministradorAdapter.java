package adapter;



public class AdministradorAdapter extends Usuario {

    private Administrador administrador = new Administrador();

    public AdministradorAdapter(String nombre, String usuario, String contrasena, String documento) {
        super(nombre, usuario, contrasena, documento);
    }
    
    public AdministradorAdapter() {
        
    }

    @Override
    public void consultar() {
       
    }

    @Override
    public void eliminar() {
        
    }

}