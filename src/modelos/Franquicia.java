/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.ArrayList;

/**
 *
 * @author Andres version 1.0
 */
public class Franquicia {

    protected long id;
    //Modela el numero identificador propio de cada franquicia
    private java.sql.Date fecha_creacion;
    //Modela la fecha en la que fueron creadas las franquicias 
    private String ubicacion;
    //Modela la ubicacion en la que se va fecha representar
    private boolean accesible;
    //Modela si tiene o no acceso fecha minusvalidos
    private Grupo grupo; //
    private Informe informe;
    private Direccion director;

    public Franquicia(java.sql.Date fecha_creacion, String ubicacion, boolean accesible, Grupo grupo, Informe informe, Direccion director) {

        this.fecha_creacion = fecha_creacion;
        this.ubicacion = ubicacion;
        this.accesible = accesible;
        this.grupo = grupo;
        this.informe = informe;
        this.director = director;
    }

    public static Franquicia nuevafranquicia() throws ParseException {
        char s='a';
        char z='a';
        char x='a';
        Scanner in;
        Date fecha;
        String ubicacion;
        Boolean accesible;
        Grupo grupo ;
        Informe informe ;
        Direccion direccion ;
        char respuesta;
        in = new Scanner(System.in);
        Franquicia franquicia = new Franquicia();
        do {
          //  System.out.println("Introduzca la fecha de creacion");
          //  Date fe = Cajadeherramientas.readDate(in, "DD-MM-YYYY");
          //  franquicia.setFecha_creacion(fe);
           //  java.util.Date utilDate = new java.util.Date(); //fecha actual
            // long lnMilisegundos = utilDate.getTime();
            // java.sql.Date fe = new java.sql.Date(lnMilisegundos);
            // franquicia.setFecha_creacion(fe);
                 System.out.println("Introduzca la fecha con formato dd-mm-yyyy");
        
        String fechaa = in.nextLine();
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        String date = fechaa;
        Date testDate = df.parse(date);
         long lnMilisegundos = testDate.getTime();
            
        java.sql.Date fe = new java.sql.Date(lnMilisegundos);;
        System.out.println("Ahora hemos creado un objeto date con la fecha indicada, "+fe);
 
        if (!df.format(testDate).equals(date)){
            System.out.println("invalid date!!");
        } else {
            System.out.println("valid date");
            franquicia.setFecha_creacion(fe);
        }
       
            System.out.println("Introduzca la ubicacion");
            ubicacion = in.nextLine();
            franquicia.setUbicacion(ubicacion);

            do {
                System.out.println("¿Es accesible?");

                respuesta = in.next().charAt(0);

            } while (respuesta != 's' && respuesta != 'S' && respuesta != 'n' && respuesta != 'N');
            if (respuesta == 's' || respuesta == 'S') {
                accesible = true;
            } else {
                accesible = false;
            }
            franquicia.setAccesible(accesible);
            System.out.println("Quiere asignar un grupo a esta franquicia");
            z = in.next().charAt(0);
            if (z == 's' || z == 'S') {
                grupo = Grupo.nuevogrupo();
                franquicia.setGrupo(grupo);
            } else {
                System.out.println("No has asiganado un grupo a esta franquicia");
            }

            System.out.println("Quiere asignar un Informe a esta franquicia");
            z = in.next().charAt(0);
            if (z == 's' || z=='S') {

                informe = Informe.nuevoinforme();
                franquicia.setInforme(informe);
            } else {
                System.out.println("No has asiganado un informe a esta franquicia");
            }
            System.out.println("Quiere asignar un director a esta franquicia");
             z = in.next().charAt(0);
            if (z == 's' || z == 'S') {
                direccion = Direccion.nuevoDireccion();
            franquicia.setDirector(direccion);}
            else {
                System.out.println("No has asiganado un director a esta franquicia");
            }
            System.out.println("¿Los datos son correctos?" + franquicia);

            System.out.println("Si lo son pulse s para continuar de lo contrario pulse n");
            s = in.next().charAt(0);
        } while (s != 's' && s != 'S');

        return franquicia;

    }

    public Franquicia getFranquiciaById(long Id) {
        Franquicia f = null;
        /* for(int i=0; i< Lista.size (); i++){
     franquicia=(Franquicia) Lista[i];
     
        if( franquicia.getId()== Id){
        }
        
     } 
         */
        return f;
    }

    public ArrayList<Franquicia> getAllFranquicias() {
        ArrayList<Franquicia> Franquicias = new ArrayList();
        /*for (int i=0; i< Lista.size(); i++)
           franquicia= Franquicia Lista[i];
        Franquicias.add(franquicia);
       
         */
        return Franquicias;
    }

    public Franquicia() {
    }

    public Franquicia(Franquicia a) {
        this.fecha_creacion = a.getFecha_creacion();
        this.director = a.getDirector();
        this.grupo = a.getGrupo();
        this.informe = a.getInforme();
        this.ubicacion = a.getUbicacion();
        this.accesible = a.isAccesible();
    }

    public Grupo getGrupo() {
        return grupo;
    }

    public Informe getInforme() {
        return informe;
    }

    public Direccion getDirector() {
        return director;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }

    public void setInforme(Informe informe) {
        this.informe = informe;
    }

    public void setDirector(Direccion director) {
        this.director = director;
    }

    public long getId() {
        return id;
    }

    public java.sql.Date getFecha_creacion() {
        return fecha_creacion;
    }

    public void setFecha_creacion(java.sql.Date fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public boolean isAccesible() {
        return accesible;
    }

    public void setAccesible(boolean accesible) {
        this.accesible = accesible;
    }

    @Override
    public String toString() {
        return "Franquicia{" + "id=" + id + ", fecha_creacion=" + fecha_creacion + ", ubicacion=" + ubicacion + ", accesible=" + accesible + ", grupo=" + grupo + ", informe=" + informe + ", director=" + director + '}';
    }

    public String data() {
        return "" + getId() + "|" + isAccesible() + "|" + getFecha_creacion() + "|" + getUbicacion() + "|" + getGrupo() + "|" + getInforme() + "|" + getDirector();
    }
}
