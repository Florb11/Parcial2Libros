public class Usuario {
    //Atributos
    private String nombre;
    private String contrasenia;

    //Constrcutor

    public Usuario(String nombre, String contrasenia) {
        this.nombre = nombre;
        this.contrasenia = contrasenia;
    }

    //Get y set

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "nombre='" + nombre + '\'' +
                ", contrasenia='" + contrasenia + '\'' +
                '}';
    }
    public boolean iniciarSesion(String mail,String contraseña) {
        if (this.nombre.equals(mail) && this.contrasenia.equals(contraseña)) {
            return true;
        } else {
            return false;
        }
    }


}
