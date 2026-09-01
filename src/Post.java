public class Post extends Publicacion{
    private String pieDeFoto;
    private String ubicacion;
    private boolean comentariosHabilitados;

    public Post(id,autor,pieDeFoto,ubicacion){
        return;
    }
    @Override
    public void mostrarDetalle(){

    }
    public void editarPieDeFoto(nuevoTexto){
        this.pieDeFoto = nuevoTexto;
    }
}
